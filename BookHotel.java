package tour.travel.management;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class BookHotel implements ActionListener {
	
	Connection con = null;
	String url = "jdbc:mysql://localhost:3306/tms";
	String driver = "com.mysql.cj.jdbc.Driver";
	String user = "root";
	String pass = "Tabuma@2205";
	
	
	JFrame f=new JFrame("Hotel Booking");
	JPanel p;
	JLabel title,l1,l11,l2,l3,l4,l5,l6,l7,l17,l8,l18,l9,l19,l10,l20;
	JTextField t1,t2,t3,t4;
	Choice c1,c2,c3;
	JButton b1,b2,b3;
	
	String username;
	
	
	BookHotel(String username){
		
		this.username=username;
		
		f.setBounds(300,100,800,700);
		f.setVisible(true);
		f.getContentPane().setBackground(new Color(0,0,102));
		f.setLayout(null);

		p=new JPanel();
		p.setLayout(null);
		p.setBounds(50,40,700,600);
		p.setBackground(Color.LIGHT_GRAY);
		f.add(p);
		
		title=new JLabel("BOOK HOTEL");
		title.setBounds(100,10,200,30);
		title.setFont(new Font("Yu Mincho",Font.PLAIN,20));
		p.add(title);
		
		l1=new JLabel("Username");
		l1.setBounds(40,70,150,30);
		l1.setFont(new Font("Tahoma",Font.PLAIN,16));
		p.add(l1);
		
	    l11=new JLabel("");
		l11.setBounds(250,70,200,30);
		l11.setFont(new Font("Tahoma",Font.PLAIN,16));
		p.add(l11);
		
		l2=new JLabel("Select Hotel");
		l2.setBounds(40,110,150,30);
		l2.setFont(new Font("Tahoma",Font.PLAIN,16));
		p.add(l2);
		
	 	c1=new Choice();
	 	try {
	 		Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			PreparedStatement st=con.prepareStatement("select * from hotel");
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				c1.add(rs.getString("hotel"));	
			}
	 	}catch(Exception e) {}
		c1.setBounds(250,110,200,30);
		p.add(c1);
	
		l3=new JLabel("Total Persons");
		l3.setBounds(40,150,150,30);
		l3.setFont(new Font("Tahoma",Font.PLAIN,16));
		p.add(l3);
		
		t1=new JTextField("1");
		t1.setBounds(250,150,200,25);
		p.add(t1);
		
		l4=new JLabel("No.of.Days");
		l4.setBounds(40,190,150,30);
		l4.setFont(new Font("Tahoma",Font.PLAIN,16));
		p.add(l4);
		
	    t2=new JTextField();
		t2.setBounds(250,190,200,30);
		t2.setFont(new Font("Tahoma",Font.PLAIN,16));
		p.add(t2);
		
		l5=new JLabel("AC or Non-AC");
		l5.setBounds(40,230,150,30);
		l5.setFont(new Font("Tahoma",Font.PLAIN,16));
		p.add(l5);
		
		c2=new Choice();
		c2.add(" ");
		c2.add("AC ");
		c2.add("Non-AC");
		c2.setBounds(250,230,200,30);
		p.add(c2);
		
		l6=new JLabel("Food Included ?");
		l6.setBounds(40,270,150,30);
		l6.setFont(new Font("Tahoma",Font.PLAIN,16));
		p.add(l6);
		
		c3=new Choice();
		c3.add(" ");
		c3.add("Yes");
		c3.add("No");
		c3.setBounds(250,270,200,30);
		p.add(c3);
		
		l7=new JLabel("ID");
		l7.setBounds(40,310,150,30);
		l7.setFont(new Font("Tahoma",Font.PLAIN,16));
		p.add(l7);
		
		l17=new JLabel();
	    l17.setBounds(250,310,200,30);
	    l17.setFont(new Font("Tahoma",Font.PLAIN,16));
		p.add(l17);
		
		l8=new JLabel("ID Number");
		l8.setBounds(40,350,150,30);
		l8.setFont(new Font("Tahoma",Font.PLAIN,16));
		p.add(l8);
		
		l18=new JLabel();
	    l18.setBounds(250,350,200,30);
	    l18.setFont(new Font("Tahoma",Font.PLAIN,16));
		p.add(l18);
		
		l9=new JLabel("Phone");
		l9.setBounds(40,390,150,30);
		l9.setFont(new Font("Tahoma",Font.PLAIN,16));
		p.add(l9);
		
		l19=new JLabel();
	    l19.setBounds(250,390,200,30);
	    l19.setFont(new Font("Tahoma",Font.PLAIN,16));
		p.add(l19);
		
		l10=new JLabel("Total Price");
		l10.setBounds(40,430,150,30);
		l10.setFont(new Font("Tahoma",Font.PLAIN,16));
		p.add(l10);
		
		l20=new JLabel();
	    l20.setBounds(250,430,200,30);
	    l20.setForeground(Color.RED);
	    l20.setFont(new Font("Tahoma",Font.PLAIN,16));
		p.add(l20);
		
		try {
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			PreparedStatement st=con.prepareStatement("select * from Customer where username='"+username+"'");
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				
				l11.setText(rs.getString("username"));
				l17.setText(rs.getString("id"));
				l18.setText(rs.getString("number"));
				l19.setText(rs.getString("phone"));
				
            }
			
			
		}
		catch(Exception e) {
			
		}
		
		b1=new JButton("Check Price");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(60,490,120,30);
		b1.addActionListener(this);
		p.add(b1);
		
		b2=new JButton("Book");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(200,490,120,30);
		b2.addActionListener(this);
		p.add(b2);
		
		b3=new JButton("Back");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setBounds(340,490,120,30);
		b3.addActionListener(this);
		p.add(b3);
			
	

		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==b1) {
			
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st=con.prepareStatement("select * from hotel where hotel='"+c1.getSelectedItem()+"'");
				ResultSet rs=st.executeQuery();
				while(rs.next()) {
					
					int cost =Integer.parseInt(rs.getString("cost_per_day"));
					int food =Integer.parseInt(rs.getString("food_charges"));
					int ac =Integer.parseInt(rs.getString("ac_charges"));
					
					int persons=Integer.parseInt(t1.getText());
					int days=Integer.parseInt(t2.getText());
					
					String acprice =c2.getSelectedItem();
					String foodprice=c3.getSelectedItem();
					
					if(persons*days >0) {
						
						int total=0;
						total +=acprice.equals("Yes")?ac:0; //ternary operator 
						total +=foodprice.equals("Yes")?food:0;
						total +=cost;
						total =total * persons * days;
						l20.setText(""+total);
						
					}
					else {
						l20.setText("Please Enter a Valid number");
					}
					
					
										
	            }
			}catch(Exception e) {}
			
		}else if(ae.getSource()==b2) {
			
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, user, pass);
				PreparedStatement st=con.prepareStatement("insert into bookhotel values('"+l11.getText()+"','"+c1.getSelectedItem()+"','"+t1.getText()+"','"+t2.getText()+"','"+c2.getSelectedItem()+"','"+c3.getSelectedIndex()+"','"+l17.getText()+"','"+l18.getText()+"','"+l19.getText()+"','"+l20.getText()+"')");
				st.executeUpdate();
				JOptionPane.showMessageDialog(null, "Hotel Booked Successfully .");
				f.dispose();
			}catch(Exception e) {
				
				JOptionPane.showMessageDialog(null, "OOPs ERROR ...");
			}
			
			
		}else if(ae.getSource()==b3) {
			new Hotels(username).setVisible(true);
			f.dispose();
		}
	}

	public static void main(String[] args) {
		new BookHotel("");

	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
