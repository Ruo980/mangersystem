package com.bestmanger.mangersystem.service.impl;

import com.bestmanger.mangersystem.mapper.MangerDao;
import com.bestmanger.mangersystem.pojo.Manger;
import com.bestmanger.mangersystem.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liangrunyong
 * @create 2021-08-0314:06
 * 主要用于账号登录的验证
 */
@Service
public class VerificationServiceImpl implements VerificationService {
    @Autowired
    private MangerDao mangerDao;


    @Override
    public Manger accountVerification(String account, String password) {
        Manger manger = mangerDao.accountVerification(account, password);
        return manger;
    }
}
