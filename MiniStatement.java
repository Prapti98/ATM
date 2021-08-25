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
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MiniStatement {
	JFrame ministatement=new JFrame("MINI STATEMENT");
	String date;
	String time;
	int cardno;
	String SPIN;
    public MiniStatement(){
        
        ministatement.setVisible(true);
        ministatement.setLocation(300,150);
        ministatement.setSize(450,450);
        ministatement.setLayout(new FlowLayout());
        ministatement.setDefaultCloseOperation(3);
        JPanel panel =new JPanel(new FlowLayout());
        panel.setPreferredSize(new Dimension(450,450));
        panel.setBackground(Color.darkGray);
        LineBorder border=new LineBorder(Color.cyan,8);
        panel.setBorder(border);
        ministatement.add(panel);
        JButton exit=new JButton("EXIT");
        exit.setPreferredSize(new Dimension(100,40));
        panel.add(exit);
        try{
        	 this.date=new SimpleDateFormat("yyyy:MM:dd").format(Calendar.getInstance().getTime());
             System.out.println(date);
             this.time=new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
             System.out.println(time);
             Class.forName("com.mysql.jdbc.Driver");
     		 Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/ATMProject","root","prapti2323");
     		  String sql="Select * from Login";
              Statement smt=(Statement) con.createStatement();
              ResultSet rs=smt.executeQuery(sql);
     		while(rs.next()){
         		this.cardno=rs.getInt("Card_No");
         		this.SPIN=rs.getString("Password");
	          }
     		Deposit d=new Deposit();
     		Withdrawal w=new Withdrawal();
     		PreparedStatement psmt=(PreparedStatement) con.prepareStatement("insert into MiniState(CardNo,Withdraw,Deposite,Time,Date) values(?,?,?,?,?)");
     		System.out.println("Deposit"+d.amount);
     		System.out.println("withdraw"+d.amount);
     		System.out.println("CardNo"+cardno);
     		System.out.println("Time"+time);
     		System.out.println("Date"+date);
     		psmt.setInt(1,cardno);
     		psmt.setInt(2,w.amount);
     		psmt.setInt(3,d.amount);
     		psmt.setString(4,time);
     		psmt.setString(5,date);
            int i=psmt.executeUpdate();
        }catch(Exception e){
        	
        }
       
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ministatement.dispose();
            }
        });
    }

    public static void main(String[] args) {
        new MiniStatement();
    }

}
