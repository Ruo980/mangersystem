package com.bestmanger.mangersystem.mapper;

import com.bestmanger.mangersystem.pojo.Protocol;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author :liangrunyong
 * @create :2021-08-2615:25
 * @description : 用户上传协议操作
 */
@Mapper
@Repository
public interface ProtocolDao {

    @Select("select * from userprotocol")
    List<Protocol> selectUserProtocol();
}
