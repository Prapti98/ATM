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

public class Withdrawal implements ActionListener{
	
	  JFrame withdraw=new JFrame("WITHDRAWAL");
	  JTextField t1=new JTextField(20);
		 public int CARDNO;
		 public int BALANCE;
		 public String Pass;
		 int amount;
    public Withdrawal(){
      
        withdraw.setVisible(true);
        withdraw.setLocation(300,150);
        withdraw.setSize(530,500);
        withdraw.setLayout(new FlowLayout());
        withdraw.setDefaultCloseOperation(3);

        JPanel panel =new JPanel(new FlowLayout());
        JPanel panel1 =new JPanel();
        JPanel panel2 =new JPanel();
        JPanel panel3 =new JPanel();
        JPanel inner=new JPanel();
        JPanel panel4 =new JPanel();

        panel1.setPreferredSize(new Dimension(470,70));
        panel.add(panel1);
        panel1.setBackground(Color.darkGray);
        panel2.setPreferredSize(new Dimension(400,70));
        panel.add(panel2);
        panel2.setBackground(Color.darkGray);
        panel3.setPreferredSize(new Dimension(400,200));
        panel.add(panel3);
        panel3.setBackground(Color.darkGray);
        inner.setPreferredSize(new Dimension(400,50));
        panel3.add(inner);
        inner.setBackground(Color.darkGray);
        panel4.setPreferredSize(new Dimension(400,70));
        panel.add(panel4);
        panel4.setBackground(Color.darkGray);



        JLabel note=new JLabel("MAXIMUM DAILY WITHDRAWAL AMOUNT IS RS 15,000");
        JLabel msg=new JLabel("PLEASE ENTER YOUR AMOUNT");

        panel.setPreferredSize(new Dimension(530,500));
        panel.setBackground(Color.darkGray);
        LineBorder border=new LineBorder(Color.cyan,8);
        panel.setBorder(border);
        withdraw.add(panel);
        
        JButton withdrw=new JButton("WITHDRAW");
        JButton clear=new JButton("CANCEL");
        JButton exit=new JButton("EXIT");

        withdrw.setPreferredSize(new Dimension(200,40));
        clear.setPreferredSize(new Dimension(200,40));
        exit.setPreferredSize(new Dimension(200,40));
        note.setFont(new Font("Times New Roman",Font.BOLD,15));
        note.setForeground(Color.white);
        msg.setForeground(Color.white);
        msg.setFont(new Font("Times New Roman",Font.BOLD,15));

        panel1.add(note);
        panel2.add(msg);
        inner.add(t1);
        panel3.add(withdrw);
        panel3.add(clear);
        panel4.add(exit);

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                t1.setText("");
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               withdraw.dispose();
                new ThankYou();
            }
        });
        
        withdrw.addActionListener(this);
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
  		 if(BALANCE<amount){
  			 JOptionPane.showMessageDialog(withdraw, "You dont have efficient fund availabel!");
  		 }else{		 
  		 BALANCE=BALANCE-amount;
  		
        PreparedStatement psmt=(PreparedStatement) con.prepareStatement("update Login set BALANCE=? where CARD_NO=?");
        psmt.setInt(1, BALANCE);
        psmt.setInt(2, CARDNO);
        int i=psmt.executeUpdate();
        if(i>0){
       	 JOptionPane.showMessageDialog(withdraw, "Collect Your cash");
        }else{
       	 JOptionPane.showMessageDialog(withdraw, "Failed To Withdraw!");
        }
  	}
		 }catch(Exception ex){
			 ex.printStackTrace();
		 }
	}
    public static void main(String[] args) {
        new Withdrawal();
    }
}
