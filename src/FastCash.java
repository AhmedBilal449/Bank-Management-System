import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FastCash extends JFrame implements ActionListener {
	
		//Elements Size and Position
		private static final int frameLength=600;
		private static final int frameHeight=400;
		private static final int itemLength=100;
		private static final int itemHeight=100;
		
		//Elements Input
		private JButton tenButton;
		private JButton twentyButton;
		private JButton thirtyButton;
		private JButton fourtyButton;
		private JButton fiftyButton;
		private JButton hundredButton;
		private JButton backButton;
		private String pinNumber;
		
		
		FastCash(String pinNumber){
			
			this.pinNumber=pinNumber;
			
			//JLabel Select Amount
			JLabel transText= new JLabel("Please Select Your Amount");
			transText.setBounds(frameLength-530, frameHeight-375,itemLength+360, itemHeight-70);
			transText.setFont(new Font("Arial",Font.BOLD,30));
			add(transText);
			
			//JButton �10
			tenButton= new JButton("£10");
			tenButton.setBounds(frameLength-460, frameHeight-300, itemLength, itemLength-70);		
			tenButton.addActionListener(this);
			add(tenButton);
			
			//JButton £20
			twentyButton= new JButton("£20");
			twentyButton.setBounds(frameLength-240, frameHeight-300, itemLength, itemLength-70);		
			twentyButton.addActionListener(this);
			add(twentyButton);
			
			//JButton �30
			thirtyButton= new JButton("£30");
			thirtyButton.setBounds(frameLength-460, frameHeight-250, itemLength, itemLength-70);		
			thirtyButton.addActionListener(this);
			add(thirtyButton);
			
			//JButton �40
			fourtyButton= new JButton("£40");
			fourtyButton.setBounds(frameLength-240, frameHeight-250, itemLength, itemLength-70);		
			fourtyButton.addActionListener(this);
			add(fourtyButton);
			
			//JButton �50
			fiftyButton= new JButton("£50");
			fiftyButton.setBounds(frameLength-460, frameHeight-200, itemLength, itemLength-70);		
			fiftyButton.addActionListener(this);
			add(fiftyButton);
			
			//JButton �100
			hundredButton= new JButton("£100");
			hundredButton.setBounds(frameLength-240, frameHeight-200, itemLength, itemLength-70);		
			hundredButton.addActionListener(this);
			add(hundredButton);
			
			//JButton Deposit
			backButton= new JButton("Back");
			backButton.setBounds(frameLength-240, frameHeight-150, itemLength, itemLength-70);		
			backButton.addActionListener(this);
			add(backButton);

			
			//Sets Background Colour
			getContentPane().setBackground(Color.white);
			
			//Set up GUI Frame
			this.setTitle("Fast Cash");
			this.setLayout(null);
			this.setVisible(false);
			this.setSize(frameLength,frameHeight);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}

		@Override
		public void actionPerformed(ActionEvent ae) {
			
			if(!(ae.getSource()==backButton)) {
				
				String amount= ((JButton)ae.getSource()).getText().substring(1);
				
				int balance = BalanceManager.calculateBalance(pinNumber);
				int amountChange= Integer.parseInt(amount);
				
				Conn connManager= new Conn();

					if(balance<amountChange) {
						
						JOptionPane.showMessageDialog(null, "Insufficient Funds");
						return;
				}				
					
				Date date1=new Date();
				String date= String.valueOf(date1);
				String type= "Withdrawn";
				
				
				String query1="INSERT INTO bank(pinNumber, date,type,amount) VALUES(?,?,?,?) ";
				
				try(PreparedStatement statement1=connManager.getC().prepareStatement(query1)){
					
					statement1.setString(1, pinNumber);
					statement1.setString(2, date);
					statement1.setString(3, type);
					statement1.setString(4, amount);
					
					statement1.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "�"+amount+" Withdrawn Successfully");
					
					setVisible(false);
					new Transactions(pinNumber).setVisible(true);
					
					
				}catch(Exception e){
					
					System.out.println(e);

				}
					
				}else{
					
					this.setVisible(false);
					new Transactions(pinNumber).setVisible(true);;
					
				}
				
			}
			

			
			
		}
		
		

