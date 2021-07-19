package com.hotelmanagementsystem;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

class checkoutHotel extends JFrame implements ActionListener{
	
	private JLabel l1,l2,l3,l4,l5,l6;
	private JTextField t1,t2,t3,t4,t5;
	private JButton b1,b2,b3,b4;
	private Container c;
	
	
	
	checkoutHotel() {
		
		setTitle("Hotel Management System");
		setBounds(100,10,400,350);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		c=getContentPane();
		c.setLayout(null);
		c.setBackground(Color.CYAN);
	
		l1=new JLabel("Enter Room ID :");
		l1.setBounds(10,10,170,30);
	
		c.add(l1);
		
		t1=new JTextField();
		t1.setBounds(100,10,170,30);
		c.add(t1);
		
		
		b1=new JButton("Check");
		b1.setBounds(275,10,100,30);
		b1.setBackground(Color.CYAN);
		c.add(b1);
		
		
		l2=new JLabel("Coustmer Name :");
		l2.setBounds(10,90,170,30);
		Font font= new Font("Arial", Font.TRUETYPE_FONT, 15);
		l2.setFont(font);
		c.add(l2);
		
		
		l3=new JLabel("Room No :");
		l3.setBounds(10,130,170,30);
		l3.setFont(font);
		c.add(l3);
		
		l4=new JLabel("Charge :");
		l4.setBounds(10,170,170,30);
		l4.setFont(font);
		c.add(l4);
		
		t2=new JTextField();
		t2.setBounds(140,90,170,30);
		c.add(t2);
		
		t3=new JTextField();
		t3.setBounds(140,130,170,30);
		c.add(t3);
		
		t4=new JTextField();
		t4.setBounds(140,170,170,30);
		c.add(t4);
		
		
		
		b2=new JButton("Checkout");
		b2.setBounds(70,240,100,30);
		b2.setBackground(Color.CYAN);
		c.add(b2);
		
		b3=new JButton("Cancel");
		b3.setBounds(210,240,100,30);
		b3.setBackground(Color.CYAN);
		c.add(b3);
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	
		setVisible(true);
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
	
		try {
			DataBase db = new DataBase();
			if(e.getSource()==b1) {
				
				String q = "select * from `booking` where `room_no`='"+t1.getText()+"'";
				ResultSet rs= db.s.executeQuery(q);
				if(rs.next()) {
					
					t2.setText(rs.getString("coustmer_name"));
					t3.setText(rs.getString("room_no"));
					t4.setText(rs.getString("price"));
				}
				else {
					JOptionPane.showMessageDialog(null, "Check Room No");
				}
				
			}
			else if(e.getSource()==b2) {
				
				String q1="update `rooms` set `avalablity`='Avalaible' where `rooms_no`='"+t1.getText()+"'";
				db.s.executeUpdate(q1);
				JOptionPane.showMessageDialog(null, "Successfuly Checked Out");
				new Menu().setVisible(true);
				setVisible(false);
			}
			else if(e.getSource()==b3) {
				new Menu().setVisible(true);
				setVisible(false);
			}
			
		}catch(Exception e1) {
			
			JOptionPane.showMessageDialog(null, "Check Room No");
			
		}
		
		
	}
	
}





public class CheckOut {

	public static void main(String[] args) {
	new checkoutHotel();

	}

}
