package com.edu.cn.ts;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


public class EnemyPlane {
	//定义一个判断是小敌机还是大boss的,根据k值加分
		public  int  k;
	public WorldPanel worldpanel;
	//敌机宽度
	public int width =100;
	//敌机高度
	public int height =100;
	//敌机的位置
	public int x;
	public int y;
	//生命值
	public int hp;
	
	public Image image;
	public Image imga = Toolkit.getDefaultToolkit().getImage("imag/爆炸文件.png");
	public int speed;
	//敌机构造函数
	public EnemyPlane(WorldPanel mypane)
	{
		this.worldpanel=mypane;
	}
	//定义一个带有画笔的方法
	public void drawSelf(Graphics g) {
	//如果敌机的生命值大于0，就保持敌机的状态
	 if(hp>0) 
	 { g.drawImage(image, x, y, width,height,null);}
	 //否则 调用Killed函数
	 else
	 {// if(worldpanel.timer%1==0)
		 g.drawImage(imga, x, y, width,height,null);
		 killed();
	 } 
	 //如果敌机移动到界面一下，就除去这个敌机
		if(this.worldpanel.timer%speed==0) {
			y++;
			if(y>=WorldFrame.frameheight) {
				this.worldpanel.enemyplane.remove(this);
			}
		}
	}
	//敌机生命值耗光byebye
	public void killed() {
		this.worldpanel.enemyplane.remove(this);
		//k=1时的小敌机加十分
		//k=2时的大boss加30分
		if(this.k==1) {
			Contents.num+=10;
			new Music2();
		}
		else if(this.k==2) {
			Contents.num+=30;
			new Music();
		}
	}
	//英雄机与敌机碰到，敌机生命值减一
	public void underAttack() {
		if(hp>0) {
			hp--;
		}
	}

}
