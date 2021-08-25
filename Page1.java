import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Page1  implements ActionListener {
	
	JFrame loginform=new JFrame("NEW ACCOUNT APPLICATION FORM");
	
	  /**Components to add**/
    JLabel form=new JLabel("APPLICATION FORM NO.1967");
    JLabel page1=new JLabel("Page 1:Personal Details");
    JLabel spacing=new JLabel("spacing");
    JLabel spacing1=new JLabel("spacing1");
    JLabel spacing2=new JLabel("spacing2");
    JLabel name=new JLabel("Name:");
    JLabel daydl=new JLabel("D:");
    JLabel montdl=new JLabel("M:");
    JLabel yeardl=new JLabel("Y:");
    JTextField namejt=new JTextField(22);
    JLabel dob=new JLabel("Date Of Birth: ");
    Choice day=new Choice();
    Choice month=new Choice();
    Choice year=new Choice();
    JLabel gender=new JLabel("Gender");
    ButtonGroup bg1=new ButtonGroup();
    ButtonGroup bg2=new ButtonGroup();
    JRadioButton female=new JRadioButton("Female");
    JRadioButton male=new JRadioButton("Male");
    JLabel email=new JLabel("Email-Address:");
    JTextField emailjt=new JTextField(22);
    JLabel maritalstatus=new JLabel("Marital Status:");
    JRadioButton married=new JRadioButton("Married");
    JRadioButton unmarried=new JRadioButton("Unmarried");
    JLabel address=new JLabel("Address:");
    JTextField addressjt=new JTextField(22);
   
   public String naame;
   public String dateOfbirthh;
   public String gen;
   public String emailAddress;
   public String Address;
   public String marstatus;
   public String addressdb;
   public int DateBirth;
  
    public void LogInFormm(){
                                                             	
        /**Jframe and configuration**/
        loginform.setVisible(true);
        loginform.setLocation(250,40);
        loginform.setSize(530,630);
        loginform.setLayout(new FlowLayout());
        loginform.setDefaultCloseOperation(3);

        /**main Jpanel and configurations**/
        JPanel panel =new JPanel(new FlowLayout());
        panel.setPreferredSize(new Dimension(530,630));
        panel.setBackground(Color.darkGray);
        loginform.add(panel);

        LineBorder border=new LineBorder(Color.cyan,8);
        panel.setBorder(border);

        /**JPanel for providing from title**/
        JPanel title =new JPanel(new FlowLayout());
        title.setPreferredSize(new Dimension(430,100));
        title.setBackground(Color.darkGray);
        panel.add(title);

        /**JPanel for providing space in title panel**/
        JPanel titles =new JPanel(new FlowLayout());
        titles.setPreferredSize(new Dimension(400,40));
        titles.setBackground(Color.darkGray);
        title.add(titles);

        /**JPanel for providing space after panel title**/
        JPanel aftertitle =new JPanel(new FlowLayout());
        aftertitle.setPreferredSize(new Dimension(400,40));
        aftertitle.setBackground(Color.darkGray);
        panel.add(aftertitle);

        /**JPanel for providing labels on left**/
        JPanel label =new JPanel(new FlowLayout());
        label.setPreferredSize(new Dimension(150,250));
        label.setBackground(Color.darkGray);
        panel.add(label);

        /**JPanel for providing textarea on right**/
        JPanel textarea =new JPanel(new FlowLayout());
        textarea.setPreferredSize(new Dimension(250,250));
        textarea.setBackground(Color.darkGray);
        panel.add(textarea);

        /**JPanel for providing button**/
        JPanel button =new JPanel(new FlowLayout());
        button.setPreferredSize(new Dimension(430,130));
        button.setBackground(Color.darkGray);
        panel.add(button);

        /**JPanel for providing spacing in buttons**/
        JPanel buttons =new JPanel(new FlowLayout());
        buttons.setPreferredSize(new Dimension(430,50));
        buttons.setBackground(Color.darkGray);
        button.add(buttons);

  
        for(int i=1;i<=31;i++){
        	day.add(Integer.toString(i));
        }
        for(int i=1;i<=12;i++){
        	month.add(Integer.toString(i));
        }
        for(int i=1910;i<=2018;i++){
        	year.add(Integer.toString(i));
        }
        
   
        JButton next=new JButton("Next");
        JButton exit=new JButton("Exit");
        JButton clear=new JButton("Clear");
        JLabel spacing3=new JLabel("spacing33333333");
        JLabel aftnme=new JLabel("spacee");
        JLabel aftgen=new JLabel("spacee");
        
        /**Configuring font**/
        form.setFont(new Font("Times New Roman",Font.BOLD,25));
        form.setForeground(Color.cyan);
        page1.setFont(new Font("Times New Roman",Font.BOLD,20));
        page1.setForeground(Color.white);
        name.setForeground(Color.white);
        dob.setForeground(Color.white);
        gender.setForeground(Color.white);
        email.setForeground(Color.white);
        maritalstatus.setForeground(Color.white);
        address.setForeground(Color.white);
        spacing.setForeground(Color.darkGray);
        spacing1.setForeground(Color.darkGray);
        spacing2.setForeground(Color.darkGray);

        /**Configuring color of drop downl list**/
        spacing.setForeground(Color.DARK_GRAY);
        spacing1.setForeground(Color.DARK_GRAY);
        spacing2.setForeground(Color.DARK_GRAY);
        spacing3.setForeground(Color.DARK_GRAY);
        aftnme.setForeground(Color.DARK_GRAY);
        aftgen.setForeground(Color.DARK_GRAY);
        daydl.setForeground(Color.white);
        montdl.setForeground(Color.white);
        yeardl.setForeground(Color.white);
        day.setForeground(Color.black);
        day.setBackground(Color.white);
        month.setForeground(Color.black);
        month.setBackground(Color.white);
        year.setForeground(Color.black);
        year.setBackground(Color.white);
       

        /**specifying button size**/
        clear.setPreferredSize(new Dimension(100,30));
        next.setPreferredSize(new Dimension(100,30));
        exit.setPreferredSize(new Dimension(100,30));


        /**Components adding to panel**/
        bg1.add(female);
        bg1.add(male);
        bg2.add(married);
        bg2.add(unmarried);
        titles.add(form);
        title.add(page1);
        label.add(name);
        label.add(aftnme);
        textarea.add(namejt);
        label.add(dob);
        label.add(spacing3);
        textarea.add(daydl);
        textarea.add(day);
        textarea.add(montdl);
        textarea.add(month);
        textarea.add(yeardl);
        textarea.add(year);
        label.add(gender);
        label.add(aftgen);
        textarea.add(female);
        textarea.add(male);
        label.add(email);
        textarea.add(emailjt);
        label.add(maritalstatus);
        textarea.add(married);
        textarea.add(unmarried);
        label.add(address);
        textarea.add(addressjt);
        label.add(spacing);
        buttons.add(clear);
        buttons.add(next);
        button.add(exit);

        next.addActionListener(this);
            
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                loginform.dispose();
            }
        });
        
    }
    public void actionPerformed(ActionEvent actionEvent){
    	try{
    	this.naame=namejt.getText();
    	System.out.println(naame);
    	this.dateOfbirthh=day.getSelectedItem()+month.getSelectedItem()+year.getSelectedItem();
    	this.DateBirth=Integer.parseInt(dateOfbirthh);
    	System.out.println(DateBirth);
    	this.gen="";
    	if(female.isSelected())
    	    gen="Female";
    	else if(male.isSelected())
    		gen="Male";
    	System.out.println(gen);
    	this.emailAddress=emailjt.getText();
    	System.out.println(emailAddress);
    	this.marstatus="";
    	if(unmarried.isSelected())
    		marstatus="UnMarried";
    	else if(married.isSelected())
    		marstatus="Married";
    	System.out.println(marstatus);
    	this.addressdb=addressjt.getText();
    	System.out.println(addressdb);
	 		   Class.forName("com.mysql.jdbc.Driver");
	 		   Connection con=DriverManager.getConnection("jdbc:mysql://localhost/ATMProject","root","prapti2323");
	 		   PreparedStatement psmt=con.prepareStatement("insert into LogInpageOne values(?,?,?,?,?,?)");
	 		   psmt.setString(1,naame);
 		       psmt.setInt(2,DateBirth);
 		       psmt.setString(3, gen);
 		       psmt.setString(4, emailAddress);
 		       psmt.setString(5, marstatus);
 		       psmt.setString(6, addressdb);
	 		  
	 		   int i=psmt.executeUpdate();
	 		   if(i>0)
	 			  JOptionPane.showMessageDialog(loginform, "Saved Successfully");
	 		   else
	 			  JOptionPane.showMessageDialog(loginform, "Failed to Saved");
	 		 con.close();
	 		 psmt.close();
	 	   }catch(Exception e){
	 		   System.out.println(e);
	 	   }
    	   Page2 pgtt=new Page2();
    	     pgtt.Pagetwo();
    	}
	
    public static void main(String[] args) {
        Page1 lg=new Page1();
        lg.LogInFormm();
        
    }
}