package com.bestmanger.mangersystem.service;

import com.bestmanger.mangersystem.pojo.AppointmentExaminations;
import com.bestmanger.mangersystem.pojo.Examinations;
import com.bestmanger.mangersystem.pojo.TestRoster;

import java.util.List;

/**
 * @author liangrunyong
 * @create 2021-08-2218:55
 */
public interface ExaminationService {

    int insertExamination(Examinations examinations);

    int deleteExamination(String examinationid);

    int deleteAppointmentExamination(String examinationid);

    List<TestRoster> selectAppointmentExaminationByExaminationidId(String examinationid);

    List<Examinations> findAllExamination();

    List<AppointmentExaminations> findAllAppointmentExaminations();

    String findIdByAccount(String account);
}
