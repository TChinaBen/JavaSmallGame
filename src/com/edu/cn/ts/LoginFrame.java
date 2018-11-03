package com.edu.cn.ts;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class LoginFrame {
	//创建Login对象
	public static  LoginFrame login;
	//创建一个JButtond对象 
	public static  MyJButton button1 ;
	  	public LoginFrame() {
	  		//创建一个窗体jf
	        JFrame jf = new JFrame ();
	        
	        jf.setBounds (200, 0, 300, 400);
	        jf.setTitle ("飞机大战");
	        jf.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	        //创建
	         button1 = new MyJButton ();
	       // MyJButton button2 = new MyJButton ();
	        button1.setBounds (100,250, 100,50);
	     //   button2.setBounds (100,200, 100, 30);
	      //按钮放到框架Jf		
	        jf.add (button1);
	       // 创建一个MyJpanel对象bp
	        MyJPanel bp = new MyJPanel ();
	        
	        jf.add (bp);
	        
	        bp.setLayout (null);
	        
	        jf.setVisible (true);
	  	}
	    public static void main(String[] args) {
			 login =new LoginFrame();
			login.print();
			playMusic();
		}
	    public static void playMusic() {
	    	BgMusic sound = new BgMusic("./music/BGM.wav");
	    	InputStream stream = new ByteArrayInputStream(sound.getSamples());



	    	new Thread(new Runnable() {
	    				@Override
	    				public void run() {
	    					// TODO 自动生成的方法存根
	    					while(true) {
	    						sound.play(stream);
	    					}
	    				}}).start();
	    }
	    //在一个方法中定义一个事件处理
	    public void print() {
	    	button1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new WorldFrame();
			//		login.dispose();
				}
			});
	    }
	    /*public void dispose() {
	    	login.dispose();
	    }
	    */	 
	}
	
	class MyJButton extends JButton 
	{
	    public void paintComponent ( Graphics f )
	    {	
	        ImageIcon imgIcon1 = new ImageIcon ("imag/center.jpg");	
	        Image img1 = imgIcon1.getImage ();	      
	        f.drawImage (img1, 0, 0, 100, 50, null);	
	    }

		}
	
	 
	class MyJPanel extends JPanel
	{
	    public void paint ( Graphics g )
	    {
	        super.paint (g);
	        ImageIcon imgIcon = new ImageIcon ("imag/飞机大作战.png");
	        Image img = imgIcon.getImage ();
	        g.drawImage (img, 0, 0, 300, 400, null);
	    }
	}