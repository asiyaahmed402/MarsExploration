package edu.bu.met.cs665.MarsPioneerParts;

import java.time.*;
import java.util.*;
/**
 * This class represents the inventory for shuttle parts
 * @Return maintenance parts, critical parts, warning parts
 * */
public class Inventory extends HealthCenter{

    // Maps parts to its # years left until required maintenance
    private HashMap<SpaceShuttleParts, Integer> partsYears;
    // Current date
    private LocalDate date;

    public Inventory(LocalDate date) {
        partsYears = new HashMap<>();
        this.date = date;


    }

    // Returns part that has the closest required maintenance date out of parts list
    public SpaceShuttleParts getImmediateMaintenancePart() {
        if (partsYears.size() == 0) {
            return null;
        }
        List<SpaceShuttleParts> spaceShuttleParts = new ArrayList<>();
        spaceShuttleParts.addAll(partsYears.keySet());

        SpaceShuttleParts immediatePart = spaceShuttleParts.get(0);
        for (SpaceShuttleParts part : spaceShuttleParts) {
            if (partsYears.get(part) < partsYears.get(immediatePart)) {
                immediatePart = part;
            }
        }
        return immediatePart;
    }
    /**
     Returns status of inventory by highest critical/warning state of its parts.
     Otherwise, returns healthy.
     */
    public String getStatus() {
        List<String> status = new ArrayList<>();
        for (SpaceShuttleParts spaceShuttleParts : partsYears.keySet()) {
            status.add(checkPartHealth(spaceShuttleParts, date));
        }
        if (status.contains("critical")) {
            return "critical";
        } else if (status.contains("warning")) {
            return "warning";
        } else {
            return "healthy";
        }
    }
    /**
     This method returns list of parts in critical condition, needing immediate maintenance
     */

    public List<SpaceShuttleParts> getCriticalParts() {
        List<SpaceShuttleParts> criticalParts = new ArrayList<>();
        for (SpaceShuttleParts spaceShuttleParts : partsYears.keySet()) {
            if (checkPartHealth(spaceShuttleParts, date).equalsIgnoreCase("critical")) {
                criticalParts.add(spaceShuttleParts);
            }
        }
        return criticalParts;
    }

    // Returns list of parts with warnings, needing maintenance scheduling
    public List<SpaceShuttleParts> getWarningParts() {
        List<SpaceShuttleParts> warningParts = new ArrayList<>();
        for (SpaceShuttleParts spaceShuttleParts : partsYears.keySet()) {
            if (checkPartHealth(spaceShuttleParts, date).equalsIgnoreCase("warning")) {
                warningParts.add(spaceShuttleParts);
            }
        }
        return warningParts;
    }

    // Returns list of all parts in inventory
    public List<SpaceShuttleParts> getParts() {
        List<SpaceShuttleParts> spaceShuttleParts = new ArrayList<>();
        spaceShuttleParts.addAll(partsYears.keySet());
        return spaceShuttleParts;
    }

    // Returns part's years left until required maintenance
    public int getYearsLeft(SpaceShuttleParts part) {
        return partsYears.get(part);
    }

    // Returns number of parts stored
    public int getSize() {
        return partsYears.size();
    }

    // Sets current date of inventory
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    // Adds part as key and its # years left required for maintenance as value
    public void add(SpaceShuttleParts part) {
        partsYears.put(part, part.getYearsLeft(date));
    }

    // Removes part from inventory
    public void remove(SpaceShuttleParts part) {
        partsYears.remove(part);
    }

    // Checks if given part is member of inventory
    public boolean contains(SpaceShuttleParts part) {
        List<SpaceShuttleParts> parts = new ArrayList<>();
        parts.addAll(partsYears.keySet());
        return parts.contains(part);
    }

    // Returns current inventory of parts and its # years left until maintenance is required
    public void print() {
        System.out.println("\n--------------------------------------------");
        System.out.println("| Mars Pioneer Parts Inventory");
        partsYears.forEach((spaceShuttleParts, years) -> {
            System.out.println("|\t" + spaceShuttleParts.getName() + ": ");
            System.out.println("|\t\t" + years + " years left until required maintenance");
        });
        System.out.println("--------------------------------------------\n");
    }
}
