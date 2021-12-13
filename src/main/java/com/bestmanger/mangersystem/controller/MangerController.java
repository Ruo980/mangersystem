package com.bestmanger.mangersystem.controller;

import com.bestmanger.mangersystem.pojo.Courses;
import com.bestmanger.mangersystem.service.CourseService;
import com.bestmanger.mangersystem.service.MangerService;
import com.bestmanger.mangersystem.service.UserService;
import com.bestmanger.mangersystem.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author liangrunyong
 * @create 2021-07-3019:27
 */
@Controller
public class MangerController {
    @Autowired
    private UserService userService;

    @Autowired
    private MangerService mangerService;

    @GetMapping("/userPassword")//密码修改页面
    public String passwordPage(HttpSession httpSession) {
        return "noUserful.html";
    }

    @GetMapping("/userSetting")//个人信息
    public String userPage(Model model, HttpSession httpSession) {
        String account = (String) httpSession.getAttribute("account");
        System.out.println("到达个人信息页面...");
        User user = userService.findUserByAccount(account);
        model.addAttribute("user", user);
        return "noUserful.html";
    }

    @PostMapping("/passwordModification")//密码修改提交
    public String PasswordModification(@RequestParam("newpassword") String newpassword, Model model, HttpSession httpSession) {
        String account = (String) httpSession.getAttribute("account");

        int row = userService.changePasswordByAccount(account, newpassword);//还要更改session的password
        if (row == 1) {
            model.addAttribute("changePasswordYes", "yes");
            httpSession.setAttribute("password", newpassword);//session注意更新密码
        } else {
            model.addAttribute("changePasswordYes", "no");
        }
        return "user-password.html";
    }

    @PostMapping("/userModification")
    public String userModification(
            @RequestParam("username") String username,
            @RequestParam("sex") String sex,
            @RequestParam("birthday") String birthday,
            @RequestParam("education") String education,
            @RequestParam("experience") String experience,
            Model model,
            HttpSession httpSession) {
        User user = new User();
        user.setAccount((String) httpSession.getAttribute("account"));
        user.setUsername(username);
        user.setSex(sex);
        user.setBirthday(birthday);
        user.setEducation(education);
        user.setExperience(experience);
        user.setPassword((String) httpSession.getAttribute("password"));
        int row = userService.updateUser(user);
        if (row == 1) {
            model.addAttribute("user", user);
            model.addAttribute("changeUserYes", "yes");
        } else {
            model.addAttribute("changeUserYes", "no");
        }
        return "user-setting.html";
    }

    /*注销操作*/
    @GetMapping("/loginout")
    public String loginOut(HttpSession httpSession) {
        httpSession.removeAttribute("account");//注销的关键是清空会话！
        System.out.println("注销成功");
        return "redirect:/index.html";//默认是forword转发，因此应该改成重定向避免返回
    }

    @RequestMapping("/test")//测试页面
    @ResponseBody
    public String test(HttpSession httpSession) {
        System.out.println("daol");
        return "访问到了";
    }


}
