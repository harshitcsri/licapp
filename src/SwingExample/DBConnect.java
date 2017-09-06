package SwingExample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
   import java.sql.Statement;
import javax.swing.JOptionPane;
public class DBConnect {
   Connection con=null;
   Statement st;
   ResultSet rs;
   public Connection getConnect()
   {
              try{
          Class.forName("oracle.jdbc.driver.OracleDriver");
String serverName = "localhost";
			String portNumber = "1521";
			String sid = " ";
        			String url = "jdbc:oracle:thin:@" + serverName + ":" + portNumber + ":" + sid;
			con=DriverManager.getConnection(url,"system","shadow");
		
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return con;
 
   }
  public int processUpdate(String sql)
  {
      int res=0;
      try{
          Connection con=getConnect();
          Statement st=con.createStatement();
          res=st.executeUpdate(sql);
      }catch(Exception e)
      {
          JOptionPane.showMessageDialog(null,e.toString());
      }
      return res;
  }
}
