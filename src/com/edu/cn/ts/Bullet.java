package com.edu.cn.ts;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Bullet {
	//公有面板便于传参
	public WorldPanel worldpanel;
	//子弹的宽度和高度
	public int width =30;
	public int height =30;
	//子弹的位置
	public int rx;
	public int ry;
	public int x;
	public int y;
	int imageindex=0;
	int index=0;
	int inde=0;
	//子弹初始版图片数组以实现视觉连发功能
	public Image []images =new Image[] {
			Toolkit.getDefaultToolkit().getImage("imag/bullet_1.png"),
			Toolkit.getDefaultToolkit().getImage("imag/bullet_2.png"),
			Toolkit.getDefaultToolkit().getImage("imag/bullet_6.png"),
			Toolkit.getDefaultToolkit().getImage("imag/bullet_3.png"),
			Toolkit.getDefaultToolkit().getImage("imag/bullet_4.png"),
			Toolkit.getDefaultToolkit().getImage("imag/bullet_5.png")
	};
	//子弹升级版
	public Image []ima =new Image[] {
			Toolkit.getDefaultToolkit().getImage("imag/b_6.png"),
			Toolkit.getDefaultToolkit().getImage("imag/b_7.png"),
			Toolkit.getDefaultToolkit().getImage("imag/b_8.png"),
			Toolkit.getDefaultToolkit().getImage("imag/b_9.png"),
			Toolkit.getDefaultToolkit().getImage("imag/b_10.png"),
			Toolkit.getDefaultToolkit().getImage("imag/b_11.png")
	};
	
	//构造函数
	public Bullet(WorldPanel mypane)
	{
		this.worldpanel=mypane;
	}
	public void drawSelf(Graphics g) {
		//awardlevel 来控制子弹是否变成升级版
		if(Contents.awardlevel==1)
		//画子弹实现连发效果
		g.drawImage(this.images[imageindex],x,y,width,height,null);
		else if(Contents.awardlevel==2)
			{	//g.drawImage(this.images[inde],rx,ry,width,height,null);
			g.drawImage(this.ima
					[index],x,y,width,height,null);
			//子弹升级版效果持续10秒
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
				//从面板移除子弹
				this.worldpanel.bullets.remove(this);
				}
		
			//碰撞时移除子弹，hp--
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

