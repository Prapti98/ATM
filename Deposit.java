import javax.swing.*;
import javax.swing.border.LineBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Deposit extends ATMMainFrame implements ActionListener {
	
	JFrame deposit=new JFrame("DEPOSIT");
	 JTextField t1=new JTextField(20);
	 ATMMainFrame atmobj=new ATMMainFrame();
	 public int CARDNO;
	 public int BALANCE;
	 public String Pass;
	 int amount;
     public Deposit(){
    	
        deposit.setVisible(true);
        deposit.setLocation(300,100);
        deposit.setSize(500,500);
        deposit.setLayout(new FlowLayout());
        deposit.setDefaultCloseOperation(3);


        JPanel main =new JPanel(new FlowLayout());
        JPanel panel1=new JPanel();
        JPanel panel2=new JPanel();
        JPanel panel3=new JPanel();
        JPanel inner=new JPanel();
        JPanel panel4=new JPanel();

        //LineBorder border=new LineBorder(Color.cyan,8);
        //main.setBorder(border);

        panel1.setLayout(new BoxLayout(panel1,BoxLayout.LINE_AXIS));
        panel1.setPreferredSize(new Dimension(400,80));
        main.add(panel1);


        main.setBackground(Color.darkGray);
        panel1.setBackground(Color.darkGray);
        panel2.setBackground(Color.darkGray);
        panel3.setBackground(Color.darkGray);
        inner.setBackground(Color.darkGray);
        panel4.setBackground(Color.darkGray);

        main.setPreferredSize(new Dimension(500,500));
        panel2.setPreferredSize(new Dimension(470,100));
        panel3.setPreferredSize(new Dimension(300,200));
        inner.setPreferredSize(new Dimension(300,50));
        panel4.setPreferredSize(new Dimension(430,70));

        deposit.add(main);
        main.add(panel2,FlowLayout.CENTER);
        main.add(panel3,FlowLayout.CENTER);
        panel3.add(inner);
        main.add(panel4,FlowLayout.CENTER);



        JLabel l=new JLabel();
        l.setFont(new Font("Times New Roman",Font.BOLD,15));
        l.setText("<html><h2>&nbsp;&nbsp;ENTER AMOUNT YOU WANT TO DEPOSIT: </h2></html>");
        l.setFont(new Font("Times New Roman",Font.BOLD,23));
        l.setForeground(Color.cyan);

       
        JButton deposite=new JButton("DEPOSIT");
        JButton clear=new JButton("CLEAR");
        JButton exit=new JButton("EXIT");

        deposite.setPreferredSize(new Dimension(100,40));
        clear.setPreferredSize(new Dimension(100,40));
        exit.setPreferredSize(new Dimension(100,40));

        panel4.add(l);
        inner.add(t1);
        panel3.add(deposite);
        panel3.add(clear);
        panel2.add(exit);
      
        
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                t1.setText("");
            }
        });
        
        deposite.addActionListener(this);
        
        
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                deposit.dispose();
                new Transcation();
                new ThankYou();
            }
        });

    }
	public void actionPerformed(ActionEvent ae){
		 try{
			 String amou=t1.getText();
   		 this.amount=Integer.parseInt(amou);
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
   		 
   		 
   		 BALANCE=BALANCE+amount;
   		System.out.println("BALANCE AFTER ADDING DEPOSITE AMOUNT:"+BALANCE);
         PreparedStatement psmt=(PreparedStatement) con.prepareStatement("update Login set BALANCE=? where CARD_NO=?");
         psmt.setInt(1, BALANCE);
         psmt.setInt(2, CARDNO);
         int i=psmt.executeUpdate();
         if(i>0){
        	 JOptionPane.showMessageDialog(deposit, "Amount Deposited!");
         }else{
        	 JOptionPane.showMessageDialog(deposit, "Failed To Deposite!");
         }
		 }catch(Exception ex){
			 ex.printStackTrace();
		 }
	}
    public static void main(String[] args) {

        new Deposit();
        
    }
}
