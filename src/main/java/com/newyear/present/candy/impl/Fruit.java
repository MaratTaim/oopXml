package com.newyear.present.candy.impl;


import com.newyear.present.candy.entity.AbstractFruit;

import java.util.Objects;

public class Fruit extends AbstractFruit {
    //attr
    private String type;
    //elements
    private String season;
    private int countOfShugar;
    private double weight;

    public Fruit() {}

    public Fruit(String type, String season, int countOfShugar, int weight) {
        this.type = type;
        this.season = season;
        this.countOfShugar = countOfShugar;
        this.weight = weight;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public void setCountOfShugar(int countOfShugar) {
        this.countOfShugar = countOfShugar;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getType(){
        return type;
    }

    @Override
    public int countOfShugar() {
        return countOfShugar;
    }

    @Override
    public double weight() {
        return weight;
    }

    @Override
    public String getSeason() {
        return season;
    }

    @Override
    public String toString() {
        return "\nFruit{" +
                "type='" + type + '\'' +
                ", season='" + season + '\'' +
                ", countOfShugar=" + countOfShugar +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, season, countOfShugar, weight);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Fruit other = (Fruit) obj;
        return Objects.equals(this.type, other.type)
                && Objects.equals(this.season, other.season)
                && Objects.equals(this.countOfShugar, other.countOfShugar)
                && Objects.equals(this.weight, other.weight);
    }
}
