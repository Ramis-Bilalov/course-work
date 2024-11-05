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

        if (departmentNum != employee.departmentNum) return false;
        if (salary != employee.salary) return false;
        if (!firstName.equals(employee.firstName)) return false;
        if (!middleName.equals(employee.middleName)) return false;
        return lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + middleName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + departmentNum;
        result = 31 * result + salary;
        return result;
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
        return "ID:" + id + "\t" + "ФИО: " + lastName + " " + firstName + " " + middleName +
                "\n\t\tНомер отдела: " + departmentNum +
                "\n\t\tЗарплата: " + salary + "\n";
    }
}
