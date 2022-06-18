package com.hillel.homework.hw13.enums;

public enum AvailableObjects {
    AUTHOR("АВТОР"),
    BOOK("КНИГА"),
    GENRE("ЖАНР");

    private final String translation;

    AvailableObjects(String translation) {
    this.translation = translation;
    }

    public String getTranslation(){
        return translation;
    }
}
