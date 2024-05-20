package AWT.learning;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Grade_Calculator extends Frame {
   TextField sub1,sub2,sub3,sub4,sub5;
   Label percentage,grade;
   Button submit;
   int sum;
	Grade_Calculator(){
		sub1 = new TextField();
		sub2 = new TextField();
		sub3 = new TextField();
		sub4 = new TextField();
		sub5 = new TextField();
		submit =new Button("Submit");
		percentage =new Label("Percentage");
		grade =new Label("Grade");
		
		sub1.setBounds(50,50,100,20);
		sub2.setBounds(50,80,100,20);
		sub3.setBounds(50,110,100,20);
		sub4.setBounds(50,140,100,20);
		sub5.setBounds(50,170,100,20);
		submit.setBounds(75,200,50,20);
		percentage.setBounds(50,230,200,20);
		grade.setBounds(50,260,50,20);
		
		
		submit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int a=Integer.parseInt(sub1.getText());
				int b=Integer.parseInt(sub2.getText());
				int c=Integer.parseInt(sub3.getText());
				int d=Integer.parseInt(sub4.getText());
				int f=Integer.parseInt(sub5.getText());
				sum=a+b+c+d+f;
				
				percentage.setText("Percentage: "+sum/5+"%");
				if(sum>=450)
					grade.setText("Grade: A");
				else if(sum>=400 && sum<450) 
					grade.setText("Grade: B");
				else if(sum>=300 && sum<400) 
					grade.setText("Grade: C");
				else if(sum>=200 && sum<300) 
					grade.setText("Grade: B");
				else  
					grade.setText("Grade: Fail");
			}
		});
		add(sub1);
		add(sub2);
		add(sub3);
		add(sub4);
		add(sub5);
		add(submit);
		add(percentage);
		add(grade);
		
		setLayout(null);
		setSize(400, 400);
		setVisible(true);
		setTitle("Grade Clculator");
		}
	public static void main(String[] args) {
		new Grade_Calculator();

	}

}
