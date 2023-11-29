package com.uryvaeva.menu;

public interface MenuItem
{
    void run();
    default String getTitle()
    {
        return "Выход";
    }
}
