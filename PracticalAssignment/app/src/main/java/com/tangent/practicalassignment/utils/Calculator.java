package com.tangent.practicalassignment.utils;

import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;
import com.tangent.practicalassignment.domain.employees.Employees;
import com.tangent.practicalassignment.domain.employees.dto.Position;
import com.tangent.practicalassignment.domain.employees.dto.PositionStats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Ans Tech on 5/11/2017.
 */

public class Calculator {

    public static int calculateNumberOfWomen(Employees[] employees){
        int results = 0;
        for(Employees employee : employees){
            if(employee.getGender().equalsIgnoreCase("f")){
                results++;
            }
        }
        return results;
    }

    public static int calculateNumberOfMen(Employees[] employees){
        int results = 0;
        for(Employees employee : employees){
            if(employee.getGender().equalsIgnoreCase("m")){
                results++;
            }
        }
        return results;
    }

    public static PositionStats[] calculatePositionDataStats(Employees[] employees){
        Map<String,PositionStats> positionStats = new HashMap<String, PositionStats>();
        Position employeePosition;
        for(Employees employee : employees){
            employeePosition = employee.getPosition();
            if(positionStats.containsKey(employeePosition.getName())){
                positionStats.get(employeePosition.getName()).setTotalCount(1);
                if("junior".equalsIgnoreCase(employeePosition.getLevel())){
                    positionStats.get(employeePosition.getName()).setJuniorCount(1);
                }else if("Senior".equalsIgnoreCase(employeePosition.getLevel())){
                    positionStats.get(employeePosition.getName()).setSeniorCount(1);
                }
            }else {
                PositionStats newPositionStats =  new PositionStats();
                newPositionStats.setTotalCount(1);
                newPositionStats.setTitle(employeePosition.getName());
                if("junior".equalsIgnoreCase(employeePosition.getLevel())){
                    newPositionStats.setJuniorCount(1);
                }else if("Senior".equalsIgnoreCase(employeePosition.getLevel())){
                    newPositionStats.setSeniorCount(1);
                }
                positionStats.put(employeePosition.getName(), newPositionStats);
            }
        }

        return getPositionStatsList(positionStats);
    }

    private static PositionStats[] getPositionStatsList(Map<String,PositionStats> positionStats){
        PositionStats[] results = new PositionStats[positionStats.size()];
        Iterator it = positionStats.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            results[i] = (PositionStats) pair.getValue();
            it.remove();
            i++;
        }
        return results;
    }

    public static LineGraphSeries<DataPoint> calculateEmployeesExperience(Employees[] employees){
        int[] entries = initializeArr();

        int employeeExperience;

        for(Employees employee : employees){
            employeeExperience = employee.getYearsWorked();
            if(entries[employeeExperience] == -1){
                entries[employeeExperience] = 0;
                entries[employeeExperience] = entries[employeeExperience] + 1;
            } else {
                entries[employeeExperience] = entries[employeeExperience] + 1;
            }
        }

        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>();

        for(int i=0;i<entries.length;i++){
            if(entries[i] != -1){
                series.appendData(new DataPoint(i, entries[i]), true, 12);
            }
        }

        return series;
    }

    public static PointsGraphSeries<DataPoint> calculateEmployeesExperience2(Employees[] employees){
        int[] entries = initializeArr();

        int employeeExperience;

        for(Employees employee : employees){
            employeeExperience = employee.getYearsWorked();
            if(entries[employeeExperience] == -1){
                entries[employeeExperience] = 0;
                entries[employeeExperience] = entries[employeeExperience] + 1;
            } else {
                entries[employeeExperience] = entries[employeeExperience] + 1;
            }
        }

        PointsGraphSeries<DataPoint> series = new PointsGraphSeries<DataPoint>();

        for(int i=0;i<entries.length;i++){
            if(entries[i] != -1){
                series.appendData(new DataPoint(i, entries[i]), true, 12);
            }
        }

        return series;
    }

    private static int[] initializeArr(){
        int[] entries = new int[70];
        for(int i=0;i<entries.length;i++){
            entries[i] = -1;
        }
        return entries;
    }
}
