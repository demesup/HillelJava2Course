package com.hillel.homework.hw4.transport;

public class Airplane extends Transport {
    public boolean airport;
    public boolean airstrip;
    public int space;

    public Airplane(long capacity, int space, long speed, String departure, String arrival, String origin, String destination,
                    int customs, boolean airport, boolean airstrip) {
        setCapacity(capacity);
        setSpeed(speed);
        setDeparture(departure);
        setArrival(arrival);
        setOrigin(origin);
        setDestination(destination);
        setCustoms(customs);
        this.airport = airport;
        this.airstrip = airstrip;
        this.space = space;
    }

    @Override
    public String toString() {
        if (airport && airstrip) {
            return "Airplane: " +
                    "speed: " + getSpeed() +
                    "km/h \n\t departure:" + getDeparture() +
                    "\n\t arrival: " + getArrival() +
                    "\n\t origin: " + getOrigin() +
                    "\n\t destination: " + getDestination() +
                    "\n\t customs: " + getCustoms() +
                    "\n\t max capacity: " + getCapacity() +
                    " tons\n\t space: " + getSpace() + " m³ ";
        }
        return "Make sure there are airport and airstrip";
    }


    public void takeOff() {
        System.out.println("The plane is taking off...");
    }

    public void fly() {
        System.out.println("The plane is flying...");
    }

    public void landing() {
        System.out.println("The plane is landing...");
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public boolean isAirport() {
        return airport;
    }

    public void setAirport(boolean airport) {
        this.airport = airport;
    }

    public boolean isAirstrip() {
        return airstrip;
    }

    public void setAirstrip(boolean airstrip) {
        this.airstrip = airstrip;
    }
}
