import java.util.Objects;

public class Employee {

    private String firstName;
    private String middleName;
    private String lastName;
    private int departmentNum;
    private int salary;

    private static int count;
    private final int id;

    public Employee(String lastName, String firstName, String middleName, int departmentNum, int salary) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.departmentNum = departmentNum;
        this.salary = salary;
        this.id = count;
        count++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName) && middleName.equals(employee.middleName) && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName);
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDepartmentNum() {
        return departmentNum;
    }

    public void setDepartmentNum(int departmentNum) {
        this.departmentNum = departmentNum;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ID:" + id + "\t");
        builder.append("ФИО: " + lastName + " ");
        builder.append(firstName + " ");
        builder.append(middleName + "\n\t\t");
        builder.append("Номер отдела: " + departmentNum);
        builder.append("\n\t\tЗарплата: " + salary + "\n");
        return builder.toString();
    }
}
