package com.hotelmanagementsystem;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

class Booking extends JFrame implements ActionListener{
	
	private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	private JTextField t1,t2,t3,t4,t5,t6,t8;
	private JTextArea t7;
	private JComboBox c1;
	private Choice c3,c2;
	private JButton b1,b2;

	private Container c;
	private String price;
	
	
	
	
	
	
	
	
	
	
	
	Booking(){
		setTitle("Hotel Management System");
		setBounds(100,10,630,500);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		c=getContentPane();
		c.setLayout(null);
		c.setBackground(Color.CYAN);
		l1=new JLabel("BOOK ROOM");
		Font font = new Font("Arial",Font.BOLD,30);
		l1.setFont(font);
		l1.setBounds(200,10,210,30);
			c.add(l1);
			
l2=new JLabel("Coustmer Name:");
l2.setBounds(10,70,150,20);
l2.setFont(new Font("Arial",Font.ITALIC,15));
c.add(l2);
			
l3=new JLabel("Coustmer ID Proof:");
l3.setBounds(10,120,150,20);
l3.setFont(new Font("Arial",Font.ITALIC,15));
c.add(l3);

l4=new JLabel("Beds Facilities:");
l4.setBounds(10,170,150,20);
l4.setFont(new Font("Arial",Font.ITALIC,15));
c.add(l4);


l5=new JLabel("Room No:");
l5.setBounds(10,220,150,20);
l5.setFont(new Font("Arial",Font.ITALIC,15));
c.add(l5);

l5=new JLabel("Price:");
l5.setBounds(10,270,150,20);
l5.setFont(new Font("Arial",Font.ITALIC,15));
c.add(l5);






l6=new JLabel("Coustmer Email:");
l6.setBounds(320,70,150,20);
l6.setFont(new Font("Arial",Font.ITALIC,15));
c.add(l6);
			
l7=new JLabel("Coustmer Phone:");
l7.setBounds(320,120,150,20);
l7.setFont(new Font("Arial",Font.ITALIC,15));
c.add(l7);

l7=new JLabel("Id Proof No:");
l7.setBounds(320,170,150,20);
l7.setFont(new Font("Arial",Font.ITALIC,15));
c.add(l7);


l8=new JLabel("Country:");
l8.setBounds(320,220,150,20);
l8.setFont(new Font("Arial",Font.ITALIC,15));
c.add(l8);

l9=new JLabel("Full Address:");
l9.setBounds(320,270,150,20);
l9.setFont(new Font("Arial",Font.ITALIC,15));
c.add(l9);






























t1=new JTextField();
t1.setBounds(160,65,150,30);
t1.setFont(new Font("Arial",Font.ITALIC,15));
c.add(t1);

String[] id= {"Aadhar Card","Voter Id","PAN Card"};
c1=new JComboBox(id);
c1.setBounds(160,115,150,30);
c1.setBackground(Color.WHITE);
c.add(c1);


c2=new Choice();
try {
	DataBase db=new DataBase();
	
	String q="select * from `rooms`";
	ResultSet rs=db.s.executeQuery(q);
	while(rs.next()) {
		
		c2.add(rs.getString("bed"));
		
	}
	
}catch(Exception e) {
	e.printStackTrace();
}
c2.setBounds(160,215,150,30);
c.add(c2);
c2.setBounds(160,165,150,30);
c2.setBackground(Color.WHITE);
c.add(c2);

c3=new Choice();
try {
	DataBase db=new DataBase();
	String avablity="Avalaible";
	String q="select * from `rooms` where `avalablity`='"+avablity+"'";
	ResultSet rs=db.s.executeQuery(q);
	while(rs.next()) {
		
		c3.add(rs.getString("rooms_no"));
		
	}
	
}catch(Exception e) {
	e.printStackTrace();
}
c3.setBounds(160,215,150,30);
c.add(c3);

t2=new JTextField();
t2.setBounds(160,265,150,30);
c.add(t2);




t3=new JTextField();
t3.setBounds(460,65,150,30);
c.add(t3);
t4=new JTextField();
t4.setBounds(460,115,150,30);
c.add(t4);
t5=new JTextField();
t5.setBounds(460,165,150,30);
c.add(t5);
t6=new JTextField();
t6.setBounds(460,215,150,30);
c.add(t6);


t7=new JTextArea();
t7.setBounds(460,265,150,30);
c.add(t7);



b1=new JButton("Book");
b1.setBounds(170,365,150,30);
b1.setBackground(Color.cyan);
c.add(b1);

b2=new JButton("Cancel");
b2.setBounds(330,365,150,30);
b2.setBackground(Color.cyan);
c.add(b2);

b1.addActionListener(this);
b2.addActionListener(this);

			setVisible(true);
	}











	@Override
	public void actionPerformed(ActionEvent e) {
		String booked="Booked";
		try {
			if(e.getSource()==b1) {
			DataBase db=new DataBase(); 

	

			String q="insert into `booking` (`coustmer_name`,`coustmer_email`,`coustmer_phone`,`room_no`,`coustmer_id`,`coustmer_id_no`,`price`,`country`,`address`,`bed`)"
					+ " values ('"+t1.getText()+"','"+t3.getText()+"','"+t4.getText()+"','"+c3.getSelectedItem()+"','"+c1.getSelectedItem()+"','"+t5.getText()+"','"+t2.getText()+"','"+t6.getText()+"','"+t7.getText()+"','"+c2.getSelectedItem()+"')";
			
			
			
		db.s.executeUpdate(q);
		
		String q1="update `rooms` set `avalablity`='"+booked+"' where `rooms_no`='"+c3.getSelectedItem()+"'";
		db.s.executeUpdate(q1);
		JOptionPane.showMessageDialog(null, "Hotel Booked");
			}
			
			else if (e.getSource()==b2) {
				
			new Menu().setVisible(true);
			setVisible(false);
				
			}
		}catch(Exception e1) {
			
			e1.printStackTrace();
			
		}
		
	}
	
}




public class BookingClass {

	public static void main(String[] args) {
	new Booking();
	}

}
