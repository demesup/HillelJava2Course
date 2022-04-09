package com.hillel.classwork.lesson5;

import com.hillel.classwork.lesson5.Plant;

public class Dandelion extends Plant {

    public Dandelion(int height) {
        super(height, "Asteraceae");
        System.out.println("Create dandelion");
    }

    @Override
    public void photosynthesis() {
        System.out.println("Dandelion photosynthesis" + this);
    }
}
