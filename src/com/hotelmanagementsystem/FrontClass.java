package com.hotelmanagementsystem;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class Front extends JFrame implements ActionListener{
	
	private JLabel l1,l2,l3,l4;
	private Container c;
	private JButton b1;
	Front(){
		
		setBounds(20,10,1280,720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		c=getContentPane();
		c.setLayout(null);
		
		c.setBackground(Color.WHITE);
		
		l1=new JLabel("HOTEL MANAGEMENT SYSTEM");
		l1.setBounds(160,90,1100,50);
		l1.setForeground(Color.MAGENTA);
		Font font=new Font("Arial",Font.BOLD,60);	
		l1.setFont(font);
		l3=new JLabel("BY RAHUL JHA");
		l3.setBounds(420, 260, 900, 50);
		l3.setForeground(Color.GREEN);
		l3.setFont(new Font("Arial",Font.BOLD,50));
		ImageIcon image=new ImageIcon("C:\\Users\\RAHUL\\eclipse-workspace\\JavaCourse\\Hotel Management System\\src\\com\\hotelmanagementsystem\\back.png");
		Image img=image.getImage().getScaledInstance(1280,720,  Image.SCALE_DEFAULT);
		ImageIcon img1=new ImageIcon(img); 
		
		l2=new JLabel(img1);
		l2.setBounds(0,0,1280,720);
		
		
		b1=new JButton("LOGIN");
		
		b1.setBounds(530,400,150,30);
		b1.setBackground(Color.WHITE);
		b1.setForeground(Color.BLACK);
		
		c.add(l1);
		c.add(l3);
		c.add(b1);
		c.add(l2);
		
		b1.addActionListener(this);
		setVisible(true);
		while(true){
			l1.setVisible(false);
			try {
				Thread.sleep(1000);
			}catch(Exception e1) {}
			l1.setVisible(true);
			try {
				Thread.sleep(1000);
			}catch(Exception e1) {}
			
			
			 
		}
		
		
		
		
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			
			new Login().setVisible(true);;
			
		setVisible(false);
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		
	}
	
}
public class FrontClass {
public static void main(String[] args) {
	new Front();
}
}
