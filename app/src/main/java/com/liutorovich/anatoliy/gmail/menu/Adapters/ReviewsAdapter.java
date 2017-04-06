package com.liutorovich.anatoliy.gmail.menu.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.liutorovich.anatoliy.gmail.menu.Models.Restaurant;
import com.liutorovich.anatoliy.gmail.menu.R;

import java.util.List;

/**
 * Created by ToLik on 30.11.2016.
 */

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.ViewHolder> {
    public static List<Restaurant> list;
    private Context context;
    private int position;

    public ReviewsAdapter(Context context, List<Restaurant> restaurant, int position) {
        this.context = context;
        this.list = restaurant;
        this.position = position;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_restaurant_review, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.mNameUser.setText(list.get(position).getFeedbacks().get(i).getUserName());
        viewHolder.mDate.setText(list.get(position).getFeedbacks().get(i).getDate());
        viewHolder.mRatingUser.setRating(list.get(position).getFeedbacks().get(i).getRating());
        viewHolder.mReviewUser.setText(list.get(position).getFeedbacks().get(i).getMessage());
    }

    @Override
    public int getItemCount() {
        return list.get(position).getFeedbacks().size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mNameUser;
        TextView mDate;
        RatingBar mRatingUser;
        TextView mReviewUser;






        public ViewHolder(View view) {
            super(view);

            mNameUser = (TextView) view.findViewById(R.id.tv_name_user);
            mDate = (TextView) view.findViewById(R.id.tv_date);
            mRatingUser = (RatingBar) view.findViewById(R.id.rb_rating_user);
            mReviewUser = (TextView) view.findViewById(R.id.tv_review_user);



        }
    }
}
