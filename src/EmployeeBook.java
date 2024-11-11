public class EmployeeBook {

    private final Employee[] employees = new Employee[10];


    public boolean addNewEmployee (Employee employee) {                                                                 // добавление нового сотрудника
        for (int i = 0; i < getEmployeesLength(); i++) {
            if(this.employees[i] == null) {
                this.employees[i] = employee;
                return true;
            }
        } return false;
    }

    public void deleteEmployee(int id) {                                                                                // удаление сотрудника
        for (int i = 0; i < employees.length; i++) {
            if (i == id && employees[i] != null) {
                employees[id] = null;
            }
        }
    }

    public Employee getEmployeeById (int id) {                                                                          // получение сотрудника по ID
        for (int i = 0; i < employees.length; i++) {
            if(i == id && employees[i] != null) {
                return employees[i];
            }
        }
        return null;
    }

    public int getEmployeesLength() {                                                                                   // вспомогательный метод для получения длины массива
        return employees.length;
    }

    public int getSalaryExpenses(EmployeeBook employeeBook) {                                                           // метод, возвращающий общую сумму затрат на ЗП
        int employeeCount = getCountOfEmployee(employeeBook);
        int sum = 0;
        for (int i = 0; i < employeeCount; i++) {
            if (this.employees[i] == null) {
                continue;
            }
            sum += this.employees[i].getSalary();
        }
        return sum;
    }

    public void getEmployeesList() {                                                                                    // метод, печатающий в консоль общее количество сотрудников со всеми данными
        System.out.println("---Список всех действующих сотрудников---\n");
        for (Employee value : this.employees) {
            if (value != null) {
                System.out.println(value);
            }
        }
    }

    public int getCountOfEmployee(EmployeeBook employeeBook) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                count++;
            }
        }
        return count;
    }

    public Employee getEmployeeWithLowestSalary() {                                                                     // метод, возвращающий объект Employee, который имеет мин. ЗП
        int label = Integer.MAX_VALUE;
        int id = 0;
        for (int i = 0; i < employees.length; i++) {
            boolean correct = employees[i].getSalary() < label && employees[i] != null;
            if (correct) {
                label = employees[i].getSalary();
                id = i;
            }
        }
        return employees[id];
    }

    public Employee getEmployeeWithHighestSalary() {                                                                    // метод, возвращающий объект Employee, который имеет макс. ЗП
        int label = 0;
        int id = 0;
        for (int i = 0; i < employees.length; i++) {
            boolean correct = employees[i].getSalary() > label && employees[i] != null;
            if (correct) {
                label = employees[i].getSalary();
                id = i;
            }
        }
        return employees[id];
    }

    public int getAverageSalary() {                                                                                     // метод, возвращающий среднюю ЗП по всем сотрудникам
        int sum = 0;
        int averageSalary = 0;
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            if(employees[i] != null) {
                count++;
                sum += employees[i].getSalary();
            }
        }
        if(count > 0) {
            averageSalary = sum / count;
        }
        return averageSalary;
    }

    public void printAllEmployeesFullNames() {                                                                          // метод, печатающий в консоль ФИО всех сотрудников
        System.out.println("\n---ФИО всех сотрудников---");
        for (int i = 0; i < employees.length; i++) {
            if(employees[i] != null) {
                System.out.println(employees[i].getLastName() + " " + employees[i].getFirstName() + " " + employees[i].getMiddleName());
            }
        }
    }
    public void indexAllEmployeesSalaries(int indexationPercentage) {                                                   // метод, который реализует индексацию ЗП по всем сотрудникам
        int newSalary;
        for (int i = 0; i < employees.length; i++) {
            if(employees[i] != null) {
                newSalary = employees[i].getSalary() + employees[i].getSalary() * indexationPercentage / 100;
                employees[i].setSalary(newSalary);
            }
        }
    }

    public Employee getEmployeeWithLowestSalaryOnDepartment(int departmentNum) {                                        // метод, возвращающий объект Employee, который имеет мин. ЗП в отделе
        int label = Integer.MAX_VALUE;
        int id = 0;
        for (int i = 0; i < employees.length; i++) {
            boolean correct = employees[i].getDepartmentNum() == departmentNum && employees[i].getSalary() < label && employees[i] != null;
            if(correct) {
                label = employees[i].getSalary();
                id = i;
            }
        }
        return employees[id];
    }

    public Employee getEmployeeWithHighestSalaryOnDepartment(int departmentNum) {                                       // метод, возвращающий объект Employee, который имеет макс. ЗП в отделе
        int label = 0;
        int id = 0;
        for (int i = 0; i < employees.length; i++) {
            boolean correct = employees[i].getDepartmentNum() == departmentNum && employees[i].getSalary() > label && employees[i] != null;
            if(correct) {
                label = employees[i].getSalary();
                id = i;
            }
        }
        return employees[id];
    }

    public int getSalaryExpensesOnDepartment(int departmentNum) {                                                       // метод, возвращающий сумму затрат на ЗП по отделу
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            boolean correct = employees[i].getDepartmentNum() == departmentNum && employees[i] != null;
            if (correct) {
                sum += employees[i].getSalary();
            }
        }
        return sum;
    }

    public int getAverageSalaryOnDepartment(int departmentNum) {                                                        // метод, возвращающий среднюю ЗП по отделу
        int sum = 0;
        int averageSalary;
        int employeesCount = getNumberOfEmployeesOnDepartment(departmentNum);
        for (int i = 0; i < employees.length; i++) {
            boolean correct = employees[i].getDepartmentNum() == departmentNum && employees[i] != null;
            if (correct) {
                sum += employees[i].getSalary();
            }
        }
        averageSalary = sum / employeesCount;
        return averageSalary;
    }

    public int getNumberOfEmployeesOnDepartment(int departmentNum) {                                                    // вспомогательный метод для вычисления количества сотрудников в отделе
        int employeesCount = 0;
        for (int i = 0; i < employees.length; i++) {
            boolean correct = employees[i].getDepartmentNum() == departmentNum && employees[i] != null;
            if (correct) {
                employeesCount++;
            }
        }
        return employeesCount;
    }

    public void indexAllEmployeesSalariesOnDepartment(int departmentNum, int indexationPercentage) {                    // метод, который реализует индексацию ЗП по отделу
        int newSalary;
        for (int i = 0; i < employees.length; i++) {
            boolean correct = employees[i].getDepartmentNum() == departmentNum && employees[i] != null;
            if (correct) {
                newSalary = employees[i].getSalary() + employees[i].getSalary() * indexationPercentage / 100;
                employees[i].setSalary(newSalary);
            }
        }
    }

    public void printAllEmployeesListWithoutDepNum() {                                                                  // метод, выводящий в консоль информацию о сотрудниках без указания номера отдела
        for (int i = 0; i < employees.length; i++) {
            if(employees[i] != null) {
                System.out.println("ID:" + employees[i].getId() + "\t" + "ФИО: " + employees[i].getLastName() + " "
                        + employees[i].getFirstName() + " " + employees[i].getMiddleName() +
                        "\n\t\tЗарплата: " + employees[i].getSalary() + "\n");
            }
        }
    }

    public void printAllEmployeesWhoEarnLessThanAmount(int value) {                                                     // метод, который выводит в консоль всех сотрудников зарабатывающих меньше значения указанного в параметрах
        for (int i = 0; i < employees.length; i++) {
            boolean correct = employees[i].getSalary() < value && employees[i] != null;
            if (correct) {
                System.out.println("ID:" + employees[i].getId() + "\t" + "ФИО: " + employees[i].getLastName() + " "
                        + employees[i].getFirstName() + " " + employees[i].getMiddleName() +
                        "\n\t\tЗарплата: " + employees[i].getSalary() + "\n");
            }
        }
    }

    public void printAllEmployeesWhoEarnMoreThanAmount (int value) {                                                    // метод, который выводит в консоль всех сотрудников зарабатывающих меньше значения указанного в параметрах
        for (int i = 0; i < employees.length; i++) {
            boolean correct = employees[i].getSalary() >= value && employees[i] != null;
            if (correct) {
                System.out.println("ID:" + employees[i].getId() + "\t" + "ФИО: " + employees[i].getLastName() + " "
                        + employees[i].getFirstName() + " " + employees[i].getMiddleName() +
                        "\n\t\tЗарплата: " + employees[i].getSalary() + "\n");
            }
        }
    }
}
