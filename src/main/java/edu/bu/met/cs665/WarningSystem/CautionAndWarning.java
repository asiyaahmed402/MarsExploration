package edu.bu.met.cs665.WarningSystem;

import edu.bu.met.cs665.*;
import edu.bu.met.cs665.MarsPioneerParts.*;

import java.util.*;
/**
 * This class represents the caution/warning alert of the warning system of the shuttle
 */
public class CautionAndWarning extends HealthCenter implements ShuttleHealth {

    private ShuttleManufacturer shuttleManufacturer;
    //save the warning parts in a list
    private List<SpaceShuttleParts> warningParts;

    public CautionAndWarning(ShuttleManufacturer shuttleManufacturer){
        this.shuttleManufacturer = shuttleManufacturer;
        warningParts = new ArrayList<>();

    }


    /**
     * Assesses and changes state appropriately based on critical/warning/healthy status
     * If status is same, gets part with least amount of years left until required maintenance
     * */


    public void evaluate() {
        Inventory inventory = shuttleManufacturer.getInventory();
        if (inventory.getStatus().equalsIgnoreCase("critical")) {
            shuttleManufacturer.setState(shuttleManufacturer.getCriticalAircraftState());
            shuttleManufacturer.checkHealth();
            return;
        } else if (inventory.getStatus().equalsIgnoreCase("healthy")) {
            shuttleManufacturer.setState(shuttleManufacturer.getHealthyAircraftState());
            shuttleManufacturer.checkHealth();
            return;
        } else {
            warningParts = inventory.getWarningParts();
            return;
        }
    }

    // Prints critical parts needing maintenance soon
    public void printResults() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("WARNING - Please schedule maintenance for following:");
        for (SpaceShuttleParts spaceShuttleParts: warningParts) {
            printMaintenance(spaceShuttleParts);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    // Prints part and years left until required maintenance
    private void printMaintenance(SpaceShuttleParts spaceShuttleParts) {
        printMaintenance(spaceShuttleParts, shuttleManufacturer.getDate());
    }

    // Performs maintenance on warning parts
    public void performMaintenance() {
        for (SpaceShuttleParts spaceShuttleParts : warningParts) {
            performPartMaintenance(spaceShuttleParts, shuttleManufacturer.getDate());
        }
        shuttleManufacturer.setState(shuttleManufacturer.getHealthyAircraftState());
        System.out.println("\nMaintenance Complete!\n");
    }

    // Retrieves warning status name
    public String get() {
        return "warning";
    }
}