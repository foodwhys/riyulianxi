package cn.itcast.controller;

import cn.itcast.domain.ResultInfo;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //登录
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ResultInfo login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return new ResultInfo(false, null, "请正确填写用户名或密码");
        } else {

            User fUser = userService.findByUsernameAndPassword(username, password);
            if (fUser == null) {
                return new ResultInfo(false, null, "用户名或密码错误");
            }

            session.setAttribute("user", fUser);
            return new ResultInfo(true, null, "登录成功");
        }
    }

    //注册
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public ResultInfo register(User user,String checkCode,HttpSession session) {
        String o_checkCode = (String) session.getAttribute("checkCode");
        session.removeAttribute("checkCode");
        if (o_checkCode==null){
            return new ResultInfo(false,null,"请刷新验证码");
        }

        if (checkCode==null || !o_checkCode.equalsIgnoreCase(checkCode)){
            return new ResultInfo(false,null,"验证码错误");
        }


        userService.add(user);
        return new ResultInfo(true, null, "注册成功");
    }

    //查询所有用户列表
    @RequestMapping(path = "/findAllUser", method = RequestMethod.GET)
    public ResultInfo findAllUser() {
        List<User> users = userService.findAll();
        return new ResultInfo(true, users, "查询成功");
    }

    //根据id查询一个用户
    @RequestMapping(path = "/findUserById", method = RequestMethod.GET)
    public ResultInfo findUserById(Integer id) {
        User user = userService.findById(id);
        return new ResultInfo(true, user, "查询成功");
    }

    //删除用户
    @RequestMapping(path = "/deleteUserById", method = RequestMethod.GET)
    public ResultInfo deleteUserById(Integer id) {
        userService.deleteById(id);
        return new ResultInfo(true, null, "删除成功");
    }

    //修改用户
    @RequestMapping(path = "/updateUser", method = RequestMethod.POST)
    public ResultInfo updateUser(User user) {
        userService.update(user);
        return new ResultInfo(true, null, "修改成功");
    }

    //添加用户
    @RequestMapping(path = "/addUser", method = RequestMethod.POST)
    public ResultInfo addUser(User user) {
        userService.add(user);
        return new ResultInfo(true, null, "添加成功");
    }



    //查询session中的用户名
    @RequestMapping(path ="/findUsername", method = RequestMethod.GET)
    public ResultInfo findUsername(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return new ResultInfo(true, user.getUsername(), "查询成功");
    }
}
