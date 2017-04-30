package com.kuy.application.features.restaurantlist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kuy.application.R;
import com.kuy.application.models.Restaurant;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by gilang on 4/30/17.
 */

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.ViewHolder> {

    private RestaurantListActivity context;
    private List<Restaurant> dataset;

    private RestaurantListAdapter.OnItemClickListener listener;

    public RestaurantListAdapter(RestaurantListActivity context, List<Restaurant> dataset, RestaurantListAdapter.OnItemClickListener listener) {
        this.context = context;
        this.dataset = dataset;
        this.listener = listener;
    }

    public void updateDataset(List<Restaurant> dataset) {
        this.dataset = dataset;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(Restaurant item);
    }

    @Override
    public RestaurantListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hotel_list_item, parent, false);

        RestaurantListAdapter.ViewHolder vh = new RestaurantListAdapter.ViewHolder(context, v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RestaurantListAdapter.ViewHolder holder, int position) {
        Restaurant restaurant = dataset.get(position);
        holder.bind(restaurant, listener);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public RestaurantListActivity context;
        public ImageView thumbnail;
        public TextView name;
        public TextView price;
        public TextView address;
        public TextView city;
        public TextView postalCode;


        public ViewHolder(RestaurantListActivity context, View v) {
            super(v);
            this.context = context;
            thumbnail = (ImageView) v.findViewById(R.id.imageview_thumbnail);
            name = (TextView) v.findViewById(R.id.textview_name);
            price = (TextView) v.findViewById(R.id.textview_price);
            address = (TextView) v.findViewById(R.id.textview_address);
            city = (TextView) v.findViewById(R.id.textview_city);
            postalCode = (TextView) v.findViewById(R.id.textview_postal_code);
        }

        public void bind(final Restaurant restaurant, final RestaurantListAdapter.OnItemClickListener listener) {
            name.setText(restaurant.getName());
            price.setText("MYR " + restaurant.getAverageCost());
            address.setText(restaurant.getAddress());
            city.setText(restaurant.getCity());
            postalCode.setText(restaurant.getPostalCode());

            //load image
            Picasso.with(context).load(restaurant.getImage()).into(thumbnail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(restaurant);
                }
            });
        }

    }
}
