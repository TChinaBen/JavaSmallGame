package com.edu.cn.ts;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


public class EnemyPlane {
	//����һ���ж���С�л����Ǵ�boss��,����kֵ�ӷ�
		public  int  k;
	public WorldPanel worldpanel;
	//�л����
	public int width =100;
	//�л��߶�
	public int height =100;
	//�л���λ��
	public int x;
	public int y;
	//����ֵ
	public int hp;
	
	public Image image;
	public Image imga = Toolkit.getDefaultToolkit().getImage("imag/��ը�ļ�.png");
	public int speed;
	//�л����캯��
	public EnemyPlane(WorldPanel mypane)
	{
		this.worldpanel=mypane;
	}
	//����һ�����л��ʵķ���
	public void drawSelf(Graphics g) {
	//����л�������ֵ����0���ͱ��ֵл���״̬
	 if(hp>0) 
	 { g.drawImage(image, x, y, width,height,null);}
	 //���� ����Killed����
	 else
	 {// if(worldpanel.timer%1==0)
		 g.drawImage(imga, x, y, width,height,null);
		 killed();
	 } 
	 //����л��ƶ�������һ�£��ͳ�ȥ����л�
		if(this.worldpanel.timer%speed==0) {
			y++;
			if(y>=WorldFrame.frameheight) {
				this.worldpanel.enemyplane.remove(this);
			}
		}
	}
	//�л�����ֵ�Ĺ�byebye
	public void killed() {
		this.worldpanel.enemyplane.remove(this);
		//k=1ʱ��С�л���ʮ��
		//k=2ʱ�Ĵ�boss��30��
		if(this.k==1) {
			Contents.num+=10;
			new Music2();
		}
		else if(this.k==2) {
			Contents.num+=30;
			new Music();
		}
	}
	//Ӣ�ۻ���л��������л�����ֵ��һ
	public void underAttack() {
		if(hp>0) {
			hp--;
		}
	}

}
