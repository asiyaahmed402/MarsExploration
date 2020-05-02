package edu.bu.met.cs665.GalacticGasStations;

import edu.bu.met.cs665.*;
/**
 This class represents the ExxonGalaticStation which is
 a gas station in outer space that orbits around earth.
 It is 20 million miles from earth */
public class ExxonGalacticStation implements GGSLocation {

    public void refuelShuttle(ShuttleManufacturer shuttle) {
        System.out.println("\t> Commander calling into ExxonGalaticStation");
        System.out.println("\t> ");
        System.out.println("\t> Landing");

        System.out.println("\t> Refueling at: " + shuttle.getRefuelingRate()
                + " pounds per second");

        String[] fueltypes = {"Ammonium Perchlorate CP Cake", "Cryogenic liquid oxygen", "Cryogenic liquid hydrogen"};
        for (String fuel: fueltypes){
            System.out.println("Now filling: " + fuel);
        }

        System.out.println("complete!");
    }

    public String getName() {
        return "Exxon";
    }

}
