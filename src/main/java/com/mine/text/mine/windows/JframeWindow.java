package com.mine.text.mine.windows;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JframeWindow {
    private JTextField url =new JTextField();
    private JframeWindow(){
        init();
    }
    private void init(){
        try {
            // 获取配置文件地址 文件在系统配置根目录直接用名字获取 生成文件
            File file = new File(ClassLoader.getSystemResource("config.properties").getPath());
            InputStream in = new FileInputStream(file);
            // 用java原生获取配置文件
            Properties properties = new Properties();
            properties.load(in);
            url.setText(properties.getProperty("url"));
        } catch (IOException ex){
            //ex.getMessage();
        }
    }

    public static JframeWindow getInstance(){
        return new JframeWindow();
    }

    public void doit(){
        JFrame jf = new JFrame();
        TextArea ta = new TextArea();
        // 拿两个按钮 一个创建 一个退出
        JButton creatButton = new JButton("CREATE");
        JButton exitButton = new JButton("EXIT");

        // 获取屏幕大小
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int xWindow = (int)toolkit.getScreenSize().getWidth()*1;
        int yWindow = (int)toolkit.getScreenSize().getHeight()*1;
        // 启动位置
        int xStrat = 100;
        int yStart = 100;
        // 窗口大小
        int xFrame = 500;
        int yFrame = 200;

        jf.setBounds(new Rectangle(xStrat,yStart,xFrame,yFrame));
        Container c = jf.getContentPane();
        c.setLayout(new GridLayout(4, 2, 10, 10));
        c.add(new JLabel("URL"));
        c.add(url);
        c.setLayout(new GridLayout(4, 2, 20, 20));
        c.add(new JLabel("DATA"));
//		c.add(txtdata);
        c.add(ta);
        c.add(creatButton);
        c.add(exitButton);
        creatButton.setBounds(new Rectangle( 10, 10, 100, 100));
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        jf.setVisible(true);
        //监听 exit按钮
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Auto-generated method stub
                System.exit(0);
            }
        });
        creatButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

            }
        });
        System.out.println("------");
    }

    public static void main(String[] args) {
        JframeWindow j = new JframeWindow();
        j.doit();
    }
}
