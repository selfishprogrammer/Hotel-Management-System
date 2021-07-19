package com.hotelmanagementsystem;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

class ARooms extends JFrame implements ActionListener{
	private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	private JTextField t1,t2,t4,t5,t6,t7,t8,t9;
	private JButton b1,b2;
	private JComboBox c1,c2,c3;
	private JCheckBox ch1,ch2,ch3,ch4;
	private Container c;
		
	ARooms(){
		
		setTitle("Hotel Management System");
		setBounds(100,100,600,550);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		c=getContentPane();
		c.setLayout(null);
		c.setBackground(Color.CYAN);
		
		l1=new JLabel("ADD ROOMS");
		l1.setBounds(200,10,400,50);
		l1.setForeground(Color.GRAY);
		Font font=new Font("Arial",Font.BOLD,25);	
		l1.setFont(font);
		c.add(l1);
		
		l2=new JLabel("ROOM NO :");
		l3=new JLabel("FLOOR :");
		l4=new JLabel("BED");
		l5=new JLabel("FACILITIES :");
		l6=new JLabel("PRICE :");

		
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

		
		t1=new JTextField();
		t1.setBounds(140, 100, 170, 30);
		c.add(t1);
		
		String[] floor= {"First Floor","Second Floor","Third Floor","Forth Floor","Fifth Floor","Six Floor"};
c1=new JComboBox(floor);
c1.setBounds(140, 140, 170, 30);
		c.add(c1);
		String[] bed= {"Single Bed","Double Bed","King Bed"};
c2=new JComboBox(bed);
c2.setBounds(140, 180, 170, 30);
		c.add(c2);
		ch1=new JCheckBox("AC");
		ch1.setBounds(140, 220, 100, 30);
		c.add(ch1);
		ch2=new JCheckBox("WIFI");
		ch2.setBounds(240, 220, 100, 30);
		c.add(ch2);
		ch3=new JCheckBox("TV");
		ch3.setBounds(340, 220, 100, 30);
		c.add(ch3);
		ch4=new JCheckBox("BATH TUB");
		ch4.setBounds(440, 220, 100, 30);
		c.add(ch4);
		ch1.setBackground(Color.cyan);
		ch2.setBackground(Color.cyan);
		ch3.setBackground(Color.cyan);
		ch4.setBackground(Color.cyan);
		
		
		t2=new JTextField();
		t2.setBounds(140, 260, 170, 30);
		c.add(t2);
		
		
		b1=new JButton("Submit");
		b1.setBounds(200,350,100,40);
		c.add(b1);
		
		
		b2=new JButton("Cancel");
		b2.setBounds(310,350,100,40);
		c.add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String avalablity="Avalaible";
		String facilities="";
		if(ch1.isSelected()) {
			facilities="AC";
			
		}
		else if(ch2.isSelected()) {
			facilities="WIFI";
			
		}
		else if(ch3.isSelected()) {
			facilities="TV";
			
		}
		else if(ch4.isSelected()) {
			facilities="BATH TUB";
			
		}
		try {
			DataBase db=new DataBase();
			
		
			
			if(e.getSource()==b1) {
				String  q ="insert into `rooms` (`rooms_no`,`floor`,`bed`,`facilities`,`price`,`avalablity`) values ('"+t1.getText()+"','"+c1.getSelectedItem()+"','"+c2.getSelectedItem()+"','"+facilities+"','"+t2.getText()+"','"+avalablity+"')";
				db.s.executeUpdate(q);
				setVisible(false);
				
				JOptionPane.showMessageDialog(null, "Inserted");
			}
			
			
			
			
			else if(e.getSource()==b2) {
				new Menu().setVisible(true);
				setVisible(false);
				
				
				
			}
			
		}catch(Exception e1) {
			
			e1.printStackTrace();
			
		}
		
		
		
		
	}
	
	
}
public class AddRooms {

	public static void main(String[] args) {
new ARooms();

	}

}
