package tour.travel.management;


import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class About implements ActionListener {
	
	String s;
	
	JFrame f=new JFrame("About Us");
	JPanel p;
	JButton b1;
	About(){
	f.getContentPane().setBackground(new Color(0,0,102));;
	f.setBounds(390,180,660,510);
	f.setVisible(true);
	f.setLayout(null);
	
	p=new JPanel();
	p.setLayout(null);
	p.setBounds(20,20,640,490);
	p.setBackground(Color.WHITE);
	f.add(p);
	
	JLabel l1 =new JLabel("Travel and Tourism Management");
	l1.setBounds(50,10,400,80);
	l1.setForeground(Color.RED);
	l1.setFont(new Font("Tahoma",Font.PLAIN,21));
	p.add(l1);
	
	
	 s = " ABOUT PROJECT \n"
			+ "The objective of the travel and tourism management system "
			+ "project is to develop a system that automates the processes and activities of a "
			+ "travel and tourism agency. The purpose is to design a system using which one "
			+ "can perform all operation related to travelling and tick booking .the system allows"
			+ " one to easily access the relevant information and make necessary travel arrangements."
			+ " Users can decide about places they want to "
			+ "visit and make bookings online for travel and generate there bill .";
	
	TextArea t1=new TextArea(s,10,40,Scrollbar.VERTICAL);
	t1.setBounds(20,100,450,280);
	t1.setEditable(false);
	t1.setFont(new Font("Tahoma",Font.BOLD,16));
	p.add(t1);
	
	b1=new JButton("Back");
	b1.setBackground(Color.BLACK);
	b1.setForeground(Color.WHITE);
	b1.setBounds(200,400,100,30);
	b1.addActionListener(this);
	p.add(b1);
	
	
	
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		f.dispose();
	}
	
	public static void main(String[] args) {
	
		new About();
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
