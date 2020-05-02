package edu.bu.met.cs665.MarsPioneerParts;

import java.time.*;
/**
 * This is the interface used for the shuttle parts
 */
public interface SpaceShuttleParts {

    // Lifespan is # of years a part is expected to last before undergoing required maintenance
    void setLifespan(int years);

    int getLifespan();

    // Start date is the date the part is installed and initiated
    void setStartDate(LocalDate date);

    LocalDate getStartDate();

    // Buffer is the # of years until maintenance that warning should be triggered
    void setBuffer(int buffer);

    int getBuffer();

    void setName(String name);

    String getName();

    // Retrieves health status of part (healthy/warning/critical)
    String checkHealth(LocalDate date);

    // Retrieves # of years left until required maintenance
    int getYearsLeft(LocalDate date);
}
