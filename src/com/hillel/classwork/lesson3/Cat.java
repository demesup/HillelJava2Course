package com.hillel.classwork.lesson3;

import java.util.Objects;

public class Cat {
    String name;
    int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age && Objects.equals(name, cat.name);
    }


    @Override
    public String toString(){
        return "Cat: " + this.name + ", " + this.age;
    }


}
