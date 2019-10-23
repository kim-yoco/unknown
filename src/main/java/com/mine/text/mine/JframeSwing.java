/**
 * 
 */
package com.mine.text.mine;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * @author admin
 *
 */
public class JframeSwing {
	
	public JframeSwing() {
		JTextField url = new JTextField("C:\\Users\\admin\\Pictures\\desktop\\");
		JButton btCreat = new JButton("CREATE");
		JButton btExit = new JButton("EXIT");
		JTextArea area = new JTextArea();
//		area.
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int xbox = (int)(toolkit.getScreenSize().getWidth()*0.6);
		int ybox = (int)(toolkit.getScreenSize().getHeight()*0.6);
		//启动位置x轴y轴
		int x = (int)(toolkit.getScreenSize().getWidth()-xbox)/2;
		int y = (int)(toolkit.getScreenSize().getHeight()-ybox)/2;
		JFrame jf = new JFrame();
		//设置外层容器
		jf.setBounds(new Rectangle(x, y, xbox, ybox));
		Container c = jf.getContentPane();
		c.setLayout(null);
		JLabel uJ = new JLabel("URL");
		uJ.setBounds(50, 10, 50, 50);
		c.add(uJ);
		url.setBounds(130, 10, 500, 50);
		c.add(url);
		JLabel dJ = new JLabel("DATA");
		dJ.setBounds(50, 70, 50, 50);
		area.setBounds(130, 70, 500, 100);
		area.setLineWrap(true);
		JScrollPane jsp = new JScrollPane(area);
		jsp.setBounds(130, 70, 500, 100);
		c.add(dJ);
		c.add(jsp);
		c.add(btCreat);
		c.add(btExit);
		btCreat.setBounds(10,400,100,50);
		btExit.setBounds(120,400,100,50);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.setVisible(true);
		btExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		btCreat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		JframeSwing j =new JframeSwing();
		
	}
}

