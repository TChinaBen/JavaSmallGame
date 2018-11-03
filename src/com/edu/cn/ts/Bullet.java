package com.edu.cn.ts;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Bullet {
	//���������ڴ���
	public WorldPanel worldpanel;
	//�ӵ��Ŀ�Ⱥ͸߶�
	public int width =30;
	public int height =30;
	//�ӵ���λ��
	public int rx;
	public int ry;
	public int x;
	public int y;
	int imageindex=0;
	int index=0;
	int inde=0;
	//�ӵ���ʼ��ͼƬ������ʵ���Ӿ���������
	public Image []images =new Image[] {
			Toolkit.getDefaultToolkit().getImage("imag/bullet_1.png"),
			Toolkit.getDefaultToolkit().getImage("imag/bullet_2.png"),
			Toolkit.getDefaultToolkit().getImage("imag/bullet_6.png"),
			Toolkit.getDefaultToolkit().getImage("imag/bullet_3.png"),
			Toolkit.getDefaultToolkit().getImage("imag/bullet_4.png"),
			Toolkit.getDefaultToolkit().getImage("imag/bullet_5.png")
	};
	//�ӵ�������
	public Image []ima =new Image[] {
			Toolkit.getDefaultToolkit().getImage("imag/b_6.png"),
			Toolkit.getDefaultToolkit().getImage("imag/b_7.png"),
			Toolkit.getDefaultToolkit().getImage("imag/b_8.png"),
			Toolkit.getDefaultToolkit().getImage("imag/b_9.png"),
			Toolkit.getDefaultToolkit().getImage("imag/b_10.png"),
			Toolkit.getDefaultToolkit().getImage("imag/b_11.png")
	};
	
	//���캯��
	public Bullet(WorldPanel mypane)
	{
		this.worldpanel=mypane;
	}
	public void drawSelf(Graphics g) {
		//awardlevel �������ӵ��Ƿ���������
		if(Contents.awardlevel==1)
		//���ӵ�ʵ������Ч��
		g.drawImage(this.images[imageindex],x,y,width,height,null);
		else if(Contents.awardlevel==2)
			{	//g.drawImage(this.images[inde],rx,ry,width,height,null);
			g.drawImage(this.ima
					[index],x,y,width,height,null);
			//�ӵ�������Ч������10��
			if(this.worldpanel.timer%10000==0) {
				Contents.awardlevel=1;
			}
		}
		if(this.worldpanel.timer%1==0) {
			{imageindex++;
				
			if(imageindex==this.images.length)
				imageindex=0;
			y--;
			}
			
			{
			index++;
			if(index==this.ima.length)
				index=0;
			y--;
			}
			if(y<0) {
				//������Ƴ��ӵ�
				this.worldpanel.bullets.remove(this);
				}
		
			//��ײʱ�Ƴ��ӵ���hp--
			for(int i=0;i<this.worldpanel.enemyplane.size();i++ ) {
				EnemyPlane e =this.worldpanel.enemyplane.get(i);
				if(this.x>(e.x-this.width)&&this.x<(e.x+e.width)&&this.y>(e.y-this.height)
						&&this.y<(e.y+e.height)) {
					this.worldpanel.bullets.remove(this);
					e.underAttack();
					}
				
				
			}
		}
	}
	}

