package tour.travel.management;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class MainPage implements ActionListener{
   
	JFrame f=new JFrame("MAIN PAGE");
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
	String username;
	
	MainPage(String username){
		
		this.username=username;
		
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setBackground(Color.LIGHT_GRAY);
		f.setLayout(null);
		f.setVisible(true);
		
		JPanel p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(0,0,1950,60);
		p1.setBackground(new Color(0,0,102));
		f.add(p1);
		
		JLabel l1=new JLabel("DASHBOARD");
		l1.setFont(new Font("Tahoma",Font.BOLD,30));
		l1.setForeground(Color.WHITE);
		l1.setBounds(810,10,300,40);
		p1.add(l1);
		
		JPanel p2=new JPanel();
		p2.setLayout(null);
		p2.setBounds(0,60,300,1000);
		p2.setBackground(new Color(0,0,102));
		f.add(p2);
		
		b1=new JButton("Add Personal Details");
		b1.setBackground(new Color(102,102,102));
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Tahoma",Font.PLAIN,20));
		b1.setMargin(new Insets(0,0,0,60));
		b1.setBounds(10,10,280,50);
		b1.addActionListener(this);
		p2.add(b1);
		
		b2=new JButton("Update Personal Details");
		b2.setBackground(new Color(102,102,102));
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Tahoma",Font.PLAIN,20));
		b2.setMargin(new Insets(0,0,0,30));
		b2.setBounds(10,80,280,50);
		b2.addActionListener(this);
		p2.add(b2);
		
		b3=new JButton("View Details");
		b3.setBackground(new Color(102,102,102));
		b3.setForeground(Color.WHITE);
		b3.setFont(new Font("Tahoma",Font.PLAIN,20));
		b3.setMargin(new Insets(0,0,0,130));
		b3.setBounds(10,150,280,50);
		b3.addActionListener(this);
		p2.add(b3);
		
		b4=new JButton("Delete Details");
		b4.setBackground(new Color(102,102,102));
		b4.setForeground(Color.WHITE);
		b4.setFont(new Font("Tahoma",Font.PLAIN,20));
		b4.setMargin(new Insets(0,0,0,110));
		b4.setBounds(10,220,280,50);
		b4.addActionListener(this);
		p2.add(b4);
		
		b5=new JButton("Package");
		b5.setBackground(new Color(102,102,102));
		b5.setForeground(Color.WHITE);
		b5.setFont(new Font("Tahoma",Font.PLAIN,20));
		b5.setMargin(new Insets(0,0,0,160));
		b5.setBounds(10,290,280,50);
		b5.addActionListener(this);
		p2.add(b5);
		
		b6=new JButton("Hotels");
		b6.setBackground(new Color(102,102,102));
		b6.setForeground(Color.WHITE);
		b6.setFont(new Font("Tahoma",Font.PLAIN,20));
		b6.setMargin(new Insets(0,0,0,190));
		b6.setBounds(10,360,280,50);
		b6.addActionListener(this);
		p2.add(b6);
		
		b7=new JButton("Generate Bill");
		b7.setBackground(new Color(102,102,102));
		b7.setForeground(Color.WHITE);
		b7.setFont(new Font("Tahoma",Font.PLAIN,20));
		b7.setMargin(new Insets(0,0,0,130));
		b7.setBounds(10,430,280,50);
		b7.addActionListener(this);
		p2.add(b7);
		
		b8=new JButton("About");
		b8.setBackground(new Color(102,102,102));
		b8.setForeground(Color.WHITE);
		b8.setFont(new Font("Tahoma",Font.PLAIN,20));
		b8.setMargin(new Insets(0,0,0,190));
		b8.setBounds(10,500,280,50);
		b8.addActionListener(this);
		p2.add(b8);
		
		b9=new JButton("Calculator");
		b9.setBackground(Color.BLACK);
		b9.setForeground(Color.WHITE);
		b9.setFont(new Font("Tahoma",Font.PLAIN,20));
		b9.setMargin(new Insets(0,0,0,100));
		b9.setBorder(new LineBorder(new Color(133,193,233)));
		b9.setBounds(1050,550,200,50);
		b9.addActionListener(this);
		f.add(b9);
			
		b10=new JButton("Notepad");
		b10.setBackground(Color.BLACK);
		b10.setForeground(Color.WHITE);
		b10.setFont(new Font("Tahoma",Font.PLAIN,20));
		b10.setMargin(new Insets(0,0,0,100));
		b10.setBorder(new LineBorder(new Color(133,193,233)));
		b10.setBounds(1050,600,200,50);
		b10.addActionListener(this);
		f.add(b10);
		
		
		
		JLabel l2=new JLabel("Travel and Tourism Management System");
		l2.setBounds(500,60,1000,70);
		l2.setForeground(new Color(102,102,102));
		l2.setFont(new Font("Tahoma",Font.ITALIC,40));
		f.add(l2);
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==b1) {
			
			new AddCustomer(username).setVisible(true);
		}
		else if(ae.getSource()==b2) {
			
			new UpdateCustomer(username).setVisible(true);
		}
		else if(ae.getSource()==b3) {
			new ViewCustomer(username).setVisible(true);
		}
		else if(ae.getSource()==b4) {
			new DeleteCustomer(username).setVisible(true);
		}
		else if (ae.getSource()==b5) {
			new Package(username).setVisible(true);
		}
		else if (ae.getSource()==b6) {
			new Hotels(username).setVisible(true);
		}
		else if (ae.getSource()==b7) {
			new GenerateBill(username).setVisible(true);
		}
		else if (ae.getSource()==b8) {
			new About().setVisible(true);
		}
		
		else if(ae.getSource()==b9) {
			
			try
			{
				Runtime.getRuntime().exec("calc.exe");
			}catch(Exception e) {
				
				JOptionPane.showMessageDialog(null, "Error in open Calculator ");
			}
			
		} else if(ae.getSource()==b10) {
			
			try
			{
				Runtime.getRuntime().exec("notepad.exe");
			}catch(Exception e) {
				
				JOptionPane.showMessageDialog(null, "Error in open Calculator ");
			}
			
		}
		
	}
	

	public static void main(String[] args) {
		
        new MainPage("");
       
	}


	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
  