package com.tangent.practicalassignment.domain.employees.dto;

/**
 * Created by Ans Tech on 7/11/2017.
 */

public class PositionStats {
    private String title;
    private int totalCount = 0;
    private int juniorCount = 0;
    private int seniorCount = 0;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = this.totalCount + totalCount;
    }

    public int getJuniorCount() {
        return juniorCount;
    }

    public void setJuniorCount(int juniorCount) {
        this.juniorCount = this.juniorCount + juniorCount;
    }

    public int getSeniorCount() {
        return seniorCount;
    }

    public void setSeniorCount(int seniorCount) {
        this.seniorCount = this.seniorCount + seniorCount;
    }
}
