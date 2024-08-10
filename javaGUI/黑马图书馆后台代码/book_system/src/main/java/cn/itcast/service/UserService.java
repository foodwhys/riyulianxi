package cn.itcast.service;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserService {
    @Autowired
    private UserDao userDao;
    //查询所有用户
    public List<User> findAll(){
        return userDao.findAll();
    }

    //根据id查询一个用户
    public User findById(Integer id){
        return userDao.findById(id);
    }

    //根据用户名和密码查询用户
    public User findByUsernameAndPassword(String username,String password){
        return userDao.findByUsernameAndPassword(username,password);
    }

    //根据id删除用户
    public void deleteById(Integer id){
        userDao.deleteById(id);
    }

    //修改用户
    public void update(User user){
        userDao.update(user);
    }

    //添加用户
    public void add(User user){
        userDao.add(user);
    }


}
