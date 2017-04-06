package com.liutorovich.anatoliy.gmail.menu.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liutorovich.anatoliy.gmail.menu.R;

/**
 * Created by ToLik on 24.02.2017.
 */

public class MenuCursorAdapter extends RecyclerViewCursorAdapter<MenuCursorAdapter.ViewHolder> {

    public MenuCursorAdapter(Context context,Cursor cursor){
        super(context,cursor);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mNameRest;
        TextView mAdress;
        TextView mSumm;
        TextView mDate;

        public ViewHolder(View view) {
            super(view);
            mNameRest = (TextView) view.findViewById(R.id.tv_name_rest);
            mAdress = (TextView) view.findViewById(R.id.tv_adress);
            mSumm = (TextView) view.findViewById(R.id.tv_summ);
            mDate = (TextView) view.findViewById(R.id.tv_date);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_order_history, parent, false);
        ViewHolder vh = new ViewHolder(itemView);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Cursor cursor) {
        final String restaurant = cursor.getString(cursor.getColumnIndex("restaurant"));
        final String adress = cursor.getString(cursor.getColumnIndex("adress"));
        final String summ = cursor.getString(cursor.getColumnIndex("summ"));
        final String date = cursor.getString(cursor.getColumnIndex("date"));

        viewHolder.mNameRest.setText(restaurant);
        viewHolder.mAdress.setText(adress);
        viewHolder.mSumm.setText(summ + " BYN");
        viewHolder.mDate.setText(date);
    }
}
