package tour.travel.management;

import java.awt.*;
import javax.swing.*;

public class CheckPackage {
	
	JFrame f=new JFrame("Packages");
	
	
	CheckPackage(){
		
		f.setVisible(true);
		f.setBounds(360,120,900,600);
		
		String[] package1=new String[] {"GOLD PACKAGE","6 Days and 7 Nights","Airport Assistance","Half Day City Tour",
				"Daily Buffet","Welcome Drinks at Arrival","Full Day 3 Island Cruise","English Speaking Guide","BOOK NOW","SUMMER SPECIAL","Rs 12000/-" };
		
		String[] package2=new String[] {"SILVER PACKAGE","5 Days and 6 Nights","Toll free and Entrance Free Ticket","Meet and Greet at Airport",
				"Welcome Drinks at Arrival","Night Safari","Full Day 3 Island Cruise","Cruise With Dinner ","BOOK NOW","WINTER SPECIAL","Rs 24000/-" };
		
		String[] package3=new String[] {"BRONZE PACKAGE","6 Days and 5 Nights","Return AirFare","Free Clubbing, Horse Riding & Other Games",
				"Welcome Drinks on Arrival","Daily Buffet","Stay in 5 Star Hotel","BBQ Dinner ","BOOK NOW","WINTER SPECIAL","Rs 32000/-" };
		
		JTabbedPane pane=new JTabbedPane();
		JPanel p1=createPackage(package1);
		pane.addTab("Package 1",null,p1);
		
		JPanel p2=createPackage(package2);
		pane.addTab("Package 2",null,p2);
		
		JPanel p3=createPackage(package3);
		pane.addTab("Package 3",null,p3);
		
		f.add(pane,BorderLayout.CENTER);
	}
	
	public JPanel createPackage(String[] pack) {
		JPanel p1 =new JPanel();
		p1.setLayout(null);
		p1.setBackground(Color.WHITE);
		
		JLabel l1=new JLabel(pack[0]);
		l1.setBounds(50,5,300,30);
		l1.setFont(new Font("Tahoma",Font.PLAIN,30));
		p1.add(l1);
		
		JLabel l2=new JLabel(pack[1]);
		l2.setBounds(100,60,300,30);
		l2.setForeground(Color.RED);
		l2.setFont(new Font("Tahoma",Font.PLAIN,20));
		p1.add(l2);
		
		JLabel l3=new JLabel(pack[2]);
		l3.setBounds(100,110,360,30);
		l3.setForeground(Color.BLUE);
		l3.setFont(new Font("Tahoma",Font.PLAIN,20));
		p1.add(l3);
		
		JLabel l4=new JLabel(pack[3]);
		l4.setBounds(100,160,400,30);
		l4.setForeground(Color.RED);
		l4.setFont(new Font("Tahoma",Font.PLAIN,20));
		p1.add(l4);
		
		JLabel l5=new JLabel(pack[4]);
		l5.setBounds(100,210,300,30);
		l5.setForeground(Color.BLUE);
		l5.setFont(new Font("Tahoma",Font.PLAIN,20));
		p1.add(l5);
		
		JLabel l6=new JLabel(pack[5]);
		l6.setBounds(100,260,300,30);
		l6.setForeground(Color.RED);
		l6.setFont(new Font("Tahoma",Font.PLAIN,20));
		p1.add(l6);
		
		JLabel l7=new JLabel(pack[6]);
		l7.setBounds(100,310,300,30);
		l7.setForeground(Color.BLUE);
		l7.setFont(new Font("Tahoma",Font.PLAIN,20));
		p1.add(l7);
		
		JLabel l8=new JLabel(pack[7]);
		l8.setBounds(100,360,300,30);
		l8.setForeground(Color.RED);
		l8.setFont(new Font("Tahoma",Font.PLAIN,20));
		p1.add(l8);
		
		JLabel l9=new JLabel(pack[8]);
		l9.setBounds(100,430,300,30);
		l9.setForeground(Color.BLUE);
		l9.setFont(new Font("Tahoma",Font.PLAIN,30));
		p1.add(l9);
		
		JLabel l10=new JLabel(pack[9]);
		l10.setBounds(370,470,300,30);
		l10.setForeground(Color.RED);
		l10.setFont(new Font("Tahoma",Font.PLAIN,30));
		p1.add(l10);
		
		JLabel l11=new JLabel(pack[10]);
		l11.setBounds(700,470,300,30);
		l11.setForeground(Color.RED);
		l11.setFont(new Font("Tahoma",Font.PLAIN,30));
		p1.add(l11);
		
		return p1;
	}

	public static void main(String[] args) {
		
		new CheckPackage();

	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
