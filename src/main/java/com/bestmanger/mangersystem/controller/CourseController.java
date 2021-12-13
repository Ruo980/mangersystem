package com.bestmanger.mangersystem.controller;

import com.bestmanger.mangersystem.pojo.AppointmentCourses;
import com.bestmanger.mangersystem.pojo.Courses;
import com.bestmanger.mangersystem.pojo.User;
import com.bestmanger.mangersystem.service.CourseService;
import com.bestmanger.mangersystem.service.UserService;
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
 * @create 2021-08-1613:06
 */
@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @GetMapping("/dataStudentRegister")//学生报名情况
    @ResponseBody
    public Map dataStudentRegister() {
        System.out.println("学生报名信息查询");
        Map map = new HashMap();
        List<User> list = new LinkedList<User>();
        try {
            list = userService.findAllUsers();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            Map result = new HashMap();
            result.put("code", 0);
            result.put("msg", "");
            result.put("count", 1000);
            result.put("data", list);
            return result;
        }

    }

    /*删除学生要删除其基本信息，删除其预约的课程安排、考试安排、身份证号表记录,减去所有number*/
    /*但为了方便此处仅采用禁止其再登录*/
    @PostMapping("/deleteStudent")
    public void deleteStudent(@RequestBody User user, HttpServletResponse response) {
        System.out.println("开始删除该学生");
        try {
            System.out.println(user);
            String account = user.getAccount();
            userService.deleteuser(account);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @PostMapping("/coursesave")//课程的发布提交
    @ResponseBody
    public Map<String, String> courseSave(@RequestBody Courses courses) {
        System.out.println("课程开始发布......");
        Map<String, String> map = new HashMap();
        try {
            courseService.insertCourse(courses);
            System.out.println("课程发布成功");
            map.put("insertCourseYes", "yes");
        } catch (Exception exception) {
            System.out.println("课程发布失败");
            System.out.println(exception.getMessage());
            map.put("insertCourseYes", "no");
        } finally {
            return map;
        }
    }

    @RequestMapping("/dataCourses")//发布课程情况
    @ResponseBody
    public Map dataCourses() {
        System.out.println("课程安排表加载中");
        List<Courses> list = new LinkedList<Courses>();
        try {
            list = courseService.findAllCourses();
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

    @PostMapping("/deleteCourse")
    public void deleteCourse(@RequestBody Courses courses, HttpServletResponse response) {
        System.out.println("开始删除课程,要将预约的表信息也删除");
        try {
            String courseid = courses.getCourseid();
            courseService.deleteCourse(courseid);
            courseService.deleteAppointmentCourse(courseid);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @GetMapping("/reservation")//查看按钮看单一课程的课程预约情况
    public String reservation(@RequestParam("courseid") String courseid, Model model) {
        System.out.println("跳转查看课程预约的页面");
        System.out.println("点击查看的课程课程号为：" + courseid);
        model.addAttribute("courseid", courseid);
        return "reservation.html";
    }

    @GetMapping("/courseReservation")//查看某一课程的数据并返回到表table里面
    @ResponseBody
    public Map courseReservation(@RequestParam("courseid") String courseid) {
        System.out.println("要查的courseid=" + courseid);
        List<AppointmentCourses> list = new LinkedList<>();
        try {
            list = courseService.selectAppointmentCourseByCourseId(courseid);
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
