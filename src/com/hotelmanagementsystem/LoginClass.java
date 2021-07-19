package com.hotelmanagementsystem;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.border.Border;



class Login extends JFrame implements ActionListener{
	JLabel l1,l2,l3,l4,l5;
	JButton b1,b2,b3;
	JTextField t1;
	JPasswordField p;
	
	Container c;
	Login(){
		setTitle("Hotel Management System");
		setBounds(100,100,900,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		c=getContentPane();
		c.setLayout(null);
		
		c.setBackground(Color.GREEN);
		
		
		
		l1=new JLabel("HOTEL MANAGEMENT SYSTEM");
		l1.setBounds(100,10,900,50);
		l1.setForeground(Color.RED);
		Font font=new Font("Arial",Font.ROMAN_BASELINE,40);	
		l1.setFont(font);
		c.add(l1);
		
		l2=new JLabel("LOGIN PAGE");
		l2.setBounds(330,70,900,50);
		l2.setForeground(Color.GRAY);
		
		l2.setFont(new Font("Arial",Font.ROMAN_BASELINE,40));
		c.add(l2);
		
		ImageIcon image=new ImageIcon("C:\\Users\\RAHUL\\eclipse-workspace\\JavaCourse\\Employee Management\\src\\EmployeeManagement\\employeeicon.png");
		Image img=image.getImage().getScaledInstance(200,200,  Image.SCALE_DEFAULT);
		ImageIcon img1=new ImageIcon(img); 
		l3=new JLabel(img1);
		l3.setBounds(550,170,200,200);
		
		
		l4=new JLabel("USERNAME : ");
		l4.setBounds(30,220,150,30);
		l4.setFont(new Font("Arial",Font.ROMAN_BASELINE,20));
		c.add(l4);
		
		
		l5=new JLabel("PASSWORD : ");
		l5.setBounds(30,300,150,30);
		l5.setFont(new Font("Arial",Font.ROMAN_BASELINE,20));
		c.add(l5);
		
		
		t1=new JTextField();
		t1.setBounds(180,220,190,30);
		
		t1.setFont(new Font("Arial",Font.ROMAN_BASELINE,15));
		c.add(t1);
		
		
		

		p=new JPasswordField();
		p.setBounds(180,300,190,30);
		
		p.setFont(new Font("Arial",Font.ROMAN_BASELINE,15));
		c.add(p);
		
		b1=new JButton("SIGN IN");
		b2=new JButton("SIGN UP");
		b3=new JButton("CLEAR");
		
		
		b1.setBounds(30,380,120,30);
		b2.setBounds(160,380,120,30);
		b3.setBounds(290,380,120,30);
		
		
		b1.setBackground(Color.GREEN);
		b2.setBackground(Color.GREEN);
		b3.setBackground(Color.GREEN);
		
		
		
		c.add(b1);
		c.add(b2);
		c.add(b3);
		
		Border border1 = BorderFactory.createLineBorder(Color.BLACK);
		t1.setBorder(BorderFactory.createCompoundBorder(border1,
		           BorderFactory.createEmptyBorder(2, 2, 2, 2)));


		Border border2 = BorderFactory.createLineBorder(Color.BLACK);
		p.setBorder(BorderFactory.createCompoundBorder(border1,
		           BorderFactory.createEmptyBorder(2, 2, 2, 2)));
		c.add(l3);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		setVisible(true);
		
		
//		while(true){
//			l1.setVisible(false);
//			
//			try {
//				Thread.sleep(1000);
//			}catch(Exception e1) {}
//			l1.setVisible(true);
//			
//			try {
//				Thread.sleep(1000);
//			}catch(Exception e1) {}
//			
//		}

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
		String a=t1.getText();
		String b=p.getText();
		
		if(e.getSource()==b1) {
			DataBase db= new DataBase();
			String q="select * from user where username ='"+a+"' and password = '"+b+"'";
		ResultSet rs=	db.s.executeQuery(q);
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "You LoggedIn");
				new Menu().setVisible(true);
				setVisible(false);
}
			else {
			
			JOptionPane.showMessageDialog(null, "Check Your Password");
			}
			
			
		
		}
		
		
		else if(e.getSource()==b2) {
			new Registration()
;			
			setVisible(false);
		}
		
		
		else if(e.getSource()==b3) {
			t1.setText("");
			p.setText("");
			
		}
		
		}catch(Exception e1) {
			
		}
		
	}
}
public class LoginClass {
	public static void main(String[] args) {
		new Login();
	}
 
}
