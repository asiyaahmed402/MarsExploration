package edu.bu.met.cs665.ShuttlePartsHealth;

import edu.bu.met.cs665.MarsPioneerParts.*;
import org.junit.*;

import java.time.*;

import static org.junit.Assert.assertEquals;

public class ElectricalPowerHealth {

    ElectricalPower electricalPower;

    @Before
    public void setUp() {
        electricalPower = new ElectricalPower("Electrical Power");
        electricalPower.setLifespan(10);
        electricalPower.setStartDate(
                LocalDate.of(2000, Month.JANUARY, 1)
        );
    }

    @Test
    public void yearsUntilMaintenance() {
        int yearsRemaining = electricalPower.getYearsLeft(
                LocalDate.of(2008, Month.JANUARY, 1)
        );
        assertEquals(2, yearsRemaining);
    }

    @Test
    public void checkPositiveHealth() {
        String status = electricalPower.checkHealth(
                LocalDate.of(2002, Month.JANUARY, 1)
        );
        assertEquals("healthy", status);
    }

    @Test
    public void checkWarningHealthDefaultBuffer() {
        String status = electricalPower.checkHealth(
                LocalDate.of(2009, Month.JANUARY, 1)
        );
        assertEquals("warning", status);
    }

    @Test
    public void checkWarningHealthCustomBuffer() {
        String originalStatus = electricalPower.checkHealth(
                LocalDate.of(2006, Month.JANUARY, 1)
        );
        assertEquals("healthy", originalStatus);

        electricalPower.setBuffer(5);
        String recheckStatus = electricalPower.checkHealth(
                LocalDate.of(2006, Month.JANUARY, 1)
        );
        assertEquals("warning", recheckStatus);
    }

    @Test
    public void checkCriticalHealth() {
        String status = electricalPower.checkHealth(
                LocalDate.of(2010, Month.JANUARY,1)
        );
        assertEquals("critical", status);

        String overdueStatus = electricalPower.checkHealth(
                LocalDate.of(2011, Month.JANUARY, 1)
        );
        assertEquals("critical", status);
    }


}
