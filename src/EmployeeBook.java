public class EmployeeBook {

    private final Employee[] employees = new Employee[10];


    public boolean addNewEmployee (Employee employee) {
        for (int i = 0; i < getEmployeesLength(); i++) {
            if(this.employees[i] == null) {
                this.employees[i] = employee;
                return true;
            }
        } return false;
    }

    public void deleteEmployee(int id) {
        employees[id] = null;
    }

    public Employee getEmployeeById (int id) {
        for (Employee employee : employees) {
            return employee;
        }
        return null;
    }

    public int getEmployeesLength() {
        return this.employees.length;
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

    public Employee getEmployeeWithLowestSalary(Employee[] employees) {                                                // метод, возвращающий объект Employee, который имеет мин. ЗП
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

    public Employee getEmployeeWithHighestSalary(Employee[] employees) {                                               // метод, возвращающий объект Employee, который имеет макс. ЗП
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

    public int getAverageSalary(Employee[] employees) {                                                                // метод, возвращающий среднюю ЗП по всем сотрудникам
        int sum = 0;
        int averageSalary;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        averageSalary = sum / employees.length;
        return averageSalary;
    }

    public void printAllEmployeesFullNames(Employee[] employees) {                                                     // метод, печатающий в консоль ФИО всех сотрудников
        System.out.println("\n---ФИО всех сотрудников---");
        for (Employee employee : employees) {
            System.out.println(employee.getLastName() + " " + employee.getFirstName() + " " + employee.getMiddleName());
        }
    }
    public void indexAllEmployeesSalaries(Employee[] employees, int indexationPercentage) {                            // метод, который реализует индексацию ЗП по всем сотрудникам
        int newSalary;
        for (Employee employee : employees) {
            newSalary = employee.getSalary() + employee.getSalary() * indexationPercentage / 100;
            employee.setSalary(newSalary);
        }
    }

    public Employee getEmployeeWithLowestSalaryOnDepartment(Employee[] employees, int departmentNum) {                 // метод, возвращающий объект Employee, который имеет мин. ЗП в отделе
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

    public Employee getEmployeeWithHighestSalaryOnDepartment(Employee[] employees, int departmentNum) {                // метод, возвращающий объект Employee, который имеет макс. ЗП в отделе
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

    public int getSalaryExpensesOnDepartment(Employee[] employees, int departmentNum) {                                // метод, возвращающий сумму затрат на ЗП по отделу
        int sum = 0;
        for (Employee employee : employees) {
            if (employee.getDepartmentNum() == departmentNum) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public int getAverageSalaryOnDepartment(Employee[] employees, int departmentNum) {                                 // метод, возвращающий среднюю ЗП по отделу
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

    public int getNumberOfEmployeesOnDepartment(Employee[] employees, int departmentNum) {                             // вспомогательный метод для вычисления количества сотрудников в отделе
        int employeesCount = 0;
        for (Employee employee : employees) {
            if (employee.getDepartmentNum() == departmentNum) {
                employeesCount++;
            }
        }
        return employeesCount;
    }

    public void indexAllEmployeesSalariesOnDepartment(Employee[] employees,                                            // метод, который реализует индексацию ЗП по отделу
                                                              int departmentNum, int indexationPercentage) {
        int newSalary = 0;
        for (Employee employee : employees) {
            if (employee.getDepartmentNum() == departmentNum) {
                newSalary = (int) (employee.getSalary() + employee.getSalary() * indexationPercentage / 100);
                employee.setSalary(newSalary);
            }
        }
    }

    public void printAllEmployeesListWithoutDepNum(Employee[] employees) {                                             // метод, выводящий в консоль информацию о сотрудниках без указания номера отдела
        for (Employee employee : employees) {
            System.out.println("ID:" + employee.getId() + "\t" + "ФИО: " + employee.getLastName() + " "
                    + employee.getFirstName() + " " + employee.getMiddleName() +
                    "\n\t\tЗарплата: " + employee.getSalary() + "\n");
        }
    }

    public void printAllEmployeesWhoEarnLessThanAmount(Employee[] employees, int value) {                              // метод, который выводит в консоль всех сотрудников зарабатывающих меньше значения указанного в параметрах
        for (Employee employee : employees) {
            if (employee.getSalary() < value) {
                System.out.println("ID:" + employee.getId() + "\t" + "ФИО: " + employee.getLastName() + " "
                        + employee.getFirstName() + " " + employee.getMiddleName() +
                        "\n\t\tЗарплата: " + employee.getSalary() + "\n");
            }
        }
    }

    public void printAllEmployeesWhoEarnMoreThanAmount (Employee[] employees, int value) {                             // метод, который выводит в консоль всех сотрудников зарабатывающих меньше значения указанного в параметрах
        for (Employee employee : employees) {
            if (employee.getSalary() >= value) {
                System.out.println("ID:" + employee.getId() + "\t" + "ФИО: " + employee.getLastName() + " "
                        + employee.getFirstName() + " " + employee.getMiddleName() +
                        "\n\t\tЗарплата: " + employee.getSalary() + "\n");
            }
        }
    }
}
