import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Employee[] employee = new Employee[10];
        employee[0] = new Employee("Виноградов", "Иван", "Максимович", 1, 320000);
        employee[1] = new Employee("Егоров", "Вадим", "Маркович", 1, 320000);
        employee[2] = new Employee("Филатов", "Макар", "Дмитриевич", 1, 320000);
        employee[3] = new Employee("Нечаев", "Александр", "Александрович", 2, 320000);
        employee[4] = new Employee("Логинов", "Артем", "Святославович", 2, 320000);
        employee[5] = new Employee("Морозова", "Василиса", "Вячеславовна", 4, 550000);
        employee[6] = new Employee("Романова", "Мария", "Михайловна", 3, 550000);
        employee[7] = new Employee("Сорокина", "Стефания", "Станисловна", 3, 550000);
        employee[8] = new Employee("Лебедева", "Алиса", "Сергеевна", 5, 550000);
        employee[9] = new Employee("Герасимова", "Екатерина", "Александровна", 4, 550000);
        /*1. Список всех сотрудников со всеми данными*/
        getEmployeeList(employee);
        /*2. Сумма затрат на зарплаты в месяц*/
        getSumOfSalaries(employee);
        /*3. Поиск сотрудника с минимальной зарплатой*/
        employeeMinSalary(employee);
        /*4. Поиск сотрудника с максимальной зарплатой*/
        employeeMaxSalary(employee);
        /*5. Подсчет среднего значения зарплат*/
        employeeMiddleSalary(employee);
        /*6. Список Ф. И. О. всех сотрудников.*/
        getInitialsList(employee);
        /*7. Индексация зарплат сотрудников*/
        indexSalaryForEmployees(employee);
        /*8. Сотрудник с минимальной зарплатой по отделу*/
        getMinSalaryOfOtdel(employee, 5);
        /*9. Сотрудник с максимульной зарплатой по отделу*/
        getMaxSalaryOfOtdel(employee, 1);
        /*10. Сумма затрат по отделу*/
        sumSalaryOfOtdel(employee, 5);
        /*11. Средняя сумма зарплат по отделу*/
        getMiddleSumSalaryOfOtdel(employee, 1);
        /*12. Зарплата после индексации */
        getIndexationSalaryOfOtdel(employee, 1, 5);
        /*13. Все сотрудники отдела*/
        getEmployeesListOfOtdel(employee, 3);
        /*14. Все сотрудники с зарплатой ниже данной входной суммы*/
        salaryDownThisNumber(employee, 40000);
        /*15. Все сотрудники с зарплатой выше данной входной суммы*/
        salaryUpThisNumber(employee, 40000);
    }


    static void getEmployeeList(Employee[] employee) {
        System.out.println("a. Список всех сотрудников ");
        for (Employee value : employee) {
            System.out.println(value);
        }
    }

    static void getSumOfSalaries(Employee[] employee) {
        int sum = 0;
        for (Employee value : employee) {
            sum = sum + value.getSalary();
        }
        System.out.println("b. Сумма затрат на зарплаты в месяц = " + sum);
    }

    static void employeeMinSalary(Employee[] employee) {
        int min = employee[0].getSalary();
        String minSalary = null;
        for (Employee item : employee) {
            if (min > item.getSalary()) {
                min = item.getSalary();
            }
        }
        for (Employee value : employee) {
            if (min == value.getSalary()) {
                minSalary = value.getName() + " " + value.getMiddleName() + " " + value.getSurname();
            }
        }
        System.out.println("с. Сотрудник с минимальной зарплатой: " + minSalary + " (" + min + ") ");
    }

    static void employeeMaxSalary(Employee[] employee) {
        int max = employee[0].getSalary();
        String maxSalary = null;
        for (Employee item : employee) {
            if (max < item.getSalary()) {
                max = item.getSalary();
            }
        }
        for (Employee value : employee) {
            if (max == value.getSalary()) {
                maxSalary = value.getName() + " " + value.getMiddleName() + " " + value.getSurname();
            }
        }
        System.out.println("d. Сотрудник с максимальной зарплатой: " + maxSalary + " (" + max + ") ");
    }

    static void employeeMiddleSalary(Employee[] employee) {
        int sum = 0;
        int middleSum = 0;
        for (Employee value : employee) {
            sum = sum + value.getSalary();
        }
        middleSum = sum / employee.length;
        System.out.println("e. Среднее значение зарплат = " + middleSum);
    }

    static void getInitialsList(Employee[] employee) {
        System.out.println("f. Список всех сотрудников: ");
        for (Employee value : employee) {
            System.out.println(value.getName() + " " + value.getMiddleName() + " " + value.getSurname());
        }
    }

    static void indexSalaryForEmployees(Employee[] employee) {
        for (Employee value : employee) {
            value.setSalary((int) (value.getSalary() * 1.05));
            System.out.println(value.getSalary());
        }
    }

    static void getMinSalaryOfOtdel(Employee[] employee, int otdel) {
        if (otdel > 5) {
            System.out.println("Такого отдела не существует!");
            return;
        }
        int min = Integer.MAX_VALUE;
        String minSalaryOfOtdel = null;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getOtdel() == otdel && min > employee[i].getSalary()) {
                min = employee[i].getSalary();
            }
        }
        for (Employee value : employee) {
            if (min == value.getSalary()) {
                minSalaryOfOtdel = value.getName() + " " + value.getMiddleName() + " " + value.getSurname();
            }
        }
        System.out.println("Сотрудник отдела " + otdel + " с минимальной зарплатой: " + minSalaryOfOtdel + " (" + min + ") ");
    }

    static void getMaxSalaryOfOtdel(Employee[] employee, int otdel) {
        if (otdel > 5) {
            System.out.println("Такого отдела не существует!");
            return;
        }
        int max = Integer.MIN_VALUE;
        String minSalaryOfOtdel = null;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getOtdel() == otdel && max < employee[i].getSalary()) {
                max = employee[i].getSalary();
            }
        }
        for (Employee value : employee) {
            if (max == value.getSalary()) {
                minSalaryOfOtdel = value.getName() + " " + value.getMiddleName() + " " + value.getSurname();
            }
        }
        System.out.println("Сотрудник отдела " + otdel + " с максимальной зарплатой: " + minSalaryOfOtdel + " (" + max + ") ");
    }

    static void sumSalaryOfOtdel(Employee[] employee, int otdel) {
        if (otdel > 5) {
            System.out.println("Такого отдела не существует!");
            return;
        }
        int sum = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getOtdel() == otdel) {
                sum = sum + employee[i].getSalary();
            }
        }
        System.out.println("Сумма затрат по отделу " + otdel + ": " + sum);
    }

    static void getMiddleSumSalaryOfOtdel(Employee[] employee, int otdel) {
        if (otdel > 5) {
            System.out.println("Такого отдела не существует!");
            return;
        }
        int sum = 0;
        int quantityEmployeesOfOtdel = 0;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getOtdel() == otdel) {
                sum = sum + employee[i].getSalary();
                quantityEmployeesOfOtdel++;
            }
        }
        System.out.println("Средняя зарплата по отделу " + otdel + ": " + sum / quantityEmployeesOfOtdel);
    }

    static void getIndexationSalaryOfOtdel(Employee[] employee, int otdel, int percent) {
        if (otdel > 5) {
            System.out.println("Такого отдела не существует!");
            return;
        }
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getOtdel() == otdel) {
                employee[i].setSalary(employee[i].getSalary() + (employee[i].getSalary() * percent) / 100);
                System.out.println("После индексации зарплата сотрудника " + employee[i].getName() + " " + employee[i].getMiddleName() + " " + employee[i].getSurname() + " равна " + employee[i].getSalary());
            }
        }
    }

    static void getEmployeesListOfOtdel(Employee[] employee, int otdel) {
        if (otdel > 5) {
            System.out.println("Такого отдела не существует!");
            return;
        }
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getOtdel() == otdel) {
                System.out.println("id = " + employee[i].getId() + ", сотрудник: " + employee[i].getName() + " " + employee[i].getMiddleName() + " " + employee[i].getSurname() + ", зарплата:" + employee[i].getSalary());
            }
        }
    }

    static void salaryDownThisNumber(Employee[] employee, int number) {
        if (number < 0) {
            System.out.println("Зарплата не может быть ниже 0");
            return;
        }
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() < number) {
                System.out.println("id = " + employee[i].getId() + ", сотрудник: " + employee[i].getName() + " " + employee[i].getMiddleName() + " " + employee[i].getSurname() + ", зарплата:" + employee[i].getSalary());
            }
        }

    }

    static void salaryUpThisNumber(Employee[] employee, int number) {
        if (number < 0) {
            System.out.println("Зарплата не может быть ниже 0");
            return;
        }
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getSalary() >= number) {
                System.out.println("id = " + employee[i].getId() + ", сотрудник: " + employee[i].getName() + " " + employee[i].getMiddleName() + " " + employee[i].getSurname() + ", зарплата:" + employee[i].getSalary());
            }
        }
    }
}