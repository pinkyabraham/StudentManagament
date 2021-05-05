package studentmanagement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    private Connection conn;
    private Statement statement;
    ResultSet rs;

    
    public void insert(String name,int id,int mark){
        try{
             statement = (Statement) conn.createStatement();
            statement.executeUpdate("INSERT into studenttble(name, id, mark)"
                            +"values('"+name+"', '"+id+"','"+mark+"')");
         
        }
        catch(SQLException e){
            System.err.print(e);
        }
       
    }
     public void display() {
       try {
       statement = (Statement) conn.createStatement();
         rs=statement.executeQuery("select * from studenttble");
                        while(rs.next())
                        {
                            System.out.println(rs.getString(1) +"\t" +rs.getInt(2)+"\t"+rs.getInt(3));
                        }
         } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
        public void view(int id){
    
          try {
       statement = (Statement) conn.createStatement();
         rs=statement.executeQuery("SELECT * FROM `studenttble` WHERE `id` = "+id+"");
                        while(rs.next())
                        {
                            System.out.println(rs.getString(1) +"\t" +rs.getInt(2)+"\t"+rs.getInt(3));
                        }
         } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
      public void update(int id,int mark){
         try{
             statement = (Statement) conn.createStatement();
             String sql = "UPDATE `studenttble` SET `mark`= '"+mark+"' WHERE id = "+id+"";
         statement.executeUpdate(sql);
        }
        catch(Exception e){
            System.err.print(e);
        }
      
                       
  
       
       
    }
    
    public Connection openConnection() throws SQLException
    {
        if(conn == null)
        {
            String url = "jdbc:mysql://localhost:3306/studentdb";         //url to database in wamp
            String driver = "com.mysql.jdbc.Driver";        //mysql jdbc driver class
            String userName = "root";
            String password = "";
            try
            {
                Class.forName(driver);
                this.conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","");
                System.out.println("Connection established");
                
//               String sql = "CREATE TABLE studenttlbe " +
//              
//                   " name VARCHAR(10), " + 
//                   " id INTEGER, " + 
//                   " mark INTEGER )"; 
//
//         statement.executeUpdate(sql);
//         System.out.println("Created table in given database..."); // create a table  
//        
                
            }
            catch(ClassNotFoundException sqle)
            {
                System.out.println("Connection failed"+sqle);
            }
        }
        return conn;
    }
    
}
