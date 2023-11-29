package com.uryvaeva.menu.button.departmentbutton;
import com.uryvaeva.dao.DepartmentDao;
import com.uryvaeva.entity.Department;
import com.uryvaeva.entity.Projects;
import com.uryvaeva.menu.MenuItem;

import java.util.Scanner;

public class UpdateDepartmentButton implements MenuItem
{

    private final DepartmentDao departmentDao=new DepartmentDao();

    public void run()
    {
        Department c=updateDepartment();
        departmentDao.update(c);
    }


    public String getTitle()
    {
        return "Изменить подразделение";
    }

    private Department updateDepartment()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите id подразделения для внесения изменений");
        int id = scanner.nextInt();

        Department e = departmentDao.findById(id);
        System.out.println(e);

        System.out.println("Редактор подразделения:");

        System.out.println("Введите имя подразделения (ввведите \"old\" для предыдущего значения)");
        String s = scanner.next();
        if(!s.equals("old"))
        {
            e.setName(s);
        }

        System.out.println("Введите шифр подразделения (ввведите \"-1\" для предыдущего значения)");
        int number = scanner.nextInt();
        if(number != -1)
        {
            e.setNumber(number);
        }

        System.out.println("Введите id проекта подразделения (ввведите \"-1\" для предыдущего значения)");
        Projects p = new Projects();
        int pId = scanner.nextInt();

        if(pId != -1)
        {
            p.setId(pId);
            e.setProjects(p);
        }
        return e;
    }
}
