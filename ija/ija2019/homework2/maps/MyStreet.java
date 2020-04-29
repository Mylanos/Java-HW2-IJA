/*
 * Soubor: MyStreet.java
 * Ukol c. 2
 * Autor: Marek Ziska, xziska03@stud.fit.vutbr.cz
 * Skupina: 2BIB
 * Datum 02.04.2020
 */

package ija.ija2019.homework2.maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Reprezentuje jednu ulici v mapě. Ulice má svůj identifikátor (název) a je
 * definována souřadnicemi. Souřadnice představují body zlomu ulice.
 * Na ulici se mohou nacházet zastávky.
 */
public class MyStreet implements Street {
    private String streetID;
    private List<Coordinate> coordinates;
    private List<Stop> stops;

    public MyStreet(String streetID, Coordinate... coordinates) {
        this.streetID = streetID;
        this.coordinates = new ArrayList<>();
        this.coordinates.addAll(Arrays.asList(coordinates));
        this.stops = new ArrayList<>();
    }

    @Override
    public Coordinate end() {
        return coordinates.get(coordinates.size() - 1);
    }

    @Override
    public Coordinate begin() {
        return coordinates.get(0);
    }

    @Override
    public String getId() {
        return streetID;
    }

    @Override
    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    @Override
    public List<Stop> getStops() {
        return stops;
    }

    @Override
    public boolean addStop(Stop stop) {
        for (int i = 0; i < coordinates.size() - 1; i++) {
            if (stop.getCoordinate().getDistance(coordinates.get(i)) +
                    coordinates.get(i + 1).getDistance(stop.getCoordinate()) ==
                    coordinates.get(i + 1).getDistance(coordinates.get(i))
            ) {
                stop.setStreet(this);
                stops.add(stop);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean follows(Street s) {
        if(this.end().equals(s.begin())){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
