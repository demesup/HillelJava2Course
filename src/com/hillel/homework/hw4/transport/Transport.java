package com.hillel.homework.hw4.transport;

public class Transport {
    private long capacity;
    private long speed;
    private String departure;
    private String arrival;
    private String origin;
    private String destination;
    private int customs; //таможня

    public void accelerate() {
        System.out.println("The transport is picking up speed...");
    }

    public void slowingDown() {
        System.out.println("The transport is slowing down...");
    }

    public void moving() {
        System.out.println("The transport is starting moving...");
    }

    public void stopping() {
        System.out.println("The transport is stopping...");
    }

    public int getCustoms() {
        return customs;
    }

    public void setCustoms(int customs) {
        this.customs = customs;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public long getSpeed() {
        return speed;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
