public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];

        employees[0] = new Employee("Годунов","Борис", "Федорович", 1, 55000);
        employees[1] = new Employee("Сидоров","Игорь", "Иванович", 3, 65000);
        employees[2] = new Employee("Гаврилов","Константин", "Юрьевич", 2, 95000);
        employees[3] = new Employee("Юлаев","Тимур", "Игоревич", 4, 81000);
        employees[4] = new Employee("Хасанов","Айдар", "Айратович", 3, 76000);
        employees[5] = new Employee("Никитина","Ольга", "Викторовна", 5, 45000);
        employees[6] = new Employee("Лаптев","Александр", "Васильевич", 1, 79000);
        employees[7] = new Employee("Петров","Максим", "Иванович", 2, 98000);
        employees[8] = new Employee("Лавров","Иван", "Алексеевич", 5, 63000);
        employees[9] = new Employee("Калашников","Сергей", "Александрович", 4, 59000);


        getEmployeesList(employees);

        System.out.println("---Cумма затрат на ЗП в месяц: " + getSalaryExpenses(employees) + "---");

        System.out.println("\n---Сотрудник с минимальной ЗП:---\n" + getEmployeeWithLowestSalary(employees));

        System.out.println("\n---Сотрудник с максимальной ЗП:---\n" + getEmployeeWithHighestSalary(employees));

        System.out.println("\n---Среднее значение ЗП: " + getAverageSalary(employees));

        printAllEmployeesFullNames(employees);

    }

    private static int getSalaryExpenses(Employee[] employees) {
        int sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    private static void getEmployeesList(Employee[] employee) {
        System.out.println("---Список всех действующих сотрудников---\n");
        for (Employee value : employee) {
            if (value != null) {
                System.out.println(value);
            }
        }
    }

    private static Employee getEmployeeWithLowestSalary(Employee[] employees) {
        int label = Integer.MAX_VALUE;
        int id = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < label) {
                label = employees[i].getSalary();
                id = i;
            }
        }
        return employees[id];
    }

    private static Employee getEmployeeWithHighestSalary(Employee[] employees) {
        int label = 0;
        int id = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() > label) {
                label = employees[i].getSalary();
                id = i;
            }
        }
        return employees[id];
    }

    private static int getAverageSalary(Employee[] employees) {
        int sum = 0;
        int averageSalary;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        averageSalary = sum / employees.length;
        return averageSalary;
    }

    private static void printAllEmployeesFullNames(Employee[] employees) {
        System.out.println("\n---ФИО всех сотрудников---");
        for (Employee employee : employees) {
            System.out.println(employee.getLastName() + " " + employee.getFirstName() + " " + employee.getMiddleName());
        }
    }
}