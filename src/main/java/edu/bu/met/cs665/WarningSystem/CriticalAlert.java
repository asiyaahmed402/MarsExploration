package edu.bu.met.cs665.WarningSystem;

import edu.bu.met.cs665.*;
import edu.bu.met.cs665.MarsPioneerParts.*;

import java.util.*;
/**
 * This class represents the critical alert of the warning system of the shuttle
 */
public class CriticalAlert extends HealthCenter implements ShuttleHealth {

    private ShuttleManufacturer shuttle;
    private List<SpaceShuttleParts> criticalParts;

    public CriticalAlert(ShuttleManufacturer shuttle) {
        this.shuttle = shuttle;
        criticalParts = new ArrayList<>();
    }
    /**
     * Assesses and changes state appropriately based on critical/warning/healthy status
     * If status is same, gets part with least amount of years left until required maintenance
     * */
    public void evaluate() {
        Inventory inventory = shuttle.getInventory();
        if (inventory.getStatus().equalsIgnoreCase("healthy")) {
            shuttle.setState(shuttle.getHealthyAircraftState());
            shuttle.checkHealth();
            return;
        } else if (inventory.getStatus().equalsIgnoreCase("warning")) {
            shuttle.setState(shuttle.getWarningAircraftState());
            shuttle.checkHealth();
            return;
        } else {
            criticalParts = inventory.getCriticalParts();
            return;
        }
    }

    // Prints critical parts needing immediate attention
    public void printResults() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("CRITICAL - Please perform maintenance for following:");
        for (SpaceShuttleParts spaceShuttleParts: criticalParts) {
            printMaintenance(spaceShuttleParts);
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    // Prints part and years left until required maintenance
    private void printMaintenance(SpaceShuttleParts spaceShuttleParts) {
        printMaintenance(spaceShuttleParts, shuttle.getDate());
    }

    // Performs immediate maintenance on critical parts
    public void performMaintenance() {
        for (SpaceShuttleParts spaceShuttleParts : criticalParts) {
            performPartMaintenance(spaceShuttleParts, shuttle.getDate());
        }
        shuttle.setState(shuttle.getHealthyAircraftState());
        System.out.println("\nMaintenance complete!\n");
    }

    // Retrieves critical status name
    public String get() {
        return "critical";
    }
}
