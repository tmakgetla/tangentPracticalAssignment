package com.tangent.practicalassignment.presentation.positionData.adapters;

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
import com.tangent.practicalassignment.domain.employees.dto.PositionStats;
import com.tangent.practicalassignment.presentation.MainActivity;
import com.tangent.practicalassignment.presentation.employees.adapters.Adapter;

/**
 * Created by Ans Tech on 7/11/2017.
 */

public class PositionDataAdapter extends RecyclerView.Adapter<PositionDataAdapter.PositionViewHolder> {

    private PositionStats[] positionStats;
    public MainActivity context;
    PositionViewHolder viewHolder;
    int lastPosition = -1;

    public PositionDataAdapter(PositionStats[] positionStats, MainActivity context) {

        this.positionStats = positionStats;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return positionStats.length;
    }

    public void onBindViewHolder(final PositionViewHolder viewHolder,
                                 final int position) {

/*        viewHolder.tvName.setText(positionStats[position].getUser().getFirstName() + " " + positionStats[position].getUser().getLastName());
        Boolean userActive = positionStats[position].getUser().getIsActive();
        if(!userActive){
            viewHolder.ivStatus.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_status_red));
        }*/

        viewHolder.tvPositionTitle.setText(positionStats[position].getTitle());
        viewHolder.tvPositionJuniorCount.setText(String.valueOf(positionStats[position].getJuniorCount()));
        viewHolder.tvPositionSeniorCount.setText(String.valueOf(positionStats[position].getSeniorCount()));
        viewHolder.tvPositionTotalCount.setText(String.valueOf(positionStats[position].getTotalCount()));

        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context,
                    R.anim.up_from_bottom);
            viewHolder.itemView.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public PositionViewHolder onCreateViewHolder(ViewGroup parent,
                                                 int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.position_data_item_list, null,false);

        itemLayoutView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        viewHolder = new PositionViewHolder(itemLayoutView);

        return viewHolder;
    }

    public static class PositionViewHolder extends RecyclerView.ViewHolder {

        public TextView tvPositionTitle;
        public TextView tvPositionTotalCount;
        public TextView tvPositionJuniorCount;
        public TextView tvPositionSeniorCount;

        public PositionViewHolder(View view) {
            super(view);

            tvPositionTitle = (TextView) view.findViewById(R.id.tv_profession_title);
            tvPositionTotalCount= (TextView) view.findViewById(R.id.tv_total_count);
            tvPositionJuniorCount= (TextView) view.findViewById(R.id.tv_junior_count);
            tvPositionSeniorCount= (TextView) view.findViewById(R.id.tv_senior_count);
        }
    }
}