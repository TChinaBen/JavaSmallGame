package com.edu.cn.ts;

import java.awt.Toolkit;

public class Award extends EnemyPlane{
	public Award(WorldPanel worldpanel) {
		super(worldpanel);
		this.width=20;
		this.height=20;
		this.speed=5;
		this.hp=1;
		this.image=Toolkit.getDefaultToolkit().getImage("imag/½±Àø.png");
	}

}
