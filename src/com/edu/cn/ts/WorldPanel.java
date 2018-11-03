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
	//英雄飞机的位置坐标rx,ry,rx1,rx2
	public static int rx=100;
	 public static int ry=400;
	//定义一个定时的东西
	public int timer=0;
	
	
	//新建一个子弹的集合
	public ArrayList<Bullet> bullets=new ArrayList<Bullet>();
	//新建一个敌机的集合
	public ArrayList<EnemyPlane> enemyplane=new ArrayList<EnemyPlane>();
	//定义一个奖励集合
	public ArrayList<Award> award =new ArrayList<>();
	//这是一个每一毫秒更新一次的线程 用于每一毫秒重绘界面 当飞行器坐标变化时，位置变化
	
	public Updatethread updatethread;
	//英雄飞机的大小
	int rm=50;
	int rn=50;
	Graphics g;
	//
	private Image imt =Toolkit.getDefaultToolkit().getImage("imag/background_1.png");
	
	//英雄飞机图片
	private Image img =Toolkit.getDefaultToolkit().getImage("imag/plane_1.png");
	//血量数组
	int n[] = new int[Contents.bloodlevel];
	{
		n[0]=0;
		for(int i=0;i<Contents.bloodlevel;i++)
			n[i]=i*10;
	}
	//构造函数
	public WorldPanel() {
		
		this.updatethread=new Updatethread(this);
		this.updatethread.start();
		//this.setBackground(Color.pink);
		
		
		}
	public void bool() {
		Contents.bloodlevel--;
	}
	//JPanel 中的paint 函数
	@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		//定义一个时间定时器
		timer++;
		//时间加到10秒后重新0开始
		if(timer==1000000) 
			timer=0;
		g.drawImage(imt,0,0,WorldFrame.framewidth,WorldFrame.frameheight,null);
		//画英雄飞机图片图片
		g.drawImage(img, rx, ry, rm, rn, this);
		//以下三行代码用以绘制游戏得分
		g.setFont(new Font("宋体", Font.BOLD, 20));
		g.setColor(Color.GREEN);
        g.drawString("游戏得分:"+Contents.num, 5,17 );
        //画血量图
        g.setColor(Color.RED);
        for(int i=0;i<Contents.bloodlevel;i++) {
        	g.fillRect(n[i],561,10,10);
        }
       /* if(Contents.awardlevel==2) {
        	if(timer%200==0) {
    			
    			Bullet bullet1 =new Bullet(this);
    			bullet1.rx=rx+rm/2-14;
    			bullet1.ry =ry;
    			//子弹bullet 加到子弹的集合
    			this.bullets.add(bullet1);
    		}
    		
        }
		*///每隔200毫秒创建一个新的子弹
		if(timer%200==0) {
			
			Bullet bullet =new Bullet(this);
			bullet.x=rx+rm/2-14;
			bullet.y =ry;
			//子弹bullet 加到子弹的集合
			this.bullets.add(bullet);
		}
		//集合中的每一个子弹对象调用drawSELF函数
		for(int i=0;i<bullets.size();i++)
		this.bullets.get(i).drawSelf(g);
		
		//每隔1500毫秒创建一个新的小敌机
		if(timer%1500==0) {
			SmallPlane smallplane =new SmallPlane(this);
			smallplane.x=new Random().nextInt(300);
			smallplane.y=new Random().nextInt(10);
			this.enemyplane.add(smallplane);
			}
		//集合中的每一个敌人对象调用drawself函数
		for(int i=0;i<enemyplane.size();i++)
			this.enemyplane.get(i).drawSelf(g);
		//每隔1500毫秒创建一个新的小敌机
		if(timer%3000==0) {
			BossPlane bossplane =new BossPlane(this);
			bossplane.x=new Random().nextInt(300);
			bossplane.y=new Random().nextInt(10);
			this.enemyplane.add(bossplane);
			}
		//集合中的每一个敌人对象调用drawself函数
		for(int i=0;i<enemyplane.size();i++)
			this.enemyplane.get(i).drawSelf(g);
		//每隔10000产生一个奖励，接到可以变化子弹
		if(timer%10000==0) {
			Award award1 =new Award(this);
			award1.x=new Random().nextInt(300);
			award1.y=new Random().nextInt(10);
			this.award.add(award1);
			}
		//集合中的每一个奖励对象调用drawself函数
		for(int i=0;i<award.size();i++)
			this.award.get(i).drawSelf(g);
		
	//如果英雄飞机碰到敌机，游戏结束，用参数stopme 来控制
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
	//判断英雄飞机是否撞到奖励，将使得awardlevel值变化
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
	
	
		// 用键盘控制飞机移动
	@Override
	public void keyPressed(KeyEvent e) {
		int num=e.getKeyCode();
		//控制飞机移动
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
