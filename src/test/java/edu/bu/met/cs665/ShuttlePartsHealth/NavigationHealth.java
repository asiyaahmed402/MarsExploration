package edu.bu.met.cs665.ShuttlePartsHealth;

import edu.bu.met.cs665.MarsPioneerParts.*;
import org.junit.*;

import java.time.*;

import static org.junit.Assert.assertEquals;

public class NavigationHealth {

    NavigationSystem navigationSystem;

    @Before
    public void setUp() {
        navigationSystem = new NavigationSystem("navigation");
        navigationSystem.setLifespan(10);
        navigationSystem.setStartDate(
                LocalDate.of(2000, Month.JANUARY, 1)
        );
    }

    @Test
    public void yearsUntilMaintenance() {
        int yearsRemaining = navigationSystem.getYearsLeft(
                LocalDate.of(2008, Month.JANUARY, 1)
        );
        assertEquals(2, yearsRemaining);
    }

    @Test
    public void checkPositiveHealth() {
        String status = navigationSystem.checkHealth(
                LocalDate.of(2002, Month.JANUARY, 1)
        );
        assertEquals("healthy", status);
    }

    @Test
    public void checkWarningHealthDefaultBuffer() {
        String status = navigationSystem.checkHealth(
                LocalDate.of(2009, Month.JANUARY, 1)
        );
        assertEquals("warning", status);
    }

    @Test
    public void checkWarningHealthCustomBuffer() {
        String originalStatus = navigationSystem.checkHealth(
                LocalDate.of(2006, Month.JANUARY, 1)
        );
        assertEquals("healthy", originalStatus);

        navigationSystem.setBuffer(5);
        String recheckStatus = navigationSystem.checkHealth(
                LocalDate.of(2006, Month.JANUARY, 1)
        );
        assertEquals("warning", recheckStatus);
    }

    @Test
    public void checkCriticalHealth() {
        String status = navigationSystem.checkHealth(
                LocalDate.of(2010, Month.JANUARY,1)
        );
        assertEquals("critical", status);

        String overdueStatus = navigationSystem.checkHealth(
                LocalDate.of(2011, Month.JANUARY, 1)
        );
        assertEquals("critical", status);
    }
}
