import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.util.*;

/**
 * Created by Ivan Minchev on 2/23/2017.
 */
public class Main {
    public static HashMap<String, List<Double>> departments = new HashMap<>();
    public static List<Employee> employeesList = new ArrayList<>();
    public static LinkedHashMap<String, Double> averageDepSalarySorted = new LinkedHashMap<>();
    public static void main(String[] args) throws Exception {
        Class employeeClass = Employee.class;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        executeFillDepartmentsAndEmplyees(n, reader, employeeClass);

        executeCalculateSortDepAverageSalaries();

        Iterator it = averageDepSalarySorted.entrySet().iterator();
        Map.Entry highestAvgPair = (Map.Entry)it.next();
        String highestAvgDep = highestAvgPair.getKey().toString();


        System.out.printf("Highest Average Salary: %s", highestAvgDep);
        System.out.println();

        employeesList.stream()
                .sorted((emp1, emp2) -> compare(emp1, emp2))
                .forEachOrdered(emp -> {
                    if (emp.department.equals(highestAvgDep)) {
                        System.out.printf("%s %.2f %s %s%n", emp.name, emp.salary, emp.email, emp.age);
                    }
                });
    }

    private static int compare(Employee emp1, Employee emp2) {
        return emp1.salary > emp2.salary ? -1
                : emp1.salary < emp2.salary ? 1
                : 0;
    }

    private static void executeCalculateSortDepAverageSalaries() {
        HashMap<String, Double> averageDepSalary = new HashMap<>();
        for (String s : departments.keySet()) {
            OptionalDouble currentAverage = departments.get(s).stream().mapToDouble(a -> a).average();
            averageDepSalary.put(s, currentAverage.getAsDouble());
        }

        averageDepSalary.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEachOrdered(sal -> averageDepSalarySorted.put(sal.getKey(), sal.getValue()));

    }

    private static void executeFillDepartmentsAndEmplyees(int n, BufferedReader reader, Class employeeClass) throws Exception {
        Constructor employeeCtor = employeeClass.getConstructor(String.class, double.class, String.class, String.class, String.class, int.class);
        Employee currentEmployee;
        String currentName;
        double currentSalary;
        String currentPosition;
        String currentDepartment;
        String currentEmail = "n/a";
        int currentAge = -1;

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().trim().split("\\s+");
            currentName = input[0];
            currentSalary = Double.parseDouble(input[1]);
            currentPosition = input[2];
            currentDepartment = input[3];

            if (input.length == 4) {
                currentEmail = "n/a";
                currentAge = -1;
            }

             if (input.length == 5) {
                if (input[4].contains("@")) {
                    currentEmail = input[4];
                    currentAge = -1;
                } else {
                    currentEmail = "n/a";
                    currentAge = Integer.parseInt(input[4]);
                }
            }

            if (input.length == 6) {
                currentEmail = input[4];
                currentAge = Integer.parseInt(input[5]);
            }

            currentEmployee = (Employee) employeeCtor.newInstance(currentName, currentSalary, currentPosition, currentDepartment, currentEmail, currentAge);
            departments.putIfAbsent(currentDepartment, new ArrayList<>());

            departments.get(currentDepartment).add(currentSalary);
            employeesList.add(currentEmployee);
        }

    }
}


class Employee {
    String name;
    double salary;
    String position;
    String department;
    String email;
    int age;


    public Employee (String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }
}

/*
Input 1:
4
Pesho 120.00 Dev Development pesho@abv.bg 28
Toncho 333.33 Manager Marketing 33
Ivan 840.20 ProjectLeader Development ivan@ivan.com
Gosho 0.20 Freeloader Nowhere 18


Expected output 1:
Highest Average Salary: Development
Ivan 840.20 ivan@ivan.com -1
Pesho 120.00 pesho@abv.bg 28


Input 2:
6
Stanimir 496.37 Temp Coding stancho@yahoo.com
Yovcho 610.13 Manager Sales
Toshko 609.99 Manager Sales toshko@abv.bg 44
Venci 0.02 Director BeerDrinking beer@beer.br 23
Andrei 700.00 Director Coding
Popeye 13.3333 Sailor SpinachGroup popeye@pop.ey


Expected output 2:
Highest Average Salary: Sales
Yovcho 610.13 n/a -1
Toshko 609.99 toshko@abv.bg 44


 */
