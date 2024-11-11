public class Main {
    public static void main(String[] args) {

        Employee employee1 = new Employee("Годунов","Борис", "Федорович", 1, 60000);
        Employee employee2 = new Employee("Сидоров","Игорь", "Иванович", 3, 65000);
        Employee employee3 = new Employee("Петров","Сергей", "Леонидович", 3, 90000);
        Employee employee4 = new Employee("Иванов","Борис", "Петрович", 3, 110000);
        Employee employee5 = new Employee("Кошкин","Дмитрий", "Юрьевич", 3, 45000);

        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addNewEmployee(employee1);                             // добавление нового сотрудника
        employeeBook.addNewEmployee(employee2);
        employeeBook.addNewEmployee(employee3);
        employeeBook.addNewEmployee(employee4);
        employeeBook.addNewEmployee(employee5);


        employeeBook.getEmployeeById(2);                                    // получение сотрудника со всеми данными по его ID

        employeeBook.getEmployeesList();                                    // получение всего списка сотрудников

        employeeBook.deleteEmployee(0);                                  // удаление сотрудника

        employeeBook.getEmployeesList();                                    // получение всего списка сотрудников после удаления

        System.out.println("Получение объекта Employee по ID \n" + employeeBook.getEmployeeById(0));

    }
}
