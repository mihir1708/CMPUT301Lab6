package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }
    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }
    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }
    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }
    @Test
    void testHasCity() {
        CityList cityList = mockCityList(); // contains Edmonton, Alberta
        // Case 1: city exists
        City existingCity = new City("Edmonton", "Alberta");
        assertTrue(cityList.hasCity(existingCity));
        // Case 2: city does not exist
        City missingCity = new City("Calgary", "Alberta");
        assertFalse(cityList.hasCity(missingCity));
    }
    @Test
    void testDelete() {
        CityList cityList = mockCityList(); // starts with Edmonton, Alberta
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        // ensure it was added
        assertEquals(2, cityList.countCities());
        assertTrue(cityList.hasCity(city));
        // delete and verify it’s gone
        cityList.delete(city);
        assertEquals(1, cityList.countCities());
        assertFalse(cityList.hasCity(city));
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        City city = new City("Vancouver", "British Columbia");
        // deleting a city not in the list should throw
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        // initially contains only mockCity()
        assertEquals(1, cityList.countCities());
        cityList.add(new City("Regina", "Saskatchewan"));
        assertEquals(2, cityList.countCities());
        cityList.add(new City("Toronto", "Ontario"));
        assertEquals(3, cityList.countCities());
    }
}