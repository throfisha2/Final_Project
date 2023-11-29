package com.uryvaeva.dao;

import com.uryvaeva.DatabaseConnector;
import com.uryvaeva.entity.Department;
import com.uryvaeva.entity.Projects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao implements CrudDao<Department>
{
    private Connection connection= DatabaseConnector.getConnection();


    public List<Department> findAll()
    {
        List <Department> departments=new ArrayList<>();
        try
        {
            PreparedStatement ps=connection.prepareStatement("select *from department join projects on projects.id=department.project_id");
            ResultSet rs = ps.executeQuery();

             while (rs.next())
             {
                 Department e = new Department();
                 e.setId(rs.getInt(1));
                 e.setName(rs.getString(2));
                 e.setNumber(rs.getInt(3));

                 Projects project = new Projects();
                 project.setId(rs.getInt(4));
                 project.setName(rs.getString(5));

                 e.setProjects(project);

                 departments.add(e);
             }
        } catch (SQLException e)
        {
            e.printStackTrace();
       }
       return departments;
    }


    public Department findById(int id)
    {
        Department department=new Department();
        String sql = "select * from department join projects on projects.id = department.project_id where department.id = ?";

        try
        {
           PreparedStatement ps = connection.prepareStatement(sql);
           ps.setInt(1, id);
           ResultSet rs = ps.executeQuery();

           while (rs.next())
            {
                department.setId(rs.getInt(1));
                department.setName(rs.getString(2));
                department.setNumber(rs.getInt(3));

                Projects project = new Projects();
                project.setId(rs.getInt(4));
                project.setName(rs.getString(5));

                department.setProjects(project);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return department;
    }


    public Department save(Department entity)
    {
        try
        {
            PreparedStatement ps = connection.prepareStatement("insert into department (name, number, project_id) values (?,?,?)");
            ps.setString(1, entity.getName());
            ps.setInt(2,entity.getNumber());
            ps.setInt(3, entity.getProjects().getId());

            ps.executeUpdate();

            PreparedStatement pst = connection.prepareStatement("select id from department where name = ? AND number = ?");
            pst.setString(1, entity.getName() );
            pst.setInt(2, entity.getNumber());
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


    public void update(Department entity)
    {
        try
        {
            PreparedStatement ps = connection.prepareStatement("update department set name = ?, number = ?, project_id=? where id = ?");
            ps.setString(1, entity.getName());
            ps.setInt(2,entity.getNumber());
            ps.setInt(3, entity.getProjects().getId());
            ps.setInt(4, entity.getId());

            ps.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


    public void delete(Department entity)
    {
        try
        {
            PreparedStatement ps = connection.prepareStatement("delete from department where id = ?");
            ps.setInt(1, entity.getId());
            ps.execute();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
