package com.uryvaeva.menu.button.employeesbutton;

import com.uryvaeva.dao.EmployeesDao;
import com.uryvaeva.entity.Employees;
import com.uryvaeva.entity.Department;
import com.uryvaeva.menu.MenuItem;

import java.util.Scanner;

public class SaveNewEmployeesButton implements MenuItem
{
    private final EmployeesDao employeesDao=new EmployeesDao();

    public void run()
    {
        Employees e = inputNewEmployee();
        e = employeesDao.save(e);
        System.out.println(e);
    }


    public String getTitle()
    {
        return "Добавить нового сотрудника";
    }

    private Employees inputNewEmployee()
    {
        Scanner scanner = new Scanner(System.in);
        Employees e = new Employees();
        System.out.println("Введите имя сотрудника");
        e.setFirstName(scanner.nextLine());
        System.out.println("Введите фамилию сотрудника");
        e.setLastName(scanner.nextLine());
        System.out.println("Введите должность сотрудника");
        e.setPosition(scanner.nextLine());
        System.out.println("Введите id подразделения");
        Department p = new Department();
        p.setId(scanner.nextInt());
        e.setDepartment(p);

        return e;
    }
}
