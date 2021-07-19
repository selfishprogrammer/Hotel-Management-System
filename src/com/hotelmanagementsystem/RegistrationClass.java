package com.hotelmanagementsystem;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

class Registration extends JFrame implements ActionListener{
	private JLabel l1,l2,l3,l4,l5;
	private JTextField t1,t2,t3,t4,t5;
	private JButton b1,b2;
	private Container c;
	
 Registration() {
	 setTitle("Registration Form");
	 setBounds(100,100,500,350);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		c=getContentPane();
		c.setLayout(null);
		
		c.setBackground(Color.GREEN);
		
		l1=new JLabel("Registration Form");
		l1.setBounds(120, 0, 300, 50);
		Font font=new Font("Arial",Font.ROMAN_BASELINE,30);	
		l1.setFont(font);
		c.add(l1);
		
		
		l2=new JLabel("Name :");
		l2.setBounds(10,20,100,100);
		l2.setFont(new Font("itailic",Font.ITALIC,20));
		c.add(l2);
		
		
		l3=new JLabel("Email :");
		l3.setBounds(10,80,100,100);
		l3.setFont(new Font("itailic",Font.ITALIC,20));
		c.add(l3);
		
		l4=new JLabel("Password :");
		l4.setBounds(10,140,100,100);
		l4.setFont(new Font("itailic",Font.ITALIC,20));
		c.add(l4);
		
		l3=new JLabel("Confirm Password :");
		l3.setBounds(10,195,200,100);
		l3.setFont(new Font("itailic",Font.ITALIC,20));
		c.add(l3);
		
		
		
		t1=new JTextField();
		t1.setBounds(190,58,200,30);
		t1.setFont(new Font("itailic",Font.BOLD,15));
		c.add(t1);
		
		t2=new JTextField();
		t2.setBounds(190,116,200,30);
		t2.setFont(new Font("itailic",Font. BOLD,15));
		c.add(t2);
		
		t3=new JTextField();
		t3.setBounds(190,174,200,30);
		t3.setFont(new Font("itailic",Font. BOLD,15));
		c.add(t3);
		
		t4=new JTextField();
		t4.setBounds(190,232,200,30);
		t4.setFont(new Font("itailic",Font. BOLD,15));
		c.add(t4);
		
		
		
		b1=new JButton("Submit");
		b1.setBounds(130,275,80,30);
		b1.setBackground(Color.GREEN);
c.add(b1);


b2=new JButton("Cancel");
b2.setBounds(230,275,80,30);
b2.setBackground(Color.GREEN);
c.add(b2);



b1.addActionListener(this);
	b2.addActionListener(this);	
		setVisible(true);
	 
	
}

@Override
public void actionPerformed(ActionEvent e) {
	try {
		
		DataBase data=new DataBase();
		Random random = new Random();
		
		if(e.getSource()==b1) {
			
			if(t3.getText().equals(t4.getText())) {
			
			String q="insert into user values('"+Math.random()+"','"+t1.getText()+"','"+t2.getText()+"' ,'"+t3.getText()+"','"+t4.getText()+"')";
			data.s.executeUpdate(q);
			JOptionPane.showMessageDialog(null, "inserted Successfully");
			}
			else {
				JOptionPane.showMessageDialog(null, "Check Your Password");
			}
			
		}
		
		
		if(e.getSource()==b2) {
			
			
			System.exit(0);
			
		}
		
		
	} catch (Exception e2) {
		e2.printStackTrace();
	}
	
}
	
}



public class RegistrationClass {
public static void main(String[] args) {
	new Registration();
}
}
