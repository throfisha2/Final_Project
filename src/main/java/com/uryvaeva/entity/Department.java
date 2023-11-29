package com.uryvaeva.entity;


public class Department
{
    private int id;
    private String Name;
    private int Number;
    private Projects Projects;

    public Department()
    {

    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return Name;
    }

    public void setName(String name)
    {
        Name = name;
    }

    public int getNumber()
    {
        return Number;
    }

    public void setNumber(int number)
    {
        Number = number;
    }

    public com.uryvaeva.entity.Projects getProjects()
    {
        return Projects;
    }

    public void setProjects(com.uryvaeva.entity.Projects projects)
    {
        Projects = projects;
    }


    @Override
    public String toString()
    {
        return "Department{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Number=" + Number +
                ", Projects=" + Projects +
                '}';
    }
}
