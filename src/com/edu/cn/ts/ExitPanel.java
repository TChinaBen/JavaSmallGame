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
		//������� �������
		//���廭��
		class circlePainter extends JPanel{
			@Override
			public void paint(Graphics g) {
				// TODO Auto-generated method stub
				super.paint(g);
				
			
			//����ͼƬ\
				
				
				
				
			g.drawImage(new ImageIcon("imag/exit1.jpg").getImage(),0,0,jf.getWidth(),jf.getHeight(),null);
			//���û��ʵ���ɫ
				g.setFont(new Font("����", Font.BOLD, 20));
				g.setColor(Color.RED);
				g.drawString("GAME OVER!",90,250 );
		        g.drawString("���յ÷�:"+Contents.num,90,290 );
			}
		}
		//����������Ķ�������һ��ʵ�ʵĻ���
		circlePainter cp = new circlePainter();
		//���û���ı���ɫ
		cp.setBackground(Color.pink);
		//�����������ӵ�����
		c.add(cp);
		//���ô�������
		jf.setVisible(true);
		jf.setLocation(200,0);
		jf.setSize(300,600);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
