package com.bestmanger.mangersystem.service;

import com.bestmanger.mangersystem.pojo.Manger;

/**
 * @author liangrunyong
 * @create 2021-08-0314:05
 */
public interface VerificationService {
    public Manger accountVerification(String account, String password);
}
