package com.edu.cn.ts;

import javax.swing.JOptionPane;

class Updatethread extends Thread{
	//����һ��ֻҪstopmeΪ�棬����ִ�е��̣߳����ӽ�������ı仯
	public WorldPanel  worldpanel;
	public Updatethread(WorldPanel mypanel) {
		this.worldpanel =mypanel;
	}
	public void run() {
		while(true) {
			//��������ػ�
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
