package com.bestmanger.mangersystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author :liangrunyong
 * @create :2021-08-2614:34
 * @description : 用户协议上传
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Protocol {
    private String protocolname;
    private String uploadtime;
    private String account;
    private String username;
}
