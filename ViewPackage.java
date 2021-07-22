package tour.travel.management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ViewPackage implements ActionListener {
	
	JFrame f=new JFrame("view Package");
	JPanel p;
	JLabel l1,l11,l2,l12,l3,l13,l4,l14,l5,l15,l6,l16,l7,l17;
	JButton b1;
	String username;
	
	
	ViewPackage(String username){
		
		this.username=username;
		
		f.getContentPane().setBackground(new Color(0,0,102));;
		f.setBounds(390,160,660,520);
		f.setVisible(true);
		f.setLayout(null);
		
		p=new JPanel();
		p.setLayout(null);
		p.setBounds(30,30,580,430);
		p.setBackground(Color.LIGHT_GRAY);
		f.add(p);
		
		JLabel heading=new JLabel("VIEW PACKAGE DETAILS");
		heading.setBounds(50,30,300,25);
		heading.setFont(new Font("Railway",Font.BOLD,20));
		p.add(heading);
		
		l1=new JLabel("Username :");
		l1.setBounds(40,80,150,25);
		l1.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l1);
		
		l11=new JLabel();
		l11.setBounds(200,80,170,25);
		p.add(l11);
		
		l2=new JLabel("Package :");
		l2.setBounds(40,120,150,25);
		l2.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l2);
		
		l12=new JLabel();
		l12.setBounds(200,120,170,25);
		p.add(l12);
		
		l3=new JLabel("Total persons :");
		l3.setBounds(40,160,150,25);
		l3.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l3);
		
		l13=new JLabel();
		l13.setBounds(200,160,170,25);
		p.add(l13);
		
		l4=new JLabel("ID :");
		l4.setBounds(40,200,150,25);
		l4.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l4);
		
		l14=new JLabel();
		l14.setBounds(200,200,170,25);
		p.add(l14);
		
		l5=new JLabel("ID Number :");
		l5.setBounds(40,240,150,25);
		l5.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l5);
		
		l15=new JLabel();
		l15.setBounds(200,240,170,25);
		p.add(l15);
		
		l6=new JLabel("Phone :");
		l6.setBounds(40,280,150,25);
		l6.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l6);
		
		l16=new JLabel();
		l16.setBounds(200,280,170,25);
		p.add(l16);
		
		l7=new JLabel("Total Price :");
		l7.setBounds(40,320,150,25);
		l7.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l7);
		
		l17=new JLabel();
		l17.setBounds(200,320,170,25);
		p.add(l17);
		
		
		
		
		
        try {
			
			Connection con = null;
			String url = "jdbc:mysql://localhost:3306/tms";
			String driver = "com.mysql.cj.jdbc.Driver";
			String user = "root";
			String pass = "Tabuma@2205";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			PreparedStatement st=con.prepareStatement("select * from bookPackage where username='"+username+"'");
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				
				l11.setText(rs.getString("username"));
				l12.setText(rs.getString("package"));
				l13.setText(rs.getString("persons"));
				l14.setText(rs.getString("id"));
				l15.setText(rs.getString("number"));
				l16.setText(rs.getString("phone"));
				l17.setText(rs.getString("price"));
				
				
				
			}
			
			
		}catch(Exception e) {}
			

		
		b1=new JButton("Back");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(210,370,100,30);
		b1.addActionListener(this);
		p.add(b1);
		
		
	
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		f.dispose();
		new Package(username).setVisible(true);
		
	}

	public static void main(String[] args) {
		
      new ViewPackage("");
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
