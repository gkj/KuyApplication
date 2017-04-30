package com.kuy.application.features.hotellist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kuy.application.R;
import com.kuy.application.models.Hotel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by gilang on 4/29/17.
 */

public class HotelListAdapter extends RecyclerView.Adapter<HotelListAdapter.ViewHolder> {

    private HotelListActivity context;
    private List<Hotel> dataset;

    private OnItemClickListener listener;

    public HotelListAdapter(HotelListActivity context, List<Hotel> dataset, OnItemClickListener listener) {
        this.context = context;
        this.dataset = dataset;
        this.listener = listener;
    }

    public void updateDataset(List<Hotel> dataset) {
        this.dataset = dataset;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(Hotel item);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hotel_list_item, parent, false);

        ViewHolder vh = new ViewHolder(context, v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Hotel hotel = dataset.get(position);
        holder.bind(hotel, listener);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public HotelListActivity context;
        public ImageView thumbnail;
        public TextView name;
        public TextView price;
        public TextView address;
        public TextView city;
        public TextView postalCode;


        public ViewHolder(HotelListActivity context, View v) {
            super(v);
            this.context = context;
            thumbnail = (ImageView) v.findViewById(R.id.imageview_thumbnail);
            name = (TextView) v.findViewById(R.id.textview_name);
            price = (TextView) v.findViewById(R.id.textview_price);
            address = (TextView) v.findViewById(R.id.textview_address);
            city = (TextView) v.findViewById(R.id.textview_city);
            postalCode = (TextView) v.findViewById(R.id.textview_postal_code);
        }

        public void bind(final Hotel hotel, final OnItemClickListener listener) {
            name.setText(hotel.getName());
            price.setText("MYR " + hotel.getPrice());
            address.setText(hotel.getAddress());
            city.setText(hotel.getCity());
            postalCode.setText(hotel.getPostalCode());

            //load image
            Picasso.with(context).load(hotel.getImage()).into(thumbnail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(hotel);
                }
            });
        }

    }
}