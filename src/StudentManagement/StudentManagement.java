
package StudentManagement;

import com.mysql.jdbc.Statement;
import java.io.DataInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;



public class StudentManagement {
 static Database db = new Database();
      
  static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws SQLException, IOException {
        // TODO code application logic here
         db.openConnection();
      
        

    System.out.println("1. Insert Student \n"
                     + "2. View Student \n"
                     + "3. Display all Student \n"
                     + "4. Update Mark \n"
                     + "5. Exit");
     System.out.print("Enter your choice: ");
     int select=sc.nextInt();
     System.out.println("............................................");
    switch(select){
        case 1 : insertStudent();
                 break;
        case 2 : viewStudent();
                 break;
        case 3 : displayStudents();
                 break;
        case 4 : updateMark();
                 break;
        case 5 : break;
        default:
            
    }
    }
    
    public static void insertStudent(){
       Scanner s = new Scanner(System.in);
        System.out.println("Enter Student Name");
         String name =s.nextLine();
        System.out.println("Enter the Id of Student");
         int id =sc.nextInt();
        System.out.println("Enter Mark");
         int mark =sc.nextInt();
         db.insert( name,id, mark);
       
         System.out.println("Student Inserted Successfully..!!");
    }
    public static void viewStudent(){
      System.out.println("Enter id of student");
        int id = sc.nextInt();
        db.view(id);
    }
    
    public static void displayStudents() {
   db.display();
        
    }
    public static void updateMark(){
        
        System.out.println("Enter id of student");
        int id = sc.nextInt();
        System.out.println("Enter new mark");
        int newmark = sc.nextInt();
        db.update(id,newmark);
    }
}
