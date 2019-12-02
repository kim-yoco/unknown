/**
 * 
 */
package com.mine.text.mine;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.apache.commons.codec.binary.Base64;

/**
 * 
 * @author admin
 *
 */
public class JFrameWindow {
	private static final String KEK_URL = "URL";
	private static final String KEY_DATA = "DATA";
	// 默认地址
	JTextField txturl = new JTextField("C:\\Users\\admin\\Pictures\\desktop\\");
	public JFrameWindow() {
		//容器
		JFrame jf = new JFrame();
		TextArea tadata = new TextArea();
		JButton createBt= new JButton("CREAT");
		JButton exitBt = new JButton("EXIT");
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int xbox = (int)(toolkit.getScreenSize().getWidth()*0.6);
		int ybox = (int)(toolkit.getScreenSize().getHeight()*0.6);
		//启动位置x轴y轴
		int x = (int)(toolkit.getScreenSize().getWidth()-xbox)/2;
		int y = (int)(toolkit.getScreenSize().getHeight()-ybox)/2;
		
		jf.setBounds(new Rectangle(x, y, xbox, ybox));
		
		Container c = jf.getContentPane();
		c.setLayout(new GridLayout(4, 2, 10, 10));
		c.add(new JLabel(KEK_URL));
		c.add(txturl);
		c.add(new JLabel(KEY_DATA));
//		c.add(txtdata);
		c.add(tadata);
		c.add(createBt);
		c.add(exitBt);
		createBt.setBounds(new Rectangle( 10, 10, 100, 100));
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.setVisible(true);
		exitBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		createBt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String url = txturl.getText();
//				String data = txtdata.getText();
				String data = tadata.getText();
				data = data.substring(data.indexOf("base64,")+7,data.lastIndexOf("&quot;"));
				genImage(url,data);
				tadata.setText("");
			}
		});
	}
	
	public void genImage(String url, String imgStr) {
    	if(null != imgStr) {
    		Base64 bs = new Base64();
    		byte[] b = bs.decodeBase64(imgStr);
    		for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }
            //生成jpeg图片C
    		Date date = new Date();
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    		String name = sdf.format(date);
            String imgFilePath = url+name+".jpg"; //新生成的图片
            OutputStream out;
			try {
				out = new FileOutputStream(imgFilePath);
	            out.write(b);
	            out.flush();
	            out.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
	
//	public static void main(String[] args) {
//		Toolkit tk = Toolkit.getDefaultToolkit();
//		Dimension size = tk.getScreenSize();
//		System.out.println(size.width + "*" +size.height);
//	}
}
