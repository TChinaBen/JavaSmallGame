package com.edu.cn.ts;

import java.awt.Toolkit;
import java.util.Random;

public class SmallPlane extends EnemyPlane {
	
	//public WorldPanel worldpanel;
	public SmallPlane(WorldPanel worldpanel) {
		
		super(worldpanel);
		//根据k的值来加分
		this.k=1;
		//飞机的宽度
		this.width=40;
		//飞机的高度
		this.height=60;
		//控制敌机的速度
		this.speed=10;
		//敌机的生命值
		this.hp=2;
		//获取敌机图片
		this.image=Toolkit.getDefaultToolkit().getImage("imag/飞机.png");
	}

}
