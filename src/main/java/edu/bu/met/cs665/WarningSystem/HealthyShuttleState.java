package edu.bu.met.cs665.WarningSystem;

import edu.bu.met.cs665.*;
import edu.bu.met.cs665.MarsPioneerParts.*;
/**
 * This class represents the healthy status of the warning system of the shuttle
 */
public class HealthyShuttleState extends HealthCenter implements ShuttleHealth {
    private ShuttleManufacturer shuttle;
    private SpaceShuttleParts immediatePart = null;
    private int yearsLeft;

    public HealthyShuttleState(ShuttleManufacturer shuttle) {
        this.shuttle = shuttle;
    }
    /**
     * Assesses and changes state appropriately based on critical/warning/healthy status
     * If status is same, gets part with least amount of years left until required maintenance
     * */


    public void evaluate() {
        Inventory inventory = shuttle.getInventory();
        if (inventory.getStatus().equals("critical")) {
            shuttle.setState(shuttle.getCriticalAircraftState());
            shuttle.checkHealth();
            return;
        } else if (inventory.getStatus().equals("warning")) {
            shuttle.setState(shuttle.getWarningAircraftState());
            shuttle.checkHealth();
            return;
        } else {
            immediatePart = inventory.getImmediateMaintenancePart();
            yearsLeft = inventory.getYearsLeft(immediatePart);
            return;
        }
    }

    // Prints positive result and part that needs the soonest maintenance
    public void printResults() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("This Mars Pioneer Xi shuttle is in a good condition.");
        System.out.println("Ready for flight!");
        System.out.println("----------------------------");
        System.out.println("Next maintenance for " + immediatePart.getName());
        System.out.println("needed in " + yearsLeft + " years");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    // Performs maintenance on part with closest maintenance date
    public void performMaintenance() {
        performPartMaintenance(immediatePart, shuttle.getDate());
        System.out.println("\nMaintenance complete!\n");
    }

    public String get() {
        return "healthy";
    }

}
