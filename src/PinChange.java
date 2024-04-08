import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class PinChange extends JFrame implements ActionListener {

	//Elements Size and Position
	private static final int frameLength=500;
	private static final int frameHeight=300;
	private static final int itemLength=100;
	private static final int itemHeight=100;
	
	//Elements
	private JPasswordField newPin;
	private JPasswordField confirmNewPin;
	private JButton changeButton;
	private JButton backButton;
	private String pinNumber;
	
	PinChange(String pinNumber){
		
		this.pinNumber=pinNumber;
		
		//JLabel Change Pin 	
		JLabel pinChangeText= new JLabel("Change Your Pin");
		pinChangeText.setBounds(frameLength-390,frameHeight-275,itemLength+200,itemHeight-60);		
		pinChangeText.setFont(new Font("Arial",Font.BOLD,30));
		add(pinChangeText);		
		
		//JLabel New Pin 	
		JLabel newPinText= new JLabel("New Pin: ");
		newPinText.setBounds(frameLength-450,frameHeight-200,itemLength+200,itemHeight-70);		
		newPinText.setFont(new Font("Arial",Font.BOLD,20));
		add(newPinText);		
		
		//TextField New Pin 	
		newPin= new JPasswordField("");
		newPin.setBounds(frameLength-270,frameHeight-200,itemLength+50,itemHeight-70);		
		newPin.setFont(new Font("Arial",Font.BOLD,20));
		add(newPin);
		
		//JLabel ReEnter New Pin 	
		JLabel reenterNewPinText= new JLabel("Confirm New Pin: ");
		reenterNewPinText.setBounds(frameLength-450,frameHeight-150,itemLength+200,itemHeight-70);		
		reenterNewPinText.setFont(new Font("Arial",Font.BOLD,20));
		add(reenterNewPinText);		
		
		//TextField Confirm New Pin 	
		confirmNewPin= new JPasswordField("");
		confirmNewPin.setBounds(frameLength-270,frameHeight-150,itemLength+50,itemHeight-70);		
		confirmNewPin.setFont(new Font("Arial",Font.BOLD,20));
		add(confirmNewPin);
		
		//Button Change
		changeButton= new JButton("Change");
		changeButton.setBounds(frameLength-375,frameHeight-110,itemLength,itemHeight-70);
		changeButton.addActionListener(this);
		add(changeButton);
		
		//Button Exit
		backButton= new JButton("Back");
		backButton.setBounds(frameLength-220,frameHeight-110,itemLength,itemHeight-70);
		backButton.addActionListener(this);
		add(backButton);
		
		//Set Frame Background Colour
		getContentPane().setBackground(Color.white);
			
		
		//Set Up GUI Frame
		this.setTitle("Pin Change");
		this.setLayout(null);
		this.setVisible(false);
		this.setSize(frameLength,frameHeight);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==backButton) {
			
		setVisible(false);
		new Transactions(pinNumber).setVisible(true);
		
		}else if(ae.getSource()==changeButton) {
			
			String newP= newPin.getText();
			String cNewP= confirmNewPin.getText();
			
			if(newP.equals(cNewP)) {
				
				Conn connManager= new Conn();

				String query="UPDATE bank SET pinNumber=? WHERE pinNumber=?";
				String query1="UPDATE login SET pinNumber=? WHERE pinNumber=?";
				String query2="UPDATE signupthree SET pinNumber=? WHERE pinNumber=?";
				
				try(PreparedStatement statement= connManager.getC().prepareStatement(query)){
					
					statement.setString(1, newP);
					statement.setString(2, pinNumber);
					
					statement.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try(PreparedStatement statement1= connManager.getC().prepareStatement(query1)){
					
					statement1.setString(1, newP);
					statement1.setString(2, pinNumber);
					
					statement1.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try(PreparedStatement statement2= connManager.getC().prepareStatement(query2)){
					
					statement2.setString(1, newP);
					statement2.setString(2, pinNumber);
					
					statement2.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null,"Pin Changed Successfully");
				setVisible(false);
				new Transactions(newP).setVisible(true);

				
			}else {
				JOptionPane.showMessageDialog(null,"The Pin Does Not Match");
			}
			
			
		}
		
	}
	
}
