package com.example.listycity;

import java.util.Objects;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City>{
    private String city;
    private String province;
    /**
     * This is a constructor for the City class
     * @param city
     * @param province
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }
    /**
     * This is a getter for the city name
     * @return String, the city name
     */
    String getCityName(){
        return this.city;
    }
    /**
     * This is a getter for the province name
     * @return String, the province name
     */
    String getProvinceName() {
        return this.province;
    }
    /**
     * This is a compareTo method that compares two cities
     * @param o
     * @return int,0 if the cities are the same, -1 if the first city is less than the second, and 1 if the first city is greater than the second
     */
    @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.city); //this.city refers to the city name
    }

    /**
     * This is a equals method that compares two cities
     * @param o
     * @return boolean, true if the cities are the same, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                     // same reference
        if (o == null || getClass() != o.getClass())    // null or different class
            return false;
        City other = (City) o;
        return Objects.equals(city, other.city)
                && Objects.equals(province, other.province); // compare fields
    }
    /**
     * This is a hashCode method that returns a hash code for the city
     * @return int, the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(city, province);             // hash the same fields
    }
}