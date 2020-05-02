package edu.bu.met.cs665.NASABranch;

import edu.bu.met.cs665.SpaceExploration.*;

public interface FieldCenters {

    // Pilot receives mission info and is tasked to it
    void update(Exploration mission);

    // Pilot is tasked to mission
    void setMission(Exploration mission);

    Exploration getMission();

    void setName(String name);

    String getName();


}
