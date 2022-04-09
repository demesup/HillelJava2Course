package com.hillel.homework.hw4.transport;

public class Transport {
    protected long capacity;
    protected long speed;
    protected String departure;
    protected String arrival;
    protected String origin;
    protected String destination;
    protected int customs; //таможня

    public Transport(long capacity, long speed, String departure, String arrival, String origin, String destination, int customs) {
        this.capacity = capacity;
        this.speed = speed;
        this.departure = departure;
        this.arrival = arrival;
        this.origin = origin;
        this.destination = destination;
        this.customs = customs;
    }

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

    public void loading() {
        System.out.println("The cargo is being loaded...");
    }

    public void unloading() {
        System.out.println("The cargo is being unloaded...");
    }

    @Override
    public String toString() {
        return "Transport{" +
                "capacity=" + capacity +
                ", speed=" + speed +
                ", departure='" + departure + '\'' +
                ", arrival='" + arrival + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", customs=" + customs +
                '}';
    }

    public void way(){
        loading();
        moving();
        accelerate();
        slowingDown();
        stopping();
        unloading();
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
