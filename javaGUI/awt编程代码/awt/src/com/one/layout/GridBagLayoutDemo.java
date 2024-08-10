package com.one.layout;

import java.awt.*;

public class GridBagLayoutDemo {
    public static void main(String[] args) {
        //1.创建Frame对象
        Frame frame = new Frame("这里是GridBagLayout测试");

        //2.创建GridBagLayout对象
        GridBagLayout gbl = new GridBagLayout();

        //3.把Frame对象的布局管理器设置为GridBagLayout
        frame.setLayout(gbl);

        //4.创建GridBagConstraints对象
        GridBagConstraints gbc = new GridBagConstraints();

        //5.创建容量为10的Button数组
        Button[] bs = new Button[10];

        //6.遍历数组，初始化每一个Button
        for (int i = 0; i < bs.length; i++) {
            bs[i] = new Button("按钮"+(i+1));
        }

        //7.设置所有的GridBagConstraints对象的fill属性为GridBagConstraints.BOTH,当有空白区域时，组件自动扩大占满空白区域
        gbc.fill=GridBagConstraints.BOTH;

        //8.设置GridBagConstraints对象的weightx设置为1,表示横向扩展比例为1
        gbc.weightx=1;

        //9.往frame中添加数组中的前3个Button
        addComponent(frame,bs[0],gbl,gbc);
        addComponent(frame,bs[1],gbl,gbc);
        addComponent(frame,bs[2],gbl,gbc);

        //10.把GridBagConstraints的gridwidth设置为GridBagConstraints.REMAINDER,则表明当前组件是横向最后一个组件
        gbc.gridwidth=GridBagConstraints.REMAINDER;

        //11.把button数组中第四个按钮添加到frame中
        addComponent(frame,bs[3],gbl,gbc);


        //12.把GridBagConstraints的weighty设置为1，表示纵向扩展比例为1
        gbc.weighty=1;

        //13.把button数组中第5个按钮添加到frame中
        addComponent(frame,bs[4],gbl,gbc);

        //14.把GridBagConstaints的gridheight和gridwidth设置为2，表示纵向和横向会占用两个网格
        gbc.gridheight=2;
        gbc.gridwidth=2;

        //15.把button数组中第6个按钮添加到frame中
        addComponent(frame,bs[5],gbl,gbc);

        //16.把GridBagConstaints的gridheight和gridwidth设置为1，表示纵向会占用1个网格
        gbc.gridwidth=1;
        gbc.gridheight=1;
        //17.把button数组中第7个按钮添加到frame中
        addComponent(frame,bs[6],gbl,gbc);

        //18.把GridBagConstraints的gridwidth设置为GridBagConstraints.REMAINDER,则表明当前组件是横向最后一个组件
        gbc.gridwidth=GridBagConstraints.REMAINDER;

        //19.把button数组中第8个按钮添加到frame中
        addComponent(frame,bs[7],gbl,gbc);

        //20.把GridBagConstaints的gridwidth设置为1，表示纵向会占用1个网格
        gbc.gridwidth=1;

        //21.把button数组中第9、10个按钮添加到frame中
        addComponent(frame,bs[8],gbl,gbc);
        addComponent(frame,bs[9],gbl,gbc);
        //frame.setLayout(gbl);
        //22.设置frame为最佳大小
        frame.pack();

        //23.设置frame可见
        frame.setVisible(true);
    }

    public static void addComponent(Container container,Component c,GridBagLayout gridBagLayout,GridBagConstraints gridBagConstraints){
        gridBagLayout.setConstraints(c,gridBagConstraints);
        container.add(c);
    }
}
