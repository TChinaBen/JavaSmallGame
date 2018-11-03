package com.edu.cn.ts;



import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class WorldFrame {
	//��Ļ�Ŀ�Ⱥ͸߶�
	public static int framewidth=300;
	public static int frameheight=600;
	
	//����һ�����е���壨���ڴ��Σ�
	public WorldPanel worldpanel;
	public WorldFrame() {	
		//���崰��jf
		JFrame jf=new JFrame();
		//���ô��ڴ�С
		jf.setBounds(200,0,framewidth,frameheight);
		//���ô�������
		Container container =jf.getContentPane();
		//�½�һ�����
	 worldpanel=new WorldPanel();
	 //���ӵ�����
		container.add(worldpanel);
		//����¼�����
		jf.addKeyListener(worldpanel);
		//��ȡͼƬ
		Toolkit toolkit =Toolkit.getDefaultToolkit();
		Image img=toolkit.getImage("images/1.png");
		//���ô���ͼƬ����
		jf.setIconImage(img);
		jf.setTitle("��Ѷ��Ϸ");
		//���ÿɼ�
		jf.setVisible(true);
		//���ý��治���޸�
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
