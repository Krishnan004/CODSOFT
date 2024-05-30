package NumberGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Atm_Meachine  extends Frame  {
	TextField display;
	Button savings,deposite,withdraw,verify;
	int balance;
	public Atm_Meachine() {
		display=new TextField();
		
		
		verify=new Button("verify");
		deposite=new Button("deposite");
		withdraw=new Button("withdraw");
		savings=new Button("savings");
		
		display.setBounds(50,50,100,20);
		verify.setBounds(50,80,100,20);
		deposite.setBounds(50,110,100,20);
		withdraw.setBounds(50,140,100,20);
		savings.setBounds(50,170,100,20);
		
		verify.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int pin=Integer.parseInt(display.getText());
				if(pin==1234) {
					balance=5000;
					display.setText("Continue");
					verify.disable();
				}
				else if(pin==4321) {
					balance=10000;
					display.setText("Continue");
					verify.disable();
				}
				else if(pin==6754) {
					balance=8000;
					display.setText("Continue");
					verify.disable();
				}
				else {
					display.setText("Incorrect pin Retry");
				}
			}
		});
		
		savings.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String bl = String.valueOf(balance);
				display.setText(bl);
			}
		});
		
		withdraw.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int amnt=Integer.parseInt(display.getText());
				if(amnt>balance) {
					display.setText("Insufficient Balance");
				}
				else {
				int result=balance-amnt;
				String bl = String.valueOf(result);
				balance=result;
				display.setText("balance"+bl);
				}
			}
		});
		
		deposite.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int amnt=Integer.parseInt(display.getText());
				int result=amnt+balance;
				balance=result;
				String bl = String.valueOf(result);
				display.setText("balance"+bl);
			}
		});
			
		
		add(display);
		add(savings);
		add(deposite);
		add(withdraw);
		add(verify);
		
		setLayout(null);
		setSize(400, 400);
		setVisible(true);
		setTitle("Grade Clculator");
	}
	public static void main(String[] args) {
		
		new Atm_Meachine();
		
	}

}
