package com.uryvaeva.entity;

public class Projects
{
    private int id;
    private String name;

    public Projects()
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
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Projects{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
