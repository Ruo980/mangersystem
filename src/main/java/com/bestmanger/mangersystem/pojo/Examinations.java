package com.bestmanger.mangersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author liangrunyong
 * @create 2021-08-2218:11
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Examinations {
    private String examinationid;
    private String examinationname;
    private String teacher;
    private String maxpeople;
    private String number;//实验表明：form提交string以及给实体类最后会自动被转换为int，数据库为int插入string时不报错
    private String telphone;
    private String opentime;
    private String closetime;
    private String remarks;
}
