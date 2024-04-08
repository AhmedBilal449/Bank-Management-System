import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

public class  SignUpPageOne extends JFrame implements ActionListener {
	

	//Elements Size and Position
	private static final int frameLength=800;
	private static final int frameHeight=800;
	private static final int itemLength=100;
	private static final int itemHeight=100;
	
	//Elements Input
	private Random ranFormNo;
	public static int ranFormNum;
	private JTextField nameTextField;
	private JTextField parentNameTextField;
	private JDateChooser dOBChooser;
	private JRadioButton genderMaleRadioButton;
	private JRadioButton genderFemaleRadioButton;
	private JRadioButton genderOtherRadioButton;
	private JTextField emailTextField;
	private JRadioButton marriedRadioButton;
	private JRadioButton unmarriedRadioButton;
	private JTextField addressTextField;
	private JTextField cityTextField;
	private JTextField stateTextField;
	private JTextField pinTextField;
	private JButton nextButton;
	
	SignUpPageOne(){
		
		//Random Form Number Generation
		ranFormNo= new Random();
		ranFormNum= ranFormNo.nextInt(1000, 9999);
		
		//JLabel for Top Form Number
		JLabel formNumber= new JLabel("FORM NUMBER. " + ranFormNum );
		formNumber.setBounds((frameLength-(itemLength+240))/2, frameHeight-750, itemLength+240, itemHeight-70);
		formNumber.setFont(new Font("Arial",Font.BOLD,30));
		formNumber.setHorizontalAlignment(SwingConstants.CENTER);
		add(formNumber);
		
		//JLabel for Personal Info
		JLabel personalInfo= new JLabel("Page 1: Personal Details");
		personalInfo.setBounds((frameLength-(itemLength+140))/2, frameHeight-700, itemLength+140, itemHeight-70);
		personalInfo.setFont(new Font("Arial",Font.BOLD,20));
		personalInfo.setHorizontalAlignment(SwingConstants.CENTER);
		add(personalInfo);
		
		//JLabel Name 
		JLabel name= new JLabel("Name:");
		name.setBounds(frameLength-620, frameHeight-650, itemLength+140, itemHeight-70);
		name.setFont(new Font("Arial",Font.BOLD,20));
		add(name);
		
		//TextField Name 
		nameTextField= new JTextField();
		nameTextField.setBounds(frameLength-420, frameHeight-650, itemLength+140, itemHeight-70);
		nameTextField.setFont(new Font("Arial",1,17));
		add(nameTextField);
		
		//JLabel  Parent Name 
		JLabel parentName= new JLabel("Parent's Name:");
		parentName.setBounds(frameLength-620, frameHeight-600, itemLength+140, itemHeight-70);
		parentName.setFont(new Font("Arial",Font.BOLD,20));
		add(parentName);
		
		//TextField Parent Name 
		parentNameTextField= new JTextField();
		parentNameTextField.setBounds(frameLength-420, frameHeight-600, itemLength+140, itemHeight-70);
		parentNameTextField.setFont(new Font("Arial",1,17));
		add(parentNameTextField);
		
		//JLabel  Date of Birth  
		JLabel dOB= new JLabel("Date Of Birth:");
		dOB.setBounds(frameLength-620, frameHeight-550, itemLength+140, itemHeight-70);
		dOB.setFont(new Font("Arial",Font.BOLD,20));
		add(dOB);
		
		//JDateChooser Date of Birth 
		dOBChooser= new JDateChooser();
		dOBChooser.setBounds(frameLength-420, frameHeight-550, itemLength+140, itemHeight-70);
		add(dOBChooser);
		
		//JLabel Gender 
		JLabel gender= new JLabel("Gender:");
		gender.setBounds(frameLength-620, frameHeight-500, itemLength+140, itemHeight-70);
		gender.setFont(new Font("Arial",Font.BOLD,20));
		add(gender);
		
		//Radio Button Gender Male
		genderMaleRadioButton= new JRadioButton("Male");
		genderMaleRadioButton.setBounds(frameLength-420, frameHeight-500, itemLength-30, itemHeight-70);
		genderMaleRadioButton.setFont(new Font("Arial",1,17));
		genderMaleRadioButton.setBackground(Color.white);
		add(genderMaleRadioButton);
		
		//Radio Button Gender Female
		genderFemaleRadioButton= new JRadioButton("Female");
		genderFemaleRadioButton.setBounds(frameLength-350, frameHeight-500, itemLength, itemHeight-70);
		genderFemaleRadioButton.setFont(new Font("Arial",1,17));
		genderFemaleRadioButton.setBackground(Color.white);
		add(genderFemaleRadioButton);
		
		//Radio Button Gender Other 
		genderOtherRadioButton= new JRadioButton("Other");
		genderOtherRadioButton.setBounds(frameLength-250, frameHeight-500, itemLength-30, itemHeight-70);
		genderOtherRadioButton.setFont(new Font("Arial",1,17));
		genderOtherRadioButton.setBackground(Color.white);
		add(genderOtherRadioButton);
		
		//ButtonGroup Gender
		ButtonGroup genderGroup= new ButtonGroup();
		genderGroup.add(genderMaleRadioButton);
		genderGroup.add(genderFemaleRadioButton);
		genderGroup.add(genderOtherRadioButton);
		
		
		//JLabel Email 
		JLabel email= new JLabel("Email:");
		email.setBounds(frameLength-620, frameHeight-450, itemLength+140, itemLength-70);
		email.setFont(new Font("Arial",Font.BOLD,20));
		add(email);
		
		//Text Field Email
		emailTextField= new JTextField();
		emailTextField.setBounds(frameLength-420, frameHeight-450, itemLength+140, itemLength-70);
		emailTextField.setFont(new Font("Arial",1,17));
		add(emailTextField);
		
		//JLabel Marital Status
		JLabel marital= new JLabel("Marital Status:");
		marital.setBounds(frameLength-620, frameHeight-400, itemLength+140, itemLength-70);
		marital.setFont(new Font("Arial",Font.BOLD,20));
		add(marital);		
		
		//Radio Button Married
		marriedRadioButton= new JRadioButton("Married");
		marriedRadioButton.setBounds(frameLength-420, frameHeight-400, itemLength+20, itemHeight-70);
		marriedRadioButton.setFont(new Font("Arial",1,17));
		marriedRadioButton.setBackground(Color.white);
		add(marriedRadioButton);
		
		//Radio Button Unmarried
		unmarriedRadioButton= new JRadioButton("Unmarried");
		unmarriedRadioButton.setBounds(frameLength-300, frameHeight-400, itemLength+50, itemHeight-70);
		unmarriedRadioButton.setFont(new Font("Arial",1,17));
		unmarriedRadioButton.setBackground(Color.white);
		add(unmarriedRadioButton);
		
		//ButtonGroup Marital Status
		ButtonGroup maritalGroup= new ButtonGroup();
		maritalGroup.add(marriedRadioButton);
		maritalGroup.add(unmarriedRadioButton);
		
		//JLabel Address
		JLabel address= new JLabel("Address:");
		address.setBounds(frameLength-620, frameHeight-350, itemLength+140, itemLength-70);
		address.setFont(new Font("Arial",Font.BOLD,20));
		add(address);
		
		//Text Field Address
		addressTextField= new JTextField();
		addressTextField.setBounds(frameLength-420, frameHeight-350, itemLength+140, itemLength-70);
		addressTextField.setFont(new Font("Arial",1,17));
		add(addressTextField);
		
		//JLabel City
		JLabel city= new JLabel("City:");
		city.setBounds(frameLength-620, frameHeight-300, itemLength+140, itemLength-70);
		city.setFont(new Font("Arial",Font.BOLD,20));
		add(city);
		
		//Text Field City
		cityTextField= new JTextField();
		cityTextField.setBounds(frameLength-420, frameHeight-300, itemLength+140, itemLength-70);
		cityTextField.setFont(new Font("Arial",1,17));
		add(cityTextField);
		
		//JLabel State
		JLabel state= new JLabel("State:");
		state.setBounds(frameLength-620, frameHeight-250, itemLength+140, itemLength-70);
		state.setFont(new Font("Arial",Font.BOLD,20));
		add(state);
		
		//Text Field State
		stateTextField= new JTextField();
		stateTextField.setBounds(frameLength-420, frameHeight-250, itemLength+140, itemLength-70);
		stateTextField.setFont(new Font("Arial",1,17));
		add(stateTextField);
		
		//JLabel Pin
		JLabel pin= new JLabel("Pin:");
		pin.setBounds(frameLength-620, frameHeight-200, itemLength+140, itemLength-70);
		pin.setFont(new Font("Arial",Font.BOLD,20));
		add(pin);
		
		//Text Field Pin
		pinTextField= new JTextField();
		pinTextField.setBounds(frameLength-420, frameHeight-200, itemLength+140, itemLength-70);
		pinTextField.setFont(new Font("Arial",1,17));
		add(pinTextField);
		
		//Button Next
		nextButton= new JButton("Next");
		nextButton.setBounds(frameLength-280, frameHeight-130, itemLength, itemLength-70);		nextButton.setBackground(Color.BLACK);
		nextButton.setForeground(Color.WHITE);
		nextButton.addActionListener(this);
		add(nextButton);
			
		//Sets Background Colour
		getContentPane().setBackground(Color.white);
		
		//Set up GUI Frame
		this.setTitle("Sign Up: Page 1");
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(frameLength,frameHeight);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		//Converting Text Fields into String
		String formNumber= String.valueOf(ranFormNum);
		String name= nameTextField.getText();
		String parentName= parentNameTextField.getText();
		String dOB = null;
		if (dOBChooser.getDate() != null) {
			 dOB= ((JTextField) dOBChooser.getDateEditor().getUiComponent()).getText();
		}
		String gender= getSelectedGender();
		String email= emailTextField.getText();
		String maritalStatus= getSelectedMaritalStatus();
		String address= addressTextField.getText();
		String city= cityTextField.getText();
		String state= stateTextField.getText();
		String pin= pinTextField.getText();
		
		try {
		    // Validate name
		    if (name.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Name is Required");
		        return; // Exit the method if name is empty
		    }

		    // Validate parent name
		    if (parentName.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Parent Name is Required");
		        return;
		    }

		    // Validate date of birth (dOB)
		    if (dOB.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Date of Birth is Required");
		        return;
		    }

		    // Validate gender
		    if (!(gender.equals("Male") || gender.equals("Female") || gender.equals("Other"))) {
		        JOptionPane.showMessageDialog(null, "Please select a valid gender");
		        return;
		    }

		    // Validate email
		    if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
		        JOptionPane.showMessageDialog(null, "Please enter a valid email address");
		        return;
		    }

		    // Validate marital status
		    if (!(maritalStatus.equals("Married") || maritalStatus.equals("Unmarried") )) {
		        JOptionPane.showMessageDialog(null, "Please select a valid marital status");
		        return;
		    }

		    // Validate address
		    if (address.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Address is Required");
		        return;
		    }

		    // Validate city
		    if (city.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "City is Required");
		        return;
		    }

		    // Validate state
		    if (state.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "State is Required");
		        return;
		    }

		    // Validate PIN (pin)
		    if (pin.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "PIN is Required");
		        return;
		    }

		    // Establish database connection and prepare SQL query
		    Conn connManager = new Conn();
		    String query = "INSERT INTO signup (formNumber, name, parentName, dOB, gender, email, maritalStatus, address, city, state, pin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		    
		    // Execute SQL query 
		    try (PreparedStatement statement = connManager.getC().prepareStatement(query)) {
		    	
		        // Set parameters for the prepared statement
		        statement.setString(1, formNumber);
		        statement.setString(2, name);
		        statement.setString(3, parentName);
		        statement.setString(4, dOB);
		        statement.setString(5, gender);
		        statement.setString(6, email);
		        statement.setString(7, maritalStatus);
		        statement.setString(8, address);
		        statement.setString(9, city);
		        statement.setString(10, state);
		        statement.setString(11, pin);

		        // Execute the query and get the number of rows affected
		        int rowsInserted = statement.executeUpdate();

		        // Check if any rows were inserted and show appropriate message
		        if (rowsInserted > 0) {
		            JOptionPane.showMessageDialog(null, "Record inserted successfully!");
		        } else {
		            JOptionPane.showMessageDialog(null, "Failed to insert record!");
		        }
		        
				this.setVisible(false);
				new SignUpPageTwo(formNumber).setVisible(true);
		    } catch (SQLException ex) {
		        // Handle SQL exceptions
		        ex.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Failed to insert record due to SQL error: " + ex.getMessage());
		    }
		} catch (Exception e) {
		    // Handle any other exceptions
		    e.printStackTrace();
		    JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + e.getMessage());
		}

		
	}
	
	//Method to get Selected Gender
	private String getSelectedGender() {
		
		String gender=null;
		if(genderMaleRadioButton.isSelected()) {
			gender= "Male";
		}else if(genderFemaleRadioButton.isSelected()) {
			gender= "Female";
		}else if(genderOtherRadioButton.isSelected()) {
			gender= "Other";
		}
		
		return gender;
		
	}
	
	//Method to get Marital Status
		private String getSelectedMaritalStatus() {
			
		String maritalStatus=null;
		if(marriedRadioButton.isSelected()) {
			maritalStatus= "Married";
		}else if(unmarriedRadioButton.isSelected()) {
			maritalStatus= "Unmarried";
		}
		
		return maritalStatus;
			
		}
		
		
		

}
