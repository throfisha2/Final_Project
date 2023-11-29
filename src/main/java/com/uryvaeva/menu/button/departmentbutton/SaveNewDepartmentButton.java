package com.uryvaeva.menu.button.departmentbutton;

import com.uryvaeva.dao.DepartmentDao;
import com.uryvaeva.entity.Department;
import com.uryvaeva.entity.Projects;
import com.uryvaeva.menu.MenuItem;

import java.util.Scanner;

public class SaveNewDepartmentButton implements MenuItem
{
    private final DepartmentDao departmentDao=new DepartmentDao();

    @Override
    public void run() {
        Department e = inputNewDepartment();
        e = departmentDao.save(e);
        System.out.println(e);
    }

    @Override
    public String getTitle() {
        return "Добавить новое подразделение";
    }

    private Department inputNewDepartment()
    {
        Scanner scanner = new Scanner(System.in);
        Department e = new Department();
        System.out.println("Введите название подразделения ");
        e.setName(scanner.nextLine());
        System.out.println("Введите шифр подразделения ");
        e.setNumber(scanner.nextInt());
        System.out.println("Введите id проекта ");
        Projects p = new  Projects();
        p.setId(scanner.nextInt());
        e.setProjects(p);

        return e;
    }
}
