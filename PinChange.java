import javax.swing.*;
import java.sql.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange implements ActionListener{
	
	 JFrame pinchange=new JFrame("PIN CHANGE");
	 JPasswordField t1=new JPasswordField(12);
     JPasswordField t2=new JPasswordField(12);
     JPasswordField t3=new JPasswordField(20);
     JLabel l1=new JLabel("Show password");
     JLabel spacing=new JLabel("dfdfgf");
     JCheckBox c1=new JCheckBox();
    public String password;
 	public String psswurd;
	public String newpsswurd;
	public String repasswurd;
	public int cardno;
	 
    public PinChange(){
        /*  Main Frame*/

        pinchange.setVisible(true);
        pinchange.setLocation(300,150);
        pinchange.setSize(450,450);
        pinchange.setLayout(new FlowLayout());
        pinchange.setDefaultCloseOperation(3);

        /*Components to add*/
        JLabel msg=new JLabel("CHANGE YOUR PIN");
        JLabel prepin=new JLabel("CURRENT PIN:");
        JLabel newpin=new JLabel("NEW PIN:");
        JLabel repin=new JLabel("RE-ENTER NEW PIN:");
        JButton save=new JButton("SAVE");
        JButton exit=new JButton("EXIT");

        /*Panels*/
        JPanel panel =new JPanel(new FlowLayout());
        panel.setPreferredSize(new Dimension(450,450));
        panel.setBackground(Color.darkGray);
        LineBorder border=new LineBorder(Color.cyan,8);
        panel.setBorder(border);
        pinchange.add(panel);

        /*Panel1*/
        JPanel panel1=new JPanel();
        panel1.setPreferredSize(new Dimension(400,100));
        panel1.setBackground(Color.darkGray);
        panel.add(panel1);

        /*panel1-innerp1*/
        JPanel innerp1=new JPanel();
        innerp1.setPreferredSize(new Dimension(300,30));
        innerp1.setBackground(Color.darkGray);
        panel1.add(innerp1);

        /*Panel2*/
        JPanel panel2=new JPanel();
        panel2.setPreferredSize(new Dimension(300,200));
        panel2.setBackground(Color.darkGray);
        panel.add(panel2);

        /*Panel2-inner*/
        JPanel innerp2=new JPanel();
        innerp2.setPreferredSize(new Dimension(300,30));
        innerp2.setBackground(Color.darkGray);
        panel2.add(innerp2);

        /*Panel3*/
        JPanel panel3=new JPanel();
        panel3.setPreferredSize(new Dimension(400,100));
        panel3.setBackground(Color.darkGray);
        panel.add(panel3);


        /*configuring fonts for title*/
        msg.setFont(new Font("Times New Roman",Font.BOLD,20));
        msg.setForeground(Color.white);

        /*configuring fonts for middle labels*/
        prepin.setFont(new Font("Times New Roman",Font.BOLD,15));
        prepin.setForeground(Color.white);

        repin.setFont(new Font("Times New Roman",Font.BOLD,15));
        repin.setForeground(Color.white);

        newpin.setFont(new Font("Times New Roman",Font.BOLD,15));
        newpin.setForeground(Color.white);
         
        spacing.setForeground(Color.DARK_GRAY);
        
        l1.setForeground(Color.WHITE);
         
        /*adding components as per panel positions*/

        panel1.add(msg);
        panel2.add(prepin);
        panel2.add(t1);
        panel2.add(newpin);
        panel2.add(t2);
        panel2.add(repin);
        panel2.add(t3);
        panel2.add(spacing);
        panel2.add(c1);
        panel2.add(l1);
        /*specifying button sizes*/
        save.setPreferredSize(new Dimension(100,40));
        exit.setPreferredSize(new Dimension(100,40));

        /*adding buttons*/

        panel3.add(save);
        panel3.add(exit);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                pinchange.dispose();
                new ThankYou();
            }
        });
        
        save.addActionListener(this);
        
        c1.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent ae){
        		 if(c1.isSelected()){
        	        	t1.setEchoChar((char)0);
        	        	t2.setEchoChar((char)0);
        	        	t3.setEchoChar((char)0);
        	        }else{
        	        	t1.setEchoChar('*');
        	        	t2.setEchoChar('*');
        	        	t3.setEchoChar('*');
        	        } 		
        	}
        });
       
    }
    public void actionPerformed(ActionEvent ae){
    	this.psswurd=String.valueOf(t1.getPassword());
    	System.out.println("password from textfield");
    	this.newpsswurd=String.valueOf(t2.getPassword()); 
    	this.repasswurd=String.valueOf(t3.getPassword());
    	
    	try{
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/ATMProject","root","prapti2323");
            String sql="Select * from Login";
    		Statement smt=con.createStatement();
    		ResultSet rs=smt.executeQuery(sql);
    		while(rs.next()){
    			this.cardno=rs.getInt("Card_No");
    			this.password=rs.getString("Password");
    			if(psswurd.equals(password)){
        			if(newpsswurd.equals(repasswurd)){
        				PreparedStatement psmt=con.prepareStatement("Update Login set Password=? where Card_No=?");
        			    psmt.setString(1, newpsswurd);
        			    psmt.setInt(2, cardno);
        				int i=psmt.executeUpdate();
        				if(i>0){
        					JOptionPane.showMessageDialog(pinchange, "Your Password Changed Successfully");
        					pinchange.dispose();
        					Transcation t=new Transcation();
        					t.mainframe.dispose();
        					ATMMainFrame atmmf=new ATMMainFrame();
        					JOptionPane.showMessageDialog(atmmf.loginframe, "Signin with your new Password");
        				}else{
        					JOptionPane.showMessageDialog(pinchange, "Failed to Change Password");
        				}
        				psmt.close();}else{
        				JOptionPane.showMessageDialog(pinchange, "Passwords Doesnt Match!");
        			}
        		}  			
    		}System.out.println("Password from table:"+password);
    	    if(!psswurd.equals(password)){
    			JOptionPane.showMessageDialog(pinchange, "Your Currrent Password doesn't Match!");
    		}
    		smt.close();
        	rs.close();
    		con.close();
    
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    public static void main(String[] args) {
        new PinChange();
    }

}
