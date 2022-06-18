package com.hillel.classwork.lesson13.annotation.cookies;

@ControlledObject(name = "biscuits")
public class Cookie {

    @StartObject
    public void cook(){
        System.out.println("baking biscuits...");
    }

    @StopObject
    public void finish(){
        System.out.println("biscuits are ready :)");
    }
}
