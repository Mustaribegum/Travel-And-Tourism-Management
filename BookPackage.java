package tour.travel.management;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class BookPackage implements ActionListener {
	
	JFrame f=new JFrame("Booking");
	JPanel p=new JPanel();
	JLabel l1,l2,l12,l3,l13,l4,l5,l15,l6,l16,l7,l17,l8,l18;
	Choice c1;
	JTextField t1;
	JButton b1,b2,b3;
	String username;
	
	
	BookPackage(String username){
		
		this.username=username;
		
		f.getContentPane().setBackground(new Color(0,0,102));;
		f.setBounds(390,180,660,510);
		f.setVisible(true);
		f.setLayout(null);
		
		p=new JPanel();
		p.setLayout(null);
		p.setBounds(20,20,640,490);
		p.setBackground(Color.WHITE);
		f.add(p);
		
		l1=new JLabel("BOOK PACKAGE");
		l1.setBounds(100,10,200,30);
		l1.setFont(new Font("Yu Mincho",Font.PLAIN,20));
		p.add(l1);
		
		l2=new JLabel("Username");
		l2.setBounds(40,70,100,30);
		l2.setFont(new Font("Tahoma",Font.PLAIN,16));
		p.add(l2);
		
	    l12=new JLabel("");
		l12.setBounds(250,70,200,30);
		l12.setFont(new Font("Tahoma",Font.PLAIN,16));
		p.add(l12);
		
		l3=new JLabel("Select Package");
		l3.setBounds(40,110,150,30);
		l3.setFont(new Font("Tahoma",Font.PLAIN,16));
		p.add(l3);
		
		c1=new Choice();
		c1.add(" ");
		c1.add("Gold Package");
		c1.add("Silver Package");
		c1.add("Bronze Package");
		c1.setBounds(250,110,200,30);
		p.add(c1);
		
		l4=new JLabel("Total Persons");
		l4.setBounds(40,150,100,30);
		l4.setFont(new Font("Tahoma",Font.PLAIN,16));
		p.add(l4);
		
		t1=new JTextField("1");
		t1.setBounds(250,150,200,25);
		p.add(t1);
		
		l5=new JLabel("ID");
		l5.setBounds(40,190,100,30);
		l5.setFont(new Font("Tahoma",Font.PLAIN,16));
		p.add(l5);
		
	    l15=new JLabel();
		l15.setBounds(250,190,200,30);
		l15.setFont(new Font("Tahoma",Font.PLAIN,16));
		p.add(l15);
		
		l6=new JLabel("Number");
		l6.setBounds(40,230,100,30);
		l6.setFont(new Font("Tahoma",Font.PLAIN,16));
		p.add(l6);
		
	    l16=new JLabel();
		l16.setBounds(250,230,200,30);
		l16.setFont(new Font("Tahoma",Font.PLAIN,16));
		p.add(l16);
		
		l7=new JLabel("Phone");
		l7.setBounds(40,270,100,30);
		l7.setFont(new Font("Tahoma",Font.PLAIN,16));
		p.add(l7);
		
	    l17=new JLabel();
		l17.setBounds(250,270,200,30);
		l17.setFont(new Font("Tahoma",Font.PLAIN,16));
		p.add(l17);
		
		l8=new JLabel("Total Price");
		l8.setBounds(40,310,100,30);
		l8.setFont(new Font("Tahoma",Font.PLAIN,16));
		p.add(l8);
		
		l18=new JLabel();
	    l18.setBounds(250,310,200,30);
	    l18.setForeground(Color.RED);
	    l18.setFont(new Font("Tahoma",Font.PLAIN,16));
		p.add(l18);
		
		try {
			Connection con = null;
			String url = "jdbc:mysql://localhost:3306/tms";
			String driver = "com.mysql.cj.jdbc.Driver";
			String user = "root";
			String pass = "Tabuma@2205";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			PreparedStatement st=con.prepareStatement("select * from Customer where username='"+username+"'");
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				
				l12.setText(rs.getString("username"));
				l15.setText(rs.getString("id"));
				l16.setText(rs.getString("number"));
				l17.setText(rs.getString("phone"));
				
            }
			
			
		}
		catch(Exception e) {
			
		}
		b1=new JButton("Check Price");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(60,380,120,28);
		b1.addActionListener(this);
		p.add(b1);
		
		b2=new JButton("Book Package");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(200,380,120,28);
		b2.addActionListener(this);
		p.add(b2);
		
		b3=new JButton("Back");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setBounds(340,380,120,28);
		b3.addActionListener(this);
		p.add(b3);
			
		
	}
	public void actionPerformed(ActionEvent ae) {
		
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/tms";
		String driver = "com.mysql.cj.jdbc.Driver";
		String user = "root";
		String pass = "Tabuma@2205";
		
		
		
		
		if(ae.getSource()==b1) {
			String p=c1.getSelectedItem();
			int cost=0;
			if(p.equals("Gold Package")) {
				cost+=12000;
			}else if(p.equals("Silver Package")) {
				cost+=24000;
			}else if(p.equals("Bronze Package")) {
				cost+=32000;
			}
			
			int persons=Integer.parseInt(t1.getText());
			cost*=persons;
			l18.setText(""+cost);
			
			
		}
		else if(ae.getSource()==b2) {
			try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			PreparedStatement st=con.prepareStatement("insert into bookPackage values ('"+l12.getText()+"','"+c1.getSelectedItem()+"','"+t1.getText()+"','"+l15.getText()+"','"+l16.getText()+"','"+l17.getText()+"','"+l18.getText()+"')");
			st.executeUpdate();
			JOptionPane.showMessageDialog(null,"Package Booked Successfully.");
            f.dispose();
			con.close();
			}
			catch(Exception e){
			JOptionPane.showMessageDialog(f,"OOPS Error in Booking!");
			}
		}
		else if(ae.getSource()==b3) {
			f.dispose();
		    new Package(username).setVisible(true);
		}
	}

	public static void main(String[] args) {
		
        new BookPackage("");
        
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
