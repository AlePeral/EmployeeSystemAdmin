package EmployeeMngSys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDaoImpl implements  EmployeeDoa{
    Connection con;

    @Override
    public void createEmployee(Employee employee) {
        con = Conexion.createdDBConnection();
        String query = "INSERT INTO employees VALUES(?,?,?,?)";
        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, employee.getId());
            pstm.setString(2, employee.getName());
            pstm.setDouble(3, employee.getSalary());
            pstm.setInt(4, employee.getAge());
            int cnt = pstm.executeUpdate();
            if(cnt != 0){
                System.out.println("Employee inserted successfully.");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void showAllEmployee() {
        con = Conexion.createdDBConnection();
        String query = "SELECT* FROM employees";
        System.out.println("Employee details: ");
        System.out.format("%s\t%s\t%s\t%s\n", "ID", "Name", "Salary", "Age");
        System.out.println("-------------------------------------------------");
        try{
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while(result.next()){
                System.out.format("%d\t%s\t%f\t%d\n", result.getInt(1), result.getString(2),
                        result.getDouble(3), result.getInt(4));
                System.out.println("-------------------------------------------------");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void showEmployeeBasenOnID(int id) {
        con = Conexion.createdDBConnection();
        String query = "SELECT * FROM employees WHERE id= "+id;
        try{
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while(result.next()){
                System.out.println("-------------------------------------------------");
                System.out.format("%s\t%s\t%s\t%s\n", "ID", "Name", "Salary", "Age");
                System.out.println("-------------------------------------------------");
                System.out.format("%d\t%s\t%f\t%d\n", result.getInt(1), result.getString(2),
                        result.getDouble(3), result.getInt(4));
                System.out.println("-------------------------------------------------");
            }


        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void updateEmployee(int id, String name) {
        con = Conexion.createdDBConnection();
        String query = "UPDATE employees SET name=? WHERE  id=?";
        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1,name);
            pstm.setInt(2, id);
            int cnt = pstm.executeUpdate();
            if(cnt != 0){
                System.out.println("Employee details updated successfully.");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void deleteEmployee(int id) {
        con = Conexion.createdDBConnection();
        String query = "DELETE FROM employees WHERE id= ?";
        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1,id);
            int cnt = pstm.executeUpdate();
            if(cnt != 0){
                System.out.println("Employee details delete successfully-");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
