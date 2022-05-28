package com.hillel.homework.hw9;

import java.util.*;

public class ControlCenter {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static Comparator<Employee> comparator = new EmployeeComparator();
    public static TreeSet<Employee> employees = new TreeSet<>(comparator.reversed());

    public static void main(String[] args) {

        String actionMessage = "Choose action: 1.add employee. 2. press any key to exit";
        System.out.println(actionMessage);
        while (SCANNER.nextLine().toLowerCase(Locale.ROOT).replaceAll(" ", "").equals("add")) {
            Employee employee = create();
            if (employee != null) employees.add(employee);
            System.out.println(actionMessage);
        }
        System.out.println(employees);

        System.out.println("Do you want to see employees of a specific department? yes/any key");
        while (SCANNER.nextLine().toLowerCase().replaceAll(" ", "").equals("yes")) {
            specificDepartment();
            System.out.println("Other department? yes/any key");
        }
    }

    public static Employee create() {
        System.out.println("Enter department \n[DEV, HR, MANAGER, QA]");
        String department = SCANNER.nextLine().toUpperCase(Locale.ROOT).replaceAll(" ", "");
        if (!checkDepartment(department)) {
            System.out.println("Wrong department, try again");
            return null;
        }
        System.out.println("Enter name");
        String name = SCANNER.nextLine().toLowerCase(Locale.ROOT).replaceAll(" ", "");
        System.out.println("Enter surname");
        String surname = SCANNER.nextLine().toLowerCase(Locale.ROOT).replaceAll(" ", "");
        System.out.println("Enter salary");
        String salaryStr = SCANNER.nextLine().replaceAll(" ", "");
        if (!isNumeric(salaryStr)) {
            System.out.println("Wrong amount, enter int");
            return null;
        }
        int salary = Integer.parseInt(salaryStr);
        return new Employee(name, surname, salary, department);
    }

    public static boolean isNumeric(String str) {
        if (str == null) return false;
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean checkDepartment(String department) {
        try {
            EmployeeType.valueOf(department);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private static void specificDepartment() {
        TreeSet<Employee> departments = new TreeSet<>(comparator.reversed());

        System.out.println("Enter department \n[DEV, HR, MANAGER, QA]");
        String department = SCANNER.nextLine().toUpperCase(Locale.ROOT).replaceAll(" ", "");
        EmployeeType employeeType = EmployeeType.valueOf(department);  //без этой строчки оно мне выделяло весь if
        for (Employee employee : employees) {
            if (employee.getDepartment().equals(employeeType)) departments.add(employee);
        }
        if (departments.isEmpty()) {
            System.out.println("Empty");
            return;
        }
        System.out.println(departments);

    }
}


