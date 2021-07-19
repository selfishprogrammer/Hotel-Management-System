package com.hotelmanagementsystem;

import java.awt.Color;
import java.awt.Container;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;



class Rview extends JFrame implements ActionListener{
	private JLabel l1,l2,l3;
	private JButton b1,b2,b3,b4;
	private Container c;
	private JTable table;
	JTextField t1;
	Rview(){
		
		setTitle("Hotel Management System");
		setBounds(100,10,900,500);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		c=getContentPane();
		c.setLayout(null);
		c.setBackground(Color.CYAN);
		l1=new JLabel("SINGLE RECORD :");
		l1.setBounds(5,10,150,30);
			c.add(l1);
		t1=new JTextField();
	t1.setBounds(120,10,140,30);
		c.add(t1);
		
		b1=new JButton("SEARCH");
		b1.setBounds(270,10,100,30);
			c.add(b1);
			b4=new JButton("VIEW AVALAIBLE ROOM");
			b4.setBounds(380,10,160,30);
				c.add(b4);
			b2=new JButton("SEARCH FULL RECORD");
			b2.setBounds(710,10,170,30);
				c.add(b2);
				
				b3=new JButton("VIEW BOOKED ROOM");
				b3.setBounds(545,10,160,30);
					c.add(b3);
					
				
				table=new JTable();
				table.setBounds(3, 80, 880, 420);
				table.setBackground(Color.white);
				c.add(table);
				
				
				JScrollPane scroll = new JScrollPane(table);
				scroll.setBounds(3, 80, 880, 420);
				c.add(scroll);
				
				b1.addActionListener(this);
				b2.addActionListener(this);
				b3.addActionListener(this);
				b4.addActionListener(this);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	try {
		DataBase db=new DataBase();
		if(e.getSource()==b2) {
			
		
		String sql="select * from `rooms`";
		ResultSet rs=db.s.executeQuery(sql);
		table.setModel(DbUtils.resultSetToTableModel(rs));
		
		}
		
		
		else if(e.getSource()==b1) {
			
			String sql="select * from `rooms` where `rooms_no`='"+t1.getText()+"'";
			ResultSet rs=db.s.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			t1.setText("");
			
		}
	else if(e.getSource()==b3) {
			
			String sql="select * from `rooms` where `avalablity`='Booked'";
			ResultSet rs=db.s.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			t1.setText("");
			
		}
	else if(e.getSource()==b4) {
		
		String sql="select * from `rooms` where `avalablity`='Avalaible'";
		ResultSet rs=db.s.executeQuery(sql);
		table.setModel(DbUtils.resultSetToTableModel(rs));
		t1.setText("");
		
	}
	}catch(Exception e1) {
		e1.printStackTrace();
	}
		
	}
	
	
}


public class ViewRooms {

	public static void main(String[] args) {
		new Rview();

	}

}
