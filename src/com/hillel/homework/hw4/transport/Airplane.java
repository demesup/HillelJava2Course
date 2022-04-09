package com.hillel.homework.hw4.transport;

public class Airplane extends Transport {
    public boolean airport;
    public boolean airstrip;
    public int space;

    public Airplane(long capacity, int space, long speed, String departure, String arrival, String origin, String destination,
                    int customs, boolean airport, boolean airstrip) {
        super(capacity, speed, departure, arrival, origin, destination, customs);
        this.airport = airport;
        this.airstrip = airstrip;
        this.space = space;
    }


    @Override
    public String toString() {
        if (airport && airstrip) {
            return "Airplane: " +
                    "speed: " + speed +
                    "km/h \n\t departure:" + departure +
                    "\n\t arrival: " + arrival +
                    "\n\t origin: " + origin +
                    "\n\t destination: " + destination +
                    "\n\t customs: " + customs +
                    "\n\t max capacity: " + capacity +
                    " tons\n\t space: " + space + " m³ ";
        }
        return "Make sure there are airport and airstrip";
    }

    public void way() {
        firstHalfWay();
        takeOff();
        fly();
        landing();
        secondHalfWay();
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
