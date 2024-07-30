public class Main {
    public static class Employee {
        private int employeeId;
        private String name;
        private String position;
        private double salary;

        public Employee(int employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        public int getEmployeeId() {
            return employeeId;
        }

        public String getName() {
            return name;
        }

        public String getPosition() {
            return position;
        }

        public double getSalary() {
            return salary;
        }
    }

    public static class EmployeeManagementSystem {
        private Employee[] employees;
        private int size;

        public EmployeeManagementSystem(int capacity) {
            this.employees = new Employee[capacity];
            this.size = 0;
        }

        public void addEmployee(Employee employee) {
            if (size < employees.length) {
                employees[size] = employee;
                size++;
            }
        }

        public Employee searchEmployee(int employeeId) {
            for (int i = 0; i < size; i++) {
                if (employees[i].getEmployeeId() == employeeId) {
                    return employees[i];
                }
            }
            return null;
        }

        public void traverseEmployees() {
            for (int i = 0; i < size; i++) {
                System.out.println(employees[i].getName());
            }
        }

        public void deleteEmployee(int employeeId) {
            for (int i = 0; i < size; i++) {
                if (employees[i].getEmployeeId() == employeeId) {
                    // Shift elements to fill the gap
                    for (int j = i; j < size - 1; j++) {
                        employees[j] = employees[j + 1];
                    }
                    size--;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(10);

        Employee employee1 = new Employee(1, "John Doe", "Software Engineer", 50000.0);
        Employee employee2 = new Employee(2, "Jane Smith", "Marketing Manager", 60000.0);

        ems.addEmployee(employee1);
        ems.addEmployee(employee2);

        System.out.println("Employees:");
        ems.traverseEmployees();

        Employee foundEmployee = ems.searchEmployee(1);
        System.out.println("Found Employee: " + foundEmployee.getName());

        ems.deleteEmployee(1);

        System.out.println("Employees after deletion:");
        ems.traverseEmployees();
    }
}

