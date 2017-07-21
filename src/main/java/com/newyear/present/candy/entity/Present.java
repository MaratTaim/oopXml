package com.newyear.present.candy.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Present {
    List<SweetProduct> list = new ArrayList<>();

    public List<SweetProduct> getList() {
        return list;
    }

    public void setList(SweetProduct sweet) {
        list.add(sweet);
    }

    @Override
    public String toString() {
        String str = "";
        for (SweetProduct sw: list){
            str += sw;
        }
        return str;
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Present other = (Present) obj;
        return Objects.equals(this.list, other.list);
    }
}
