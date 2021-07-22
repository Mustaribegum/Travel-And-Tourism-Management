package tour.travel.management;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.sql.Date.*;


public class GenerateBill implements ActionListener {
	
	Connection con = null;
	String url = "jdbc:mysql://localhost:3306/tms";
	String driver = "com.mysql.cj.jdbc.Driver";
	String user = "root";
	String pass = "Tabuma@2205";
	
	JFrame f=new JFrame();
	JPanel p;
	JLabel l1,l2,l12,l3,l13,l4,l14,l5,l15,l6,l16,l7,l17,l8,l18,l9,l19;
	JButton b1,b2;
	TextArea t1;
	
	String username;
	
	GenerateBill(String username){
		
		this.username=username;
		
		f.getContentPane().setBackground(new Color(0,0,102));;
		f.setBounds(390,130,950,600);
		f.setVisible(true);
		f.setLayout(null);
		
		p=new JPanel();
		p.setLayout(null);
		p.setBounds(33,0,859,530);
		p.setBackground(Color.WHITE);
		f.add(p);
		
		l1=new JLabel("Generate Your Bill Here");
		l1.setBounds(50,30,300,25);
		l1.setFont(new Font("Railway",Font.BOLD,20));
		p.add(l1);
		
		l2=new JLabel("Username :");
		l2.setBounds(40,80,140,25);
		l2.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l2);
		
		l12=new JLabel();
		l12.setBounds(200,80,150,25);
		l12.setFont(new Font("Tahoma",Font.BOLD,16));
		p.add(l12);
		
		l3=new JLabel("Selected Package :");
		l3.setBounds(40,120,190,25);
		l3.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l3);
		
		l13=new JLabel();
		l13.setBounds(200,120,150,25);
		l13.setFont(new Font("Tahoma",Font.BOLD,16));
		p.add(l13);
		
		l4=new JLabel("Package Price :");
		l4.setBounds(40,160,190,25);
		l4.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l4);
		
		l14=new JLabel();
		l14.setBounds(200,160,190,25);
		l14.setFont(new Font("Tahoma",Font.BOLD,16));
		p.add(l14);
		
		l5=new JLabel("Booked Hotel :");
		l5.setBounds(40,200,190,25);
		l5.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l5);
		
		l15=new JLabel();
		l15.setBounds(200,200,190,25);
		l15.setFont(new Font("Tahoma",Font.BOLD,16));
		p.add(l15);
		
		l6=new JLabel("Hotel Price :");
		l6.setBounds(40,240,190,25);
		l6.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l6);
		
		l16=new JLabel();
		l16.setBounds(200,240,190,25);
		l16.setFont(new Font("Tahoma",Font.BOLD,16));
		p.add(l16);
		
		l7=new JLabel("No.of Persons :");
		l7.setBounds(40,280,190,25);
		l7.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l7);
		
		l17=new JLabel();
		l17.setBounds(200,280,190,25);
		l17.setFont(new Font("Tahoma",Font.BOLD,16));
		p.add(l17);
		
		l8=new JLabel("No.of.Days :");
		l8.setBounds(40,320,190,25);
		l8.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l8);
		
		l18=new JLabel();
		l18.setBounds(200,320,190,25);
		l18.setFont(new Font("Tahoma",Font.BOLD,16));
		p.add(l18);
		

		l9=new JLabel("Your Total :");
		l9.setBounds(40,360,190,25);
		l9.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l9);
		
		l19=new JLabel();
		l19.setBounds(200,360,190,25);
		l19.setFont(new Font("Tahoma",Font.BOLD,16));
		p.add(l19);
		
	    t1=new TextArea(null,10,40,Scrollbar.VERTICAL);
		t1.setBounds(450,80,400,350);
		t1.setFont(new Font("Tahoma",Font.BOLD,12));
		t1.setEditable(false);
		p.add(t1);
		
try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			PreparedStatement st=con.prepareStatement("select * from bookpackage where username='"+username+"'");
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				
				l12.setText(rs.getString("username"));
				l13.setText(rs.getString("package"));
				l14.setText(rs.getString("price"));
				
            }
			
			
		}
		catch(Exception e) {
			
		}

try {
	
	Class.forName(driver);
	con = DriverManager.getConnection(url, user, pass);
	PreparedStatement st=con.prepareStatement("select * from bookhotel where username='"+username+"'");
	ResultSet rs=st.executeQuery();
	while(rs.next()) {
		
		l15.setText(rs.getString("hotel"));
		l16.setText(rs.getString("price"));
		l17.setText(rs.getString("persons"));
		l18.setText(rs.getString("days"));
		
    }
	
	
}
catch(Exception e) {
	
}
		
		b1=new JButton("Generate Bill");
		b1.setBounds(40,400,120,30);
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLACK);
		b1.addActionListener(this);
		p.add(b1);
		
		b2=new JButton("Back");
		b2.setBounds(200,400,120,30);
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.BLACK);
		b2.addActionListener(this);
		p.add(b2);
		
				
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1) {
		int a=Integer.parseInt(l14.getText());
		int b=Integer.parseInt(l16.getText());
		
		int cost=a+b;
		l19.setText("Rs "+cost);
		
		t1.setText("************************************************************************\n");
		t1.setText(t1.getText()+"*                        TRAVEL AND TOURISM MANAGMENT                           *\n");
		t1.setText(t1.getText()+"************************************************************************\n");
		
		
		t1.setText(t1.getText()+"Username : "+ l12.getText()+"\n\n");
		t1.setText(t1.getText()+"Package : "+ l13.getText()+"\n\n");
		t1.setText(t1.getText()+"Package Price : "+ l14.getText()+"\n\n");
		t1.setText(t1.getText()+"Hotel Name : "+ l15.getText()+"\n\n");
		t1.setText(t1.getText()+"Hotel Price : "+ l16.getText()+"\n\n");
		t1.setText(t1.getText()+"No.of.Persons : "+ l17.getText()+"\n\n");
		t1.setText(t1.getText()+"No.of.Days : "+ l18.getText()+"\n\n");
		t1.setText(t1.getText()+"Total Price : "+ l19.getText()+"\n\n");
		
		t1.setText(t1.getText()+"************************************************************************\n");
		t1.setText(t1.getText()+"                         THANK YOU HAPPY VACATIONS   ");
		
		
		}
		
		else if(ae.getSource()==b2) {
			f.dispose();
		}
	}

	public static void main(String[] args) {
		
		new GenerateBill("");
	}

	public void setVisible(boolean b) {
		
		
	}

}
