package com.uryvaeva.menu.button.projectbutton;

import com.uryvaeva.dao.ProjectsDao;
import com.uryvaeva.menu.MenuItem;
public class AllProjectsButton implements MenuItem
{

    private final ProjectsDao positionDao = new ProjectsDao();

    public void run() {
        System.out.println("Список всех проектов");
        positionDao.findAll().forEach(System.out::println);
    }


    public String getTitle() {
        return "Показать все проекты";
    }
}
