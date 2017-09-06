package SwingExample;
import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.sql.*;

import java.util.Vector;

 

public class ViewWin extends JInternalFrame implements ActionListener {

 

    JLabel l, l1, l2, l3, l4, l5,l6,l7,l8;

    JButton b,b1,b2;

    JTextField tf1, tf2, tf3, tf4,tf6,tf7,tf8;

    JComboBox bx;

    String str;

 

    public ViewWin(String title)
    {

       super();
        setClosable(true);
        setMaximizable(true);
        setSize(800,600);
        setIconifiable(true);
        setLayout(null);
        setVisible(true);
        setTitle("POLICY DETAIL");

 

        l = new JLabel("Choose Policy number:");

        b = new JButton("Submit");

 

        tf1 = new JTextField();

        tf2 = new JTextField();

        tf3 = new JTextField();

        tf4 = new JTextField();
        
         tf6 = new JTextField();
         
          tf7 = new JTextField();
          
           tf8 = new JTextField();
        
       
 

        l.setBounds(20, 20, 200, 20);

        b.setBounds(50, 50, 150, 30);

 

        add(l);

        add(b);

 

        tf1.setEditable(true);

        tf2.setEditable(true);

        tf3.setEditable(true);

        tf4.setEditable(true);
        
        tf6.setEditable(true);
        tf7.setEditable(true);
        
        tf8.setEditable(true);
        

        b.addActionListener(this);

 

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            String serverName = "localhost";
			String portNumber = "1521";
			String sid = " ";
                        String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;
                        Connection con=DriverManager.getConnection(url,"system","shadow");

            

            PreparedStatement ps = con.prepareStatement("select LICPNO from TESTLIC");

            ResultSet rs = ps.executeQuery();

            Vector v = new Vector();

            while (rs.next()) {

                String s = rs.getString(1);

 

                v.add(s);

            }

            bx = new JComboBox(v);

            bx.setBounds(240, 20, 200, 20);

            add(bx);

 

        } catch (Exception ex) {

            System.out.println(ex);

        }

 

    }

    ViewWin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
 

    public void actionPerformed(ActionEvent e) {


        setClosable(true);
        setMaximizable(true);
        setSize(800,600);
        setIconifiable(true);
        setLayout(null);
        
        setVisible(true);




        setTitle("POLICY DETAIL");
        b2=new JButton("SAVE EDITED");
        b1=new JButton("DELETE POLICY");
        l5 = new JLabel("LIC");       

        l5.setForeground(Color.red);

        l5.setFont(new Font("Serif", Font.BOLD, 20));

        l1 = new JLabel("S.no:");

        l2 = new JLabel("Policy no:");

        l3 = new JLabel("Name:");

        l4 = new JLabel("Mode of Payment:");
        l6 =new JLabel("Amount:");
        l7=new JLabel("Due Date:");
        l8=new JLabel("Comment:");
        l5.setBounds(100, 50, 300, 30);

        l1.setBounds(20, 110, 200, 20);

        l2.setBounds(20, 140, 200, 20);

        l3.setBounds(20, 170, 200, 20);
        

        l4.setBounds(20, 200, 200, 20);
        l6.setBounds(20, 230, 200, 20);
        l7.setBounds(20, 260, 200, 20);
        l8.setBounds(20, 290, 200, 20);

 

        tf1.setBounds(240, 110, 200, 20);

        tf2.setBounds(240, 140, 200, 20);

        tf3.setBounds(240, 170, 200, 20);

        tf4.setBounds(240, 200, 200, 20);
        tf6.setBounds(240, 230, 200, 20);
        tf7.setBounds(240, 260, 200, 20);
        tf8.setBounds(240, 290, 200, 20);
        b2.setBounds(240,340,200,20);
        b1.setBounds(240,390,200,20);
        /////////////////DELETE BUTTON
   b1.addActionListener(new ActionListener()
		{
                    @Override
			public void actionPerformed(ActionEvent e)
			{
                    
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

                        String serverName = "localhost";
			String portNumber = "1521";
			String sid = " ";
                        String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;

            Connection con = DriverManager.getConnection(url, "system", "shadow");


            PreparedStatement ps = con.prepareStatement("DELETE from TESTLIC where LICPNO=?");

            ps.setString(1, str);

            ResultSet rs = ps.executeQuery();
            JOptionPane.showMessageDialog(null,"Policy Deleted Successfully");

        } catch (Exception ex) {

            System.out.println(ex);

        }

    
							}
		});
         /////////////////////////DELETE BUTTON

   /////////////////UPDATE BUTTON
   b2.addActionListener(new ActionListener()
		{
                    @Override
			public void actionPerformed(ActionEvent e)
			{
                    
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

                        String serverName = "localhost";
			String portNumber = "1521";
			String sid = " ";
                        String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;

            Connection con = DriverManager.getConnection(url, "system", "shadow");
            		DBConnect obj=new DBConnect();
                                int LICSNO,LICPNO,LICAMOUNT;
                                String LICNAME ,LICDUEDATE,LICMODE,LICCOMMENT;
                                   LICSNO=Integer.parseInt(tf1.getText());
                                   LICPNO=Integer.parseInt(tf2.getText());
                                   LICAMOUNT=Integer.parseInt(tf4.getText());
                                   LICNAME=tf3.getText();
                                   LICDUEDATE=tf6.getText();
                                   LICMODE=tf7.getText();
                                   LICCOMMENT=tf8.getText();
                


            PreparedStatement ps = con.prepareStatement("UPDATE TESTLIC set LICSNO='LICSNO' LICPNO='LICPNO' LICNAME='LICNAME',LICAMOUNT='LICAMOUNT',LICDUEDATE='LICDUEDATE',LICMODE='LICMODE',LICCOMMENT='LICCOMMENT' where  LICPNO=?");

            ps.setString(1, str);

            ResultSet rs = ps.executeQuery();
            JOptionPane.showMessageDialog(null,"Edited Saved Successfully");

        } catch (Exception ex) {

            System.out.println(ex);

        }

                        }
							
		});
         /////////////////////////UPDATE BUTTON
    

        add(l5);

        add(l1);

        add(tf1);

        add(l2);

        add(tf2);

        add(l3);

        add(tf3);

        add(l4);

        add(tf4);
        
        add(l6);
        add(tf6);
        add(l7);
        add(tf7);
        add(l8);
        add(tf8);
        add(b2);
        add(b1);
 

        str = (String) bx.getSelectedItem();

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

                        String serverName = "localhost";
			String portNumber = "1521";
			String sid = " ";
                        String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;

            Connection con = DriverManager.getConnection(url, "system", "shadow");


            PreparedStatement ps = con.prepareStatement("select * from TESTLIC where LICPNO=?");

            ps.setString(1, str);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

 

                tf1.setText(rs.getString(1));

                tf2.setText(rs.getString(2));

                tf3.setText(rs.getString(3));

                tf4.setText(rs.getString(4));
tf6.setText(rs.getString(5));
                                                tf7.setText(rs.getString(6));
                                                                tf8.setText(rs.getString(7));
 

            }

        } catch (Exception ex) {

            System.out.println(ex);

        }

    }}

    

 




 

