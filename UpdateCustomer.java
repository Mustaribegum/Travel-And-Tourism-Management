package tour.travel.management;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class UpdateCustomer implements ActionListener {
	
	JFrame f=new JFrame("Update Details");
	JPanel p;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
	JRadioButton r1,r2;
	JButton b1,b2;
	
	
	UpdateCustomer(String username){
		
		
		f.getContentPane().setBackground(new Color(0,0,102));;
		f.setBounds(390,130,700,600);
		f.setVisible(true);
		f.setLayout(null);
		
		p=new JPanel();
		p.setLayout(null);
		p.setBounds(33,0,609,530);
		p.setBackground(Color.WHITE);
		f.add(p);
		
		l10=new JLabel("UPDATE CUSTOMER DETAILS");
		l10.setBounds(50,30,300,25);
		l10.setFont(new Font("Railway",Font.BOLD,20));
		p.add(l10);
		
		l1=new JLabel("Username :");
		l1.setBounds(40,80,150,25);
		l1.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l1);
		
		t1=new JTextField();
		t1.setBounds(200,80,170,25);
		p.add(t1);
		
		l2=new JLabel("ID :");
		l2.setBounds(40,120,150,25);
		l2.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l2);
		
		t8=new JTextField();
		t8.setBounds(200,120,170,25);
		p.add(t8);
		
		l3=new JLabel("Number :");
		l3.setBounds(40,160,150,25);
		l3.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l3);
		
		t2=new JTextField();
		t2.setBounds(200,160,170,25);
		p.add(t2);
		
		l4=new JLabel("Name :");
		l4.setBounds(40,200,150,25);
		l4.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l4);
		
		t3=new JTextField();
		t3.setBounds(200,200,170,25);
		p.add(t3);
		
		l5=new JLabel("Gender :");
		l5.setBounds(40,240,150,25);
		l5.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l5);
	
		t9=new JTextField();
		t9.setBounds(200,240,170,25);
		p.add(t9);
		
		l6=new JLabel("Country :");
		l6.setBounds(40,280,150,25);
		l6.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l6);
		
		t4=new JTextField();
		t4.setBounds(200,280,170,25);
		p.add(t4);
		
		l7=new JLabel("Address :");
		l7.setBounds(40,320,150,25);
		l7.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l7);
		
		t5=new JTextField();
		t5.setBounds(200,320,170,25);
		p.add(t5);
		
		l8=new JLabel("Phone Number :");
		l8.setBounds(40,360,150,25);
		l8.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l8);
		
		t6=new JTextField();
		t6.setBounds(200,360,170,25);
		p.add(t6);
		
		l9=new JLabel("Email :");
		l9.setBounds(40,400,150,25);
		l9.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l9);
		
		t7=new JTextField();
		t7.setBounds(200,400,170,25);
		p.add(t7);
		
		b1=new JButton("Upadate");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(100,460,100,30);
		b1.addActionListener(this);
		p.add(b1);
		
		b2=new JButton("Back");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(250,460,100,30);
		b2.addActionListener(this);
		p.add(b2);
		
		
		
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
				
				t1.setText(rs.getString("username"));
				t2.setText(rs.getString("number"));
				t3.setText(rs.getString("name"));
				t4.setText(rs.getString("country"));
				t5.setText(rs.getString("address"));
				t6.setText(rs.getString("phone"));
				t7.setText(rs.getString("email"));
				t8.setText(rs.getString("id"));
				t9.setText(rs.getString("gender"));
				
			}
			
			
		}catch(Exception e) {}
			
	}
	public void actionPerformed(ActionEvent ae) {
		
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/tms";
		String driver = "com.mysql.cj.jdbc.Driver";
		String user = "root";
		String pass = "Tabuma@2205";
		
        if(ae.getSource()==b1) {
		
		String uname=t1.getText();
		String id=t8.getText();
		String number=t2.getText();
		String name=t3.getText();
		String radio=t9.getText();
		String country=t4.getText();
		String address=t5.getText();
		String phone=t6.getText();
		String email=t7.getText();
		
		
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			PreparedStatement st=con.prepareStatement("update Customer set username='"+uname+"',id='"+id+"',number='"+number+"',name='"+name+"',gender='"+radio+"',country='"+country+"',address='"+address+"',phone='"+phone+"',email='"+email+"'" );
			st.executeUpdate();
			JOptionPane.showMessageDialog(null,"Details Updated successfully");
            f.dispose();
			con.close();
			}
			catch(Exception e){
			JOptionPane.showMessageDialog(null,"Error in submitting data!");
			}	
		
		
		
        }
        else if(ae.getSource()==b2) {
        	
        	
        	f.dispose();
        }
        
       
	}

	public static void main(String[] args) {
		
		new UpdateCustomer("");

	}
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
