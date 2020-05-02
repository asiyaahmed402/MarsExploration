package edu.bu.met.cs665.GalacticGasStations;

import edu.bu.met.cs665.*;
/**
 This class represents the Deimos Fuel Station which is
 located on Mar's moon; Deimos.
 It is 48.34 million miles from earth */
public class DeimosStation implements GGSLocation {


    // Executes shuttle refueling using DeimosStation
    public void refuelShuttle(ShuttleManufacturer shuttle) {
        System.out.println("\t> Commander calling into Deimos Station");
        System.out.println("\t> Releasing parachute and speed brake");
        System.out.println("\t> preparing for landing");

        System.out.println("\t> Refueling at: " + shuttle.getRefuelingRate()
                + " pounds per second");

        String[] fueltypes = {"Ammonium Perchlorate CP Cake", "Cryogenic liquid oxygen", "Cryogenic liquid hydrogen"};
        for (String fuel: fueltypes){
            System.out.println("Now filling: " + fuel);
        }

        System.out.println("Complete");
    }

    public String getName() {
        return "Deimos Station";
    }

}
