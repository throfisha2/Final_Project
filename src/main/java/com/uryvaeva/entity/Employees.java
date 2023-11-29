package com.uryvaeva.entity;

public class Employees
{
    private int id;
    private String FirstName;
    private String LastName;
    private String Position;
    private Department Department;


    public Employees()
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

    public String getFirstName()
    {
        return FirstName;
    }

    public void setFirstName(String firstName)
    {
        FirstName = firstName;
    }

    public String getLastName()
    {
        return LastName;
    }

    public void setLastName(String lastName)
    {
        LastName = lastName;
    }

    public String getPosition()
    {
        return Position;
    }

    public void setPosition(String position)
    {
        Position = position;
    }

    public com.uryvaeva.entity.Department getDepartment()
    {
        return Department;
    }

    public void setDepartment(com.uryvaeva.entity.Department department)
    {
        Department = department;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Position='" + Position + '\'' +
                ", Department=" + Department +
                '}';
    }
}
