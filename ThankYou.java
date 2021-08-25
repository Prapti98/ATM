import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThankYou {
	
	 JFrame thankyou=new JFrame("THANK YOU");
	
    public ThankYou(){
       
        thankyou.setVisible(true);
        thankyou.setLocation(300,150);
        thankyou.setSize(450,500);
        thankyou.setLayout(new FlowLayout());
        thankyou.setDefaultCloseOperation(3);

        JPanel panel =new JPanel(new FlowLayout());
        JPanel panel1=new JPanel();
        JPanel panel2=new JPanel();
        JPanel panel3=new JPanel();


        panel1.setPreferredSize(new Dimension(400,100));
        panel1.setBackground(Color.darkGray);
        panel2.setPreferredSize(new Dimension(400,100));
        panel2.setBackground(Color.darkGray);
        panel3.setPreferredSize(new Dimension(400,100));
        panel3.setBackground(Color.darkGray);

        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);

        thankyou.add(panel);
        panel.setPreferredSize(new Dimension(450,500));
        panel.setBackground(Color.darkGray);
        LineBorder border=new LineBorder(Color.cyan,8);
        panel.setBorder(border);

        JLabel l=new JLabel("THANK YOU FOR USING ATM");
        l.setFont(new Font("Times New Roman",Font.BOLD,20));
        l.setForeground(Color.cyan);
        JButton exit=new JButton("OK");
        exit.setPreferredSize(new Dimension(150,50));


        panel2.add(l);
        panel3.add(exit);


        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                thankyou.dispose();

            }
        });

    }

    public static void main(String[] args) {

        new ThankYou();
    }
}
