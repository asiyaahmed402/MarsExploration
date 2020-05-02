package edu.bu.met.cs665.MarsPioneerParts;

import java.time.*;
/**
 * This class represents the electrical power system of the shuttle
 * part names, life span, etc
 * */
public class ElectricalPower extends HealthCenter implements SpaceShuttleParts{

    private String name;


    private LocalDate startDate;

    private int lifespanYears;

    private int buffer = 2;

    public ElectricalPower(String name) {
        this.name = name;
    }

    public void setLifespan(int years) {
        this.lifespanYears = years;
    }

    public int getLifespan() {
        return lifespanYears;
    }

    public void setStartDate(LocalDate date) {
        this.startDate = date;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setBuffer(int buffer) {
        this.buffer = buffer;
    }

    public int getBuffer() {
        return buffer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Given current date, checks part using MaintenanceUtil te get healthy/warning/critical status
    public String checkHealth(LocalDate date) {
        return checkPartHealth(this, date);
    }

    // Returns years left until required maintenance
    public int getYearsLeft(LocalDate date) {
        return getPartYearsLeft(this, date);
    }
}
