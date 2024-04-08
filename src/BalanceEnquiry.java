import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
		
	//Elements Size and Position
	private static final int frameLength=500;
	private static final int frameHeight=300;
	private static final int itemLength=100;
	private static final int itemHeight=100;	
	
	//Elements
	String pinNumber;
	JButton backButton;
	int balance;
	
	BalanceEnquiry(String pinNumber){
		
		this.pinNumber=pinNumber;
		
		balance= BalanceManager.calculateBalance(pinNumber);
		
		//JLabel Balance
		JLabel balanceText= new JLabel("Your Current Balance is £"+balance);
		balanceText.setBounds(frameLength-470,frameHeight-225,itemLength+380,itemHeight-60);
		balanceText.setFont(new Font("Arial",Font.BOLD,30));
		add(balanceText);
		
		//Button Exit
		backButton= new JButton("Back");
		backButton.setBounds(frameLength-220,frameHeight-110,itemLength,itemHeight-70);
		backButton.addActionListener(this);
		add(backButton);
		
		//Set Frame Background Colour
		getContentPane().setBackground(Color.white);	
		
		//Set Up GUI Frame
		this.setTitle("Balance Enquiry");
		this.setLayout(null);
		this.setVisible(false);
		this.setSize(frameLength,frameHeight);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		setVisible(false);
		new Transactions(pinNumber).setVisible(true);
		
	}

}
