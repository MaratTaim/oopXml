package com.newyear.present.candy.impl;


import com.newyear.present.candy.entity.AbstractCandy;

import java.util.Objects;

public class Candy extends AbstractCandy {
    //attr
    private String type;
    //elements
    private String size;
    private int countOfShugar;
    private double weight;

    public Candy(String type, String size, int countOfShugar, int weight) {
        this.type = type;
        this.size = size;
        this.countOfShugar = countOfShugar;
        this.weight = weight;
    }

    public Candy() {}

    public void setType(String type) {
        this.type = type;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setCountOfShugar(int countOfShugar) {
        this.countOfShugar = countOfShugar;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    private String getType(){
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
    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "\nCandy{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", countOfShugar=" + countOfShugar +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, size, countOfShugar, weight);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Candy other = (Candy) obj;
        return Objects.equals(this.type, other.type)
                && Objects.equals(this.size, other.size)
                && Objects.equals(this.countOfShugar, other.countOfShugar)
                && Objects.equals(this.weight, other.weight);
    }
}
