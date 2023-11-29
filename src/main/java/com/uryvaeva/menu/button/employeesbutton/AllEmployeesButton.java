package com.uryvaeva.menu.button.employeesbutton;

import com.uryvaeva.dao.EmployeesDao;
import com.uryvaeva.menu.MenuItem;

public class AllEmployeesButton implements MenuItem
{
    private final EmployeesDao employeesDao=new EmployeesDao();

    public void run()
    {
        System.out.println("Список всех сотрудников: ");
        employeesDao.findAll().forEach(System.out::println);
    }

    public String getTitle()
    {
        return "Список всех сотрудников";
    }
}
