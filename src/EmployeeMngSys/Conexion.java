package EmployeeMngSys;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    static Connection con;

   public static Connection createdDBConnection(){
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           String url = "jdbc:mysql://localhost:3306/myEmployeeSys?useSSL=false&allowPublicKeyRetrieval=true";
           String username = "root";
           String password = "Alegperal";

           con = DriverManager.getConnection(url, username, password);

       }catch (Exception ex){
           ex.printStackTrace();
       }

       return con;
   }
}
