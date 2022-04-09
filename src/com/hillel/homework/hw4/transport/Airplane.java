package com.hillel.homework.hw4.transport;

public class Airplane extends Transport {
    public boolean airport;
    public boolean airstrip;

    public Airplane(long capacity, long speed, String departure, String arrival, String origin, String destination,
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
                    "\n\t max capacity: " + getCapacity() + " tons"  ;
        }
        return "Make sure there are airport and airstrip";
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
