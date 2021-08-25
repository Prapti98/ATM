import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Page2 {
	
	/**Components to add**/
	JFrame page2=new JFrame("NEW ACCOUNT APPLICATION FORM-Page 2"); 
	JLabel pagetwo=new JLabel("Page 2:Additional Details");
     JLabel category=new JLabel("Category:");
     JLabel income=new JLabel("Income:");
     JLabel spacing=new JLabel("Spacing");
     JLabel spacing1=new JLabel("Spacing");
     JLabel educationalqualification=new JLabel("Educational:");
     JLabel occupation=new JLabel("Occupation:");
     JLabel panno=new JLabel("PAN No:");
     JTextField pannojt=new JTextField(10);
    
     JLabel seniorcitizen=new JLabel("Senior Citizen:");
     ButtonGroup bg1=new ButtonGroup();
     ButtonGroup bg2=new ButtonGroup(); 
     JRadioButton scyes=new JRadioButton("Yes");
     JRadioButton scno=new JRadioButton("No");
   
     JButton clear=new JButton("Clear");
     JButton next=new JButton("Next");
     JButton exit=new JButton("Exit");
     
     Choice cate=new Choice();
     
     Choice incum=new Choice();
     
     Choice edu=new Choice();
     
     Choice occu=new Choice();
     
    
     
   
    public void Pagetwo(){

        /**Jframe and configuration**/
        
        page2.setVisible(true);
        page2.setLocation(250,80);
        page2.setSize(450,570);
        page2.setLayout(new FlowLayout());
        page2.setDefaultCloseOperation(3);

        /**main Jpanel and configurations**/
        JPanel panel =new JPanel(new FlowLayout());
        page2.add(panel);
        panel.setPreferredSize(new Dimension(450,570));
        panel.setBackground(Color.darkGray);
        LineBorder border=new LineBorder(Color.cyan,8);
        panel.setBorder(border);

        /**panel1 for title of the frame**/
        JPanel title =new JPanel(new FlowLayout());
        title.setPreferredSize(new Dimension(380,100));
        title.setBackground(Color.darkGray);
        panel.add(title);

        JPanel innertitle =new JPanel(new FlowLayout());
        innertitle.setPreferredSize(new Dimension(380,35));
        innertitle.setBackground(Color.darkGray);
        title.add(innertitle);
        
        JPanel panel3 =new JPanel(new FlowLayout());
        panel3.setPreferredSize(new Dimension(380,30));
        panel3.setBackground(Color.darkGray);
        panel.add(panel3);
        /**panel1 for dividing frame in two sides label panel**/
        JPanel label =new JPanel(new FlowLayout());
        label.setPreferredSize(new Dimension(100,200));
        label.setBackground(Color.darkGray);
        panel.add(label);

        /**panel1 for dividing frame in two sides textarea panel**/
        JPanel textarea =new JPanel(new FlowLayout());
        textarea.setPreferredSize(new Dimension(150,200));
        textarea.setBackground(Color.darkGray);
        panel.add(textarea);

        /**panel1 for adding buttons to the frame**/
        JPanel button =new JPanel(new FlowLayout());
        button.setPreferredSize(new Dimension(380,100));
        button.setBackground(Color.darkGray);
        panel.add(button);

        JPanel innerbutton =new JPanel(new FlowLayout());
        innerbutton.setPreferredSize(new Dimension(380,50));
        innerbutton.setBackground(Color.darkGray);
        button.add(innerbutton);
        
        /**Creating Drop down list**/
        /**for category**/
        cate.add("Open");
        cate.add("OBC");
        cate.add("SC");
        cate.add("NT");
        cate.add("Others");
        
        /**for income**/
        incum.add("1Lakh >");
        incum.add("1Lakh <");
        incum.add("5Lakh >");
        incum.add("5Lakh <");
        incum.add("Others");
        
        /**for educational qualification**/   
        edu.add("X");
        edu.add("XII");
        edu.add("Graduate");
        edu.add("Post-Graduate");
        edu.add("Others");
        
        /**for occution**/
        occu.add("Service");
        occu.add("Buisness");
        occu.add("Marketing");
        occu.add("Corporate");
        occu.add("Others");     
        
    
        /**Configuring font**/
        pagetwo.setFont(new Font("Times New Roman",Font.BOLD,20));
        pagetwo.setForeground(Color.cyan);
       
        category.setForeground(Color.white);
        income.setForeground(Color.white);
        educationalqualification.setForeground(Color.white);
        occupation.setForeground(Color.white);
        panno.setForeground(Color.white);
      
        seniorcitizen.setForeground(Color.white);
       


        /**configuring font color and background color of drop down list**/
        cate.setForeground(Color.black);
        incum.setForeground(Color.black);
        occu.setForeground(Color.black);
        edu.setForeground(Color.black);
        cate.setBackground(Color.white);
        incum.setBackground(Color.white);
        edu.setBackground(Color.white);
        occu.setBackground(Color.white);
        

        /**Components adding to buttongroup**/
        bg1.add(scyes);
        bg1.add(scno);
       


        /**specifying button size**/
        clear.setPreferredSize(new Dimension(100,30));
        next.setPreferredSize(new Dimension(100,30));
        exit.setPreferredSize(new Dimension(100,30));


        /**Components adding to panel**/
        title.add(pagetwo);
        label.add(category);
        textarea.add(cate);
        label.add(income);
        label.add(spacing);
        textarea.add(incum);
        label.add(educationalqualification);
        textarea.add(edu);
        label.add(occupation);
        textarea.add(occu);
        label.add(panno);
        textarea.add(pannojt);
        label.add(spacing1);
        label.add(seniorcitizen);
        textarea.add(scyes);
        textarea.add(scno);
        innerbutton.add(clear);
        innerbutton.add(next);
        button.add(exit);
        spacing.setForeground(Color.DARK_GRAY);
        spacing1.setForeground(Color.DARK_GRAY);

        next.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
            	 
            	 String cateegory=cate.getSelectedItem();
            	 String inccomee=incum.getSelectedItem();
            	  String education=edu.getSelectedItem();
            	 String pano=pannojt.getText();
            	  String occcupation=occu.getSelectedItem();
          
               String SenCit="";
                 if(scyes.isSelected()){
                	SenCit="Yes";
                }else if(scno.isSelected()){
                	SenCit="No";
                }
               
                try{
        	 		   Class.forName("com.mysql.jdbc.Driver");
        	 		   Connection con=DriverManager.getConnection("jdbc:mysql://localhost/ATMProject","root","prapti2323");
        	 		   PreparedStatement psmt=con.prepareStatement("insert into LogInpageTwo values(?,?,?,?,?,?)");
     
        	 		   psmt.setString(1,cateegory);
        	 		   psmt.setString(2,inccomee);
        	 		   psmt.setString(3, education);
        	 		   psmt.setString(4,occcupation);
        	 		   psmt.setString(5, pano);
        	 		   psmt.setString(6, SenCit);
        	 		  
        	 		   int i=psmt.executeUpdate();
        	 		   if(i>0)
        	 			  JOptionPane.showMessageDialog(page2, "Saved Successfully");
        	 		   else
        	 			  JOptionPane.showMessageDialog(page2, "Failed to Saved");
        	 		 con.close();
        	 	   }catch(Exception e){
        	 		   System.out.println(e);
        	 	   }
            	Page3 pgthr=new Page3();
            	pgthr.Pagethree();
            }
        });


    }

    public static void main(String[] args) {
        Page2 pg2=new Page2();
        pg2.Pagetwo();
    }
}
