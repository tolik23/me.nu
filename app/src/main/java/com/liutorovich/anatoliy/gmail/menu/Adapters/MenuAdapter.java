package com.liutorovich.anatoliy.gmail.menu.Adapters;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.liutorovich.anatoliy.gmail.menu.Fragments.DishInfoFragment;
import com.liutorovich.anatoliy.gmail.menu.Models.Restaurant;
import com.liutorovich.anatoliy.gmail.menu.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ToLik on 09.12.2016.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    public static List<Restaurant> list;
    private Context context;
    private int position;
    FragmentActivity activity;


    public MenuAdapter(Context context, List<Restaurant> restaurant, int position, FragmentActivity activity) {
        this.context = context;
        this.list = restaurant;
        this.position = position;
        this.activity=activity;

    }

    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_menu, viewGroup, false);

        return new MenuAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MenuAdapter.ViewHolder viewHolder, int i) {

        viewHolder.mNameDish.setText(list.get(position).getDishes().get(i).getName());
        Picasso.with(context).load("http://#########"+list.get(position).getDishes().get(i).getUrlImage()).into(viewHolder.mImgDish);
        viewHolder.mLike.setText(list.get(position).getDishes().get(i).getLike()+"");
        viewHolder.mDislike.setText(list.get(position).getDishes().get(i).getDislike()+"");
        viewHolder.mWeight.setText(list.get(position).getDishes().get(i).getWeight());
        viewHolder.mDescription.setText(list.get(position).getDishes().get(i).getDescription());
        viewHolder.mPrice.setText(list.get(position).getDishes().get(i).getPrice() + " BYN");
    }

    @Override
    public int getItemCount() {
        return list.get(position).getDishes().size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView mNameDish;
        ImageView mImgDish;
        TextView mLike;
        TextView mDislike;
        TextView mWeight;
        TextView mDescription;
        TextView mPrice;

        public ViewHolder(View view) {
            super(view);

            view.setOnClickListener(this);
            mNameDish = (TextView)view.findViewById(R.id.tv_nameDish);
            mImgDish = (ImageView)view.findViewById(R.id.iv_imgDish);
            mLike = (TextView)view.findViewById(R.id.tv_like);
            mDislike = (TextView)view.findViewById(R.id.tv_dislike);
            mWeight = (TextView)view.findViewById(R.id.tv_weight);
            mDescription = (TextView)view.findViewById(R.id.tv_description);
            mPrice = (TextView)view.findViewById(R.id.tv_price);
        }


        @Override
        public void onClick(View view) {
            FragmentManager fm = activity.getSupportFragmentManager();
            fm.beginTransaction()
                    .replace(R.id.conteiner, DishInfoFragment.newInstance(position,getAdapterPosition()))
                    .addToBackStack(null)
                    .commit();
        }
    }

}
