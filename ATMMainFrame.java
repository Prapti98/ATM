import javax.swing.*;
import javax.swing.border.LineBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ATMMainFrame implements ActionListener{
	JTextField textarea1 = new JTextField(20);
	 JPasswordField textarea2 = new JPasswordField(20);
	 JPasswordField pinjt=new JPasswordField(15);
	 JTextField cashdepojt=new JTextField(15);   
	 JFrame loginframe = new JFrame("AUTOMATED TELLER MACHINE");
	
	 JButton signin = new JButton("SIGN IN");
	 public int cardno;
     public String SPIN;
     public String Sbal;
     public int bal;
	  
        public ATMMainFrame() {
        			
        loginframe.setVisible(true);
        loginframe.setLocation(300,100);
        loginframe.setSize(450, 550);
        loginframe.setLayout(new FlowLayout());
        loginframe.setDefaultCloseOperation(3);

        JPanel panel = new JPanel(new FlowLayout());
        JPanel panel1=new JPanel();
        JPanel panel2=new JPanel();
        JPanel inner=new JPanel();
        JPanel panel3=new JPanel();
        JPanel panel4=new JPanel();

        //LineBorder border1=new LineBorder(Color.cyan,8);
        //panel.setBorder(border1);
        panel.setPreferredSize(new Dimension(450,550));
        panel.setBackground(Color.darkGray);
        loginframe.add(panel);

        panel1.setPreferredSize(new Dimension(400,100));
        panel1.setLayout(new BoxLayout(panel1,BoxLayout.LINE_AXIS));
        panel1.setBackground(Color.darkGray);
        panel.add(panel1);

        panel2.setPreferredSize(new Dimension(300,120));
        panel2.setBackground(Color.darkGray);
        panel.add(panel2,FlowLayout.CENTER);

        inner.setPreferredSize(new Dimension(300,60));
        inner.setBackground(Color.darkGray);
        panel2.add(inner);

        panel3.setPreferredSize(new Dimension(400,100));
        panel3.setBackground(Color.darkGray);
        panel.add(panel3,FlowLayout.CENTER);

        panel4.setPreferredSize(new Dimension(400,80));
        panel4.setBackground(Color.darkGray);
        panel.add(panel4,FlowLayout.CENTER);

            
            JLabel welcomenote=new JLabel("WELCOME TO ATM");
            JLabel cardNo=new JLabel("ENTER CARD NO:");
            JLabel pin=new JLabel("ENTER YOUR PIN:");
            JButton clear = new JButton("CLEAR");
            JButton signup=new JButton("SIGN UP");
            JButton exit=new JButton("EXIT");
            welcomenote.setForeground(Color.white);
            pin.setForeground(Color.white);
            cardNo.setForeground(Color.white);


        welcomenote.setFont(new Font("Times New Roman",Font.BOLD,25));
        welcomenote.setForeground(Color.cyan);
        panel4.add(welcomenote);


        panel3.add(cardNo);
        cardNo.setFont(new Font("Times New Roman",Font.BOLD,15));
        cardNo.setForeground(Color.cyan);


        panel3.add(textarea1);

        panel3.add(pin);
        pin.setFont(new Font("Times New Roman",Font.BOLD,15));
        pin.setForeground(Color.cyan);

        panel3.add(textarea2);

        signin.setPreferredSize(new Dimension(100,40));
        signup.setPreferredSize(new Dimension(100,40));
        clear.setPreferredSize(new Dimension(100,40));
        exit.setPreferredSize(new Dimension(100,40));
        
        inner.add(signin);
        inner.add(clear);
        panel2.add(signup);
        panel2.add(exit);
        
       signup.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent actionEvent){
                   Page1 log=new Page1();
                   log.LogInFormm();
            }
       });

       clear.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent actionEvent) {
               textarea1.setText("");
               textarea2.setText("");
           }
       });
     
       exit.addActionListener(new ActionListener(){
    	   public void actionPerformed(ActionEvent ae){
    		   loginframe.dispose();
    	   }
       });
       
      signin.addActionListener(this);
        }
        public void actionPerformed(ActionEvent ae){
 			   try{
 				   String txt1=textarea1.getText();
 				   String txt2=String.valueOf(textarea2.getPassword());
 				  if(txt1.isEmpty() && txt2.isEmpty()){
 					  JOptionPane.showMessageDialog(loginframe, "You have not entered any value!");
 				  }
 				   String caardnumm=textarea1.getText();
 				   int cardnum=Integer.parseInt(caardnumm);
 				   String passwurd=String.valueOf(textarea2.getPassword());
 					Class.forName("com.mysql.jdbc.Driver");
 	            	Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/ATMProject","root","prapti2323");
 	                String sql="Select * from Login";
 	            	Statement smt=(Statement) con.createStatement();
 	            	ResultSet rs=smt.executeQuery(sql);
 	            	while(rs.next()){
 	            		this.cardno=rs.getInt("Card_No");
 	            		this.SPIN=rs.getString("Password");
 	            		if(cardnum==(cardno) && passwurd.equals(SPIN) ){
 	            			JOptionPane.showMessageDialog(loginframe, "Loggedin succesfully!");
 	            			new Transcation();
 	 	            		break;
 	 	            	}
 	            	}if(cardnum!=cardno && !passwurd.equals(SPIN)){
 	            		JOptionPane.showMessageDialog(loginframe, "Authetication Failed");
 	            	}
 	            	
 	            	
 	                   smt.close();
 	            	  con.close();   
 			   }catch(Exception e){
 				   e.printStackTrace();
 			   }
        }
  

	public static void main(String[] args) {
        new ATMMainFrame();
        
        
    }
}
