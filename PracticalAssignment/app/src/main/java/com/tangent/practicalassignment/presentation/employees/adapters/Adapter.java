package com.tangent.practicalassignment.presentation.employees.adapters;

import android.content.Context;
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
import android.widget.Toast;

import com.tangent.practicalassignment.R;
import com.tangent.practicalassignment.domain.employees.Employees;

/**
 * Created by Ans Tech on 3/11/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Employees[] list;
    public Context context;
    ViewHolder viewHolder;
    int lastPosition = -1;

    public Adapter(Employees[] list, Context context) {

        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return list.length;
    }

    public void onBindViewHolder(final ViewHolder viewHolder,
                                 final int position) {

        viewHolder.tvName.setText(list[position].getUser().getFirstName() + " " + list[position].getUser().getLastName());
        Boolean userActive = list[position].getUser().getIsActive();
        if(!userActive){
            viewHolder.ivStatus.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_status_red));
        }

        viewHolder.llRow.setOnClickListener(new
        View.OnClickListener() {
           @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),
                        "OnClick :" + list[position].getUser().getFirstName() ,
                        Toast.LENGTH_SHORT).show();

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
                .inflate(R.layout.item_list, null);

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