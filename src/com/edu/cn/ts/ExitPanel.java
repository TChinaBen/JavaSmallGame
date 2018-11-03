package com.edu.cn.ts;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ExitPanel {
	
	public void print() {
		
		JFrame jf = new JFrame();
		Container c = jf.getContentPane();
		//创建组件 画板组件
		//定义画板
		class circlePainter extends JPanel{
			@Override
			public void paint(Graphics g) {
				// TODO Auto-generated method stub
				super.paint(g);
				
			
			//绘制图片\
				
				
				
				
			g.drawImage(new ImageIcon("imag/exit1.jpg").getImage(),0,0,jf.getWidth(),jf.getHeight(),null);
			//设置画笔的颜色
				g.setFont(new Font("宋体", Font.BOLD, 20));
				g.setColor(Color.RED);
				g.drawString("GAME OVER!",90,250 );
		        g.drawString("最终得分:"+Contents.num,90,290 );
			}
		}
		//创建画板类的对象，运行一个实际的画板
		circlePainter cp = new circlePainter();
		//设置花瓣的背景色
		cp.setBackground(Color.pink);
		//将画板对象添加到窗体
		c.add(cp);
		//设置窗体属性
		jf.setVisible(true);
		jf.setLocation(200,0);
		jf.setSize(300,600);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
