package com.uryvaeva;

import com.uryvaeva.dao.DepartmentDao;
import com.uryvaeva.entity.Department;
import com.uryvaeva.menu.Menu;

import java.sql.Connection;
import java.util.List;

/**
 *
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        new Menu().startMenu();
    }
   /* public static void main( String[] args )
    {
        Connection connection=DatabaseConnector.getConnection();
        System.out.println("Успешно");

        System.out.println("Cписок подразделений");

        DepartmentDao d=new DepartmentDao();
        List<Department> departmentList=d.findAll();
        departmentList.forEach(System.out::println);

        System.out.println("-------------------");
        System.out.println(d.findById(1));

       /* Department e=new Department();
        e.setName("Цех 11");
        e.setNumber(11);
        departmentDao.save(e);

        System.out.println("-------------------");

        departmentList=departmentDao.findAll();
        departmentList.forEach(System.out::println); //добавление строки

        e.setNumber(12);
        departmentDao.update(e);

        System.out.println("-------------------");
        departmentList=departmentDao.findAll();
        departmentList.forEach(System.out::println);//обновление строки

        Department d=new Department();
        d.setId(5);
        departmentDao.delete(d);

        System.out.println("-------------------");
        departmentList=departmentDao.findAll();
        departmentList.forEach(System.out::println);//удаление строки
    }*/

}
