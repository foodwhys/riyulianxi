package com.one.menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class SimpleMenu {
    //创建窗口
    private Frame frame = new Frame("这里测试菜单相关组件");

    //创建菜单条
    MenuBar menuBar = new MenuBar();

    //创建菜单组件
    Menu fileMenu = new Menu("文件");
    Menu editMenu = new Menu("编辑");
    Menu formatMenu = new Menu("格式");

    //菜单项组件
    MenuItem auto = new MenuItem("自动换行");
    MenuItem copy = new MenuItem("复制");
    MenuItem paste = new MenuItem("粘贴");

    MenuItem comment = new MenuItem("注释",new MenuShortcut(KeyEvent.VK_Q,true));//关联快捷键  ctrl+shift+Q
    MenuItem cancelComment = new MenuItem("取消注释");

    TextArea ta = new TextArea(6,40);

    public void init(){
        //组装视图
        comment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.append("您点击了菜单项： "+e.getActionCommand()+"\n");
            }
        });

        formatMenu.add(comment);
        formatMenu.add(cancelComment);

        //组装编辑菜单
        editMenu.add(auto);
        editMenu.add(copy);
        editMenu.add(paste);
        editMenu.add(formatMenu);

        //组装菜单条
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        //把菜单条放入到Frame中
        frame.setMenuBar(menuBar);

        frame.add(ta);

        //设置frame最佳大小并可见
        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new SimpleMenu().init();
    }
}
