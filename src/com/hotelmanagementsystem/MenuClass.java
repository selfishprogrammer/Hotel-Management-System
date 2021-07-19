package com.hotelmanagementsystem;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

class Menu extends JFrame implements ActionListener{
	
	private JLabel l1,l2,l3,l4,l5;
	JMenuBar m1;
	JMenuItem m2,m3,m4,m5,m6,m9,m10,m11,m12,m13;
	JMenu m7,m8;
	private JButton b1,b2,b3,b4,b5,b6;
	
	private Container c;
	
	Menu(){
		setTitle("Hotel Management");
		setBounds(100,100,900,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		c=getContentPane();
		c.setLayout(null);
		c.setBackground(Color.CYAN);
		
		
		l1=new JLabel("HOTEL MANAGEMENT SYSTEM");
		l1.setBounds(150,10,900,50);
		l1.setForeground(Color.BLACK);
		Font font=new Font("Arial",Font.BOLD,40);	
		l1.setFont(font);
		c.add(l1);
		
		b5=new JButton("BOOK HOTEL");
		b5.setBounds(290,100,130,30);
		b5.setBackground(Color.CYAN);
		c.add(b5);
		b6=new JButton("CHECKOUT");
		b6.setBounds(520,100,130,30);
		b6.setBackground(Color.CYAN);
		c.add(b6);
		ImageIcon image1=new ImageIcon("C:\\Users\\RAHUL\\eclipse-workspace\\JavaCourse\\Hotel Management System\\src\\com\\hotelmanagementsystem\\addemp.png");
		Image img2=image1.getImage().getScaledInstance(130,130,  Image.SCALE_DEFAULT);
		ImageIcon img3=new ImageIcon(img2); 
		l3=new JLabel(img3);
		l3.setBounds(40,220,130,130);
		c.add(l3);
		
		
		ImageIcon image2=new ImageIcon("C:\\Users\\RAHUL\\eclipse-workspace\\JavaCourse\\Hotel Management System\\src\\com\\hotelmanagementsystem\\addhot.png");
		Image img4=image2.getImage().getScaledInstance(150,150,  Image.SCALE_DEFAULT);
		ImageIcon img5=new ImageIcon(img4); 
		l4=new JLabel(img5);
		l4.setBounds(270,210,150,150);
		c.add(l4);
		
		
		
		ImageIcon image3=new ImageIcon("C:\\Users\\RAHUL\\eclipse-workspace\\JavaCourse\\Hotel Management System\\src\\com\\hotelmanagementsystem\\viewroom.png");
		Image img6=image3.getImage().getScaledInstance(150,150,  Image.SCALE_DEFAULT);
		ImageIcon img7=new ImageIcon(img6); 
		l5=new JLabel(img7);
		l5.setBounds(510,210,150,150);
		c.add(l5);
		

		ImageIcon image4=new ImageIcon("C:\\Users\\RAHUL\\eclipse-workspace\\JavaCourse\\Hotel Management System\\src\\com\\hotelmanagementsystem\\viewemp.png");
		Image img8=image4.getImage().getScaledInstance(130,130,  Image.SCALE_DEFAULT);
		ImageIcon img9=new ImageIcon(img8); 
		l2=new JLabel(img9);
		l2.setBounds(740,220,130,130);
		c.add(l2);
		
	
		
		b1=new JButton("ADD EMPLOYEE");
		b1.setBounds(40,370,130,30);
		b1.setBackground(Color.CYAN);
		c.add(b1);
		
		b2=new JButton("ADD ROOM");
		b2.setBounds(280,370,130,30);
		b2.setBackground(Color.CYAN);
		c.add(b2);
		
		
		b3=new JButton("VIEW ROOM");
		b3.setBounds(520,370,130,30);
		b3.setBackground(Color.CYAN);
		c.add(b3);
		
		
		b4=new JButton("VIEW EMPLOYEE");
		b4.setBounds(740,370,130,30);
		b4.setBackground(Color.CYAN);
		c.add(b4);
		
		 m1=new JMenuBar();
		 m1.setBackground(Color.GRAY);
		 
		 m7=new JMenu("Employee Details");
		 m7.setForeground(Color.WHITE);
		 
		 m8=new JMenu("Rooms Details");
		 m8.setForeground(Color.WHITE);
		 
		 
		 m2=new JMenuItem("Update Details");
		 m3=new JMenuItem("Manager");
		 m4=new JMenuItem("Other Staff");
		 m5=new JMenuItem("Ratings");
		 m6=new JMenuItem("Complain");
		 
		 m9=new JMenuItem("Update Details");
		
		 m10=new JMenuItem("Ratings");
		 m11=new JMenuItem("Complain");
		 
		 m2.setForeground(Color.WHITE);
		 m3.setForeground(Color.WHITE);
		 m4.setForeground(Color.WHITE);
		 m5.setForeground(Color.WHITE);
		 m6.setForeground(Color.WHITE);
		 
		 
		 m7.add(m2);
		 m7.add(m3);
		 m7.add(m4);
		 m7.add(m5);
		 m7.add(m6);
		 
		 m8.add(m9);
		 m8.add(m10);
		 m8.add(m11);
	
		 
		 
		 m1.add(m7);
		 
		 m1.add(m8);
		 
		 Border border6 = BorderFactory.createLineBorder(Color.BLACK);
		 m1.setBorder(BorderFactory.createCompoundBorder(border6,
		            BorderFactory.createEmptyBorder(2, 2, 2, 2)));
		
		 
		 setJMenuBar(m1);
		
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		setVisible(true);
		
		
	}
	
	

	@Override
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			
			new addEmp().setVisible(true);
			setVisible(false);
			
		}
if(e.getSource()==b2) {
			
			new ARooms().setVisible(true);
			setVisible(false);
			
		}
if(e.getSource()==b3) {
	
	new Rview().setVisible(true);
	setVisible(false);
	
}
if(e.getSource()==b4) {
	
	new Eview().setVisible(true);
	setVisible(false);
	
}

if(e.getSource()==b5) {
	
	new Booking().setVisible(true);
	setVisible(false);
	
}
if(e.getSource()==b6) {
	
	new checkoutHotel().setVisible(true);
	setVisible(false);
	
}

	}
}
public class MenuClass {

	public static void main(String[] args) {
		new Menu();
	}

}
