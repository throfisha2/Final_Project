package com.uryvaeva.menu.button.employeesbutton;

import com.uryvaeva.dao.EmployeesDao;
import com.uryvaeva.entity.Employees;
import com.uryvaeva.menu.MenuItem;

import java.util.Scanner;

public class DeleteEmployeesButton implements MenuItem
{
    private final EmployeesDao employeesDao=new EmployeesDao();

    public void run()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id");
        int id = scanner.nextInt();
        Employees e = new Employees();
        e.setId(id);
        employeesDao.delete(e);
    }


    public String getTitle()
    {
        return "Удалить работника по id";
    }

}
