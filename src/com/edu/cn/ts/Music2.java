package com.edu.cn.ts;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URI;
import java.net.URL;
import java.io.*;
import javax.swing.JFrame;

public class Music2 extends JFrame {
	
	File f ;
	URI uri ;
	URL url ;
	public Music2(){
		try {
			f =new File("./music/BOMB.WAV");
			uri = f.toURI();
			url = uri.toURL();
			AudioClip aau;
			aau = Applet.newAudioClip(url);
			aau.play();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
