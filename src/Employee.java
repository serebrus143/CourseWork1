public class Employee {

    private static int idGenerator = 1;

    private final int id;
    private final String fullName;
    private int salary;
    private int department; // 1-5

    public Employee(String fullName, int salary, int department) {
        this.id = idGenerator++;
        this.fullName = fullName;
        this.salary = salary;
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", ФИО=" + fullName +
                ", ЗП=" + salary +
                ", отдел=" + department;
    }
}
