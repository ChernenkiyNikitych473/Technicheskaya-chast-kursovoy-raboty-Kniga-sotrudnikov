public class EmployeeBook {
    
    /**
     * Привести структуру проекта к ООП.
     * 1. Создать класс EmployeeBook.
     * 2. Перенести хранилище сотрудников в него (массив), закрыть к нему доступ извне (сделать приватным).
     * 3. Все статические методы по работе с массивом перенести в этот класс и сделать нестатическими.
     * 4. Добавить несколько новых методов:
     * 1. Добавить нового сотрудника (создаем объект, заполняем поля, кладем в массив).
     * Нужно найти свободную ячейку в массиве и добавить нового сотрудника в нее. Искать нужно всегда с начала,
     * так как возможно добавление в ячейку удаленных ранее сотрудников.
     * 2. Удалить сотрудника (находим сотрудника по Ф. И. О. и/или id, обнуляем его ячейку в массиве).
     * 5. Изменить сотрудника (получить сотрудника по Ф. И. О., модернизировать его запись):
     * 1. Изменить зарплату.
     * 2. Изменить отдел.
     * Придумать архитектуру. Сделать или два метода, или один, но продумать его.
     * 6. Получить Ф. И. О. всех сотрудников по отделам (напечатать список отделов и их сотрудников).
     */

    private Employee[] employees = new Employee[10];

    public EmployeeBook (int size) {
        employees = new Employee[size];
    }

    public boolean add (Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return true;
            }
        }
        return false;
    }

    public void printAllEmployees () {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void monthlyAmount () {
        int summ = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                summ += employee.getSalary();
            }
        }
        System.out.println("Сумма затрат на зарплату в месяц: " + summ + " рублей.");
    }

    public void employeeMinSalary () {
        int minSalary = Integer.MAX_VALUE;
        Employee result = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
            }
        }
        System.out.println("Сотрудник с минимальной зарплатой: " + minSalary + " рублей.");
    }

    public void employeeMaxSalary () {
        int maxSalary = Integer.MIN_VALUE;
        Employee result = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();

            }
        }
        System.out.println("Сотрудник с максимальной зарплатой: " + maxSalary + " рублей.");
    }

    public void averageSalary () {
        int peopleCount = 0;
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
                peopleCount++;
            }
        }
        float salaryAverage = sum / peopleCount;
        System.out.println("Средняя зарплата сотрудников: " + salaryAverage + " рублей.");
    }

    public void printFullNameEmployees () {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println("Ф.И.О. всех сотрудников: " + employee.getSurName() + employee.getFirstName()
                        + employee.getMiddleName());
            }
        }
    }

    public void indexationSalary (int percent) {
        for (Employee employee : employees) {
            if (employee != null) {
                int increaseSalary = (int) (employee.getSalary() * (percent / 100f * 1) + employee.getSalary());
                employee.setSalary(increaseSalary);
                System.out.println(increaseSalary);
            }
        }
    }

    public void minSalaryInDepartment (int department) {
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

    public void maxSalaryInDepartment (int department) {
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

    public void departmentalPayrollCosts (int department) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        System.out.println("Сумму затрат на зарплату по отделу № " + department + " составляет: "
                + sum + " рублей.");
    }

    public void averageSalaryInDepartment (int department) {
        int peopleCount = 0;
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                sum += employee.getSalary();
                peopleCount++;
            }
        }
        float salaryAverage = sum / peopleCount;
        System.out.println("Средняя зарплата сотрудников отдела № " + department + " составляет: "
                + salaryAverage + " рублей.");
    }

    public void indexationSalaryInDepartment (int percent, int dapartment) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == dapartment) {
                int increaseSalary = (int) (employee.getSalary() * (percent / 100f * 1) + employee.getSalary());
                employee.setSalary(increaseSalary);
                System.out.println(increaseSalary);
            }
        }
    }

    public void printAllEmployeesInDepartment (int department) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println("Id " + employee.getId() + " Фамилия " + employee.getSurName() +
                        " Имя " + employee.getFirstName() + " Отчество " + employee.getMiddleName() +
                        " Зарплата " + employee.getSalary());
            }
        }
    }

    public void employeeLessSalary (int salary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < salary) {
                System.out.println("Сотрудники с с зарплатой меньше " + salary + " рублей Id " + employee.getId()
                        + " Фамилия " + employee.getSurName() + " Имя " + employee.getFirstName() + " Отчество "
                        + employee.getMiddleName() + " Зарплата " + employee.getSalary());
            }
        }
    }

    public void employeeMoreSalary (int salary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > salary) {
                System.out.println("Сотрудники с зарплатой больше (или равно) " + salary + " рублей Id "
                        + employee.getId() + " Фамилия " + employee.getSurName() + " Имя " + employee.getFirstName()
                        + " Отчество " + employee.getMiddleName() + " Зарплата " + employee.getSalary());
            }
        }
    }

    public void deleteEmployee (int i) {
    }

    public void changesEmployee (String агеева, String ксения, String павловна, int i, int i1) {
    }

    public void printOfDepartments (int i) {
    }
}
