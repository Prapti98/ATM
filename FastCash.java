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

public class FastCash implements ActionListener{
	
	 JFrame fastcash=new JFrame("FAST CASH");
	 JButton h=new JButton("200");
     JButton fh=new JButton("500");
     JButton th=new JButton("1000");
     JButton of=new JButton("1500");
     JButton ft=new JButton("5000");
     JButton tt=new JButton("10000");
     public int CARDNO;
	 public int BALANCE;
	 public String Pass;
	 public String amou;
	 public int amount;
	 
    public FastCash(){
        fastcash.setVisible(true);
        fastcash.setLocation(300,100);
        fastcash.setSize(450,500);
        fastcash.setLayout(new FlowLayout());
        fastcash.setDefaultCloseOperation(3);
        JLabel note=new JLabel("SELECT WITHDRAWAL AMOUNT");
        JPanel panel =new JPanel(new FlowLayout());
        JPanel panel1 =new JPanel();
        JPanel inner=new JPanel();
        JPanel panel2 =new JPanel();
        JPanel panel3 =new JPanel();
        JPanel panel4 =new JPanel();
        panel.setPreferredSize(new Dimension(450,500));
        panel.setBackground(Color.darkGray);
        panel1.setBackground(Color.darkGray);
        panel2.setBackground(Color.darkGray);
        inner.setBackground(Color.darkGray);
        panel3.setBackground(Color.darkGray);
        panel4.setBackground(Color.darkGray);
        LineBorder border=new LineBorder(Color.cyan,8);
        panel.setBorder(border);
        fastcash.add(panel);
        panel1.setPreferredSize(new Dimension(400,80));
        inner.setPreferredSize(new Dimension(400,30));
        panel2.setPreferredSize(new Dimension(200,250));
        panel3.setPreferredSize(new Dimension(200,250));
        panel4.setPreferredSize(new Dimension(400,80));
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);
        JButton clear=new JButton("CANCEL");
        JButton exit=new JButton("EXIT");
        h.setPreferredSize(new Dimension(150,60));
        fh.setPreferredSize(new Dimension(150,60));
        th.setPreferredSize(new Dimension(150,60));
        of.setPreferredSize(new Dimension(150,60));
        ft.setPreferredSize(new Dimension(150,60));
        tt.setPreferredSize(new Dimension(150,60));
        clear.setPreferredSize(new Dimension(100,50));
        exit.setPreferredSize(new Dimension(100,50));
        note.setFont(new Font("Times New Roman",Font.BOLD,15));
        note.setForeground(Color.cyan);
        panel1.add(inner);
        panel1.add(note);
        panel2.add(h);
        panel2.add(fh);
        panel2.add(th);
        panel3.add(of);
        panel3.add(ft);
        panel3.add(tt);
        panel4.add(clear);
        panel4.add(exit);
        h.addActionListener(this);
        fh.addActionListener(this);
        th.addActionListener(this);
        of.addActionListener(this);
        ft.addActionListener(this);
        tt.addActionListener(this);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                fastcash.dispose();
                new ThankYou();
            }
        });
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==h){
    		this.amount=200;
    	}if(ae.getSource()==fh){
    		this.amount=500;
    	}if(ae.getSource()==th){
    		this.amount=1500;
    	}if(ae.getSource()==of){
    		this.amount=1000;
    	}if(ae.getSource()==ft){
    		this.amount=5000;
    	}if(ae.getSource()==tt){
    		 this.amount=10000;
    	}
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
		 System.out.println("CARDNO:"+CARDNO);
		 System.out.println("PASSWORD:"+Pass);
		 System.out.println("BALANCE:"+BALANCE);
		 
		 BALANCE=BALANCE-amount;
		System.out.println("BALANCE AFTER ADDING DEPOSITE AMOUNT:"+BALANCE);
    PreparedStatement psmt=(PreparedStatement) con.prepareStatement("update Login set BALANCE=? where CARD_NO=?");
    psmt.setInt(1, BALANCE);
    psmt.setInt(2, CARDNO);
    int i=psmt.executeUpdate();
    if(i>0){
   	 JOptionPane.showMessageDialog(fastcash, "Collect Your cash");
    }else{
   	 JOptionPane.showMessageDialog(fastcash, "Failed To Withdraw!");
    }
	 }catch(Exception ex){
		 ex.printStackTrace();
	 }
     
    }
    public static void main(String[] args) {
        new FastCash();
       
    }
}
