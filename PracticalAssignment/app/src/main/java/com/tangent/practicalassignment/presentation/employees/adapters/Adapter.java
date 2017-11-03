package com.tangent.practicalassignment.presentation.employees.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.tangent.practicalassignment.R;

import java.util.List;

/**
 * Created by Ans Tech on 3/11/2017.
 */

public class Adapter  extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<String> list ;
    public Context context;
    ViewHolder viewHolder;
    int lastPosition = -1;

    public Adapter(List<String> list, Context context) {

        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void onBindViewHolder(final ViewHolder viewHolder,
                                 final int position ) {

        viewHolder.textView.setText(list.get(position));
        Picasso.with(context).load(R.drawable.ic_profile)
                .into(viewHolder.imageView);
        viewHolder.textView.setOnClickListener(new
                                                       View.OnClickListener() {

                                                           @Override
                                                           public void onClick(View v) {
                                                               Toast.makeText(v.getContext(),
                                                                       "OnClick :" + list.get(position),
                                                                       Toast.LENGTH_SHORT).show();

                                                           }
                                                       });

        if(position >lastPosition) {

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

        public TextView textView;
        public ImageView imageView;

        public ViewHolder(View view) {
            super(view);

            textView = (TextView) view.findViewById(R.id.text);
            imageView = (ImageView) view.findViewById(R.id.image);
        }
    }
}