import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{
	
	//Elements Size and Position
	private static final int frameLength=750;
	private static final int frameHeight=500;
	private static final int itemLength=100;
	private static final int itemHeight=100;
	
	//Elements Input
	private JButton signInButton;
	private JButton clearButton;
	private JButton signUpButton;
	private JTextField cardTextField;
	private JPasswordField pinTextField;
	
	Login(){
	
		//Load Bank-Logo
		ImageIcon logo= new ImageIcon(ClassLoader.getSystemResource("Icons/Logo.png"));
		Image scaledLogo = logo.getImage().getScaledInstance(itemLength, itemHeight, Image.SCALE_DEFAULT);
		ImageIcon bankLogo= new ImageIcon(scaledLogo);
		
		//JLabel for Bank-Logo
		JLabel bankLogoLabel= new JLabel(bankLogo);
		bankLogoLabel.setBounds(frameLength-700, frameHeight-490, itemLength, itemHeight);
		add(bankLogoLabel);
		
		//JLabel for Bank-Logo-Right
		JLabel bankLogoLabelRight= new JLabel(bankLogo);
		bankLogoLabelRight.setBounds(frameLength-150, frameHeight-490, itemLength, itemHeight);
		add(bankLogoLabelRight);
		
		//JLabel for Heading
		JLabel heading= new JLabel("Welcome to Bank of Bank ATM");
		heading.setBounds(frameLength-600, frameHeight-460, itemLength+350, itemLength-50);
		heading.setFont(new Font("Arial",Font.BOLD, 30));
		add(heading);
		
		//JLabel for Card-Number
		JLabel cardNumber= new JLabel("Card No. :");
		cardNumber.setBounds(frameLength-650, frameHeight-325, itemLength+50, itemLength-70);
		cardNumber.setFont(new Font("Arial",Font.BOLD,30));
		add(cardNumber);
		
		//TextField Card-Number
		cardTextField=new JTextField();
		cardTextField.setBounds(frameLength-500, frameHeight-325, itemLength+150, itemHeight-70);
		cardTextField.setFont(new Font("Arial",1,20));
		add(cardTextField);
		
		//JLabel for Pin
		JLabel pin= new JLabel("Pin No. :");
		pin.setBounds(frameLength-630, frameHeight-240,itemLength+50, itemHeight-70);
		pin.setFont(new Font("Arial",Font.BOLD,30));
		add(pin);
		
		//TextField Pin
		pinTextField=new JPasswordField();
		pinTextField.setBounds(frameLength-500, frameHeight-240, itemLength+150, itemHeight-70);
		pinTextField.setFont(new Font("Arial",1,20));
		add(pinTextField);
		
		//Sets Background Colour
		getContentPane().setBackground(Color.lightGray);
		
		//Sign in Button
		signInButton=new JButton("Sign In");
		signInButton.setBounds(frameLength-500, frameHeight-170, itemLength, itemHeight-70);
		signInButton.setBackground(Color.BLACK);
		signInButton.setForeground(Color.WHITE);
		signInButton.addActionListener(this);
		add(signInButton);
		
		//Clear Button
		clearButton=new JButton("Clear");
		clearButton.setBounds(frameLength-350, frameHeight-170, itemLength, itemHeight-70);
		clearButton.setBackground(Color.BLACK);
		clearButton.setForeground(Color.WHITE);
		clearButton.addActionListener(this);
		add(clearButton);
		
		//Sign up Button
		signUpButton=new JButton("Sign Up");
		signUpButton.setBounds(frameLength-500, frameHeight-120, itemLength+150, itemHeight-70);
		signUpButton.setBackground(Color.BLACK);
		signUpButton.setForeground(Color.WHITE);
		signUpButton.addActionListener(this);
		add(signUpButton);
		
		//Set up GUI Frame
		this.setTitle("ATM");
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(frameLength,frameHeight);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==signInButton) {
			
			//Get Values For Card And Pin
			String cardNumber= cardTextField.getText();
			String pinNumber= pinTextField.getText();
			
		    // Establish database connection 			
			Conn connManager= new Conn();
			
			//Prepare SQL query to check if Login is legitimate
			String query= "SELECT * FROM login WHERE cardNumber = ? AND pinNumber = ?";			
			//Execute SQL Query To Check Login Data
			try(PreparedStatement statement=connManager.getC().prepareStatement(query)) {
				
				//Get Values
				statement.setString(1, cardNumber);
				statement.setString(2, pinNumber);
				
		        // Execute Query
		        ResultSet rs = statement.executeQuery();

		        // Check if the ResultSet has any rows
		        if (rs.next()) {
		            String dataCardNumber = rs.getString("cardNumber");
		            String dataPinNumber = rs.getString("pinNumber");

		            // Check if the retrieved values match with input values
		            if (dataCardNumber.equals(cardNumber) && dataPinNumber.equals(pinNumber)) {
		                setVisible(false);
		                new Transactions(pinNumber).setVisible(true);
		            } else {
		                // Handle case where the retrieved values don't match input values
		                JOptionPane.showMessageDialog(null, "Incorrect card number or pin.");
		            }
		        } else {
		            // Handle case where no rows were returned by the query
		            JOptionPane.showMessageDialog(null, "No user found with provided credentials.");
		        }
				
				
			} catch (SQLException ex) {
		        // Handle SQL exceptions
		        ex.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Failed to fetch record due to SQL error: " + ex.getMessage());
			}
			
		}
		else if(ae.getSource()==clearButton) {
			
			cardTextField.setText("");
			pinTextField.setText("");
			
		}
		else if(ae.getSource()==signUpButton) {
			this.setVisible(false);
			new SignUpPageOne().setVisible(true);
		}
		else {}
	
		
	}
	

}
