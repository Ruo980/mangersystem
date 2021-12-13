package com.bestmanger.mangersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author liangrunyong
 * @create 2021-08-1416:38
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manger {
    private String account;
    private String password;

}
