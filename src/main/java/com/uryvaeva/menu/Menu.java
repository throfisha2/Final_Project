package com.uryvaeva.menu;

import com.uryvaeva.menu.button.departmentbutton.*;
import com.uryvaeva.menu.button.employeesbutton.*;
import com.uryvaeva.menu.button.projectbutton.AllProjectsButton;
import com.uryvaeva.menu.button.projectbutton.ProjectByIdButton;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Menu
{

    private static boolean exitButton = false;
    private static Map<Integer, MenuItem> menu = new TreeMap<>();

    static
    {
        menu.put(-1, () -> exitButton = true);
        menu.put(11, new AllProjectsButton());
        menu.put(12, new ProjectByIdButton());

        menu.put(21, new AllDepartmentButton());
        menu.put(22, new DepartmentByIdButton());
        menu.put(23, new SaveNewDepartmentButton());
        menu.put(24, new UpdateDepartmentButton());
        menu.put(25, new DeleteDepartmentButton());

        menu.put(31, new AllEmployeesButton());
        menu.put(32, new EmployeesByIdButton());
        menu.put(33, new SaveNewEmployeesButton());
        menu.put(34, new UpdateEmployeesButton());
        menu.put(35, new DeleteEmployeesButton());


    }

    public void startMenu()
    {
        Scanner scanner = new Scanner(System.in);
        do
        {
            printMenuChoices();
            Integer choice = scanner.nextInt();
            if (menu.containsKey(choice))
            {
                menu.get(choice).run();
            }
            else
            {
                System.out.println("Выберите одну из команд ");
            }

        }
        while(!exitButton);
    }

    private void printMenuChoices()
    {
        System.out.println("----------------");
        System.out.println("Подтвердите свой выбор : ");
        menu.forEach((k,v) -> System.out.println(k + " - " + v.getTitle()));
    }
}
