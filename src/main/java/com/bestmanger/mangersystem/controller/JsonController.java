package com.bestmanger.mangersystem.controller;

import com.bestmanger.mangersystem.pojo.AppointmentCourses;
import com.bestmanger.mangersystem.pojo.AppointmentExaminations;
import com.bestmanger.mangersystem.pojo.Courses;
import com.bestmanger.mangersystem.pojo.User;
import com.bestmanger.mangersystem.service.CourseService;
import com.bestmanger.mangersystem.service.ExaminationService;
import com.bestmanger.mangersystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author liangrunyong
 * @create 2021-08-1117:51
 * 主要用于选项卡跳转，故接收init.json的数据并实现跳转
 */
@Controller
public class JsonController {
    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private ExaminationService examinationService;

    /*首页的请求*/
    @GetMapping("/welcome")
    public String welcome(Model model) {
        try {
            List<User> list = userService.findAllUsers();
            model.addAttribute("userSize", list.size());//发送用户总数
            List<Courses> list2 = courseService.findAllCourses();
            model.addAttribute("courseSize", list2.size());//统计已开课程数
            List<AppointmentCourses> list3 = courseService.findAllAppointmentCourses();
            model.addAttribute("appointmentCourseSize", list3.size());//总预约次数
            List<AppointmentExaminations> list4 = examinationService.findAllAppointmentExaminations();
            model.addAttribute("appointmentExaminationSize", list4.size());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "welcome.html";
    }

    @GetMapping("/studentRoster")
    public String studentRoster() {
        System.out.println("展示花名册");
        return "studentRoster.html";
    }

    @GetMapping("/learnMessage")
    public String learnMessage() {
        return "learnMessage.html";
    }

    @GetMapping("/courseRelease")//课程发布
    public String courseRelease() {
        System.out.println("准备发布课程");
        return "courseRelease.html";
    }

    @GetMapping("/scheduledCourses")//课程发布情况表
    public String scheduledCourses() {
        System.out.println("查看课程安排情况");
        return "scheduledCourses.html";
    }

    @GetMapping("/examinationRelease")//考试发布
    public String examinationRelease() {
        System.out.println("准备发布考试");
        return "examinationRelease.html";
    }

    @GetMapping("/scheduledExamination")//考试发布情况表
    public String scheduledExamination() {
        System.out.println("查看考试安排情况");
        return "scheduledExamination.html";
    }


    @GetMapping("/examinationAnalysis")//考试发布情况表
    public String examinationAnalysis() {
        System.out.println("查看考试分析");
        return "examinationAnalysis.html";
    }

    @GetMapping("/teachingEvaluation")//教学评估
    public String teachingEvaluation() {
        return "error/404.html";
    }

    @GetMapping("/announcementRelease")//公告发布
    public String announcementRelease() {
        return "error/404.html";
    }

    @GetMapping("/protocolSend")//协议发布
    public String protocolSend(Model model, HttpSession httpSession) {
        System.out.println("开始协议发布");
        return "error/404.html";//不要/error的/,有prefix
    }

    @GetMapping("/protocolDownload")//协议下载
    public String protocolDownload() {
        System.out.println("开始协议下载");
        return "protocol-download.html";
    }

    @GetMapping("/protocolReceivingBox")
    public String protocolReceivingBox() {
        return "protocolReceivingBox.html";
    }

}
