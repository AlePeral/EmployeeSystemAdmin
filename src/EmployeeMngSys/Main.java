package EmployeeMngSys;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeDoa dao = new EmployeeDaoImpl();
        String name;
        int id;

        System.out.println("Welcome to Employee management System");
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("1. Add Employee\n2. Show all employeed \n3. Show Employee base on id \n4. Update the employee \n5. Delete the employeed");

            System.out.println("Enter some option");
            int choice = scanner.nextInt();
            switch (choice){
                case 1 :
                    Employee employee = new Employee();
                    System.out.print("Enter ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    System.out.print("Salary: ");
                    double salary = scanner.nextDouble();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    employee.setId(id);
                    employee.setName(name);
                    employee.setSalary(salary);
                    employee.setAge(age);
                    dao.createEmployee(employee);
                    break;
                case 2:
                    dao.showAllEmployee();
                    break;
                case 3:
                    System.out.println("Enter id to show the details");
                    id = scanner.nextInt();
                    dao.showEmployeeBasenOnID(id);
                    break;
                case 4:
                    System.out.println("Enter id to update the details");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the new name");
                    name = scanner.nextLine();

                    dao.updateEmployee(id,name);
                    break;
                case 5:
                    System.out.println("Enter the id to delete");
                    id = scanner.nextInt();

                    dao.deleteEmployee(id);
                    break;
                case 6:
                    System.out.println("Thank you !!");

                default:
                    System.out.println("Enter valid choice!");
                    break;
            }

        }while(true);


    }
}