package com.liutorovich.anatoliy.gmail.menu.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liutorovich.anatoliy.gmail.menu.Models.Order;
import com.liutorovich.anatoliy.gmail.menu.R;

import java.util.List;

/**
 * Created by ToLik on 20.02.2017.
 */

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    public static List<Order> list;
    private Context context;

    public OrderAdapter(Context context, List<Order> orders) {
        this.context = context;
        this.list = orders;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_order, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.mDish.setText(list.get(i).getNameDish());
        viewHolder.mQuantity.setText(Integer.toString(list.get(i).getNumbOfDish()));
        viewHolder.mPrice.setText(list.get(i).getPrice() + " BYN");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mDish;
        TextView mQuantity;
        TextView mPrice;


        public ViewHolder(View view) {
            super(view);

            mDish = (TextView) view.findViewById(R.id.tv_dish);
            mQuantity = (TextView) view.findViewById(R.id.tv_quantity);
            mPrice = (TextView) view.findViewById(R.id.tv_price);



        }
    }
}
