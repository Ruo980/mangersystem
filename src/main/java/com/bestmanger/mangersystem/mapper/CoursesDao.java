package com.bestmanger.mangersystem.mapper;

import com.bestmanger.mangersystem.pojo.AppointmentCourses;
import com.bestmanger.mangersystem.pojo.Courses;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liangrunyong
 * @create 2021-08-1416:41
 */
@Mapper
@Repository
public interface CoursesDao {

    @Insert("insert into courses values(#{courseid},#{coursename},#{teacher},#{maxpeople},#{number},#{telphone},#{opentime},#{closetime},#{remarks})")
//插入课程
    int insertCourse(Courses courses);

    @Select("select * from courses")
    List<Courses> findAllCourses();

    @Delete("delete from courses where courseid=#{courseid}")
    int deleteCourse(String courseid);

    @Delete("delete from appointmentcourses where courseid=#{courseid}")
    int deleteAppointmentCourse(String courseid);

    @Select("select * from appointmentcourses")
    List<AppointmentCourses> findAllAppointmentCourses();

    @Select("select * from appointmentcourses where courseid=#{courseid}")
    List<AppointmentCourses> selectAppointmentCourseByCourseId(String courseid);

}
