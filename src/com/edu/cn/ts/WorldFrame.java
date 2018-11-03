package com.edu.cn.ts;



import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class WorldFrame {
	//屏幕的宽度和高度
	public static int framewidth=300;
	public static int frameheight=600;
	
	//定义一个公有的面板（便于传参）
	public WorldPanel worldpanel;
	public WorldFrame() {	
		//定义窗口jf
		JFrame jf=new JFrame();
		//设置窗口大小
		jf.setBounds(200,0,framewidth,frameheight);
		//设置窗口容器
		Container container =jf.getContentPane();
		//新建一个面板
	 worldpanel=new WorldPanel();
	 //面板加到容器
		container.add(worldpanel);
		//添加事件处理
		jf.addKeyListener(worldpanel);
		//获取图片
		Toolkit toolkit =Toolkit.getDefaultToolkit();
		Image img=toolkit.getImage("images/1.png");
		//设置窗口图片标题
		jf.setIconImage(img);
		jf.setTitle("腾讯游戏");
		//设置可见
		jf.setVisible(true);
		//设置界面不可修改
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
