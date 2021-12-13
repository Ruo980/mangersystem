package com.bestmanger.mangersystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author :liangrunyong
 * @create :2021-08-2516:57
 * @description :身份证号操作
 */
@Mapper
@Repository
public interface IDNumberDao {

    @Select("select idnumber from accountidnumber where account=#{account}")
    String findIdByAccount(String account);
}
