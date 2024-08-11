import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class SignUpPageThree extends JFrame implements ActionListener {
	
	//Elements Size and Position
	private static final int frameLength=800;
	private static final int frameHeight=800;
	private static final int itemLength=100;
	private static final int itemHeight=100;
	
	//Elements Input
	private String formNo;
	private JRadioButton savingAccountRadioButton;
	private JRadioButton fixedDepositAccountRadioButton;
	private JRadioButton currentAccountRadioButton;
	private JRadioButton recurringDepositAccountRadioButton;
	private JCheckBox agreement;
	private JButton submitButton;
	private JButton cancelButton;
	
	
	SignUpPageThree(String x){
		
		this.formNo=x;
		
		//JLabel for Top Form Number
		JLabel formNumber= new JLabel("FORM NUMBER. " + formNo );
		formNumber.setBounds((frameLength-(itemLength+240))/2, frameHeight-750, itemLength+240, itemHeight-70);
		formNumber.setFont(new Font("Arial",Font.BOLD,30));
		formNumber.setHorizontalAlignment(SwingConstants.CENTER);
		add(formNumber);
		
		//JLabel for Card Info
		JLabel cardInfo= new JLabel("Page 3: Account Details");
		cardInfo.setBounds((frameLength-(itemLength+150))/2, frameHeight-700, itemLength+150, itemHeight-70);
		cardInfo.setFont(new Font("Arial",Font.BOLD,20));
		cardInfo.setHorizontalAlignment(SwingConstants.CENTER);
		add(cardInfo);		

		//JLabel Account Type 
		JLabel accountType= new JLabel("Account Type:");
		accountType.setBounds(frameLength-620, frameHeight-650, itemLength+140, itemHeight-70);
		accountType.setFont(new Font("Arial",Font.BOLD,20));
		add(accountType);

		//Radio Button Saving Account
		savingAccountRadioButton= new JRadioButton("Savings Account");
		savingAccountRadioButton.setBounds(frameLength-620, frameHeight-600, itemLength+100, itemHeight-70);
		savingAccountRadioButton.setFont(new Font("Arial",1,17));
		savingAccountRadioButton.setBackground(Color.white);
		add(savingAccountRadioButton);
		
		//Radio Button Fixed Deposit Account
		fixedDepositAccountRadioButton= new JRadioButton("Fixed Deposit Account");
		fixedDepositAccountRadioButton.setBounds(frameLength-420, frameHeight-600, itemLength+150, itemHeight-70);
		fixedDepositAccountRadioButton.setFont(new Font("Arial",1,17));
		fixedDepositAccountRadioButton.setBackground(Color.white);
		add(fixedDepositAccountRadioButton);
		
		//Radio Button Current Account
		currentAccountRadioButton= new JRadioButton("Current Account");
		currentAccountRadioButton.setBounds(frameLength-620, frameHeight-550, itemLength+100, itemHeight-70);
		currentAccountRadioButton.setFont(new Font("Arial",1,17));
		currentAccountRadioButton.setBackground(Color.white);
		add(currentAccountRadioButton);
		
		//Radio Button Recurring Deposit Account
		recurringDepositAccountRadioButton= new JRadioButton("Recurring Deposit");
		recurringDepositAccountRadioButton.setBounds(frameLength-420, frameHeight-550, itemLength+100, itemHeight-70);
		recurringDepositAccountRadioButton.setFont(new Font("Arial",1,17));
		recurringDepositAccountRadioButton.setBackground(Color.white);
		add(recurringDepositAccountRadioButton);

		//Button Group Account Type
		ButtonGroup accountTypeGroup=new ButtonGroup();
		accountTypeGroup.add(savingAccountRadioButton);
		accountTypeGroup.add(fixedDepositAccountRadioButton);
		accountTypeGroup.add(currentAccountRadioButton);
		accountTypeGroup.add(recurringDepositAccountRadioButton);
		
		//JLabel Card Number
		JLabel cardNumber= new JLabel("Card Number:");
		cardNumber.setBounds(frameLength-620, frameHeight-500, itemLength+140, itemLength-70);
		cardNumber.setFont(new Font("Arial",Font.BOLD,20));
		add(cardNumber);	
		
		//JLabel Card Number Dummy
		JLabel cardNumberDummy= new JLabel("XXXX-XXXX-XXXX-4198");
		cardNumberDummy.setBounds(frameLength-420, frameHeight-500, itemLength+140, itemLength-70);
		cardNumberDummy.setFont(new Font("Arial",Font.BOLD,20));
		add(cardNumberDummy);	
		
		//JLabel Your Card Number
		JLabel yourCardNumber= new JLabel("Your card Number");
		yourCardNumber.setBounds(frameLength-620, frameHeight-480, itemLength+140, itemLength-70);
		yourCardNumber.setFont(new Font("Arial",Font.BOLD,13));
		add(yourCardNumber);		
		
		//JLabel Pin Number
		JLabel pinNumber= new JLabel("Pin:");
		pinNumber.setBounds(frameLength-620, frameHeight-450, itemLength+140, itemLength-70);
		pinNumber.setFont(new Font("Arial",Font.BOLD,20));
		add(pinNumber);		
		
		//JLabel Pin Number Dummy
		JLabel pinNumberDummy= new JLabel("XXXX");
		pinNumberDummy.setBounds(frameLength-420, frameHeight-450, itemLength+140, itemLength-70);
		pinNumberDummy.setFont(new Font("Arial",Font.BOLD,20));
		add(pinNumberDummy);
		
		//JLabel Your Pin Number
		JLabel yourPinNumber= new JLabel("Your card Number");
		yourPinNumber.setBounds(frameLength-620, frameHeight-430, itemLength+140, itemLength-70);
		yourPinNumber.setFont(new Font("Arial",Font.BOLD,13));
		add(yourPinNumber);
		
//		//JLabel Services Required
//		JLabel servicesRequired= new JLabel("Services Required:");
//		servicesRequired.setBounds(frameLength-620, frameHeight-400, itemLength+140, itemLength-70);
//		servicesRequired.setFont(new Font("Arial",Font.BOLD,20));
//		add(servicesRequired);		
//		
		//CheckBox Agreement
		agreement=new JCheckBox("I heareby declare that the above entered details are correct");
		agreement.setBounds(frameLength-620, frameHeight-350, itemLength+540, itemLength-70);
		agreement.setFont(new Font("Arial",Font.BOLD,15));
		agreement.setBackground(Color.white);
		add(agreement);
		
		//Button Submit
		submitButton= new JButton("Submit");
		submitButton.setBounds(frameLength-550, frameHeight-300, itemLength, itemLength-70);		
		submitButton.setBackground(Color.BLACK);
		submitButton.setForeground(Color.WHITE);
		submitButton.addActionListener(this);
		add(submitButton);
		
		//Button Cancel
		cancelButton= new JButton("Cancel");
		cancelButton.setBounds(frameLength-350, frameHeight-300, itemLength, itemLength-70);		
		cancelButton.setBackground(Color.BLACK);
		cancelButton.setForeground(Color.WHITE);
		cancelButton.addActionListener(this);
		add(cancelButton);
		
		//Sets Background Colour
		getContentPane().setBackground(Color.white);
		
		//Set up GUI Frame
		this.setTitle("Sign Up: Page 3");
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(frameLength,frameHeight);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==submitButton) {
			
			//Create random account number
			Random ranCardNum= new Random();
			long cardNum= Math.abs((ranCardNum.nextLong()%90000000L) +4494494400000000L);
			
			//Create random Pin number
			Random ranPinNum= new Random();
			int pinNum= Math.abs((ranPinNum.nextInt()%9000)+1000);
			
			//Converting Text Fields into String
			String formNumber= String.valueOf(formNo);
			String accountType= getAccountType();
			String cardNumber= 	String.valueOf(cardNum);
			String pinNumber= String.valueOf(pinNum);
			String agreementBox= String.valueOf(agreement);
			
			//Validate if Agreement is checked.
			
		    // Establish database connection 
			Conn connManager= new Conn();
			
			//Prepare SQL query signupthree
			String query= "INSERT INTO signupthree(formNumber,accountType,cardNumber,pinNumber) VALUES(?,?,?,?)";
			
			//Prepare SQL query login
			String query1= "INSERT INTO login(formNumber,cardNumber,pinNumber) VALUES(?,?,?)";
			
			//Execute SQL Query to insert into signupthree
			
			try(PreparedStatement statement=connManager.getC().prepareStatement(query)){
				
				//Set Parameters for prepared statement
				statement.setString(1, formNumber);
				statement.setString(2, accountType);
				statement.setString(3, cardNumber);
				statement.setString(4, pinNumber);

		        // Execute the query and get the number of rows affected
		        int rowsInserted = statement.executeUpdate();

		        // Check if any rows were inserted and show appropriate message
		        if (rowsInserted > 0) {
		            JOptionPane.showMessageDialog(null, "Record inserted successfully!");
		        } else {
		            JOptionPane.showMessageDialog(null, "Failed to insert record!");
		        }
		        
		        JOptionPane.showMessageDialog(null, "Your Card Number is: "+ cardNumber +"\nYour Pin Number is: "+ pinNumber );				
		    	setVisible(false);
				new Login().setVisible(true);
		        
			} catch (SQLException ex) {
		        // Handle SQL exceptions
		        ex.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Failed to insert record due to SQL error: " + ex.getMessage());
			}
			
			
			//Execute SQL Query to insert into login

			try(PreparedStatement statement1=connManager.getC().prepareStatement(query1)){
				
				//Set Parameters for prepared statement
				statement1.setString(1, formNumber);
				statement1.setString(2, cardNumber);
				statement1.setString(3, pinNumber);
				
				// Execute the query and get the number of rows affected
				statement1.executeUpdate();
		
								
			} catch (SQLException ex) {
				// Handle SQL exceptions
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "Failed to insert record due to SQL error: " + ex.getMessage());
			}
		
			
			
		}
		
		
		else if(e.getSource()==cancelButton) {
			
			
			
		}
		
	}
	
	//Method to get Account Type
	private String getAccountType() {
		

		
		String accountType=null;
		if(savingAccountRadioButton.isSelected()) {
			accountType= "Savings";
		}else if(fixedDepositAccountRadioButton.isSelected()) {
			accountType= "Fixed Deposit";
		}else if(currentAccountRadioButton.isSelected()) {
			accountType= "Current";
		}else if(recurringDepositAccountRadioButton.isSelected()) {
			accountType= "Recurring Deposit";
		}
		
		return accountType;	
	}	

}
