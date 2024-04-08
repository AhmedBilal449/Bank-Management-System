import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transactions extends JFrame implements ActionListener {
	
		//Elements Size and Position
		private static final int frameLength=600;
		private static final int frameHeight=400;
		private static final int itemLength=100;
		private static final int itemHeight=100;
		
		//Elements Input
		private JButton depositButton;
		private JButton withdrawlButton;
		private JButton fastCashButton;
		//private JButton statementButton;
		private JButton pinChangeButton;
		private JButton balanceButton;
		private JButton exitButton;
		private String pinNumber;
		
		
		Transactions(String pinNumber){
			
			this.pinNumber=pinNumber;
			
			//JLabel Select Transaction
			JLabel transText= new JLabel("Please Select Your Transaction");
			transText.setBounds(frameLength-530, frameHeight-375,itemLength+360, itemHeight-70);
			transText.setFont(new Font("Arial",Font.BOLD,30));
			add(transText);
			
			//JButton Deposit
			depositButton= new JButton("Deposit");
			depositButton.setBounds(frameLength-460, frameHeight-300, itemLength, itemLength-70);		
			depositButton.addActionListener(this);
			add(depositButton);
			
			//JButton Deposit
			withdrawlButton= new JButton("Withdrawl");
			withdrawlButton.setBounds(frameLength-240, frameHeight-300, itemLength, itemLength-70);		
			withdrawlButton.addActionListener(this);
			add(withdrawlButton);
			
			//JButton Deposit
			fastCashButton= new JButton("Fast Cash");
			fastCashButton.setBounds(frameLength-460, frameHeight-250, itemLength, itemLength-70);		
			fastCashButton.addActionListener(this);
			add(fastCashButton);
			
			//JButton Deposit
//			statementButton= new JButton("Statement");
//			statementButton.setBounds(frameLength-240, frameHeight-250, itemLength, itemLength-70);		
//			statementButton.addActionListener(this);
//			add(statementButton);
			
			//JButton Deposit
			pinChangeButton= new JButton("Pin Change");
			pinChangeButton.setBounds(frameLength-460, frameHeight-200, itemLength, itemLength-70);		
			pinChangeButton.addActionListener(this);
			add(pinChangeButton);
			
			//JButton Deposit
			balanceButton= new JButton("Balance");
			balanceButton.setBounds(frameLength-240, frameHeight-250, itemLength, itemLength-70);		
			balanceButton.addActionListener(this);
			add(balanceButton);
		
			//JButton Deposit
			exitButton= new JButton("Exit");
			exitButton.setBounds(frameLength-240, frameHeight-200, itemLength, itemLength-70);		
			exitButton.addActionListener(this);
			add(exitButton);

			
			//Sets Background Colour
			getContentPane().setBackground(Color.white);
			
			//Set up GUI Frame
			this.setTitle("Transaction");
			this.setLayout(null);
			this.setVisible(true);
			this.setSize(frameLength,frameHeight);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}

		@Override
		public void actionPerformed(ActionEvent ae) {
			
			if(ae.getSource()==depositButton) {
				
				this.setVisible(false);
				new Deposit(pinNumber).setVisible(true);
				
			}
			
			else if(ae.getSource()==withdrawlButton) {
				this.setVisible(false);
				new Withdrawl(pinNumber).setVisible(true);				
			}
			
			else if(ae.getSource()==fastCashButton) {
				
				setVisible(false);
				new FastCash(pinNumber).setVisible(true);
				
			}
			
//			else if(ae.getSource()==statementButton) {
//				
//			}
			
			else if(ae.getSource()==pinChangeButton) {
				
				setVisible(false);
				new PinChange(pinNumber).setVisible(true);
				
			}
			
			else if(ae.getSource()==balanceButton) {
				
				setVisible(false);
				new BalanceEnquiry(pinNumber).setVisible(true);
				
			}
			
			else if(ae.getSource()==exitButton) {
				
				System.exit(0);
				
			}
			
			
		}
		
		

}
