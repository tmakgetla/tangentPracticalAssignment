package com.tangent.practicalassignment.presentation.statistics;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;
import com.tangent.practicalassignment.R;
import com.tangent.practicalassignment.domain.employees.Employees;
import com.tangent.practicalassignment.presentation.MainActivity;
import com.tangent.practicalassignment.presentation.statistics.interfaces.StatisticsFragmentInterface;
import com.tangent.practicalassignment.presentation.userProfile.UserProfileFragment;
import com.tangent.practicalassignment.utils.AppCache;
import com.tangent.practicalassignment.utils.Calculator;

/**
 * Created by Ans Tech on 5/11/2017.
 */

public class StatisticsFragment extends Fragment implements StatisticsFragmentInterface{
    private MainActivity mainActivity;
    private View rootView;
    private GraphView graph;
    private TextView tvWomenCount;
    private TextView tvMenCount;

    public StatisticsFragment(){}

    public static StatisticsFragment newInstance(MainActivity mainActivity){
        StatisticsFragment statisticsFragment = new StatisticsFragment();
        statisticsFragment.mainActivity = mainActivity;
        return statisticsFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.statistic_fragment, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        wireUpViews();
        setUpListeners();
        loadDataPoints();
        setGenderCount();
    }

    private void wireUpViews(){
        graph = (GraphView) rootView.findViewById(R.id.graph);
        tvMenCount = rootView.findViewById(R.id.tv_male);
        tvWomenCount = rootView.findViewById(R.id.tv_female);
    }

    @Override
    public void loadDataPoints(){
        LineGraphSeries<DataPoint> series = Calculator.calculateEmployeesExperience(AppCache.employees);
        PointsGraphSeries<DataPoint> series2 = Calculator.calculateEmployeesExperience2(AppCache.employees);

        graph.setTitle("Employees Experience :");
        graph.addSeries(series2);
        graph.addSeries(series);
    }

    @Override
    public void setGenderCount(){
        String numberOfWomen = String.valueOf(Calculator.calculateNumberOfWomen(AppCache.employees));
        String numberOfMen = String.valueOf(Calculator.calculateNumberOfMen(AppCache.employees));
        tvWomenCount.setText(numberOfWomen);
        tvMenCount.setText(numberOfMen);
    }

    private void setUpListeners(){
    }
}
