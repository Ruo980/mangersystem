package com.bestmanger.mangersystem.mapper;

import com.bestmanger.mangersystem.pojo.AppointmentExaminations;
import com.bestmanger.mangersystem.pojo.Examinations;
import com.bestmanger.mangersystem.pojo.TestRoster;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liangrunyong
 * @create 2021-08-2218:26
 */
@Mapper
@Repository
public interface ExaminationDao {

    @Insert("insert into examination values(#{examinationid},#{examinationname},#{teacher},#{maxpeople},#{number},#{telphone},#{opentime},#{closetime},#{remarks})")
//插入课程
    int insertExamination(Examinations examination);

    @Delete("delete from examination where examinationid=#{examinationid}")
    int deleteExamination(String examinationid);

    @Delete("delete from appointmentexamination where examinationid=#{examinationid}")
    int deleteAppointmentExamination(String examinationid);

    @Select("select examinationid,examinationname,username,appointmentexamination.account,opentime,closetime,accountidnumber.idnumber from appointmentexamination,accountidnumber where examinationid=#{examinationid} and appointmentexamination.account=accountidnumber.account")
    List<TestRoster> selectAppointmentExaminationByExaminationidId(String examinationid);

    @Select("select * from examination")
    List<Examinations> findAllExamination();

    @Select("select * from appointmentexamination")
    List<AppointmentExaminations> findAllAppointmentExaminations();
}
