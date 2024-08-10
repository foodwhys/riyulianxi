package com.one.ui;

import com.one.component.BackGroundPanel;
import com.one.domain.ResultInfo;
import com.one.net.FailListener;
import com.one.net.PostUtils;
import com.one.net.SuccessListener;
import com.one.util.JsonUtils;
import com.one.util.PathUtils;
import com.one.util.ScreenUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.rmi.server.ExportException;
import java.util.HashMap;
import java.util.Map;

public class MainInterface {

    JFrame jf = new JFrame("黑马图书馆");

    final int WIDTH = 500;
    final int HEIGHT = 300;

    //组装视图
    public void init() throws Exception {
        //设置窗口相关的属性
        jf.setBounds((ScreenUtils.getScreenWidth() - WIDTH) / 2, (ScreenUtils.getScreenHeight() - HEIGHT) / 2, WIDTH, HEIGHT);
        jf.setResizable(false);
        jf.setIconImage(ImageIO.read(new File(PathUtils.getRealPath("logo.png"))));

        //设置窗口的内容

        BackGroundPanel bgPanel = new BackGroundPanel(ImageIO.read(new File(PathUtils.getRealPath("library.jpg"))));
        bgPanel.setBounds(0,0,WIDTH,HEIGHT);
        //组装登录相关的元素
        Box vBox = Box.createVerticalBox();

        //组装用户名
        Box uBox = Box.createHorizontalBox();
        JLabel uLabel = new JLabel("用户名：");
        JTextField uField = new JTextField(15);

        uBox.add(uLabel);
        uBox.add(Box.createHorizontalStrut(20));
        uBox.add(uField);

        //组装密码
        Box pBox = Box.createHorizontalBox();
        JLabel pLabel = new JLabel("密    码：");
        JTextField pField = new JTextField(15);

        pBox.add(pLabel);
        pBox.add(Box.createHorizontalStrut(20));
        pBox.add(pField);

        //组装按钮
        Box btnBox = Box.createHorizontalBox();
        JButton loginBtn = new JButton("登录");
        JButton registBtn = new JButton("注册");

       loginBtn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               //获取用户输入的数据
               String username = uField.getText().trim();
               String password = pField.getText().trim();
               Map<String,String> params = new HashMap<>();
               params.put("username",username);
               params.put("password",password);

               //访问登录接口
               PostUtils.postWithParams("http://localhost:8080/user/login", params, new SuccessListener() {
                   //请求发送成功，服务器正常响应，会执行这里
                   @Override
                   public void success(String result) {//result参数就是服务器响应回来的json字符串
                       ResultInfo info = JsonUtils.parseResult(result);
                       //判断info中的flag标记
                       if (info.isFlag()){
                           //登录成功,跳转到主页面
                           try {
                               new ManagerInterface().init();
                               jf.dispose();
                           } catch (Exception ex) {
                               ex.printStackTrace();
                           }
                       }else{
                          // 登录失败
                           JOptionPane.showMessageDialog(jf,info.getMessage());
                       }
                   }
               }, new FailListener() {
                   //当该请求发送失败后会执行这个方法
                   @Override
                   public void fail() {
                        JOptionPane.showMessageDialog(jf,"网络异常，请稍后重试");
                   }
               });

           }
       });

       registBtn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               //跳转到注册页面
               try {
                   new RegisterInterface().init();
               } catch (Exception ex) {
                   ex.printStackTrace();
               }
               //当前界面消失
               jf.dispose();
           }
       });


        btnBox.add(loginBtn);
        btnBox.add(Box.createHorizontalStrut(100));
        btnBox.add(registBtn);

        vBox.add(Box.createVerticalStrut(50));
        vBox.add(uBox);
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(pBox);
        vBox.add(Box.createVerticalStrut(40));
        vBox.add(btnBox);

        bgPanel.add(vBox);
        jf.add(bgPanel);
        jf.setVisible(true);
    }

    //客户端程序的入口
    public static void main(String[] args) {
        try {
            new MainInterface().init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
