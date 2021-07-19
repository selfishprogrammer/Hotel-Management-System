package com.hotelmanagementsystem;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

class addEmp extends JFrame implements ActionListener{
private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
private JButton b1,b2;
private JComboBox c1;
private Container c;
	
	addEmp(){
		setTitle("Hotel Management System");
		setBounds(100,100,600,550);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		c=getContentPane();
		c.setLayout(null);
		c.setBackground(Color.CYAN);
		
		
		l1=new JLabel("ADD EMPLOYEE");
		l1.setBounds(200,10,400,50);
		l1.setForeground(Color.GRAY);
		Font font=new Font("Arial",Font.BOLD,25);	
		l1.setFont(font);
		c.add(l1);
		
		l2=new JLabel("NAME :");
		l3=new JLabel("EMAIL ID :");
		l4=new JLabel("JOB PROFFESION");
		l5=new JLabel("DATE OF BIRTH :");
		l6=new JLabel("GENDER :");
		l7=new JLabel("ADDRESS :");
		l8=new JLabel("EMLOYEE ID :");
		l9=new JLabel("AADHAR CARD :");
		l10=new JLabel("PHONE:");
		
		l2.setBounds(10,100,130,30);
		
		l2.setFont(new Font("Arial",Font.BOLD,15));
		c.add(l2);
		
		
l3.setBounds(10,140,130,30);
		
		l3.setFont(new Font("Arial",Font.BOLD,15));
		c.add(l3);
		
		
l4.setBounds(10,180,130,30);
		
		l4.setFont(new Font("Arial",Font.BOLD,15));
		c.add(l4);
		
		
l5.setBounds(10,220,180,30);
		
		l5.setFont(new Font("Arial",Font.BOLD,15));
		c.add(l5);
		
		
l6.setBounds(10,260,130,30);
		
		l6.setFont(new Font("Arial",Font.BOLD,15));
		c.add(l6);
		
		
l7.setBounds(10,300,130,30);
		
		l7.setFont(new Font("Arial",Font.BOLD,15));
		c.add(l7);
		
		
l8.setBounds(10,340,180,30);
		
		l8.setFont(new Font("Arial",Font.BOLD,15));
		c.add(l8);
		
		
l9.setBounds(10,380,210,30);
		
		l9.setFont(new Font("Arial",Font.BOLD,15));
		c.add(l9);
		
		

		
		
l10.setBounds(10,420,130,30);
		
		l10.setFont(new Font("Arial",Font.BOLD,15));
		c.add(l10);
		
		t1=new JTextField();
		t1.setBounds(150,100,200,30);
		t1.setFont(new Font("Arial",Font.BOLD,15));
		
		c.add(t1);
		
		
		t2=new JTextField();
		t2.setBounds(150,140,200,30);
		t2.setFont(new Font("Arial",Font.BOLD,15));
		
		c.add(t2);
	String[] job= {"Manager","Staff Member","Gaurd","Cook","Reception","Others"};	
	c1=new JComboBox(job);
	c1.setBackground(Color.WHITE);
	c1.setBounds(150,180,200,30);
		c.add(c1);
		
		t4=new JTextField();
		t4.setBounds(150,220,200,30);
		t4.setFont(new Font("Arial",Font.BOLD,15));
		
		c.add(t4);
		
		
		t5=new JTextField();
		t5.setBounds(150,260,200,30);
		t5.setFont(new Font("Arial",Font.BOLD,15));
		
		c.add(t5);
		
		
		
		t6=new JTextField();
		t6.setBounds(150,300,200,30);
		t6.setFont(new Font("Arial",Font.BOLD,15));
		
		c.add(t6);
		
		Random random=new Random();
		long card3=(random.nextLong() % 9000000L)+ 1000L;
		long card4=Math.abs(card3);	
		
		t7=new JTextField("EMP"+card4);
		t7.setBounds(150,340,200,30);
		t7.setFont(new Font("Arial",Font.BOLD,15));
		t7.setEditable(false);
		c.add(t7);
		
		t8=new JTextField();
		t8.setBounds(150,380,200,30);
		t8.setFont(new Font("Arial",Font.BOLD,15));
		
		c.add(t8);
		
		
		
		t9=new JTextField();
		t9.setBounds(150,420,200,30);
		t9.setFont(new Font("Arial",Font.BOLD,15));
		
		c.add(t9);
		
		
	b1=new JButton("Submit");
	b1.setBounds(10,480,90,25);
	b1.setBackground(Color.CYAN);
	c.add(b1);	
	b2=new JButton("Cancel");
	b2.setBounds(480,480,90,25);
	b2.setBackground(Color.CYAN);
	c.add(b2);		
	
	
		b1.addActionListener(this);
		b2.addActionListener(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		try {
			DataBase db=new DataBase();
			if(e.getSource()==b1) {
				if(t1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, " Fill All field ");
					
				}
				else {
				String q="insert into `employee` values('"+t1.getText()+"','"+t2.getText()+"','"+c1.getSelectedItem()+"','"+t4.getText()+"','"+t5.getText()+"','"+t6.getText()+"','"+t7.getText()+"','"+t8.getText()+"','"+t9.getText()+"')";
				db.s.executeUpdate(q);
				JOptionPane.showMessageDialog(null, " Employee is added Successfully ");
				setVisible(false);
				}
			}
				
				else if(e.getSource()==b2) {
					
					t1.setText("");
					t2.setText("");
					c1.setSelectedItem("");
					t4.setText("");
					t5.setText("");
					t6.setText("");
					t7.setText("");
					t8.setText("");
					t9.setText("");
				
					
				}
		
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}

		
	}
	
}




public class AddEmployee {

	public static void main(String[] args) {
		new addEmp();

	}

}
