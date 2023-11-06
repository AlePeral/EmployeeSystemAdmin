package EmployeeMngSys;

public interface EmployeeDoa {
    // create employee

    public void createEmployee(Employee employee);
    // show all employee
    public void showAllEmployee();
    // show employee based on id
    public void showEmployeeBasenOnID(int id);
    //update employee
    public void updateEmployee(int id, String name);
    // Delete employee
    public void deleteEmployee(int id);

}
