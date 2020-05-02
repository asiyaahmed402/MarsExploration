package edu.bu.met.cs665.MarsPioneerParts;

import java.time.*;

public class HealthCenter {
    /**
     Assesses shuttle part's health status based on its buffer. number of years until
     warning is triggered) and current date.
     @Returns healthy/warning/critical status
     */

    public String checkPartHealth(SpaceShuttleParts spaceShuttleParts, LocalDate date) {
        int remainingYears = getPartYearsLeft(spaceShuttleParts, date);
        if (remainingYears <= 0) {
            return "critical";
        } else if (remainingYears <= spaceShuttleParts.getBuffer()) {
            return "warning";
        } else {
            return "healthy";
        }
    }
    /**
     Computes and returns number of years left a part has until required maintenance based
     on its lifespan and current date
     */
    public int getPartYearsLeft(SpaceShuttleParts spaceShuttleParts, LocalDate date) {
        int ageYears = date.getYear() - spaceShuttleParts.getStartDate().getYear();
        int remainingYears = spaceShuttleParts.getLifespan() - ageYears;
        return remainingYears;
    }

    // Performs maintenance on given part and resets start date to current date
    public void performPartMaintenance(SpaceShuttleParts spaceShuttleParts, LocalDate date) {
        System.out.println(" Tuning up " + spaceShuttleParts.getName() + " . . .");
        spaceShuttleParts.setStartDate(date);
    }

    public void printMaintenance(SpaceShuttleParts spaceShuttleParts, LocalDate date) {
        System.out.println("Part " + spaceShuttleParts.getName() + " inspection");
        System.out.print(" due in " + spaceShuttleParts.getYearsLeft(date));
    }
}
