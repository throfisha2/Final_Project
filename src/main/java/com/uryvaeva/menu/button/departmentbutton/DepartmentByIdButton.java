package com.uryvaeva.menu.button.departmentbutton;

import com.uryvaeva.dao.DepartmentDao;
import com.uryvaeva.menu.MenuItem;

import java.util.Scanner;

public class DepartmentByIdButton implements MenuItem
{
    private final DepartmentDao departmentDao=new DepartmentDao();

    public void run()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("id подразделений");
        int id = scanner.nextInt();

        System.out.println(departmentDao.findById(id));
    }


    public String getTitle()
    {
        return "Найти подразделение по id ";
    }
}

