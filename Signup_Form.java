package tour.travel.management;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.sql.*;

public class Signup_Form  implements ActionListener{
	
	JFrame f=new JFrame("Registration Form");
	JLabel luname,lname,lpass,lque,lans,ltitle;
	JTextField tuname,tname,tans;
	JPasswordField tpass;
	Choice c1;
	JButton b1,b2;
	
	
	Signup_Form(){
		
		f.setVisible(true);
		f.setBounds(400,150,600,550);
		f.getContentPane().setBackground(Color.LIGHT_GRAY);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		
		ltitle=new JLabel("Create Account ");
		ltitle.setBounds(30,50,200,25);
		ltitle.setFont(new Font("Tahoma",Font.BOLD,20));
		ltitle.setBackground(Color.CYAN);
		f.add(ltitle);
		
		luname=new JLabel("Username ");
		luname.setBounds(50,110,150,25);
		luname.setFont(new Font("Tahoma",Font.PLAIN,16));
		f.add(luname);
		
		tuname=new JTextField();
		tuname.setBounds(180,110,200,25);
		tuname.setBorder(BorderFactory.createEmptyBorder());
		f.add(tuname);
		
		lname=new JLabel("Name ");
		lname.setBounds(50,160,150,25);
		lname.setFont(new Font("Tahoma",Font.PLAIN,16));
		f.add(lname);
		
		tname=new JTextField();
		tname.setBounds(180,160,200,25);
		tname.setBorder(BorderFactory.createEmptyBorder());
		f.add(tname);
		
		lpass=new JLabel("Password ");
		lpass.setBounds(50,210,150,25);
		lpass.setFont(new Font("Tahoma",Font.PLAIN,16));
		f.add(lpass);
		
		tpass=new JPasswordField();
		tpass.setBounds(180,210,200,25);
		tpass.setBorder(BorderFactory.createEmptyBorder());
		f.add(tpass);
		
		lque=new JLabel("Security Question ");
		lque.setBounds(50,260,130,25);
		lque.setFont(new Font("Tahoma",Font.PLAIN,16));
		f.add(lque);
		
		c1=new Choice();
		c1.add("select Question");
		c1.add("your nick Name ?");
		c1.add("your native place ?");
		c1.add("your school name ?");
		c1.setBounds(180,260,200,25);
		f.add(c1);
		
		lans=new JLabel("Your Answer  ");
		lans.setBounds(50,310,150,25);
		lans.setFont(new Font("Tahoma",Font.PLAIN,16));
		f.add(lans);
		
		tans=new JTextField();
		tans.setBounds(180,310,200,25);
		tans.setBorder(BorderFactory.createEmptyBorder());
		f.add(tans);
		
		b1=new JButton("CREATE");
		b1.setBounds(80,400,120,30);
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLACK);
		b1.setFont(new Font("Tahoma",Font.BOLD,14));
		b1.addActionListener(this);
		f.add(b1);
		
		b2=new JButton("BACK");
		b2.setBounds(250,400,120,30);
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.BLACK);
		b2.setFont(new Font("Tahoma",Font.BOLD,14));
		b2.addActionListener(this);
		f.add(b2);
	    
		
		
	}
	public void actionPerformed(ActionEvent ae) {
		
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/tms";
		String driver = "com.mysql.cj.jdbc.Driver";
		String user = "root";
		String pass = "Tabuma@2205";
		
		
		if(ae.getSource()==b1) {
			
			String uname=tuname.getText();
			String name=tname.getText();
			String password=tpass.getText();
			String security=c1.getSelectedItem();
			String answer=tans.getText();
			
			
		
			try{
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			PreparedStatement st=con.prepareStatement("insert into account(Username,Name,Password,Security,Answer) values(?,?,?,?,?)");
			st.setString(1,uname);
			st.setString(2,name);
			st.setString(3,password);
			st.setString(4,security);
			st.setString(5,answer);
			st.executeUpdate();
			JOptionPane.showMessageDialog(f,"Data is successfully inserted into database.");
			new Login_Form().setVisible(true);
			f.dispose();
			con.close();
			}
			catch(Exception e){
			JOptionPane.showMessageDialog(f,"Error in submitting data!");
			}	
			
		}
		else if(ae.getSource()==b2) {
			
			int opt=JOptionPane.showConfirmDialog(b2, "Do You need to Go Back to the Login Page ?",
					"Exit",JOptionPane.YES_NO_OPTION);
			if(opt==0) {
			Login_Form lf=new Login_Form();
			lf.setVisible(true);
			f.dispose();
			}
			
			try {
				
				
			}catch(Exception e) {}
		}
		
	    	
		
	
	}
	
	public static void main(String args[]) {
		
		new Signup_Form();
	}
	
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}


	

	
}
