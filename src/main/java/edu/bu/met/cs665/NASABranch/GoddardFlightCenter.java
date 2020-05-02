package edu.bu.met.cs665.NASABranch;

import edu.bu.met.cs665.SpaceExploration.*;

public class GoddardFlightCenter implements FieldCenters {

    private String type = "Goddard Flight Center";
    private String name;
    private Exploration mission;

    public GoddardFlightCenter(String name) {
        this.name = name;
    }


    public void update(Exploration mission) {
        System.out.println("\t> Goddard Flight Center " + name + " received "
                + mission.getTypeName() + " exploration mission.");
        System.out.println("\t\t\tMission Description: " + mission.getDescription());
        setMission(mission);
    }

    public Exploration getMission() {
        return mission;
    }

    public void setMission(Exploration mission) {
        this.mission = mission;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
