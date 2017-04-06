package com.liutorovich.anatoliy.gmail.menu.Models;

/**
 * Created by ToLik on 17.11.2016.
 */

public class FiltersList {

    public String filterName;
    public boolean value;
    public int id;

    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "FiltersList{" +
                "filterName='" + filterName + '\'' +
                ", value=" + value +
                ", id=" + id +
                '}';
    }
}
