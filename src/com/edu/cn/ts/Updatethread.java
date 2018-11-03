package com.edu.cn.ts;

import javax.swing.JOptionPane;

class Updatethread extends Thread{
	//这是一个只要stopme为真，持续执行的线程，监视界面参数的变化
	public WorldPanel  worldpanel;
	public Updatethread(WorldPanel mypanel) {
		this.worldpanel =mypanel;
	}
	public void run() {
		while(true) {
			//公有面板重绘
			this.worldpanel.repaint();
			try {
				if(Contents.stopme)	
					
				this.currentThread().sleep(2);
				else
					{
					this.currentThread().sleep(10000);
}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
