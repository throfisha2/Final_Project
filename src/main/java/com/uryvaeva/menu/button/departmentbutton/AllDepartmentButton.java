package com.uryvaeva.menu.button.departmentbutton;

import com.uryvaeva.dao.DepartmentDao;
import com.uryvaeva.menu.MenuItem;

public class AllDepartmentButton implements MenuItem
{
    private final DepartmentDao departmentDao=new DepartmentDao();

    public void run()
    {
        System.out.println("Список всех подразделений: ");
        departmentDao.findAll().forEach(System.out::println);
    }

    public String getTitle()
    {
        return "Список всех подразделений";
    }
}
