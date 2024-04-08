import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

import javax.swing.*;

public class Withdrawl extends JFrame implements ActionListener{
	
	//Elements Size and Position
	private static final int frameLength=500;
	private static final int frameHeight=300;
	private static final int itemLength=100;
	private static final int itemHeight=100;
	
	//Elements
	private JTextField withdrawlTextField;
	private JButton withdrawlButton;
	private JButton backButton;
	private String pinNumber;
	
	Withdrawl(String pinNumber){
		
		this.pinNumber=pinNumber;
	
		//JLabel Withdrawl Amount	
		JLabel WithdrawlText= new JLabel("Please Enter Amount");
		WithdrawlText.setBounds(frameLength-400,frameHeight-275,itemLength+220,itemHeight-70);		
		WithdrawlText.setFont(new Font("Arial",Font.BOLD,30));
		add(WithdrawlText);
		
		//TextField Withdrawl 	
		withdrawlTextField= new JTextField("");
		withdrawlTextField.setBounds(frameLength-400,frameHeight-200,itemLength+220,itemHeight-70);		
		withdrawlTextField.setFont(new Font("Arial",Font.BOLD,20));
		add(withdrawlTextField);
		
		//Button Withdrawl
		withdrawlButton= new JButton("Withdraw");
		withdrawlButton.setBounds(frameLength-180,frameHeight-150,itemLength,itemHeight-70);
		withdrawlButton.addActionListener(this);
		add(withdrawlButton);
		
		//Button Back
		backButton= new JButton("Back");
		backButton.setBounds(frameLength-180,frameHeight-100,itemLength,itemHeight-70);
		backButton.addActionListener(this);
		add(backButton);
		
		//Set Frame Background Colour
		getContentPane().setBackground(Color.white);
			
		
		//Set Up GUI Frame
		this.setTitle("Withdrawl");
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(frameLength,frameHeight);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

	    if (ae.getSource() == withdrawlButton) {

	        String amount = withdrawlTextField.getText();
	        int amountChange = Integer.parseInt(amount);
	        Date date1 = new Date();
	        String date = String.valueOf(date1);
	        String type = "Withdrawl";
	        if (amount.equals("")) {
	            JOptionPane.showMessageDialog(null, "Please Enter an Amount");

	        } else {

	            // Establish database Connection
	            Conn connManager = new Conn();

	            int balance=BalanceManager.calculateBalance(pinNumber);
	                // Check if the balance is sufficient for the withdrawal
	                if (balance < amountChange) {
	                    JOptionPane.showMessageDialog(null, "Insufficient Funds");
	                    return;
	                }

	                // Proceed with the withdrawal
	                String insertQuery = "INSERT INTO bank(pinNumber,date,type,amount)VALUES(?,?,?,?)";

	                try (PreparedStatement insertStatement = connManager.getC().prepareStatement(insertQuery)) {

	                    insertStatement.setString(1, pinNumber);
	                    insertStatement.setString(2, date);
	                    insertStatement.setString(3, type);
	                    insertStatement.setString(4, amount);

	                    // Execute Query
	                    insertStatement.executeUpdate();

	                    // Display Message
	                    JOptionPane.showMessageDialog(null, "£" + amount + " Withdrawn Successfully");

	                    // Go back to Transactions Page
	                    setVisible(false);
	                    new Transactions(pinNumber).setVisible(true);
	                }

	             catch (SQLException ex) {
	                // Handle SQL exceptions
	                ex.printStackTrace();
	                JOptionPane.showMessageDialog(null, "Failed to retrieve transactions due to SQL error: " + ex.getMessage());
	            }
	        }

	    } else if (ae.getSource() == backButton) {
	        setVisible(false);
	        new Transactions(pinNumber).setVisible(true);
	    }
	}


}
