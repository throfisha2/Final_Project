package com.uryvaeva.menu.button.employeesbutton;

import com.uryvaeva.dao.EmployeesDao;
import com.uryvaeva.menu.MenuItem;

import java.util.Scanner;

public class EmployeesByIdButton implements MenuItem
{
    private final EmployeesDao employeesDao=new EmployeesDao();

    public void run()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("id сотрудника");
        int id = scanner.nextInt();

        System.out.println(employeesDao.findById(id));
    }


    public String getTitle()
    {
        return "Найти сотрудника по id";
    }
}
