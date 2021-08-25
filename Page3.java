import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Page3 extends Page2 implements ActionListener{
	
	JFrame page3=new JFrame("NEW ACCOUNT APPLICATION FORM-Page 3");
   	JLabel accdetails=new JLabel("Page 3: Account Details");
	   JLabel spacing=new JLabel("Spacing");
	   JLabel spacing1=new JLabel("Spacing333333");
	   JLabel spacing2=new JLabel("Spacing222222222.2");
	   JLabel spacing3=new JLabel("Spacing33333333");
	   JLabel spacing4=new JLabel("Spacing3333");
	   JLabel spacing5=new JLabel("Spacing33333333");
       JLabel accctype=new JLabel("Account Type:");
       ButtonGroup bg=new ButtonGroup();
       JRadioButton savings_account=new JRadioButton("Savings Account");
       JRadioButton current_account=new JRadioButton("Current Account");
       JRadioButton fixed_deposit_account=new JRadioButton("Fixed Deposit Account");
       JRadioButton recurring_deposit_account=new JRadioButton("Recurring Deposit Account");
       JLabel services_required=new JLabel("Services Required:");
       JCheckBox atm_card=new JCheckBox("ATM Card");
       JCheckBox internet_banking=new JCheckBox("Internet Banking");
       JCheckBox email_alerts=new JCheckBox("Email Alerts");
       JCheckBox cheque_book=new JCheckBox("Cheque Book");
       JCheckBox empty=new JCheckBox();
       JLabel declaration=new JLabel("<html>I hereby declare that the above entered details are"
       		+ "<br>correct to the best of my knowledge</html>");
       JButton submit=new JButton("Submit");
       JButton cancel=new JButton("Cancel");
       
       public String Check;
       
    public void Pagethree(){

        /**Jframe and configuration**/
        
        page3.setVisible(true);
        page3.setLocation(300,100);
        page3.setSize(450,550);
        page3.setLayout(new FlowLayout());
        page3.setDefaultCloseOperation(3);

        /**main Jpanel and configurations**/
        JPanel panel =new JPanel(new FlowLayout());
        page3.add(panel);
        panel.setPreferredSize(new Dimension(450,550));
        panel.setBackground(Color.darkGray);
        LineBorder border=new LineBorder(Color.cyan,8);
        panel.setBorder(border);

        /**panel1 for title of the frame**/
        JPanel title =new JPanel(new FlowLayout());
        title.setPreferredSize(new Dimension(400,100));
        title.setBackground(Color.darkGray);
        panel.add(title);
       
        JPanel innertitle =new JPanel(new FlowLayout());
        innertitle.setPreferredSize(new Dimension(400,30));
        innertitle.setBackground(Color.darkGray);
        title.add(innertitle);
        
        
        /**panel for adding acctype**/
        JPanel acctype =new JPanel(new FlowLayout());
        acctype.setPreferredSize(new Dimension(400,150));
        acctype.setBackground(Color.darkGray);
        panel.add(acctype);

        /**panel for adding services requried**/
        JPanel servreq =new JPanel(new FlowLayout());
        servreq.setPreferredSize(new Dimension(400,100));
        servreq.setBackground(Color.darkGray);
        panel.add(servreq);

        /**panel for adding declaration and buttons**/
        JPanel decabutton =new JPanel(new FlowLayout());
        decabutton.setPreferredSize(new Dimension(400,150));
        decabutton.setBackground(Color.darkGray);
        panel.add(decabutton);

        JPanel decabuttoninner =new JPanel(new FlowLayout());
        decabuttoninner.setPreferredSize(new Dimension(400,65));
        decabuttoninner.setBackground(Color.darkGray);
        decabutton.add(decabuttoninner);
        
        /**Components adding to buttongroup**/
        bg.add(savings_account);
        bg.add(current_account);
        bg.add(recurring_deposit_account);
        bg.add(fixed_deposit_account);

        /**Configuring font**/
        accdetails.setFont(new Font("Times New Roman",Font.BOLD,20));
        accdetails.setForeground(Color.cyan);
        accctype.setForeground(Color.white);
        services_required.setForeground(Color.white);
        declaration.setForeground(Color.white);
        spacing.setForeground(Color.darkGray);
        spacing1.setForeground(Color.darkGray);
        spacing2.setForeground(Color.darkGray);
        spacing3.setForeground(Color.darkGray);
        spacing4.setForeground(Color.darkGray);
        spacing5.setForeground(Color.darkGray);

        /**Components adding to panel**/
        title.add(accdetails);
        acctype.add(accctype);
        acctype.add(savings_account);
        acctype.add(spacing);
        acctype.add(spacing2);
        acctype.add(current_account);
        acctype.add(spacing1);
        acctype.add(spacing4);
        acctype.add(fixed_deposit_account);
        acctype.add(spacing5);
        acctype.add(recurring_deposit_account);
        servreq.add(services_required);
        servreq.add(atm_card);
        servreq.add(internet_banking);
        servreq.add(spacing3);
        servreq.add(email_alerts);
        servreq.add(cheque_book);
        decabuttoninner.add(empty);
        decabuttoninner.add(declaration);
        decabutton.add(submit);
        decabutton.add(cancel);
        
        submit.addActionListener(this);
        
       
    }
    
    public void actionPerformed(ActionEvent ae){
    	
    	String servrIB="";
    	String servrCB="";
    	String servrAC="";
    	String servrEA="";
    	String accType="";
    	
    	if(savings_account.isSelected()){
			accType="SavingAccount";
		}else if(current_account.isSelected()){
			accType="CurrentAccount";
		}else if(recurring_deposit_account.isSelected()){
			accType="RecurringAccount";
		}else if(fixed_deposit_account.isSelected()){
			accType="FixedAccount";
		}
		
		if(atm_card.isSelected()){
			servrAC="Yes";
		}else{
			servrAC="No";
		}
		if(internet_banking.isSelected()){
			servrIB="Yes";
		}else{
			servrIB="No";
		}
		if(email_alerts.isSelected()){
			servrEA="Yes";
		}else{
			servrEA="No";
		}
		if(cheque_book.isSelected()){
			servrCB="Yes";
		}else{
			servrCB="No";
		}
		
		if(empty.isSelected()){
			this.Check="Checked";
			try{
				
		 		   Class.forName("com.mysql.jdbc.Driver");
		 		   Connection con=DriverManager.getConnection("jdbc:mysql://localhost/ATMProject","root","prapti2323");
		 		   PreparedStatement psmt=con.prepareStatement("insert into LogInpageThree values(?,?,?,?,?,?)");
		 		   psmt.setString(1,accType);
		 		   psmt.setString(2,servrAC);
		 	       psmt.setString(3,servrIB);
		 	       psmt.setString(4,servrEA);
		 	       psmt.setString(5,servrCB);
		 	       psmt.setString(6, Check);
		 		   int i=psmt.executeUpdate();
		 		   if(i>0){
		 			   JOptionPane.showMessageDialog(page3,"Saved Successfully");
		 		       new LoginDetail();}
		 		   else
		 			  JOptionPane.showMessageDialog(page3,"failed to save");
		 		  
		 		 psmt.close();
		 		 con.close();
		 	   }catch(Exception e){
		 		   e.printStackTrace();
		 	   }
		}else{
			JOptionPane.showMessageDialog(page3, "Please check Declaration!");
		}
	
    	}
    

    public static void main(String[] args) {
        Page3 pg3=new Page3();
        pg3.Pagethree();
    }
}
