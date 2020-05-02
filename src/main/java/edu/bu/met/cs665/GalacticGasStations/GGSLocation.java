package edu.bu.met.cs665.GalacticGasStations;

import edu.bu.met.cs665.*;

public interface GGSLocation {

    // Executes refueling for given aircraft using its refueling rate spec
    void refuelShuttle(ShuttleManufacturer shuttle);

    String getName();
}
