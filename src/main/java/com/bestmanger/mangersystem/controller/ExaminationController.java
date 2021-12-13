package com.bestmanger.mangersystem.controller;

import com.bestmanger.mangersystem.pojo.*;
import com.bestmanger.mangersystem.service.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author liangrunyong
 * @create 2021-08-2218:34
 */
@Controller
public class ExaminationController {
    @Autowired
    private ExaminationService examinationService;

    @PostMapping("/examinationsave")//考试的发布提交
    @ResponseBody
    public Map<String, String> examinationSave(@RequestBody Examinations examinations) {
        System.out.println("考试开始发布......");
        Map<String, String> map = new HashMap();
        try {
            examinationService.insertExamination(examinations);
            System.out.println("考试发布成功");
            map.put("insertExaminationYes", "yes");
        } catch (Exception exception) {
            System.out.println("考试发布失败");
            System.out.println(exception.getMessage());
            map.put("insertExaminationYes", "no");
        } finally {
            return map;
        }
    }

    @RequestMapping("/dataExamination")//发布考试情况
    @ResponseBody
    public Map dataExamination() {
        System.out.println("考试安排表加载中");
        List<Examinations> list = new LinkedList<Examinations>();
        try {
            list = examinationService.findAllExamination();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            Map result = new HashMap();
            result.put("code", 0);
            result.put("msg", "");
            result.put("count", 1000);
            result.put("data", list);
            return result;
        }

    }

    @PostMapping("/deleteExamination")
    public void deleteExamination(@RequestBody Examinations examinations, HttpServletResponse response) {
        System.out.println("开始删除考试,要将预约的表信息也删除");
        try {
            String examinationid = examinations.getExaminationid();
            examinationService.deleteExamination(examinationid);
            examinationService.deleteAppointmentExamination(examinationid);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @GetMapping("/reservationExamination")//考试预约,查看单一考试的预约情况
    public String reservationExamination(@RequestParam("examinationid") String examinationid, Model model) {
        System.out.println("跳转到查看考试预约情况页面");
        System.out.println("点击查看的考试号为：" + examinationid);
        model.addAttribute("examinationid", examinationid);
        return "reservationExamination.html";
    }

    @GetMapping("/examinationReservation")//查看某一课程的数据并返回到表table里面
    @ResponseBody
    public Map courseReservation(@RequestParam("examinationid") String examinationid) {
        System.out.println("要查的examinationid=" + examinationid);
        List<TestRoster> list = new LinkedList<>();
        try {
            list = examinationService.selectAppointmentExaminationByExaminationidId(examinationid);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            Map result = new HashMap();
            result.put("code", 0);
            result.put("msg", "");
            result.put("count", 1000);
            result.put("data", list);
            return result;
        }
    }

}
