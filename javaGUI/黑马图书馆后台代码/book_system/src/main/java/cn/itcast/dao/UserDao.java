package cn.itcast.dao;

import cn.itcast.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao{

    //查询所有用户
    @Select("select * from user")
    public List<User> findAll();

    //根据id查询一个用户
    @Select("select * from user where id=#{id}")
    public User findById(Integer id);

    //根据用户名和密码查询用户
    @Select("select * from user where username=#{username} and password=#{password} ")
    public User findByUsernameAndPassword(@Param("username") String username,@Param("password")String password);

    //根据id删除用户
    @Delete("delete from user where id=#{id}")
    public void deleteById(Integer id);

    //修改用户
    @Update("update user set username=#{username},password=#{password},phone=#{phone},gender=#{gender} where id=#{id} ")
    public void update(User user);

    //添加用户
    @Insert("insert into user(username,password,phone,gender) values(#{username},#{password},#{phone},#{gender})")
    public void add(User user);

}
