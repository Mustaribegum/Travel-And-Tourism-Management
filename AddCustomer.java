package tour.travel.management;


import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class AddCustomer implements ActionListener {
	
	JFrame f=new JFrame("Personal Details");
	JPanel p;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JComboBox c1;
	JRadioButton r1,r2;
	JButton b1,b2;
	
	
	AddCustomer(String username){
		
		
		f.getContentPane().setBackground(new Color(0,0,102));;
		f.setBounds(390,130,700,600);
		f.setVisible(true);
		f.setLayout(null);
		
		p=new JPanel();
		p.setLayout(null);
		p.setBounds(33,33,608,500);
		p.setBackground(Color.WHITE);
		f.add(p);
		
		
		l1=new JLabel("Username :");
		l1.setBounds(40,60,150,25);
		l1.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l1);
		
		t1=new JTextField();
		t1.setBounds(200,60,170,25);
		p.add(t1);
		
		l2=new JLabel("ID :");
		l2.setBounds(40,100,150,25);
		l2.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l2);
		
		c1=new JComboBox(new String[]{"","passport","Aadhar  Card","Pan Card","Ration Card"});
		c1.setBounds(200,100,170,25);
		p.add(c1);
		
		l3=new JLabel("Number :");
		l3.setBounds(40,140,150,25);
		l3.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l3);
		
		t2=new JTextField();
		t2.setBounds(200,140,170,25);
		p.add(t2);
		
		l4=new JLabel("Name :");
		l4.setBounds(40,180,150,25);
		l4.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l4);
		
		t3=new JTextField();
		t3.setBounds(200,180,170,25);
		p.add(t3);
		
		l5=new JLabel("Gender :");
		l5.setBounds(40,220,150,25);
		l5.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l5);
		
		r1=new JRadioButton("Male");
		r1.setBackground(Color.WHITE);
		r1.setBounds(200,220,70,25);
		p.add(r1);
		
		r2=new JRadioButton("Female");
		r2.setBackground(Color.WHITE);
		r2.setBounds(300,220,70,25);
		p.add(r2);
		
		ButtonGroup gen=new ButtonGroup();
		gen.add(r1);
		gen.add(r2);
		
		l6=new JLabel("Country :");
		l6.setBounds(40,260,150,25);
		l6.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l6);
		
		t4=new JTextField();
		t4.setBounds(200,260,170,25);
		p.add(t4);
		
		l7=new JLabel("Address :");
		l7.setBounds(40,300,150,25);
		l7.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l7);
		
		t5=new JTextField();
		t5.setBounds(200,300,170,25);
		p.add(t5);
		
		l8=new JLabel("Phone Number :");
		l8.setBounds(40,340,150,25);
		l8.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l8);
		
		t6=new JTextField();
		t6.setBounds(200,340,170,25);
		p.add(t6);
		
		l9=new JLabel("Email :");
		l9.setBounds(40,380,150,25);
		l9.setFont(new Font("Tahoma",Font.BOLD,15));
		p.add(l9);
		
		t7=new JTextField();
		t7.setBounds(200,380,170,25);
		p.add(t7);
		
		b1=new JButton("Add");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(100,450,100,30);
		b1.addActionListener(this);
		p.add(b1);
		
		b2=new JButton("Back");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(250,450,100,30);
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
			PreparedStatement st=con.prepareStatement("select * from account where Username='"+username+"'");
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				
				t1.setText(rs.getString("Username"));
				t3.setText(rs.getString("Name"));
				
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
		String id=(String)c1.getSelectedItem();
		String number=t2.getText();
		String name=t3.getText();
		String radio=null;
		if(r1.isSelected()) {
			radio="Male";
		}
		else if(r2.isSelected()){
			radio="Female";
		}
		String country=t4.getText();
		String address=t5.getText();
		String phone=t6.getText();
		String email=t7.getText();
		
		
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			PreparedStatement st=con.prepareStatement("insert into Customer(username,id,number,name,gender,country,address,phone,email) values(?,?,?,?,?,?,?,?,?)");
			st.setString(1,uname);
			st.setString(2,id);
			st.setString(3,number);
			st.setString(4,name);
			st.setString(5,radio);
			st.setString(6,country);
			st.setString(7,address);
			st.setString(8,phone);
			st.setString(9,email);
			st.executeUpdate();
			JOptionPane.showMessageDialog(null,"Customer Details Added successfully");
            f.dispose();
			con.close();
			}
			catch(Exception e){
			JOptionPane.showMessageDialog(f,"Error in submitting data!");
			}	
		
		
		
        }
        else if(ae.getSource()==b2) {
        	
        	
        	f.dispose();
        }
        
       
	}

	public static void main(String[] args) {
		
		new AddCustomer("");

	}
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
