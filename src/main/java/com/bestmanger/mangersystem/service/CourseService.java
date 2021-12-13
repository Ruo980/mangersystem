package com.bestmanger.mangersystem.service;

import com.bestmanger.mangersystem.pojo.AppointmentCourses;
import com.bestmanger.mangersystem.pojo.Courses;

import java.util.List;

/**
 * @author liangrunyong
 * @create 2021-08-1612:29
 */
public interface CourseService {
    int insertCourse(Courses courses);

    List<Courses> findAllCourses();

    int deleteCourse(String courseid);

    List<AppointmentCourses> findAllAppointmentCourses();

    int deleteAppointmentCourse(String courseid);

    int deleteExamination();

    List<AppointmentCourses> selectAppointmentCourseByCourseId(String courseid);
}
