package com.one.listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ListenerDemo1 {
    public static void main(String[] args) {
        Frame frame = new Frame("这里测试监听器");

        //创建组件（事件源）
        TextField tf = new TextField(30);
        Choice names = new Choice();
        names.add("柳岩");
        names.add("舒淇");
        names.add("闫妮");

        //给文本域添加TextListener，监听内容的变化
        tf.addTextListener(new TextListener() {
            @Override
            public void textValueChanged(TextEvent e) {
                String text = tf.getText();
                System.out.println("当前文本框中的内容为："+text);
            }
        });


        //给下拉选择框添加ItemListener，监听条目选项的变化
        names.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Object item = e.getItem();
                System.out.println("当前选中的条目为："+item);
            }
        });


        //给frame注册ContainerListener监听器，监听容器中组件的添加
        frame.addContainerListener(new ContainerListener() {
            @Override
            public void componentAdded(ContainerEvent e) {
                Component child = e.getChild();
                System.out.println("frame中添加了："+child);
            }

            @Override
            public void componentRemoved(ContainerEvent e) {

            }
        });


        //添加到frame中
        Box hBox = Box.createHorizontalBox();
        hBox.add(names);
        hBox.add(tf);
        frame.add(hBox);

        //设置frame最佳大小并可见
        frame.pack();
        frame.setVisible(true);
    }
}
