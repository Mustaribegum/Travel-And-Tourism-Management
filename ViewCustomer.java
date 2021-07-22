package tour.travel.management;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class ViewCustomer implements ActionListener {
	
	JFrame f=new JFrame("Your Details");
	JPanel p;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l11,l12,l13,l14,l15,l16,l17,l18,l19;
	JButton b1;
	
	
	ViewCustomer(String username){
		
		
		f.getContentPane().setBackground(new Color(0,0,102));;
		f.setBounds(390,130,720,600);
		f.setVisible(true);
		f.setLayout(null);
		
		p=new JPanel();
		p.setLayout(null);
		p.setBounds(33,33,622,495);
		p.setBackground(Color.WHITE);
		f.add(p);
		
		
		
		l1=new JLabel("Username :");
		l1.setBounds(40,80,100,25);
		l1.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l1);
		
		l11=new JLabel();
		l11.setBounds(160,80,150,25);
		l11.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l11);
		
		
		l2=new JLabel("ID :");
		l2.setBounds(40,140,150,25);
		l2.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l2);
		
		l12=new JLabel();
		l12.setBounds(160,140,150,25);
		l12.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l12);
		
		
		l3=new JLabel("Number :");
		l3.setBounds(40,200,150,25);
		l3.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l3);
		
		l13=new JLabel();
		l13.setBounds(160,200,150,25);
		l13.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l13);
		
		
		l4=new JLabel("Name :");
		l4.setBounds(40,260,150,25);
		l4.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l4);
		
		l14=new JLabel();
		l14.setBounds(160,260,150,25);
		l14.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l14);
		
		
		l5=new JLabel("Gender :");
		l5.setBounds(40,320,150,25);
		l5.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l5);
	
		l15=new JLabel();
		l15.setBounds(160,320,150,25);
		l15.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l15);
		
		l6=new JLabel("Country :");
		l6.setBounds(300,80,150,25);
		l6.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l6);
		
		l16=new JLabel();
		l16.setBounds(430,80,150,25);
		l16.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l16);
		
		l7=new JLabel("Address :");
		l7.setBounds(300,140,150,25);
		l7.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l7);
		
		l17=new JLabel();
		l17.setBounds(430,140,150,25);
		l17.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l17);
		
		l8=new JLabel("Phone Number :");
		l8.setBounds(300,200,150,25);
		l8.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l8);
		
		l18=new JLabel();
		l18.setBounds(430,200,150,25);
		l18.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l18);
		
		l9=new JLabel("Email :");
		l9.setBounds(300,260,140,25);
		l9.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l9);
		
		l19=new JLabel();
		l19.setBounds(430,260,180,25);
		l19.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l19);
		
		
		
		b1=new JButton("Back");
		b1.setFont(new Font("Tahoma",Font.BOLD,20));
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(230,400,150,50);
		b1.addActionListener(this);
		p.add(b1);
		
		
		
		try {
			
			Connection con = null;
			String url = "jdbc:mysql://localhost:3306/tms";
			String driver = "com.mysql.cj.jdbc.Driver";
			String user = "root";
			String pass = "Tabuma@2205";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			PreparedStatement st=con.prepareStatement("select * from Customer where Username='"+username+"'");
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				
				l11.setText(rs.getString("username"));
				l12.setText(rs.getString("id"));
				l13.setText(rs.getString("number"));
				l14.setText(rs.getString("name"));
				l15.setText(rs.getString("country"));
				l16.setText(rs.getString("phone"));
				l17.setText(rs.getString("address"));
				l18.setText(rs.getString("phone"));
				l19.setText(rs.getString("email"));
				
				
			}
			
			
		}catch(Exception e) {}
			
	}
	public void actionPerformed(ActionEvent ae) {
		
		
		 if(ae.getSource()==b1) {
        	
			 f.dispose();
        }
        

	}
	

	public static void main(String[] args) {
		
		new ViewCustomer("");

	}
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
