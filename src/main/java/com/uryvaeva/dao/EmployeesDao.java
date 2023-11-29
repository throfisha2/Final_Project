package com.uryvaeva.dao;

import com.uryvaeva.DatabaseConnector;
import com.uryvaeva.entity.Department;
import com.uryvaeva.entity.Employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDao implements CrudDao<Employees>
{
    private Connection connection= DatabaseConnector.getConnection();

    public List<Employees> findAll()
    {
        List <Employees> employees=new ArrayList<>();
        try
        {
            PreparedStatement ps=connection.prepareStatement("select *from employees join department on department.id=employees.department_id");
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                Employees e = new Employees();
                e.setId(rs.getInt(1));
                e.setFirstName(rs.getString(2));
                e.setLastName(rs.getString(3));
                e.setPosition(rs.getString(4));

                Department department=new Department();
                department.setId(rs.getInt(5));
                department.setName(rs.getString(6));
                department.setNumber(rs.getInt(8));

                employees.add(e);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return employees;
    }

    public Employees findById(int id)
    {
        Employees employee=new Employees();
        String sql = "select * from employees join department on department.id = employees.department_id where employees.id = ?";

        try
        {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                employee.setId(rs.getInt(1));
                employee.setFirstName(rs.getString(2));
                employee.setLastName(rs.getString(3));
                employee.setPosition(rs.getString(4));

                Department department=new Department();
                department.setId(rs.getInt(5));
                department.setName(rs.getString(6));
                department.setNumber(rs.getInt(7));

                employee.setDepartment(department);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return employee;
    }

    public Employees save(Employees entity)
    {
        try
        {
            PreparedStatement ps = connection.prepareStatement("insert into employees (firstname, lastname, position, department_id) values (?,?,?,?)");
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getLastName());
            ps.setString(3, entity.getPosition());
            ps.setInt(4, entity.getDepartment().getId());

            ps.executeUpdate();

            PreparedStatement pst = connection.prepareStatement("select id from employees where firstname=? AND lastname=? AND position=?");
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getLastName());
            ps.setString(3, entity.getPosition());
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                entity.setId(rs.getInt(1));
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return entity;
    }

    public void update(Employees entity)
    {
        try
        {
            PreparedStatement ps = connection.prepareStatement("update employees set firstname=?, lastname=?, position=?, department_id = ? where id = ?");
            ps.setString(1, entity.getFirstName());
            ps.setString(2, entity.getLastName());
            ps.setString(3, entity.getPosition());
            ps.setInt(4, entity.getDepartment().getId());
            ps.setInt(5, entity.getId());

            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void delete(Employees entity)
    {
        try
        {
            PreparedStatement ps = connection.prepareStatement("delete from employees where id = ?");
            ps.setInt(1, entity.getId());
            ps.execute();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
