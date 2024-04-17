import java.util.Random;

public class App {

    private final static Employee[] EMPLOYEES = new Employee[10];
    private final static Random RANDOM = new Random();
    private final static String[] MALE_SURNAMES = {"Иванов", "Петров", "Сидоров", "Алексеев", "Александров"};
    private final static String[] MALE_NAMES = {"Иван", "Петр", "Павел", "Александр", "Алексей"};
    private final static String[] MALE_PATRONYMIC_NAME = {"Иванович", "Петрович", "Павлович", "Александрович", "Алексеевич"};

    private static Employee generateEmployee(){
        return new Employee(
                MALE_SURNAMES[RANDOM.nextInt(MALE_SURNAMES.length)] +" "+
                        MALE_NAMES[RANDOM.nextInt(MALE_NAMES.length)] +" "+
                        MALE_PATRONYMIC_NAME[RANDOM.nextInt(MALE_PATRONYMIC_NAME.length)] ,
                RANDOM.nextInt(50_000, 100_000),
                RANDOM.nextInt(1, 6)
        );
    }

    public static void main(String[] args) {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            EMPLOYEES[i] = generateEmployee();
        }

        printEmployess();
        printFullNameOfEmployess();
        System.out.println("Сумма ЗП: "+calculateSumOfSalaries());
        System.out.println("Средняя ЗП: "+calculateAverageOfSalaries());
        System.out.println("Сотрудник с максимальной ЗП: "+findEmployeeWithMaxSalary());
        System.out.println("Сотрудник с минимальной ЗП: "+findEmployeeWithMinSalary());
    }

    private static Employee findEmployeeWithMaxSalary() {
        Employee employeeWithMaxSalary = null;
        int maxSalary = Integer.MIN_VALUE;
        for (Employee employee : EMPLOYEES){
            if(employee.getSalary()> maxSalary){
                maxSalary = employee.getSalary();
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }

    private static Employee findEmployeeWithMinSalary() {
        Employee employeeWithMinSalary = null;
        int minSalary = Integer.MAX_VALUE;
        for (Employee employee : EMPLOYEES){
            if(employee.getSalary()< minSalary){
                minSalary = employee.getSalary();
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }

    private static double calculateAverageOfSalaries(){
        return (double) calculateSumOfSalaries() / EMPLOYEES.length;
    }

    private static int calculateSumOfSalaries(){
        int sum = 0;
        for (Employee employee : EMPLOYEES){
            sum+=employee.getSalary();
        }
        return sum;
    }

    private static void printEmployess() {
        System.out.println("Сотрудники:");
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee);
        }
    }

    private static void printFullNameOfEmployess() {
        System.out.println("ФИО сотрудников:");
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee.getFullName());
        }
    }

}