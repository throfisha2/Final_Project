package com.uryvaeva.menu.button.employeesbutton;

import com.uryvaeva.dao.EmployeesDao;
import com.uryvaeva.entity.Department;
import com.uryvaeva.entity.Employees;
import com.uryvaeva.menu.MenuItem;

import java.util.Scanner;

public class UpdateEmployeesButton implements MenuItem
{
    private final EmployeesDao employeesDao=new EmployeesDao();

    public void run()
    {
        Employees c=updateEmployees();
        employeesDao.update(c);
    }


    public String getTitle()
    {
        return "Изменить данные о сотруднике";
    }

    private Employees updateEmployees()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите id сотрудника для внесения изменений");
        int id = scanner.nextInt();

        Employees e = employeesDao.findById(id);
        System.out.println(e);

        System.out.println("Редактор данных сотрудника:");

        System.out.println("Введите имя сотрудника (введите \"old\" для предыдущего значения)");
        String s = scanner.next();
        if(!s.equals("old"))
        {
            e.setFirstName(s);
        }

        System.out.println("Введите фамилию сотрудника (введите \"old\" для предыдущего значения)");
        String s1 = scanner.next();
        if(!s1.equals("old"))
        {
            e.setLastName(s1);
        }

        System.out.println("Введите должность сотрудника (введите \"old\" для предыдущего значения)");
        String s2 = scanner.next();
        if(!s2.equals("old"))
        {
            e.setPosition(s2);
        }


        System.out.println("Введите id подразделения (введите \"-1\" для предыдущего значения)");
        Department p = new Department();
        int pId = scanner.nextInt();

        if(pId != -1)
        {
            p.setId(pId);
            e.setDepartment(p);
        }
        return e;
    }
}
