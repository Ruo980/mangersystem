package com.bestmanger.mangersystem.controller;

import com.bestmanger.mangersystem.service.ProtocolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.*;

/**
 * @author :liangrunyong
 * @create :2021-08-2518:56
 * @description :文件上传接口
 */
@Controller
@MultipartConfig
public class FileUpdate {

    @Autowired
    private ProtocolService protocolService;


    /*查看所有用户上传文件*/
    @GetMapping("/searcheUploadedProtocol")
    @ResponseBody
    public Map searcheUploadedProtocol(HttpServletResponse response, HttpSession httpSession) {
        Map result = new HashMap();
        List list = new LinkedList();
        try {
            list = protocolService.selectUserProtocol();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            result.put("code", 0);
            result.put("msg", "");
            result.put("count", 1000);
            result.put("data", list);
            return result;
        }
    }

    @RequestMapping(value = "/seeProtocol", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String seeProtocol(@RequestParam("protocolname") String protocolname, HttpServletResponse response, HttpServletRequest request) {
        System.out.println("文件名：" + protocolname + ".pdf" + "正在下载中");
        String uploadFilePath = "D:/uploadFile/" + protocolname + ".pdf";
        /*String uploadFilePath = "/root/uploadFile/" + protocolname + ".pdf";*/
        File file = new File(uploadFilePath);

        /*
        *下载文件不需要创建，只要知道读文件的位置，os输出流有使用者决定
        下载文件创建*//*
        String downloadFilePath = "D:/downloadFile";
        File file = new File(downloadFilePath, protocolname + ".pdf");
        */

        /*开始响应并写入*/
        response.setHeader("content-type", "application/pdf");
        response.setContentType("application/pdf");

        /*创建缓冲区，加速下载*/
        byte[] buffer = new byte[1024];
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            fis = new FileInputStream(file);//输入流文件
            bis = new BufferedInputStream(fis);
            OutputStream os = response.getOutputStream();//创建输出流对象
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);//显然下载是不需要指定位置的
                i = bis.read(buffer);
            }
            System.out.println("Download  successfully!");
            return "successfully";

        } catch (Exception e) {
            System.out.println("Download  failed!");
            return "failed";

        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
