package com.kuy.application.features.trainmap;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kuy.application.R;
import com.kuy.application.features.hotellist.HotelListAdapter;
import com.kuy.application.models.Plan;
import com.kuy.application.models.Section;

/**
 * Created by gilang on 5/2/17.
 */

public class TrainStepAdapter extends RecyclerView.Adapter<TrainStepAdapter.BaseViewHolder> {
    private Context context;
    private Plan plan;

    private TrainStepAdapter.OnItemClickListener listener;

    public TrainStepAdapter(Context context, Plan plan, TrainStepAdapter.OnItemClickListener listener) {
        this.context = context;
        this.plan = plan;
        this.listener = listener;

        Section first = plan.getSections().get(0);
        first.setFromTime(plan.getSummary().getMove().getFromTime());

        Section last = plan.getSections().get(plan.getSections().size()-1);
        last.setFromTime(plan.getSummary().getMove().getToTime());

        for(int i = 2; i < plan.getSections().size()-2; i = i + 2) {
            Section s = plan.getSections().get(i);
            s.setFromTime(plan.getSections().get(i-1).getToTime());
            s.setToTime(plan.getSections().get(i+1).getFromTime());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Section item);
    }

    @Override
    public int getItemViewType(int position) {
        Section section = plan.getSections().get(position);
        return section.getType().equals("point") ? 0 : 1;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item_point, parent, false);

            BaseViewHolder vh = new PointViewHolder(context, v);
            return vh;
        }
        else {
            LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item_move, parent, false);

            BaseViewHolder vh = new MoveViewHolder(context, v);
            return vh;
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        Section section = plan.getSections().get(position);
        if (holder instanceof PointViewHolder) {
            PointViewHolder vh = (PointViewHolder) holder;
            vh.bind(section, listener);
        }
        else {
            MoveViewHolder vh = (MoveViewHolder) holder;
            vh.bind(section, listener);
        }
    }

    @Override
    public int getItemCount() {
        return plan != null && plan.getSections() != null ? plan.getSections().size() : 0;
    }

    public static abstract class BaseViewHolder extends RecyclerView.ViewHolder {

        public Context context;
        public BaseViewHolder(Context context, View view) {
            super(view);
            this.context = context;
        }

    }

    public static class PointViewHolder extends BaseViewHolder {

        public TextView time_from;
        public TextView time_to;
        public TextView station_name;

        public PointViewHolder(Context context, View v) {
            super(context, v);
            this.context = context;
            time_from = (TextView) v.findViewById(R.id.textview_time_from);
            time_to = (TextView) v.findViewById(R.id.textview_time_to);
            station_name = (TextView) v.findViewById(R.id.textview_station_name);
        }

        public void bind(final Section section, final TrainStepAdapter.OnItemClickListener listener) {

            if (section.getFromTime() != null) {
                String[] from = section.getFromTime().split("T");
                time_from.setText(from[1].substring(0, 5));
                time_from.setVisibility(View.VISIBLE);
            }
            else {
                time_from.setVisibility(View.GONE);
            }

            if (section.getToTime() != null) {
                String[] to = section.getToTime().split("T");
                time_to.setText(to[1].substring(0, 5));
                time_to.setVisibility(View.VISIBLE);
            }
            else {
                time_to.setVisibility(View.GONE);
            }

            station_name.setText(section.getNodeName());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(section);
                }
            });
        }

    }

    public static class MoveViewHolder extends BaseViewHolder {

        public TextView time_travel;
        public TextView operation_name;
        public TextView info;

        public MoveViewHolder(Context context, View v) {
            super(context, v);
            time_travel = (TextView) v.findViewById(R.id.textview_time_travel);
            operation_name = (TextView) v.findViewById(R.id.textview_operation_name);
            info = (TextView) v.findViewById(R.id.textview_info);
        }

        public void bind(final Section section, final TrainStepAdapter.OnItemClickListener listener) {
            time_travel.setText("" + section.getTime());
            operation_name.setText(section.getOperationName());
            info.setText(section.getMove());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(section);
                }
            });
        }

    }
}
