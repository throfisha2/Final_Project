package com.uryvaeva.menu.button.projectbutton;
import com.uryvaeva.dao.ProjectsDao;
import com.uryvaeva.menu.MenuItem;

import java.util.Scanner;

public class ProjectByIdButton implements MenuItem
{
    private final ProjectsDao projectsDaoDao = new ProjectsDao();
    @Override
    public void run()
    {
        System.out.println("Введите id проекта ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        System.out.println(projectsDaoDao.findById(id));
    }

    @Override
    public String getTitle()
    {
        return "Найти проект по id";
    }
}
