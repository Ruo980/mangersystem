package com.bestmanger.mangersystem.controller;

import com.bestmanger.mangersystem.pojo.Manger;
import com.bestmanger.mangersystem.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author liangrunyong
 * @create 2021-07-3022:53
 */
@Controller
public class LoginController {

    @Autowired
    private VerificationService verificationService;

    @PostMapping("/mangerLogin")//检测账号密码
    public String userLogin(@RequestParam("account") String account, @RequestParam("password") String password, Model model, HttpSession httpSession) {
        System.out.println("登录验证中");
        Manger manger = verificationService.accountVerification(account, password);
        if (manger == null) {
            System.out.println("验证失败");
            model.addAttribute("verification", "false");
            return "index.html";
        } else {
            System.out.println("验证成功");
            model.addAttribute("verification", "true");
            httpSession.setAttribute("account", account);
            httpSession.setAttribute("password", password);
            System.out.println("账号密码添加会话成功");
            return "main.html";//main.html和main都可以
        }

    }

}
