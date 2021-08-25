import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.mysql.jdbc.Statement;

public class LoginDetail implements ActionListener{
	 JFrame logindetails=new JFrame("LOGIN DETAILS");
	 ATMMainFrame atmm=new ATMMainFrame();
       public LoginDetail(){
    	  
    		 JButton procced=new JButton("Procced->");
     	   logindetails.setVisible(true);
           logindetails.setLocation(400,200);
           logindetails.setSize(350,400);
           logindetails.setLayout(new FlowLayout());
           logindetails.setDefaultCloseOperation(3);
           
           JPanel panelLD=new JPanel();
           logindetails.add(panelLD);
           panelLD.setPreferredSize(new Dimension(350,400));
           panelLD.setBackground(Color.darkGray);
           LineBorder border=new LineBorder(Color.cyan,5);
           panelLD.setBorder(border);
           
           JPanel titlep=new JPanel();
           titlep.setPreferredSize(new Dimension(300,50));
           titlep.setBackground(Color.darkGray);
           panelLD.add(titlep);
        
           JPanel jlabelpanel=new JPanel();
           jlabelpanel.setPreferredSize(new Dimension(300,100));
           jlabelpanel.setBackground(Color.darkGray);
           panelLD.add(jlabelpanel);
           
           JLabel note=new JLabel("<html>NOTE: You have to remember <br> PIN & CARDNO which will be<br> generated after you deposite amount</html>");
           note.setForeground(Color.white);
           jlabelpanel.add(note);
           
           JPanel middle=new JPanel();
           middle.setPreferredSize(new Dimension(250,120));
           middle.setBackground(Color.darkGray);
           panelLD.add(middle);
           
           
           JPanel lower=new JPanel();
           lower.setPreferredSize(new Dimension(250,50));
           lower.setBackground(Color.darkGray);
           panelLD.add(lower);
           
           JLabel titlel=new JLabel("YOUR LOGIN DETAILS:");
           titlel.setFont(new Font("Times New Roman",Font.BOLD,20));
           titlel.setForeground(Color.cyan);
           titlep.add(titlel);
       
       	//JLabel card=new JLabel("Your Card_No: "+cardno);
           JLabel pinS=new JLabel("Set Your PIN: ");
          
         
           JLabel cashdepo=new JLabel("Deposite some Amount: ");
           cashdepo.setForeground(Color.white);
          
          
           
           pinS.setForeground(Color.white);
           
          
           middle.add(pinS);
           middle.add(atmm.pinjt);
           middle.add(cashdepo);
           middle.add(atmm.cashdepojt);
           
          lower.add(procced);
            
    
           
           procced.addActionListener(this);
       }
       
       public void actionPerformed(ActionEvent ae){
    	   
           	try{
    			    atmm.SPIN=String.valueOf(atmm.pinjt.getPassword());
    			    atmm.Sbal=atmm.cashdepojt.getText();
    	            atmm.bal=Integer.parseInt(atmm.Sbal);
           		  Class.forName("com.mysql.jdbc.Driver");
           		  Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/ATMProject","root","prapti2323");
           		  PreparedStatement psmt=con.prepareStatement("insert into Login(Password,BALANCE) values (?,?)");
           		  psmt.setString(1,atmm.SPIN);
           		  psmt.setInt(2,atmm.bal );
           		  int i=psmt.executeUpdate();
           		  if(i>0){
           			  JOptionPane.showMessageDialog(logindetails, "Saved Successfully");
           		  }else{
           			  JOptionPane.showMessageDialog(logindetails, "Failed To Save");
           		  }psmt.close();
           		  con.close();
           	  }catch(Exception e){
           		  e.printStackTrace();
           	  }
    		   try{
                 	Class.forName("com.mysql.jdbc.Driver");
               	Connection con1=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/ATMProject","root","prapti2323");
                   String sql="Select Card_No from Login";
               	Statement smt=(Statement) con1.createStatement();
               	ResultSet rs=smt.executeQuery(sql);
               	while(rs.next()){
               		atmm.cardno=rs.getInt("Card_No");
               	}
                      JOptionPane.showMessageDialog(logindetails, "Your Card No:"+atmm.cardno);  
                      smt.close();
               	   con1.close();
               	   logindetails.dispose();
               	   new ATMMainFrame();
    		   }catch(Exception e){
                   	e.printStackTrace();
                   }
    		   
       }
       
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new LoginDetail();
        
	}

}
