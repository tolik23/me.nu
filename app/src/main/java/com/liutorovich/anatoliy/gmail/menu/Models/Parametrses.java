package com.liutorovich.anatoliy.gmail.menu.Models;

import java.util.List;

/**
 * Created by ToLik on 17.11.2016.
 */

public class Parametrses {

        public String filterSectionName;
    public List<FiltersList> filtersList;
    public int id;

    public String getFilterSectionName() {
        return filterSectionName;
    }

    public void setFilterSectionName(String filterSectionName) {
        this.filterSectionName = filterSectionName;
    }

    public List<FiltersList> getFiltersList() {
        return filtersList;
    }

    public void setFiltersList(List<FiltersList> filtersList) {
        this.filtersList = filtersList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Filter_Parametrses{" +
                "filterSectionName='" + filterSectionName + '\'' +
                ", filtersList=" + filtersList +
                ", id=" + id +
                '}';
    }
}
