package com.liutorovich.anatoliy.gmail.menu.Interface;

import com.liutorovich.anatoliy.gmail.menu.Models.Filter_Parametrses;
import com.liutorovich.anatoliy.gmail.menu.Models.Restaurant;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by ToLik on 07.11.2016.
 */

public interface RestaurantService {

    @GET("restaurants")
    Call<List<Restaurant>> callRest();

    @GET("restaurants?sort=distanceToUser")
    Call<List<Restaurant>> sortDistance();

    @GET("restaurants")
    Call<List<Restaurant>> searsch(@QueryMap Map<String, String> options);

    @GET("filters")
    Call<Filter_Parametrses> filter();

}
