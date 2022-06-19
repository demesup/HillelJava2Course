package com.hillel.homework.hw13.Objects;

import com.hillel.homework.hw13.FieldProcessing;


public abstract class LibraryObjects  implements FieldProcessing {
    public LibraryObjects() {
    }

    protected String name;
    public LibraryObjects(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
