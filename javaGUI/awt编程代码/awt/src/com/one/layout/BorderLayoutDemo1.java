package com.one.layout;

import java.awt.*;

public class BorderLayoutDemo1 {
    public static void main(String[] args) {

        Frame frame = new Frame("这里测试BorderLayout");

        //1.给frame设置BorderLayout布局管理器
        frame.setLayout(new BorderLayout(30,10));

        //2.往frame的指定区域添加组件
        frame.add(new Button("北侧按钮"),BorderLayout.NORTH);
        frame.add(new Button("南侧按钮"),BorderLayout.SOUTH);
        frame.add(new Button("东侧按钮"),BorderLayout.EAST);
        frame.add(new Button("西侧按钮"),BorderLayout.WEST);
        frame.add(new Button("中间按钮"),BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }
}
