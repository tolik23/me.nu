package com.liutorovich.anatoliy.gmail.menu.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.liutorovich.anatoliy.gmail.menu.Models.Restaurant;
import com.liutorovich.anatoliy.gmail.menu.R;
import com.liutorovich.anatoliy.gmail.menu.UI.RestaurantInfoActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ToLik on 07.11.2016.
 */

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder>{
    public static List<Restaurant> list;
    private Context context;

    public RestaurantAdapter(Context context, List<Restaurant> restaurant) {
        this.context = context;
        this.list = restaurant;
    }

    @Override
    public RestaurantAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_swipe, viewGroup, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.tv_android.setText(list.get(i).getType() +" «"+ list.get(i).getName()+"»");
        viewHolder.tv_kitchen.setText(list.get(i).getKitchen().toString());
        Picasso.with(context).load("http://###########"+list.get(i).getImages().get(0).getUrl()).into(viewHolder.imgLogo);
        viewHolder.ratingBar.setRating(list.get(i).getRating());
        viewHolder.tv_numberOfReviews.setText("Отзывы: " + list.get(i).getNumberOfReviews());
        viewHolder.tv_address.setText(list.get(i).getAddress());
        viewHolder.tv_distance.setText(list.get(i).getDistanceToUser()+" км");
        viewHolder.tv_classOfRestaurant.setText(list.get(i).getClassOfRestaurant());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tv_android;
        TextView tv_kitchen;
        ImageView imgLogo;
        RatingBar ratingBar;
        TextView tv_numberOfReviews;
        TextView tv_address;
        TextView tv_distance;
        TextView tv_classOfRestaurant;

        public ViewHolder(View view) {
            super(view);

            view.setOnClickListener(this);
            tv_android = (TextView)view.findViewById(R.id.txtName);
            tv_kitchen = (TextView)view.findViewById(R.id.textView);
            imgLogo = (ImageView)view.findViewById(R.id.imgLogo);
            ratingBar = (RatingBar)view.findViewById(R.id.ratingBar);
            tv_numberOfReviews = (TextView)view.findViewById(R.id.txtNumberOfReviews);
            tv_address = (TextView)view.findViewById(R.id.txtAddress);
            tv_distance = (TextView)view.findViewById(R.id.txtDistance);
            tv_classOfRestaurant = (TextView)view.findViewById(R.id.txtClassOfRestaurant);
        }
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(context, RestaurantInfoActivity.class);
            intent.putExtra("position",getAdapterPosition());
            context.startActivity(intent);
        }

    }

}
