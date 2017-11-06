package com.tangent.practicalassignment.presentation.employees.adapters;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tangent.practicalassignment.R;
import com.tangent.practicalassignment.domain.employees.Employees;
import com.tangent.practicalassignment.presentation.MainActivity;

/**
 * Created by Ans Tech on 3/11/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Employees[] employees;
    public MainActivity context;
    ViewHolder viewHolder;
    int lastPosition = -1;

    public Adapter(Employees[] employees, MainActivity context) {

        this.employees = employees;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return employees.length;
    }

    public void onBindViewHolder(final ViewHolder viewHolder,
                                 final int position) {

        viewHolder.tvName.setText(employees[position].getUser().getFirstName() + " " + employees[position].getUser().getLastName());
        Boolean userActive = employees[position].getUser().getIsActive();
        if(!userActive){
            viewHolder.ivStatus.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_status_red));
        }

        viewHolder.llRow.setOnClickListener(new
        View.OnClickListener() {
           @Override
            public void onClick(View v) {
                context.navigateToUserProfileScreen(employees[position]);
            }
        });

        if (position > lastPosition) {

            Animation animation = AnimationUtils.loadAnimation(context,
                    R.anim.up_from_bottom);
            viewHolder.itemView.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                 int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, null,false);

        itemLayoutView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        viewHolder = new ViewHolder(itemLayoutView);

        return viewHolder;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public ImageView ivProfilePic;
        public ImageView ivStatus;
        public LinearLayout llRow;

        public ViewHolder(View view) {
            super(view);

            tvName = (TextView) view.findViewById(R.id.tv_name);
            ivProfilePic = (ImageView) view.findViewById(R.id.iv_profile_pic);
            ivStatus = (ImageView) view.findViewById(R.id.iv_status);
            llRow = (LinearLayout) view.findViewById(R.id.ll_user_row);

        }
    }
}