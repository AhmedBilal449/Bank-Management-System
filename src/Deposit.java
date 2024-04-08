import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

import javax.swing.*;

public class Deposit extends JFrame implements ActionListener{
	
	//Elements Size and Position
	private static final int frameLength=500;
	private static final int frameHeight=300;
	private static final int itemLength=100;
	private static final int itemHeight=100;
	
	//Elements
	private JTextField depositTextField;
	private JButton depositButton;
	private JButton backButton;
	private String pinNumber;
	
	Deposit(String pinNumber){
		
		this.pinNumber=pinNumber;
	
		//JLabel Deposit Amount	
		JLabel depositText= new JLabel("Please Enter Amount");
		depositText.setBounds(frameLength-400,frameHeight-275,itemLength+220,itemHeight-70);		
		depositText.setFont(new Font("Arial",Font.BOLD,30));
		add(depositText);
		
		//TextField Deposit 	
		depositTextField= new JTextField("");
		depositTextField.setBounds(frameLength-400,frameHeight-200,itemLength+220,itemHeight-70);		
		depositTextField.setFont(new Font("Arial",Font.BOLD,20));
		add(depositTextField);
		
		//Button Deposit
		depositButton= new JButton("Deposit");
		depositButton.setBounds(frameLength-180,frameHeight-150,itemLength,itemHeight-70);
		depositButton.addActionListener(this);
		add(depositButton);
		
		//Button Back
		backButton= new JButton("Back");
		backButton.setBounds(frameLength-180,frameHeight-100,itemLength,itemHeight-70);
		backButton.addActionListener(this);
		add(backButton);
		
		//Set Frame Background Colour
		getContentPane().setBackground(Color.white);
			
		
		//Set Up GUI Frame
		this.setTitle("Deposit");
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(frameLength,frameHeight);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		if(ae.getSource()==depositButton) {
			
			String amount=  depositTextField.getText();
			Date date1= new Date();
			String date= String.valueOf(date1);
			String type= "Deposit";
			if(amount.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter an Amount");
				
			}else {
				
				//Establish database Connection
				Conn connManager= new Conn();
				
				//Prepare SQL query bank
				String query="INSERT INTO bank(pinNumber,date,type,amount)VALUES(?,?,?,?)";
				
				//Execute SQL Query to insert into bank
				try(PreparedStatement statement= connManager.getC().prepareStatement(query)){
					
					//Set Parameters for prepared statement
					statement.setString(1, pinNumber);
					statement.setString(2, date);
					statement.setString(3, type);
					statement.setString(4, amount);
					
					//Execute Query
					statement.executeUpdate();
					
					//Display Message 
					JOptionPane.showMessageDialog(null, "£"+amount+" Deposited Successfully");
					
					//Go back to Transactions Page
					setVisible(false);
					new Transactions(pinNumber).setVisible(true);
				} catch (SQLException ex) {
			        // Handle SQL exceptions
			        ex.printStackTrace();
			        JOptionPane.showMessageDialog(null, "Failed to insert record due to SQL error: " + ex.getMessage());
				}

			}
			
		}else if(ae.getSource()==backButton) {
			setVisible(false);
			new Transactions(pinNumber).setVisible(true);}
	}

}
