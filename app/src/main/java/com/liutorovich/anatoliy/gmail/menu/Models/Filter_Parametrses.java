package com.liutorovich.anatoliy.gmail.menu.Models;

import java.util.List;

/**
 * Created by ToLik on 17.11.2016.
 */

public class Filter_Parametrses {

    public List<Parametrses> parametrses;


    public List<Parametrses> getParametrses() {
        return parametrses;
    }

    public void setParametrses(List<Parametrses> parametrses) {
        this.parametrses = parametrses;
    }

    @Override
    public String toString() {
        return "Filter_Parametrses{" +
                "parametrses=" + parametrses +
                '}';
    }

}
