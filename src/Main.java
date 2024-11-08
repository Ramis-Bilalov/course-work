public class Main {
    public static void main(String[] args) {

        Employee employee1 = new Employee("Годунов","Борис", "Федорович", 1, 60000);
        Employee employee2 = new Employee("Сидоров","Игорь", "Иванович", 3, 65000);

        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addNewEmployee(employee1);                             // добавление нового сотрудника
        employeeBook.addNewEmployee(employee2);

        employeeBook.getEmployeesList();                                    // получение всего списка сотрудников

        employeeBook.deleteEmployee(1);                                  // удаление сотрудника

        employeeBook.getEmployeesList();                                    // получение всего списка сотрудников после удаления

        System.out.println("Получение объекта Employee по ID \n" + employeeBook.getEmployeeById(0));

    }
}
