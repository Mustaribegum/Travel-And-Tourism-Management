package tour.travel.management;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;

public class Login_Form implements ActionListener{
	
	JFrame f=new JFrame("Travel and Tourism Agency");
	JPanel p1,p2;
	JLabel l1,l2,l3,l4;
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2,b3;
	
	
	Login_Form(){
		
		f.getContentPane().setBackground(Color.GRAY);
		f.setVisible(true);
		f.setBounds(400,150,900,400);
		f.setLayout(null);  
		
		//Panel 1
		
		p1=new JPanel();
		p1.setBackground(Color.BLACK);
		p1.setBounds(0,0,400,400);
		p1.setLayout(null);
		f.add(p1);
		
		l1=new JLabel("TRAVEL AND TOURISM PAGE");
		l1.setBounds(80,50,300,200);
		l1.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 20));
		l1.setForeground(Color.WHITE);
		p1.add(l1);
	
		//Panel 2 
		
		
		p2=new JPanel();
		p2.setLayout(null);
		p2.setBackground(Color.LIGHT_GRAY);
		p2.setBounds(400,30,450,300);
		f.add(p2);
		
		l2=new JLabel("Username ");
		l2.setBounds(60,20,100,25);
		l2.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
		p2.add(l2);
		
		
		t1=new JTextField();
		t1.setBounds(60,60,300,30);
		t1.setBorder(BorderFactory.createEmptyBorder());
		t1.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
		p2.add(t1);
		
		l3=new JLabel("Password ");
		l3.setBounds(60,110,100,25);
		l3.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
		p2.add(l3);
		
		
		t2=new JPasswordField();
		t2.setBounds(60,150,300,30);
		t2.setBorder(BorderFactory.createEmptyBorder());
		t2.setFont(new Font("Times new Roman",Font.PLAIN,20));
		p2.add(t2);
		
		
		//Button
		
		b1=new JButton("Login");
		b1.setBounds(60,210,130,30);
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLACK);
		b1.setBorder(new LineBorder(new Color(133,193,233)));
		b1.addActionListener(this);
		p2.add(b1);
		
		b2=new JButton("Signup");
		b2.setBounds(230,210,130,30);
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.BLACK);
		b2.setBorder(new LineBorder(new Color(133,193,233)));
		b2.addActionListener(this);
		p2.add(b2);
		
		b3=new JButton("Forget Password");
		b3.setBounds(130,250,160,30);
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setBorder(new LineBorder(new Color(133,193,233)));
		b3.addActionListener(this);
		p2.add(b3);
		
		l4=new JLabel("Trouble in Login...");
		l4.setForeground(Color.RED);
		l4.setBounds(300,250,100,20);
		p2.add(l4);
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		Connection con=null;
		String Driver="com.mysql.cj.jdbc.Driver";
		String url= "jdbc:mysql://localhost:3306/tms";
		String username="root";
		String password="Tabuma@2205";
		
		
		if(ae.getSource()==b1) 
		{
			String uname=t1.getText();
			String pass=t2.getText();
			
			
			try {
				
				Class.forName(Driver);
				con = DriverManager.getConnection(url, username, password);
				PreparedStatement st=con.prepareStatement("select * from account where Username=? And password=?");
				st.setString(1,uname);
				st.setString(2,pass);
				ResultSet rs=st.executeQuery();
				if(rs.next()) {
					new Loading(uname).setVisible(true);
					f.dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Invalid Login "+uname);
				}
				
			}catch(Exception e) {
				
			}
			
		}
		else if(ae.getSource()==b2) 
		{
			Signup_Form sf=new Signup_Form();
			sf.setVisible(true);
			f.dispose();
			
		}
		else if(ae.getSource()==b3) 
		{
			new Forgetpassword().setVisible(true);
			f.dispose();
		}
	}


void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

public static void main(String[] args) {
		
		new Login_Form();
		

	}
}
