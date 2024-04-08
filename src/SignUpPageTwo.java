import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

public class SignUpPageTwo extends JFrame implements ActionListener {
	
	

	//Elements Size and Position
	private static final int frameLength=800;
	private static final int frameHeight=800;
	private static final int itemLength=100;
	private static final int itemHeight=100;
	
	//Elements Input
	private JComboBox religionComboBox;
	private JComboBox ethnicityComboBox;
	private JComboBox incomeComboBox;
	private JComboBox qualificationComboBox;
	private JTextField occupationTextField;
	private JTextField iBANTextField;
	private JTextField iDNumberTextField;
	private JRadioButton seniorRadioButton;
	private JRadioButton notSeniorRadioButton;
	private JRadioButton existingAccountRadioButton;
	private JRadioButton notExistingAccountRadioButton;
	private String formNo;
	private JButton nextButton;
	
	SignUpPageTwo(String x){
		
		this.formNo=x;
		
		//JLabel for Top Form Number
		JLabel formNumber= new JLabel("FORM NUMBER. " + formNo );
		formNumber.setBounds((frameLength-(itemLength+240))/2, frameHeight-750, itemLength+240, itemHeight-70);
		formNumber.setFont(new Font("Arial",Font.BOLD,30));
		formNumber.setHorizontalAlignment(SwingConstants.CENTER);
		add(formNumber);
		
		//JLabel for Additional Info
		JLabel additionalInfo= new JLabel("Page 2: Additional Details");
		additionalInfo.setBounds((frameLength-(itemLength+150))/2, frameHeight-700, itemLength+150, itemHeight-70);
		additionalInfo.setFont(new Font("Arial",Font.BOLD,20));
		additionalInfo.setHorizontalAlignment(SwingConstants.CENTER);
		add(additionalInfo);
		
		//JLabel Religion 
		JLabel religion= new JLabel("Religion:");
		religion.setBounds(frameLength-620, frameHeight-650, itemLength+140, itemHeight-70);
		religion.setFont(new Font("Arial",Font.BOLD,20));
		add(religion);
		
		//ComboBox Religion
		religionComboBox= new JComboBox(new String[]{"","Muslim","Christian","Hindu","Jewish","Other","Prefer Not To Say"});
		religionComboBox.setBounds(frameLength-420, frameHeight-650, itemLength+140, itemHeight-70);
		religionComboBox.setFont(new Font("Arial",1,17));
		religionComboBox.setBackground(Color.white);
		add(religionComboBox);
		
		//JLabel Ethnicity 
		JLabel ethnicity= new JLabel("Ethnicity:");
		ethnicity.setBounds(frameLength-620, frameHeight-600, itemLength+140, itemHeight-70);
		ethnicity.setFont(new Font("Arial",Font.BOLD,20));
		add(ethnicity);
		
		//ComboBox Ethnicity 
		ethnicityComboBox= new JComboBox(new String[]{"","East Asian","South Asian","European","American","Africian","Other","Prefer Not To Say"});
		ethnicityComboBox.setBounds(frameLength-420, frameHeight-600, itemLength+140, itemHeight-70);
		ethnicityComboBox.setFont(new Font("Arial",1,17));
		ethnicityComboBox.setBackground(Color.white);
		add(ethnicityComboBox);
		
		//JLabel  Income  
		JLabel income= new JLabel("Income:");
		income.setBounds(frameLength-620, frameHeight-550, itemLength+140, itemHeight-70);
		income.setFont(new Font("Arial",Font.BOLD,20));
		add(income);
		
		//ComboBox Income
		incomeComboBox= new JComboBox(new String[] {"","<10,000","10,000< <20,000","<20,000 <50,000","50,000<"});
		incomeComboBox.setBounds(frameLength-420, frameHeight-550, itemLength+140, itemHeight-70);
		incomeComboBox.setFont(new Font("Arial",1,17));
		incomeComboBox.setBackground(Color.white);
		add(incomeComboBox);
		
		//JLabel Qualification 
		JLabel qualification= new JLabel("Qualification:");
		qualification.setBounds(frameLength-620, frameHeight-500, itemLength+140, itemHeight-70);
		qualification.setFont(new Font("Arial",Font.BOLD,20));
		add(qualification);
		
		//ComboBox Qualification
		qualificationComboBox= new JComboBox(new String[] {"","GCSE","Higher","Bachelors","Masters","PHD"});
		qualificationComboBox.setBounds(frameLength-420, frameHeight-500, itemLength+140, itemHeight-70);
		qualificationComboBox.setFont(new Font("Arial",1,17));
		qualificationComboBox.setBackground(Color.white);
		add(qualificationComboBox);
		
		//JLabel Occupation 
		JLabel occupation= new JLabel("Occupation:");
		occupation.setBounds(frameLength-620, frameHeight-450, itemLength+140, itemHeight-70);
		occupation.setFont(new Font("Arial",Font.BOLD,20));
		add(occupation);
		
		//TextField Occupation
		occupationTextField= new JTextField();
		occupationTextField.setBounds(frameLength-420, frameHeight-450, itemLength+140, itemLength-70);
		occupationTextField.setFont(new Font("Arial",1,17));
		add(occupationTextField);
		
		//JLabel IBAN Number 
		JLabel iBAN= new JLabel("IBAN Number:");
		iBAN.setBounds(frameLength-620, frameHeight-400, itemLength+140, itemLength-70);
		iBAN.setFont(new Font("Arial",Font.BOLD,20));
		add(iBAN);
		
		//Text Field Email
		iBANTextField= new JTextField();
		iBANTextField.setBounds(frameLength-420, frameHeight-400, itemLength+140, itemLength-70);
		iBANTextField.setFont(new Font("Arial",1,17));
		add(iBANTextField);
		
		//JLabel ID Card Number
		JLabel iDNumber= new JLabel("ID Card Number:");
		iDNumber.setBounds(frameLength-620, frameHeight-350, itemLength+140, itemLength-70);
		iDNumber.setFont(new Font("Arial",Font.BOLD,20));
		add(iDNumber);		
		
		//Text Field ID Card Number
		iDNumberTextField= new JTextField();
		iDNumberTextField.setBounds(frameLength-420, frameHeight-350, itemLength+140, itemLength-70);
		iDNumberTextField.setFont(new Font("Arial",1,17));
		add(iDNumberTextField);
		
		//JLabel Senior Citizen
		JLabel seniorCitizen= new JLabel("Senior Citizen:");
		seniorCitizen.setBounds(frameLength-620, frameHeight-300, itemLength+140, itemLength-70);
		seniorCitizen.setFont(new Font("Arial",Font.BOLD,20));
		add(seniorCitizen);
		
		//Radio Button Senior Citizen
		seniorRadioButton= new JRadioButton("Yes");
		seniorRadioButton.setBounds(frameLength-420, frameHeight-300, itemLength+20, itemHeight-70);
		seniorRadioButton.setFont(new Font("Arial",1,17));
		seniorRadioButton.setBackground(Color.white);
		add(seniorRadioButton);
		
		//Radio Button Not Senior Citizen
		notSeniorRadioButton= new JRadioButton("No");
		notSeniorRadioButton.setBounds(frameLength-300, frameHeight-300, itemLength+50, itemHeight-70);
		notSeniorRadioButton.setFont(new Font("Arial",1,17));
		notSeniorRadioButton.setBackground(Color.white);
		add(notSeniorRadioButton);
		
		//ButtonGroup Senior Citizen 
		ButtonGroup seniorGroup= new ButtonGroup();
		seniorGroup.add(seniorRadioButton);
		seniorGroup.add(notSeniorRadioButton);		
		
		//JLabel Existing Account
		JLabel existingAccount= new JLabel("Existing Account:");
		existingAccount.setBounds(frameLength-620, frameHeight-250, itemLength+140, itemLength-70);
		existingAccount.setFont(new Font("Arial",Font.BOLD,20));
		add(existingAccount);
		
		//Radio Button Existing Account
		existingAccountRadioButton= new JRadioButton("Yes");
		existingAccountRadioButton.setBounds(frameLength-420, frameHeight-250, itemLength+20, itemHeight-70);
		existingAccountRadioButton.setFont(new Font("Arial",1,17));
		existingAccountRadioButton.setBackground(Color.white);
		add(existingAccountRadioButton);
		
		//Radio Button Not Existing Account
		notExistingAccountRadioButton= new JRadioButton("No");
		notExistingAccountRadioButton.setBounds(frameLength-300, frameHeight-250, itemLength+50, itemHeight-70);
		notExistingAccountRadioButton.setFont(new Font("Arial",1,17));
		notExistingAccountRadioButton.setBackground(Color.white);
		add(notExistingAccountRadioButton);
		
		//ButtonGroup Existing Account 
		ButtonGroup existingAccountGroup= new ButtonGroup();
		existingAccountGroup.add(existingAccountRadioButton);
		existingAccountGroup.add(notExistingAccountRadioButton);		

		
		//Button Next
		nextButton= new JButton("Next");
		nextButton.setBounds(frameLength-280, frameHeight-180, itemLength, itemLength-70);		nextButton.setBackground(Color.BLACK);
		nextButton.setForeground(Color.WHITE);
		nextButton.addActionListener(this);
		add(nextButton);
			
		//Sets Background Colour
		getContentPane().setBackground(Color.white);
		
		//Set up GUI Frame
		this.setTitle("Sign Up: Page 2");
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(frameLength,frameHeight);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Converting Text Fields into String
		String formNumber= String.valueOf(formNo);
		String religion= (String) religionComboBox.getSelectedItem();
		String ethnicity= (String) ethnicityComboBox.getSelectedItem();
		String income= (String) incomeComboBox.getSelectedItem();
		String qualification= (String) qualificationComboBox.getSelectedItem();
		String occupation= occupationTextField.getText();
		String iBAN= iBANTextField.getText();
		String iDNumber= iDNumberTextField.getText();
		String senior=isSenior();
		String existing=isExistingAccount();
		
	    // Establish database connection and prepare SQL query
	    Conn connManager = new Conn();
	    String query = "INSERT INTO signuptwo (formNumber, religion, ethnicity, income, qualification, occupation, iBAN, iDNumber, senior, existing) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    
	    // Execute SQL query 
	    try (PreparedStatement statement = connManager.getC().prepareStatement(query)) {
	    	
	        // Set parameters for the prepared statement
	        statement.setString(1, formNumber);
	        statement.setString(2, religion);
	        statement.setString(3, ethnicity);
	        statement.setString(4, income);
	        statement.setString(5, qualification);
	        statement.setString(6, occupation);
	        statement.setString(7, iBAN);
	        statement.setString(8, iDNumber);
	        statement.setString(9, senior);
	        statement.setString(10, existing);


	        // Execute the query and get the number of rows affected
	        int rowsInserted = statement.executeUpdate();

	        // Check if any rows were inserted and show appropriate message
	        if (rowsInserted > 0) {
	            JOptionPane.showMessageDialog(null, "Record inserted successfully!");
	        } else {
	            JOptionPane.showMessageDialog(null, "Failed to insert record!");
	        }
	        
			this.setVisible(false);
			new SignUpPageThree(formNumber).setVisible(true);
			
	    } catch (SQLException ex) {
	        // Handle SQL exceptions
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Failed to insert record due to SQL error: " + ex.getMessage());
	    }		
		
	}	

	//Method to get Senior or not
		private String isSenior() {
			
			String senior=null;
			if(seniorRadioButton.isSelected()) {
				senior= "Yes";
			}else if(notSeniorRadioButton.isSelected()) {
				senior= "No";
			}	
			return senior;	
		}
		
		//Method to get Senior or not
		private String isExistingAccount() {
			
			String existing=null;
			if(existingAccountRadioButton.isSelected()) {
				existing= "Yes";
			}else if(notExistingAccountRadioButton.isSelected()) {
				existing= "No";
			}	
			return existing;	
		}
	
}
