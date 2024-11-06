public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];

        employees[0] = new Employee("Годунов","Борис", "Федорович", 1, 60000);
        employees[1] = new Employee("Сидоров","Игорь", "Иванович", 3, 65000);
        employees[2] = new Employee("Гаврилов","Константин", "Юрьевич", 2, 95000);
        employees[3] = new Employee("Юлаев","Тимур", "Игоревич", 4, 81000);
        employees[4] = new Employee("Хасанов","Айдар", "Айратович", 3, 76000);
        employees[5] = new Employee("Никитина","Ольга", "Викторовна", 5, 45000);
        employees[6] = new Employee("Лаптев","Александр", "Васильевич", 1, 79000);
        employees[7] = new Employee("Петров","Максим", "Иванович", 2, 98000);
        employees[8] = new Employee("Лавров","Иван", "Алексеевич", 5, 63000);
        employees[9] = new Employee("Калашников","Сергей", "Александрович", 4, 59000);


        getEmployeesList(employees);                                                                                    // получение списка сотрудников со всеми данными

        System.out.println("---Cумма затрат на ЗП в месяц: " + getSalaryExpenses(employees) + "---");                   // вывод в консоль всех затрат ЗП на месяц

        System.out.println("\n---Сотрудник с минимальной ЗП:---\n" + getEmployeeWithLowestSalary(employees));           // вывод в консоль сотрудника с мин. ЗП

        System.out.println("\n---Сотрудник с максимальной ЗП:---\n" + getEmployeeWithHighestSalary(employees));         // вывод в консоль сотрудника с макс. ЗП

        System.out.println("\n---Среднее значение ЗП: " + getAverageSalary(employees));                                 // вывод в консоль среднего значения ЗП по всем сотрудникам

        printAllEmployeesFullNames(employees);                                                                          // вывод в консоль ФИО всех сотрудников

        indexAllEmployeesSalaries(employees, 10);                                                       // индексация зарплат сотрудников, в параметрах указан массив Employee[] и процент индексации

        System.out.println("\n---Данные о зарплате сотрудников после индексации---");
        getEmployeesList(employees);                                                                                    // вывод в консоль данных всех сотрудников после индексации ЗП

        System.out.println("\n---Сотрудник с минимальной зарплатой в отделе---\n"                                       // вывод в консоль сотрудника с мин. ЗП в отделе
                + getEmployeeWithLowestSalaryOnDepartment(employees, 1));

        System.out.println("\n---Сотрудник с максимальной зарплатой в отделе---\n"                                      // вывод в консоль сотрудника с макс. ЗП в отделе
                + getEmployeeWithHighestSalaryOnDepartment(employees, 1));

        System.out.println("\n---Сумма затрат на ЗП по отделу---"                                                       // вывод в консоль суммы затрат на ЗП по отделу
                + getSalaryExpensesOnDepartment(employees, 1));

        System.out.println("\n---Среднее значение ЗП по отделу: "                                                       // вывод в консоль средней ЗП по отделу
                + getAverageSalaryOnDepartment(employees, 1));

        indexAllEmployeesSalariesOnDepartment(employees,1,10);                            // индексация зарплат сотрудников по отделу

        System.out.println("\n---Данные о зарплате сотрудников после индексации---");
        getEmployeesList(employees);

        System.out.println("---Данные о сотрудниках без указания номера отдела---\n");
        printAllEmployeesListWithoutDepNum(employees);                                                                  // вывод в консоль данных о сотрудниках без указания номера отдела

        System.out.println("---Данные всех сотрудников с зп меньше числа (распечатать id, фио и зп в консоль)---\n");
        printAllEmployeesWhoEarnLessThanAmount(employees, 80000);                                                 // вывод в консоль данных о сотрудниках с ЗП меньше числа указанного в параметрах

        System.out.println("---Данные всех сотрудников с зп больше (или равно) числа (распечатать id, фио и зп в консоль)---\n");
        printAllEmployeesWhoEarnMoreThanAmount(employees, 95000);                                                 // вывод в консоль данных о сотрудниках с ЗП больше (или равно) числа указанного в параметрах


    }

    private static int getSalaryExpenses(Employee[] employees) {                                                        // метод, возвращающий общую сумму затрат на ЗП
        int sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    private static void getEmployeesList(Employee[] employee) {                                                         // метод, печатающий в консоль общее количество сотрудников со всеми данными
        System.out.println("---Список всех действующих сотрудников---\n");
        for (Employee value : employee) {
            if (value != null) {
                System.out.println(value);
            }
        }
    }

    private static Employee getEmployeeWithLowestSalary(Employee[] employees) {                                         // метод, возвращающий объект Employee, который имеет мин. ЗП
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

    private static Employee getEmployeeWithHighestSalary(Employee[] employees) {                                        // метод, возвращающий объект Employee, который имеет макс. ЗП
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

    private static int getAverageSalary(Employee[] employees) {                                                         // метод, возвращающий среднюю ЗП по всем сотрудникам
        int sum = 0;
        int averageSalary;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        averageSalary = sum / employees.length;
        return averageSalary;
    }

    private static void printAllEmployeesFullNames(Employee[] employees) {                                              // метод, печатающий в консоль ФИО всех сотрудников
        System.out.println("\n---ФИО всех сотрудников---");
        for (Employee employee : employees) {
            System.out.println(employee.getLastName() + " " + employee.getFirstName() + " " + employee.getMiddleName());
        }
    }
    private static void indexAllEmployeesSalaries(Employee[] employees, int indexationPercentage) {                     // метод, который реализует индексацию ЗП по всем сотрудникам
        int newSalary;
        for (Employee employee : employees) {
            newSalary = employee.getSalary() + employee.getSalary() * indexationPercentage / 100;
            employee.setSalary(newSalary);
        }
    }

    private static Employee getEmployeeWithLowestSalaryOnDepartment(Employee[] employees, int departmentNum) {          // метод, возвращающий объект Employee, который имеет мин. ЗП в отделе
        int label = Integer.MAX_VALUE;
        int id = 0;
        for (int i = 0; i < employees.length; i++) {
            if(employees[i].getDepartmentNum() == departmentNum && employees[i].getSalary() < label) {
                label = employees[i].getSalary();
                id = i;
            }
        }
        return employees[id];
    }

    private static Employee getEmployeeWithHighestSalaryOnDepartment(Employee[] employees, int departmentNum) {         // метод, возвращающий объект Employee, который имеет макс. ЗП в отделе
        int label = 0;
        int id = 0;
        for (int i = 0; i < employees.length; i++) {
            if(employees[i].getDepartmentNum() == departmentNum && employees[i].getSalary() > label) {
                label = employees[i].getSalary();
                id = i;
            }
        }
        return employees[id];
    }

    private static int getSalaryExpensesOnDepartment(Employee[] employees, int departmentNum) {                         // метод, возвращающий сумму затрат на ЗП по отделу
        int sum = 0;
        for (Employee employee : employees) {
            if (employee.getDepartmentNum() == departmentNum) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    private static int getAverageSalaryOnDepartment(Employee[] employees, int departmentNum) {                          // метод, возвращающий среднюю ЗП по отделу
        int sum = 0;
        int averageSalary;
        int employeesCount = getNumberOfEmployeesOnDepartment(employees, departmentNum);
        for (Employee employee : employees) {
            if (employee.getDepartmentNum() == departmentNum) {
                sum += employee.getSalary();
            }
        }
        averageSalary = sum / employeesCount;
        return averageSalary;
    }

    private static int getNumberOfEmployeesOnDepartment(Employee[] employees, int departmentNum) {                      // вспомогательный метод для вычисления количества сотрудников в отделе
        int employeesCount = 0;
        for (Employee employee : employees) {
            if (employee.getDepartmentNum() == departmentNum) {
                employeesCount++;
            }
        }
        return employeesCount;
    }

    private static void indexAllEmployeesSalariesOnDepartment(Employee[] employees,                                     // метод, который реализует индексацию ЗП по отделу
                                                              int departmentNum, int indexationPercentage) {
        int newSalary = 0;
        for (Employee employee : employees) {
            if (employee.getDepartmentNum() == departmentNum) {
                newSalary = (int) (employee.getSalary() + employee.getSalary() * indexationPercentage / 100);
                employee.setSalary(newSalary);
            }
        }
    }

    private static void printAllEmployeesListWithoutDepNum(Employee[] employees) {                                      // метод, выводящий в консоль информацию о сотрудниках без указания номера отдела
        for (Employee employee : employees) {
            System.out.println("ID:" + employee.getId() + "\t" + "ФИО: " + employee.getLastName() + " "
                    + employee.getFirstName() + " " + employee.getMiddleName() +
                    "\n\t\tЗарплата: " + employee.getSalary() + "\n");
        }
    }

    private static void printAllEmployeesWhoEarnLessThanAmount(Employee[] employees, int value) {                       // метод, который выводит в консоль всех сотрудников зарабатывающих меньше значения указанного в параметрах
        for (Employee employee : employees) {
            if (employee.getSalary() < value) {
                System.out.println("ID:" + employee.getId() + "\t" + "ФИО: " + employee.getLastName() + " "
                        + employee.getFirstName() + " " + employee.getMiddleName() +
                        "\n\t\tЗарплата: " + employee.getSalary() + "\n");
            }
        }
    }

    private static void printAllEmployeesWhoEarnMoreThanAmount (Employee[] employees, int value) {                      // метод, который выводит в консоль всех сотрудников зарабатывающих меньше значения указанного в параметрах
        for (Employee employee : employees) {
            if (employee.getSalary() >= value) {
                System.out.println("ID:" + employee.getId() + "\t" + "ФИО: " + employee.getLastName() + " "
                        + employee.getFirstName() + " " + employee.getMiddleName() +
                        "\n\t\tЗарплата: " + employee.getSalary() + "\n");
            }
        }
    }
}
