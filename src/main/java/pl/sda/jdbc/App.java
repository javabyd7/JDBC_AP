package pl.sda.jdbc;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        boolean exit = true;
        while (exit) {
            System.out.println("1. dodaj pracownika\n2. wyświetl wszystkich\n3. exit");
            int input = new Scanner(System.in).nextInt();
            switch (input) {
                case 1:
                    employeeService.addEmployee();
                    break;
                case 2:
                    employeeService.printAllEmployees();
                    break;
                case 3:
                    exit = false;
            }
        }
    }
}
