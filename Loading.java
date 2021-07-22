package tour.travel.management;

import java.awt.*;
import javax.swing.*;

public class Loading implements Runnable{
	
	JFrame f=new JFrame("Redirecting..");
	JLabel l1,l2,l3;
	JProgressBar p;
	Thread t;
	String username;
	
	public void run() {
	   try {
		   for(int i=1;i<=101;i++) {
			   int m=p.getMaximum(); //Progress bars maximum value 100
			   int n=p.getValue(); //progress bars current value 30
			   if(n<m) {
				   p.setValue(p.getValue()+1); //31<100
			   }else {
				   i=101;
				   f.dispose();
				   new MainPage(username).setVisible(true);
			   }
			   Thread.sleep(10);
		   }
	   }catch(Exception e) {}	
		
	}
	
	Loading(String user){
		
		 username=user;
		
		t=new Thread(this);
		
		f.setVisible(true);
		f.setBounds(390,130,600,400);
		f.getContentPane().setBackground(Color.LIGHT_GRAY);
		f.setLayout(null);
		
		l1=new JLabel("TRAVEL AND TOURISM AGENCY");
		l1.setBounds(30,20,600,40);
		l1.setFont(new Font("Railway",Font.BOLD,33));
		f.add(l1);
		
		p=new JProgressBar();
		p.setStringPainted(true);
		p.setBounds(140,120,300,25);
		p.setBackground(Color.WHITE);
		f.add(p);
		
		l2=new JLabel("Please wait...");
		l2.setBounds(240,160,120,20);
		l2.setFont(new Font("Tahoma",Font.BOLD,16));
		f.add(l2);
		
		l3=new JLabel("Welcome "+ username);
		l3.setBounds(20,310,400,20);
		l3.setFont(new Font("Tahoma",Font.BOLD,16));
		f.add(l3);
		
		t.start();
		
		
	}

	public static void main(String[] args) {
		
        new Loading(""); 	
        
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
