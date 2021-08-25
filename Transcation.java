import javax.swing.*;
import javax.swing.border.LineBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Transcation implements ActionListener {
	 public int CARDNO;
	 public int BALANCE;
	 public String Pass;
	JFrame mainframe = new JFrame("TRANSCATION");
	
    public Transcation() {
        
        mainframe.setVisible(true);
        mainframe.setSize(500, 500);
        mainframe.setLocation(300,150);
        mainframe.setLayout(new FlowLayout());
        mainframe.setDefaultCloseOperation(3);

        JLabel l=new JLabel("PLEASE SELECT YOUR TRANSCATION");
        JButton withdraw = new JButton("CASH WITHDRAWL");
        JButton deposit = new JButton("DEPOSIT");
        JButton fast_cash = new JButton("FAST CASH");
        JButton mini_statement = new JButton("MINI STATEMENT"); // SPECIAL CASES
        JButton pin_change = new JButton("PIN CHANGE"); //DATABASE
        JButton balance_enquiry= new JButton("BALANCE ENQUIRY"); // SPECIAL CASES
        JButton exit = new JButton("EXIT");

        JPanel panel = new JPanel(new FlowLayout());
        mainframe.add(panel);
        panel.setPreferredSize(new Dimension(500, 500));
        panel.setBackground(Color.darkGray);
        LineBorder border=new LineBorder(Color.cyan,8);
        panel.setBorder(border);

        JPanel panel1=new JPanel();
        panel1.setPreferredSize(new Dimension(400,50));
        panel1.setBackground(Color.darkGray);
        panel.add(panel1);

        JPanel panel2=new JPanel();
        panel2.setPreferredSize(new Dimension(450,100));
        panel2.setBackground(Color.darkGray);
        panel.add(panel2);

        JPanel panel3=new JPanel();
        panel3.setPreferredSize(new Dimension(200,200));
        panel3.setBackground(Color.darkGray);
        panel.add(panel3);

        JPanel panel4=new JPanel();
        panel4.setPreferredSize(new Dimension(200,200));
        panel4.setBackground(Color.darkGray);
        panel.add(panel4);

        JPanel panel5=new JPanel();
        panel5.setPreferredSize(new Dimension(400,50));
        panel5.setBackground(Color.darkGray);
        panel.add(panel5);



       l.setFont(new Font("Times New Roman",Font.BOLD,20));
        l.setForeground(Color.cyan);
        panel2.add(l);
        withdraw.setPreferredSize(new Dimension(200,40));
        panel3.add(withdraw);
        deposit.setPreferredSize(new Dimension(200,40));
        panel3.add(deposit);
        balance_enquiry.setPreferredSize(new Dimension(200,40));
        panel3.add(balance_enquiry);
        mini_statement.setPreferredSize(new Dimension(200,40));
        panel4.add(mini_statement);
        fast_cash.setPreferredSize(new Dimension(200,40));
        panel4.add(fast_cash);
        pin_change.setPreferredSize(new Dimension(200,40));
        panel4.add(pin_change);
        exit.setPreferredSize(new Dimension(200,40));
        panel5.add(exit);


        withdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                new Withdrawal();
            }
        });

        deposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new Deposit();
            }
        });

        fast_cash.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent actionEvent){

                new FastCash();
            }
        });
        pin_change.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new PinChange();
            }
        });

        mini_statement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               new MiniStatement();
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                mainframe.dispose();
                new ThankYou();
            }
        });

        balance_enquiry.addActionListener(this);
    }
    
        public void actionPerformed(ActionEvent ae){
            try{
        	Class.forName("com.mysql.jdbc.Driver");
      		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/ATMProject","root","prapti2323");
      		Statement smt=(Statement) con.createStatement();
      		String sql="Select * from Login";
      		ResultSet rs=smt.executeQuery(sql);
      		while(rs.next()){
      			this.CARDNO=rs.getInt("Card_No");
      			this.Pass=rs.getString("Password");
      			this.BALANCE=rs.getInt("Balance");
              }
                JOptionPane.showMessageDialog(mainframe, "Your Balance is: "+BALANCE);
      }catch(Exception e){
    	  e.printStackTrace();
      }
    } 

    public static void main(String[] args) {
        new Transcation();
    }
}



