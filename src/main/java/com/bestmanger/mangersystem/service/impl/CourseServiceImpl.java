package com.bestmanger.mangersystem.service.impl;

import com.bestmanger.mangersystem.mapper.CoursesDao;
import com.bestmanger.mangersystem.pojo.AppointmentCourses;
import com.bestmanger.mangersystem.pojo.Courses;
import com.bestmanger.mangersystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liangrunyong
 * @create 2021-08-1612:29
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CoursesDao coursesDao;

    @Override
    public int insertCourse(Courses courses) {
        int row = coursesDao.insertCourse(courses);
        return row;
    }

    @Override
    public List<Courses> findAllCourses() {
        List<Courses> list = coursesDao.findAllCourses();
        return list;
    }

    @Override
    public int deleteCourse(String courseid) {
        int row = coursesDao.deleteCourse(courseid);
        return row;
    }

    @Override
    public List<AppointmentCourses> findAllAppointmentCourses() {
        List<AppointmentCourses> list = coursesDao.findAllAppointmentCourses();
        return list;
    }

    @Override
    public int deleteAppointmentCourse(String courseid) {
        int row = coursesDao.deleteAppointmentCourse(courseid);
        return row;
    }

    @Override
    public int deleteExamination() {
        return 0;
    }

    /*查看指定课程的预约情况*/
    @Override
    public List<AppointmentCourses> selectAppointmentCourseByCourseId(String courseid) {
        List<AppointmentCourses> list = coursesDao.selectAppointmentCourseByCourseId(courseid);
        return list;
    }
}
