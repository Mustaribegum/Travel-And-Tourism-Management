package tour.travel.management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Forgetpassword implements ActionListener {
	
	JFrame f=new JFrame("Forget Password");
	JPanel p;
	JLabel luname,lname,lque,lans,lpass;
	JTextField tuname,tname,tque,tans,tpass;
	JButton b1,b2,b3;
	
	Forgetpassword(){
		f.getContentPane().setBackground(Color.GRAY);;
		f.setBounds(390,130,660,510);
		f.setVisible(true);
		f.setLayout(null);
		
		p=new JPanel();
		p.setLayout(null);
		p.setBounds(50,50,540,380);
		p.setBackground(Color.LIGHT_GRAY);
		f.add(p);
		
		luname=new JLabel("Username");
		luname.setBounds(40,50,160,25);
		luname.setFont(new Font("Tahoma",Font.BOLD,14));
		p.add(luname);
		
		tuname=new JTextField();
		tuname.setBounds(200,50,200,25);
		tuname.setBorder(BorderFactory.createEmptyBorder());
		p.add(tuname);
		
		b1=new JButton("Search");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(410,50,100,25);
		b1.addActionListener(this);
		p.add(b1);
		
		lname=new JLabel("Name");
		lname.setBounds(40,100,160,25);
		lname.setFont(new Font("Tahoma",Font.BOLD,14));
		p.add(lname);
		
		tname=new JTextField();
		tname.setBounds(200,100,200,25);
		tname.setBorder(BorderFactory.createEmptyBorder());
		p.add(tname);
		
		lque=new JLabel("Your Security Question");
		lque.setBounds(40,150,160,25);
		lque.setFont(new Font("Tahoma",Font.BOLD,14));
		p.add(lque);
		
		tque=new JTextField();
		tque.setBounds(200,150,260,25);
		tque.setBorder(BorderFactory.createEmptyBorder());
		p.add(tque);
		
		lans=new JLabel("Answer");
		lans.setBounds(40,200,160,25);
		lans.setFont(new Font("Tahoma",Font.BOLD,14));
		p.add(lans);
		
		tans=new JTextField();
		tans.setBounds(200,200,200,25);
		tans.setBorder(BorderFactory.createEmptyBorder());
		p.add(tans);
		
		b2=new JButton("Retrieve");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(410,200,100,25);
		b2.addActionListener(this);
		p.add(b2);
		
		
		lpass=new JLabel("Password");
		lpass.setBounds(40,250,160,25);
		lpass.setFont(new Font("Tahoma",Font.BOLD,14));
		p.add(lpass);
		
		tpass=new JTextField();
		tpass.setBounds(200,250,200,25);
		tpass.setBorder(BorderFactory.createEmptyBorder());
		p.add(tpass);
		
		b3=new JButton("Back");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setBounds(200,325,100,28);
		b3.addActionListener(this);
		p.add(b3);
			
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/tms";
		String driver = "com.mysql.cj.jdbc.Driver";
		String user = "root";
		String pass = "Tabuma@2205";
		
		if(ae.getSource()== b1) {
			
			String uname=tuname.getText();
			
			try{
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			PreparedStatement st=con.prepareStatement("select * from account where Username=?");
			st.setString(1,uname);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				tname.setText(rs.getString("Name"));
				tque.setText(rs.getString("Security"));
			}
			con.close();
			}
			catch(Exception e){
			//JOptionPane.showMessageDialog(f,"Error in submitting data!");
			}	
			
		}
		else if (ae.getSource()==b2) {
			
			String uname=tuname.getText();
            String ans=tans.getText();
			
			try{
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			PreparedStatement st=con.prepareStatement("select * from account where Answer=? AND Username=?");
			st.setString(1,ans);
			st.setString(2, uname);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				
				tpass.setText(rs.getString("Password"));
			}
			con.close();
			}
			catch(Exception e){
			
			}	
			
		}
		else if (ae.getSource()==b3) {
			
			new Login_Form().setVisible(true);
			f.dispose();
		}
		
	}

	public static void main(String[] args) {
		
		new Forgetpassword();

	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
