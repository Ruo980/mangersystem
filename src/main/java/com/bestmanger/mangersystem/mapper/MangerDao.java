package com.bestmanger.mangersystem.mapper;

import com.bestmanger.mangersystem.pojo.Manger;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author liangrunyong
 * @create 2021-08-1416:38
 */
@Mapper
@Repository
public interface MangerDao {
    @Select("select * from manger where account=#{account} and password=#{password}")//验证账号密码
    public Manger accountVerification(@Param("account") String account, @Param("password") String password);
}
