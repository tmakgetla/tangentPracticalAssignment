package com.tangent.practicalassignment.domain.employees.dto;

/**
 * Created by Ans Tech on 30/10/2017.
 */

public class Position {
    private int id;

    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }

    private String name;

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }

    private String level;

    public String getLevel() { return this.level; }

    public void setLevel(String level) { this.level = level; }

    private int sort;

    public int getSort() { return this.sort; }

    public void setSort(int sort) { this.sort = sort; }
}
