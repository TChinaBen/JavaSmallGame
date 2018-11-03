package com.edu.cn.ts;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class WorldPanel extends JPanel implements KeyListener {
	//Ӣ�۷ɻ���λ������rx,ry,rx1,rx2
	public static int rx=100;
	 public static int ry=400;
	//����һ����ʱ�Ķ���
	public int timer=0;
	
	
	//�½�һ���ӵ��ļ���
	public ArrayList<Bullet> bullets=new ArrayList<Bullet>();
	//�½�һ���л��ļ���
	public ArrayList<EnemyPlane> enemyplane=new ArrayList<EnemyPlane>();
	//����һ����������
	public ArrayList<Award> award =new ArrayList<>();
	//����һ��ÿһ�������һ�ε��߳� ����ÿһ�����ػ���� ������������仯ʱ��λ�ñ仯
	
	public Updatethread updatethread;
	//Ӣ�۷ɻ��Ĵ�С
	int rm=50;
	int rn=50;
	Graphics g;
	//
	private Image imt =Toolkit.getDefaultToolkit().getImage("imag/background_1.png");
	
	//Ӣ�۷ɻ�ͼƬ
	private Image img =Toolkit.getDefaultToolkit().getImage("imag/plane_1.png");
	//Ѫ������
	int n[] = new int[Contents.bloodlevel];
	{
		n[0]=0;
		for(int i=0;i<Contents.bloodlevel;i++)
			n[i]=i*10;
	}
	//���캯��
	public WorldPanel() {
		
		this.updatethread=new Updatethread(this);
		this.updatethread.start();
		//this.setBackground(Color.pink);
		
		
		}
	public void bool() {
		Contents.bloodlevel--;
	}
	//JPanel �е�paint ����
	@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		//����һ��ʱ�䶨ʱ��
		timer++;
		//ʱ��ӵ�10�������0��ʼ
		if(timer==1000000) 
			timer=0;
		g.drawImage(imt,0,0,WorldFrame.framewidth,WorldFrame.frameheight,null);
		//��Ӣ�۷ɻ�ͼƬͼƬ
		g.drawImage(img, rx, ry, rm, rn, this);
		//�������д������Ի�����Ϸ�÷�
		g.setFont(new Font("����", Font.BOLD, 20));
		g.setColor(Color.GREEN);
        g.drawString("��Ϸ�÷�:"+Contents.num, 5,17 );
        //��Ѫ��ͼ
        g.setColor(Color.RED);
        for(int i=0;i<Contents.bloodlevel;i++) {
        	g.fillRect(n[i],561,10,10);
        }
       /* if(Contents.awardlevel==2) {
        	if(timer%200==0) {
    			
    			Bullet bullet1 =new Bullet(this);
    			bullet1.rx=rx+rm/2-14;
    			bullet1.ry =ry;
    			//�ӵ�bullet �ӵ��ӵ��ļ���
    			this.bullets.add(bullet1);
    		}
    		
        }
		*///ÿ��200���봴��һ���µ��ӵ�
		if(timer%200==0) {
			
			Bullet bullet =new Bullet(this);
			bullet.x=rx+rm/2-14;
			bullet.y =ry;
			//�ӵ�bullet �ӵ��ӵ��ļ���
			this.bullets.add(bullet);
		}
		//�����е�ÿһ���ӵ��������drawSELF����
		for(int i=0;i<bullets.size();i++)
		this.bullets.get(i).drawSelf(g);
		
		//ÿ��1500���봴��һ���µ�С�л�
		if(timer%1500==0) {
			SmallPlane smallplane =new SmallPlane(this);
			smallplane.x=new Random().nextInt(300);
			smallplane.y=new Random().nextInt(10);
			this.enemyplane.add(smallplane);
			}
		//�����е�ÿһ�����˶������drawself����
		for(int i=0;i<enemyplane.size();i++)
			this.enemyplane.get(i).drawSelf(g);
		//ÿ��1500���봴��һ���µ�С�л�
		if(timer%3000==0) {
			BossPlane bossplane =new BossPlane(this);
			bossplane.x=new Random().nextInt(300);
			bossplane.y=new Random().nextInt(10);
			this.enemyplane.add(bossplane);
			}
		//�����е�ÿһ�����˶������drawself����
		for(int i=0;i<enemyplane.size();i++)
			this.enemyplane.get(i).drawSelf(g);
		//ÿ��10000����һ���������ӵ����Ա仯�ӵ�
		if(timer%10000==0) {
			Award award1 =new Award(this);
			award1.x=new Random().nextInt(300);
			award1.y=new Random().nextInt(10);
			this.award.add(award1);
			}
		//�����е�ÿһ�������������drawself����
		for(int i=0;i<award.size();i++)
			this.award.get(i).drawSelf(g);
		
	//���Ӣ�۷ɻ������л�����Ϸ�������ò���stopme ������
	for(int i=0;i<this.enemyplane.size();i++ ) {
		
		EnemyPlane e =this.enemyplane.get(i);
		if(this.rx>(e.x-this.rm)&&this.rx<(e.x+e.width)&&this.ry>(e.y-this.rn)
				&&this.ry<(e.y+e.height)) {
			if(Contents.bloodlevel==0) {
			new ExitPanel().print();
				
				Contents.stopme=false;}
			if(timer%100==0)
				bool();
			
			
			
			}
		}
	//�ж�Ӣ�۷ɻ��Ƿ�ײ����������ʹ��awardlevelֵ�仯
	for(int i=0;i<this.award.size();i++ ) {
		
		Award e =this.award.get(i);
		if(this.rx>(e.x-this.rm)&&this.rx<(e.x+e.width)&&this.ry>(e.y-this.rn)
				&&this.ry<(e.y+e.height)) {
			
			
			this.award.remove(this.award.get(i));
	        new AwardMusic();
			Contents.awardlevel=2;
			
		
					}
		
			
			}
			
			}
	
	
		// �ü��̿��Ʒɻ��ƶ�
	@Override
	public void keyPressed(KeyEvent e) {
		int num=e.getKeyCode();
		//���Ʒɻ��ƶ�
		switch(num) {
		case 37:
		if(rx>3)rx=rx-5;
		break;
		case 38:
			ry-=5;
		
			break;
		case 39:
		if(rx<250) rx=rx+5;
		break;
		case 40:
		if(ry<this.getHeight()-50) ry+=5;
		break;
		}	
		repaint();		
	
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
		}
