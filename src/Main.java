import java.util.Arrays;

public class Main {

    private static Employee[] employees = new Employee[10];

    private static EmployeeBook[] employeeBooks = new EmployeeBook[10];

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Employee employee1 = new Employee("Виноградов", "Иван", "Максимович", 1, 320000);
        Employee employee2 = new Employee("Егоров", "Вадим", "Маркович", 1, 320000);
        Employee employee3 = new Employee("Филатов", "Макар", "Дмитриевич", 1, 320000);
        Employee employee4 = new Employee("Нечаев", "Александр", "Александрович", 2, 320000);
        Employee employee5 = new Employee("Логинов", "Артем", "Святославович", 2, 320000);
        Employee employee6 = new Employee("Морозова", "Василиса", "Вячеславовна", 4, 550000);
        Employee employee7 =  new Employee("Романова", "Мария", "Михайловна", 3, 550000);
        Employee employee8 = new Employee("Сорокина", "Стефания", "Станисловна", 3, 550000);
        Employee employee9 = new Employee("Лебедева", "Алиса", "Сергеевна", 5, 550000);
        Employee employee10 = new Employee("Герасимова", "Екатерина", "Александровна", 4, 550000);

        employees[0] = employee1;
        employees[1] = employee2;
        employees[2] = employee3;
        employees[3] = employee4;
        employees[4] = employee5;
        employees[5] = employee6;
        employees[6] = employee7;
        employees[7] = employee8;
        employees[8] = employee9;
        employees[9] = employee10;

        EmployeeBook book1 = new EmployeeBook(10);
        book1.add(new Employee("Сидоров ", "Степан ", "Ярославович", 2,320000));
        book1.add(new Employee("Попов", "Данила", "Максимович", 1,320000));
        book1.add(new Employee("Морозов ", "Александр", "Тимофеевич ", 3, 32000));
        book1.add(new Employee("Козлова", "Анна", "Сергеевна",4,550000));
        book1.add(new Employee("Гусева", "Анастасия", "Валерьевна", 5, 550000));
        book1.add(new Employee("Агеева", "Ксения", "Павловна", 1,550000));

        Arrays.stream(employees).forEach(System.out::println);

        printAllEmployees();
        monthlyAmount();
        employeeMaxSalary();
        employeeMinSalary();
        averageSalary();
        printFullNameEmployees();
        indexationSalary(5);
        minSalaryInDepartment(4);
        maxSalaryInDepartment(5);
        departmentalPayrollCosts(5);
        averageSalaryInDepartment(4);
        indexationSalaryInDepartment(5, 5);
        printAllEmployeesInDepartment(4);
        employeeLessSalary(320000);
        employeeMoreSalary(550000);

        System.out.println();
        book1.printAllEmployees();
        book1.monthlyAmount();
        book1.employeeMaxSalary();
        book1.employeeMinSalary();
        book1.averageSalary();
        book1.printFullNameEmployees();
        book1.indexationSalary(5);
        book1.minSalaryInDepartment(1);
        book1.maxSalaryInDepartment(1);
        book1.departmentalPayrollCosts(4);
        book1.averageSalaryInDepartment(1);
        book1.indexationSalaryInDepartment(5,1);
        book1.printAllEmployeesInDepartment(1);
        book1.employeeLessSalary(13500);
        book1.employeeMoreSalary(13500);
        book1.deleteEmployee(3);
        book1.changesEmployee("Агеева", "Ксения", "Павловна", 1,550000);
        book1.printOfDepartments(1);


    }
    private static void printAllEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static void monthlyAmount() {
        int summ = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                summ += employee.getSalary();
            }
        }
        System.out.println("Сумма затрат на зарплату в месяц: " + summ + " рублей.");
    }

    private static void employeeMinSalary() {
        int minSalary = Integer.MAX_VALUE;
        Employee result = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой: " + minSalary + " рублей.");
    }

    private static void employeeMaxSalary() {
        int maxSalary = Integer.MIN_VALUE;
        Employee result = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();

            }
        }
        System.out.println("Сотрудник с максимальной зарплатой: " + maxSalary + " рублей.");
    }

    private static void averageSalary() {
        int peopleCount = 0;
        double sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
                peopleCount++;
            }
        }
        double salaryAverage = sum / peopleCount;
        System.out.println("Средняя зарплата сотрудников: " + salaryAverage + " рублей.");
    }

    private static void printFullNameEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println("Ф.И.О. всех сотрудников: " + employee.getSurName() + employee.getFirstName()
                        + employee.getMiddleName());
            }
        }
    }

    // Повышенная сложность
    /**
     * Создать дополнительные статические методы для решения следующих задач.
     * 1. Проиндексировать зарплату (вызвать изменение зарплат у всех сотрудников на величину аргумента в %).
     * 2. Получить в качестве параметра номер отдела (1–5) и найти (всего 6 методов):
     * a. Сотрудника с минимальной зарплатой.
     * b. Сотрудника с максимальной зарплатой.
     * c. Сумму затрат на зарплату по отделу.
     * d. Среднюю зарплату по отделу (учесть, что количество людей в отделе отличается от employees.length).
     * e. Проиндексировать зарплату всех сотрудников отдела на процент, который приходит в качестве параметра.
     * f. Напечатать всех сотрудников отдела (все данные, кроме отдела).
     * 3. Получить в качестве параметра число и найти:
     * a. Всех сотрудников с зарплатой меньше числа (вывести id, Ф. И. О. и зарплатой в консоль).
     * b. Всех сотрудников с зарплатой больше (или равно) числа (вывести id, Ф. И. О. и зарплатой в консоль).
     */

    private static void indexationSalary(int percent) {
        for (Employee employee : employees) {
            if (employee != null) {
                int increaseSalary = (int) (employee.getSalary() * (percent / 100f * 1) + employee.getSalary());
                employee.setSalary(increaseSalary);
            }
        }
    }

    private static void minSalaryInDepartment(int department) {
        double minSalary = Integer.MAX_VALUE;
        Employee result = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                result = employee;
            }
        }
        if (result != null) {
            System.out.println("Сотрудник отдела № " + department + " с минимальной зарплатой: "
                    + result.getSurName() + result.getFirstName() + result.getMiddleName());
        }
    }

    private static void maxSalaryInDepartment(int department) {
        int maxSalary = Integer.MIN_VALUE;
        Employee result = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                result = employee;
            }
        }
        if (result != null) {
            System.out.println("Сотрудник отдела № " + department + " с максимальной зарплатой: " + result.getSurName()
                    + result.getFirstName() + result.getMiddleName());
        }
    }

    private static void departmentalPayrollCosts(int department) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        System.out.println("Сумму затрат на зарплату по отделу № " + department + " составляет: "
                + sum + " рублей.");
    }

    private static void averageSalaryInDepartment(int department) {
        int peopleCount = 0;
        double sum = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                sum += employee.getSalary();
                peopleCount++;
            }
        }
        double salaryAverage = sum / peopleCount;
        System.out.println("Средняя зарплата сотрудников отдела № " + department + " составляет: "
                + salaryAverage + " рублей.");
    }

    private static void indexationSalaryInDepartment(int percent, int dapartment) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == dapartment) {
                int increaseSalary = (int) (employee.getSalary() * (percent / 100f * 1) + employee.getSalary());
                employee.setSalary(increaseSalary);
            }
        }
    }

    private static void printAllEmployeesInDepartment(int department) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println("Id " + employee.getId() + " Фамилия " + employee.getSurName() +
                        " Имя " + employee.getFirstName() + " Отчество " + employee.getMiddleName() +
                        " Зарплата " + employee.getSalary());
            }
        }
    }

    private static void employeeLessSalary(int salary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < salary) {
                System.out.println("Сотрудники с с зарплатой меньше " + salary + " рублей Id " + employee.getId()
                        + " Фамилия " + employee.getSurName() + " Имя " + employee.getFirstName() + " Отчество "
                        + employee.getMiddleName() + " Зарплата " + employee.getSalary());
            }
        }
    }

    private static void employeeMoreSalary(int salary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > salary) {
                System.out.println("Сотрудники с зарплатой больше (или равно) " + salary + " рублей Id "
                        + employee.getId() + " Фамилия " + employee.getSurName() + " Имя " + employee.getFirstName()
                        + " Отчество " + employee.getMiddleName() + " Зарплата " + employee.getSalary());
            }
        }
    }
}