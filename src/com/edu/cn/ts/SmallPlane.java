package com.edu.cn.ts;

import java.awt.Toolkit;
import java.util.Random;

public class SmallPlane extends EnemyPlane {
	
	//public WorldPanel worldpanel;
	public SmallPlane(WorldPanel worldpanel) {
		
		super(worldpanel);
		//����k��ֵ���ӷ�
		this.k=1;
		//�ɻ��Ŀ��
		this.width=40;
		//�ɻ��ĸ߶�
		this.height=60;
		//���Ƶл����ٶ�
		this.speed=10;
		//�л�������ֵ
		this.hp=2;
		//��ȡ�л�ͼƬ
		this.image=Toolkit.getDefaultToolkit().getImage("imag/�ɻ�.png");
	}

}
