package com.bestmanger.mangersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author :liangrunyong
 * @create :2021-08-2516:56
 * @description : 身份证号
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class accountidnumber {
    private String account;
    private String idnumber;
}
