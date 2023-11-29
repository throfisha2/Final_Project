package com.uryvaeva.dao;

import com.uryvaeva.DatabaseConnector;
import com.uryvaeva.entity.Projects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectsDao implements CrudDao<Projects>
{
    private final Connection connection = DatabaseConnector.getConnection();
    @Override
    public List<Projects> findAll()
    {
        List<Projects> projects = new ArrayList<>();

        try
        {
            PreparedStatement ps = connection.prepareStatement("select * from projects");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Projects project = new Projects();
                project.setId(rs.getInt(1));
                project.setName(rs.getString(2));

                projects.add(project);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return projects;
    }

    @Override
    public Projects findById(int id)
    {
        Projects project = new Projects();
        try
        {
            PreparedStatement ps = connection.prepareStatement("select * from projects where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                project.setId(rs.getInt(1));
                project.setName(rs.getString(2));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return project;
    }

    @Override
    public Projects save(Projects entity)
    {
        return null;
    }

    @Override
    public void update(Projects entity)
    {

    }

    @Override
    public void delete(Projects entity)
    {

    }
}
