package com.bestmanger.mangersystem.mapper;

import com.bestmanger.mangersystem.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liangrunyong
 * @create 2021-07-318:33
 * 关于User表的方法处理定义
 */
@Mapper
@Repository
public interface UserDao {

    @Select("select * from user")
    public List<User> findAllUsers();

    @Select("select * from user where account=#{account}")//按电话号码查
    public User findUserByAccount(@Param("account") String account);

    @Insert("insert into user values(#{username},#{account},#{password},#{sex},#{birthday},#{education},#{experience})")
    public int insertUser(User user);

    @Select("select * from user where account=#{account} and password=#{password}")//验证账号密码
    public User accountVerification(@Param("account") String account, @Param("password") String password);

    @Update("update user set password=#{password} where account=#{account}")
    public int changePasswordByAccount(@Param("account") String account, @Param("password") String password);

    @Update("update user set username=#{username},sex=#{sex},birthday=#{birthday},education=#{education},experience=#{experience} where account=#{account}")
    public int updateUser(User user);

    @Delete("delete from user where account=#{account}")
    public int deleteUser(String account);
}
