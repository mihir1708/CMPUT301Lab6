package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();
    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }
    /**
     * This returns a sorted list of cities
     * @return a sorted list of cities
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This checks if a city is in the list
     * @param city
     * @return boolean, true if the city is in the list, false otherwise
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * This deletes a city from the list
     * @param city
     */
    public void delete(City city) {
        if (this.hasCity(city)) {
            cities.remove(city);
        } else {
            throw new IllegalArgumentException();
        }
    }
    /**
     * This counts the number of cities in the list
     * @return int, the number of cities in the list
     */
    public int countCities() {
        return cities.size();
    }
}