package com.bestmanger.mangersystem.service.impl;

import com.bestmanger.mangersystem.mapper.ProtocolDao;
import com.bestmanger.mangersystem.pojo.Protocol;
import com.bestmanger.mangersystem.service.ProtocolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author :liangrunyong
 * @create :2021-08-2615:34
 * @description :
 */
@Service
public class ProtocolServiceImpl implements ProtocolService {

    @Autowired
    private ProtocolDao protocolDao;

    @Override
    public List selectUserProtocol() {
        List list = new LinkedList();
        list = protocolDao.selectUserProtocol();
        return list;
    }
}
