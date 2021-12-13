package com.bestmanger.mangersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;


/**
 * @author liangrunyong
 * @create 2021-07-318:20
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private String username;//用户真实姓名而非账号名
    private String account;
    private String password;
    private String sex;
    private String birthday;
    private String education;
    private String experience;
}
