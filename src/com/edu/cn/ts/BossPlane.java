package com.edu.cn.ts;

import java.awt.Toolkit;

public class BossPlane extends EnemyPlane {
	
	public BossPlane(WorldPanel mypane) {
		super(mypane);
		this.k=2;
		this.width=40;
		this.height=60;
		this.speed=10;
		this.hp=5;
		this.image=Toolkit.getDefaultToolkit().getImage("imag/plane_6.png");
	}
	
}
