package com.bestmanger.mangersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author liangrunyong
 * @create 2021-08-1912:37
 */
/*已经预约的课程情况*/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentCourses {
    private String courseid;
    private String coursename;
    private String username;//用户真实姓名而非账号名
    private String account;
    private String teacher;
    private String maxpeople;
    private String number;
    private String telphone;
    private String opentime;
    private String closetime;
    private String remarks;
}
