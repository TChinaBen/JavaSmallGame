package com.edu.cn.ts;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Plane {
	public WorldPanel worldpanel;
//  �ɻ����������
	int num = new Random().nextInt(6)+3;
//	�ɻ��Ĵ�С
	int len = 50 ;
//	�ɻ�������
	int planeX[] = new int[num];
//	�ɻ�������
 	int planeY[] = new int[num];
//  �ɻ����ٶ�
	int speed[] = new int[num];
//  boss�ɻ����������
	int num1 = new Random().nextInt(2)+2;
//	boss�ɻ��Ĵ�С
	int len1 = 80 ;
//	boss�ɻ��ĺ�����
	int planeX1[] = new int[num1];
//	boss�ɻ���������
 	int planeY1[] = new int[num1];
//  boss�ɻ����ٶ�
	int speed1[] = new int[num1];
//	��Ļ�Ĵ�С
	int jfw = 500;
	int jfh = 800;
	public Plane(WorldPanel worldpanel){
		this.worldpanel=worldpanel;
	}

	{

//	��ʼ���ɻ��ĸ�������
		for (int i = 0; i < num; i++) {
//	��������� ������̶�
			planeX[i] = new Random().nextInt(jfw-50);	
//	������Ϊ�� �����ƽ���ɳ��Ľ��������ͻȻ����
			planeY[i] = -50;
//	���ò�ͬ���ٶȵķɻ��������Ѷ�  �ٶ���1��5֮��
			speed[i] = new Random().nextInt(4)+1;
		}

	}
	
	{

//		��ʼ��boss�ɻ��ĸ�������
			for (int i = 0; i < num1; i++) {
//		��������� ������̶�
				planeX1[i] = new Random().nextInt(jfw-100);
//		������Ϊ�� �����ƽ���ɳ��Ľ��������ͻȻ����
				planeY1[i] = -80;
//		���ò�ͬ���ٶȵķɻ��������Ѷ�  �ٶ���1��4֮��
				speed1[i] = new Random().nextInt(3)+1;
			}

		}


public void print(Graphics g) {
			for (int i = 0; i < num; i++) {
				g.drawImage(new ImageIcon("imag/enemy.png").getImage(), planeX[i], planeY[i], len, len, null);
			}
//����boss�ɻ�
			for (int i = 0; i < num1; i++) {
				g.drawImage(new ImageIcon("imag/boss1.png").getImage(), planeX1[i], planeY1[i], len1, len1, null);
			}

	
	new Thread(new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			boolean t = true;
			while (t) {
//	�ı�λ��
				for (int i = 0; i < num; i++) {
					planeY[i] += speed[i];
					
					if(planeY[i] > jfh - 300) {
//  ����ɻ�����������Ĵ��壬�Ͱѷɻ��ͻش���������
						planeY[i] = -50;
//  �ɻ���ȥ�����´����µĺ�����λ��							
						planeX[i] = new Random().nextInt(jfw);
//	�ɻ���ȥ���ٶ�Ҳ���
						speed[i] = new Random().nextInt(4)+1;
					}					
				}	
			
//				�߳����� 
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				ͼƬ�ػ�
				worldpanel.repaint();

			}

		}
	}).start();
	
	new Thread(new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			boolean m = true;
			while (m) {
//	�ı�λ��
				for (int i = 0; i < num1; i++) {
					planeY1[i] += speed1[i];
					
					if(planeY1[i] > jfh) {
//  ���boss�ɻ�����������Ĵ��壬�Ͱѷɻ��ͻش���������
						planeY1[i] = -80;
//  boss�ɻ���ȥ�����´����µĺ�����λ��							
						planeX1[i] = new Random().nextInt(jfw);
//	boss�ɻ���ȥ���ٶ�Ҳ���
						speed1[i] = new Random().nextInt(3)+1;
					}					
				}	
			
//				�߳����� 
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				ͼƬ�ػ�
				worldpanel.repaint();

			}

		}
	}).start();

}


	}


