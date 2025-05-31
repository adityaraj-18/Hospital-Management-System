package Hospital.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class connection {

    //it is a constructor
    //the code written inside this will connect to the data base

    //declare connection and statement globally
    Connection connection;

    Statement statement;

    public connection(){
//there may be exception as we move from intellijidea to other database
        try{
            //it will help in connecting to database where u created the login table
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system", "root", "aadiadmin123");
            statement=connection.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
