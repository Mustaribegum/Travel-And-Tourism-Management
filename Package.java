package tour.travel.management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Package implements ActionListener,MouseListener{
	
	JFrame f=new JFrame("Packages");
	JPanel p;
	JButton b1,b2,b3,b4;
	String username;
	Package(String username){
		
		this.username=username;
		
		f.getContentPane().setBackground(new Color(0,0,102));;
		f.setBounds(390,160,660,510);
		f.setVisible(true);
		f.setLayout(null);
		
		p=new JPanel();
		p.setLayout(null);
		p.setBounds(50,50,540,380);
		p.setBackground(Color.LIGHT_GRAY);
		f.add(p);
		
		b1=new JButton("Check Package");
		b1.setBackground(new Color(102,102,102));
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Tahoma",Font.PLAIN,20));
		b1.setBounds(110,40,280,50);
		b1.addActionListener(this);
		b1.addMouseListener(this);
		p.add(b1);
		
		b2=new JButton("Book Package");
		b2.setBackground(new Color(102,102,102));
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Tahoma",Font.PLAIN,20));
		b2.setBounds(110,130,280,50);
		b2.addActionListener(this);
		b2.addMouseListener(this);
		p.add(b2);
		
		b3=new JButton("View Package");
		b3.setBackground(new Color(102,102,102));
		b3.setForeground(Color.WHITE);
		b3.setFont(new Font("Tahoma",Font.PLAIN,20));
		b3.setBounds(110,230,280,50);
		b3.addActionListener(this);
		b3.addMouseListener(this);
		p.add(b3);
		
		b4=new JButton("Back");
		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.WHITE);
		b4.setFont(new Font("Tahoma",Font.PLAIN,20));
		b4.setBounds(194,340,110,30);
		b4.addActionListener(this);
		p.add(b4);
		
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==b1) {
			CheckPackage c=new CheckPackage();
			c.setVisible(true);
			f.dispose();
		}
		else if(ae.getSource()==b2) {
			f.dispose();
			new BookPackage(username).setVisible(true);
			
		}
		else if(ae.getSource()==b3) {
			f.dispose();
			new ViewPackage(username).setVisible(true);
			
		}
		
		else if(ae.getSource()==b4) {
			f.dispose();
		}
	}
	

	public static void main(String[] args) {
		
		new Package("");

	}


	public void setVisible(boolean b) {
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==b1) {
		b1.setBackground(Color.GRAY);}
		else if(e.getSource()==b2) {
		b2.setBackground(Color.GRAY);}
		else if(e.getSource()==b3) {
		b3.setBackground(Color.GRAY);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource()==b1) {
		b1.setBackground(new Color(102,102,102));}
		else if(e.getSource()==b2) {
		b2.setBackground(new Color(102,102,102));}
		else if(e.getSource()==b3) {
		b3.setBackground(new Color(102,102,102));}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getSource()==b1) {
		b1.setBackground(new Color(102,102,102));}
		else if(e.getSource()==b2) {
		b2.setBackground(new Color(102,102,102));}
		else if(e.getSource()==b3) {
		b3.setBackground(new Color(102,102,102));}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==b1) {
		b1.setBackground(Color.BLACK);}
		else if(e.getSource()==b2) {
		b2.setBackground(Color.BLACK);}
		else if(e.getSource()==b3) {
		b3.setBackground(Color.BLACK);}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==b1) {
		b1.setBackground(new Color(102,102,102));}
		else if(e.getSource()==b2) {
		b2.setBackground(new Color(102,102,102));}
		else if(e.getSource()==b3) {
		b3.setBackground(new Color(102,102,102));}
	}

}
