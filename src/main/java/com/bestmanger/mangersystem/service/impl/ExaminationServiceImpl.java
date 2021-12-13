package com.bestmanger.mangersystem.service.impl;

import com.bestmanger.mangersystem.mapper.ExaminationDao;
import com.bestmanger.mangersystem.mapper.IDNumberDao;
import com.bestmanger.mangersystem.pojo.AppointmentExaminations;
import com.bestmanger.mangersystem.pojo.Examinations;
import com.bestmanger.mangersystem.pojo.TestRoster;
import com.bestmanger.mangersystem.service.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liangrunyong
 * @create 2021-08-2218:55
 */
@Service
public class ExaminationServiceImpl implements ExaminationService {

    @Autowired
    private ExaminationDao examinationDao;

    @Autowired
    private IDNumberDao idNumberDao;

    @Override
    public int insertExamination(Examinations examinations) {
        int row = examinationDao.insertExamination(examinations);
        return row;
    }

    @Override
    public int deleteExamination(String examinationid) {
        int row = examinationDao.deleteExamination(examinationid);
        return row;
    }

    @Override
    public int deleteAppointmentExamination(String examinationid) {
        int row = examinationDao.deleteAppointmentExamination(examinationid);
        return row;
    }

    @Override
    public List<TestRoster> selectAppointmentExaminationByExaminationidId(String examinationid) {
        List list = examinationDao.selectAppointmentExaminationByExaminationidId(examinationid);
        return list;
    }

    @Override
    public List<Examinations> findAllExamination() {
        List list = examinationDao.findAllExamination();
        return list;
    }

    @Override
    public List<AppointmentExaminations> findAllAppointmentExaminations() {
        List list = examinationDao.findAllAppointmentExaminations();
        return list;
    }

    @Override
    public String findIdByAccount(String account) {
        String idnumber = idNumberDao.findIdByAccount(account);
        return idnumber;
    }
}
