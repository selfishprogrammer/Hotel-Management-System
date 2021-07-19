package com.hotelmanagementsystem;

import java.awt.Color;
import java.awt.Container;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;



class Eview extends JFrame implements ActionListener{
	private JLabel l1,l2,l3;
	private JButton b1,b2,b3,b4;
	private Container c;
	private JTable table;
	JTextField t1;
	Eview(){
		
		setTitle("Hotel Management System");
		setBounds(100,10,900,500);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		c=getContentPane();
		c.setLayout(null);
		c.setBackground(Color.CYAN);
		l1=new JLabel("SEARCH SINGLE RECORD BY ID :");
		l1.setBounds(5,10,210,30);
			c.add(l1);
		t1=new JTextField();
	t1.setBounds(230,10,140,30);
		c.add(t1);
		
		b1=new JButton("SEARCH");
		b1.setBounds(390,10,100,30);
			c.add(b1);
		
			b2=new JButton("SEARCH FULL RECORD");
			b2.setBounds(640,10,180,30);
				c.add(b2);
				
				table=new JTable();
				table.setBounds(3, 80, 880, 420);
				table.setBackground(Color.white);
				c.add(table);
				
				
				JScrollPane scroll = new JScrollPane(table);
				scroll.setBounds(3, 80, 880, 420);
				c.add(scroll);
				
				b1.addActionListener(this);
				b2.addActionListener(this);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	try {
		DataBase db=new DataBase();
		if(e.getSource()==b2) {
			
		
		String sql="select * from `employee`";
		ResultSet rs=db.s.executeQuery(sql);
		table.setModel(DbUtils.resultSetToTableModel(rs));
		
		}
		
		
		else if(e.getSource()==b1) {
			
			String sql="select * from `employee` where `empid`='"+t1.getText()+"'";
			ResultSet rs=db.s.executeQuery(sql);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			t1.setText("");
			
		}
	}catch(Exception e1) {
		e1.printStackTrace();
	}
		
	}
	
	
}


public class ViewEmployee {

	public static void main(String[] args) {
		new Eview();

	}

}
