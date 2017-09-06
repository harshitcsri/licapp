
package SwingExample;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainWin extends JFrame {
		JMenuBar jmb;
	JMenu m;
	JMenuItem ii1,ii2,ii3;
	JDesktopPane desktop;
	public MainWin()
	{
		super("LIC Management");
		desktop = new JDesktopPane();
		setContentPane(desktop);	
		jmb=new JMenuBar();
		setJMenuBar(jmb);
		m=new JMenu("LIC");
		jmb.add(m);
		ii1=new JMenuItem("Insert new Policy");
		ii2=new JMenuItem("View and Modify Policy");
	
		m.add(ii1);
		m.add(ii2);
	
      		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,300);
                setVisible(true);
               ii1.addActionListener(new ActionListener()
		{
                    @Override
			public void actionPerformed(ActionEvent e)
			{
                            InsertWin inswin = new InsertWin("Record Insert Window");
				inswin.setLocation(15,15);
				inswin.setResizable(true);
				desktop.add(inswin);

							}
		});
               
               ii2.addActionListener(new ActionListener()
		{
                    @Override
			public void actionPerformed(ActionEvent e)
			{
                            ViewWin viewwin = new ViewWin("Record Insert Window");
				viewwin.setLocation(15,15);
				viewwin.setResizable(true);
				desktop.add(viewwin);

							}
		});
               
              
               setDefaultCloseOperation(EXIT_ON_CLOSE);
               setSize(800,600);
               
        }   
}        

