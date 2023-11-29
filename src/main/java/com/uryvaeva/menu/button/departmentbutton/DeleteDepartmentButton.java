package com.uryvaeva.menu.button.departmentbutton;

import com.uryvaeva.dao.DepartmentDao;
import com.uryvaeva.entity.Department;
import com.uryvaeva.menu.MenuItem;
import java.util.Scanner;

public class DeleteDepartmentButton implements MenuItem
{
    private final DepartmentDao departmentDao=new DepartmentDao();


    public void run()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id");
        int id = scanner.nextInt();
        Department e = new Department();
        e.setId(id);
        departmentDao.delete(e);
    }


    public String getTitle()
    {
        return "Удалить подразделение по id";
    }
}
