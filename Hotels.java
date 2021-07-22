package tour.travel.management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Hotels implements ActionListener,MouseListener{
	
	JFrame f=new JFrame("HOTELS");
	JPanel p;
	JButton b1,b2,b3;
	String username;
	Hotels(String username){
		
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
		
		b1=new JButton("Book Hotel");
		b1.setBackground(new Color(102,102,102));
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Tahoma",Font.PLAIN,20));
		b1.setBounds(90,60,300,100);
		b1.addActionListener(this);
		b1.addMouseListener(this);
		p.add(b1);
		
		b2=new JButton("view Booked Hotel ");
		b2.setBackground(new Color(102,102,102));
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Tahoma",Font.PLAIN,20));
		b2.setBounds(90,200,300,100);
		b2.addActionListener(this);
		b2.addMouseListener(this);
		p.add(b2);
		
		
		b3=new JButton("Back");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setFont(new Font("Tahoma",Font.PLAIN,20));
		b3.setBounds(194,340,110,30);
		b3.addActionListener(this);
		p.add(b3);
		
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==b1) {
			f.dispose();
			BookHotel c=new BookHotel(username);
			c.setVisible(true);
			
		}
		else if(ae.getSource()==b2) {
			f.dispose();
			new ViewBookedHotel(username).setVisible(true);
			
		}
		
		
		else if(ae.getSource()==b3) {
			f.dispose();
		}
	}
	

	public static void main(String[] args) {
		
		new Hotels("");

	}


	public void setVisible(boolean b) {
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==b1) {
		b1.setBackground(Color.GRAY);}
		else if(e.getSource()==b2) {
		b2.setBackground(Color.GRAY);}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource()==b1) {
		b1.setBackground(new Color(102,102,102));}
		else if(e.getSource()==b2) {
		b2.setBackground(new Color(102,102,102));}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getSource()==b1) {
		b1.setBackground(new Color(102,102,102));}
		else if(e.getSource()==b2) {
		b2.setBackground(new Color(102,102,102));}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==b1) {
		b1.setBackground(Color.BLACK);}
		else if(e.getSource()==b2) {
		b2.setBackground(Color.BLACK);}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==b1) {
		b1.setBackground(new Color(102,102,102));}
		else if(e.getSource()==b2) {
		b2.setBackground(new Color(102,102,102));}
		
	}

}
