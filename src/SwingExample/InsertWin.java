
package SwingExample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class InsertWin extends JInternalFrame
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JButton b1,b2;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    
    
    public InsertWin(String title)
    {
        super();
        setClosable(true);
        setMaximizable(true);
        setSize(800,600);
        setIconifiable(true);
        setLayout(null);
        l1=new JLabel("S.no");
        l2=new JLabel("Policy no.");
        l3=new JLabel("Name");
        l4=new JLabel("Mode of Payment");
        l5=new JLabel("Amount");
        l6=new JLabel("Due Date");
        l7=new JLabel("Comment");
        t1=new JTextField(20);
        t2=new JTextField(20);
        t3=new JTextField(20);
        t4=new JTextField(20);
        t5=new JTextField(20);
        t6=new JTextField(20);
        t7=new JTextField(50);
        b1=new JButton("Save");
      
      
        l1.setBounds(10,30,150,20);
        t1.setBounds(160,30,150,20);
        l2.setBounds(10,60,150,20);
        t2.setBounds(160,60,150,20);
        l3.setBounds(10,90,150,20);
        t3.setBounds(160,90,150,20);
        l4.setBounds(10,120,150,20);
        t4.setBounds(160,120,150,20);
        l5.setBounds(10,150,150,20);
        t5.setBounds(160,150,150,20);
        l6.setBounds(10,180,150,20);
        t6.setBounds(160,180,150,20);
        l7.setBounds(10,210,150,20);
        t7.setBounds(160,210,150,50);
        b1.setBounds(160,270,150,20);
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);
        add(l5);
        add(t5);
        add(l6);
        add(t6);
        add(l7);
        add(t7);
        add(b1);
      
        		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				DBConnect obj=new DBConnect();
                                int LICSNO,LICPNO,LICAMOUNT;
                                String LICNAME ,LICDUEDATE,LICMODE,LICCOMMENT;
                                   LICSNO=Integer.parseInt(t1.getText());
                                   LICPNO=Integer.parseInt(t2.getText());
                                   LICAMOUNT=Integer.parseInt(t5.getText());
                                   LICNAME=t3.getText();
                                   LICDUEDATE=t6.getText();
                                   LICMODE=t4.getText();
                                   LICCOMMENT=t7.getText();
                                String sql="Insert into TESTLIC values ("+LICSNO+","+LICPNO+",'"+LICNAME+"','"+LICMODE+"',"+LICAMOUNT+",'"+LICDUEDATE+"','"+LICCOMMENT+"')";
                                        
                              int res=obj.processUpdate(sql);
                              if(res!=0)
                              {
                                  JOptionPane.showMessageDialog(null,"Inserted Successfully");
                              }
                              else
                                  JOptionPane.showMessageDialog(null,"Error While Inserting");
			}
		});
 
                   
        setVisible(true);
    }
}
