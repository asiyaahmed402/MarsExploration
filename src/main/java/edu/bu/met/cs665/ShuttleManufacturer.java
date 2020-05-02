package edu.bu.met.cs665;

import edu.bu.met.cs665.GalacticGasStations.*;
import edu.bu.met.cs665.MarsPioneerParts.*;
import edu.bu.met.cs665.NASABranch.*;
import edu.bu.met.cs665.WarningSystem.*;
import edu.bu.met.cs665.SpaceExploration.*;

import java.time.*;
import java.util.*;
/**
 * This class represents the shuttle part manufacturer
 * */
public class ShuttleManufacturer {
    /**
     * The builder class ensures that minimum specs are defined when creating the shuttle
     * The ShuttleManufacturer can then have more detailed information such as additional parts listing.
     * */

    public static class Builder {

        private String modelName;
        private long id;

        private LocalDate date;

        //MARS PIONEER PARTS
        private CommandCenter commandCenter;
        private ElectricalPower electricalPower;
        private NavigationSystem navigationSystem;
        private ThermalSystem thermalSystem;

        private int refuelingRate;
        private int speed;
        private int range;
        private int engineThrust;
        private int weight;

        public Builder(long id) {
            this.id = id;
        }

        public Builder withModelName(String modelName) {
            this.modelName = modelName;
            return this;
        }

        public Builder withCommandCenter(CommandCenter commandCenter) {
            this.commandCenter = commandCenter;
            return this;
        }

        public Builder withElectricalPower(ElectricalPower electricalPower) {
            this.electricalPower = electricalPower;
            return this;
        }

        public Builder withNavigationSystem(NavigationSystem navigationSystem){
            this.navigationSystem = navigationSystem;
            return this;
        }

        public Builder withThermalSystem(ThermalSystem thermalSystem){
            this.thermalSystem = thermalSystem;
            return this;
        }

        public Builder withDate(LocalDate date) {
            this.date = date;
            return this;
        }



        public Builder withSpeed(int speed) {
            this.speed = speed;
            return this;
        }

        public Builder withRange(int range) {
            this.range = range;
            return this;
        }

        public Builder withWeight(int weight) {
            this.weight = weight;
            return this;
        }

        public Builder withEngineThrust(int engineThrust) {
            this.engineThrust = engineThrust;
            return this;
        }

        public Builder withRefuelRate(int refuelingRate) {
            this.refuelingRate = refuelingRate;
            return this;
        }

        // Assembles and returns Mars Pioneer Xi with given specifications
        public ShuttleManufacturer build() {
            ShuttleManufacturer shuttle = new ShuttleManufacturer();

            shuttle.setModelName(modelName);
            shuttle.setId(id);
            shuttle.setDate(date);
            shuttle.setCommandCenter(commandCenter);
            shuttle.setElectricalPower(electricalPower);
            shuttle.setNavigationSystem(navigationSystem);
            shuttle.setThermalSystem(thermalSystem);
            shuttle.setRefuelingRate(refuelingRate);
            shuttle.setSpeed(speed);
            shuttle.setRange(range);
            shuttle.setEngineThrust(engineThrust);
            shuttle.setWeight(weight);

            // Assesses health based on parts to assign proper state to the shuttle
            shuttle.checkHealth();

            return shuttle;
        }
    }

    // Default date is current date
    private LocalDate date = LocalDate.now();

    private String modelName;
    private long id;

    private Inventory inventory;

    private GGSLocation ggsLocation;
    private int refuelingRate;

    private int speed;
    private int range;
    private int engineThrust;
    private int weight;

    HealthyShuttleState healthyShuttleState;
    CautionAndWarning cautionAndWarning;
    CriticalAlert criticalAlert;

    ShuttleHealth state;

    Exploration exploration;
    List<FieldCenters> fieldCenterList;


    public ShuttleManufacturer() {
        inventory = new Inventory(date);
        healthyShuttleState = new HealthyShuttleState(this);
        cautionAndWarning = new CautionAndWarning(this);
        criticalAlert = new CriticalAlert(this);
        state = healthyShuttleState; //COME BACK TO THIS
        fieldCenterList = new ArrayList<>();
        ggsLocation = new DeimosStation();
    }

    // Assigns mission to shuttle
    public void setMission(Exploration mission) {
        System.out.println("/////////////////////////////////////////");
        System.out.println("* Tasked " + modelName + " with "
                + mission.getTypeName() + " mission *");
        System.out.println("/////////////////////////////////////////\n");
        this.exploration = mission;
    }

    public Exploration getMission() {
        return exploration;
    }

    public void removeMission() {
        exploration = null;
    }

    // Notifies delegated NASA field centers of mission, does nothing if no mission is assigned
    public void notifyFieldCenters() {
        if (exploration == null) {
            System.out.println("Currently no tasked mission");
        }
        System.out.println("Christopher C. Kraft Jr. Mission Control Center notifying field centers . . .");
        Collections.shuffle(fieldCenterList);
        for (FieldCenters pilot : fieldCenterList) {
            pilot.update(exploration);
        }
    }

    public void addFieldCenter(FieldCenters pilot) {
        fieldCenterList.add(pilot);
    }

    public void removeFieldCenter(FieldCenters pilot) {
        fieldCenterList.remove(pilot);
    }

    public List<FieldCenters> getFieldCenter() {
        return fieldCenterList;
    }

    // Executes refueling using set method of refueling (drogue by default)
    public void refuel() {
        System.out.println("Starting " + ggsLocation.getName() + " refueling process:");
        ggsLocation.refuelShuttle(this);
    }

    // Interchanges refueling method
    public void setGgsLocation(GGSLocation method) {
        this.ggsLocation = method;
    }

    public GGSLocation getGgsLocation() {
        return ggsLocation;
    }


    public void checkHealth() {
        state.evaluate();
    }


    public void printResults() {
        state.printResults();
    }


    public void performMaintenance() {
        System.out.println("Starting maintenance");
        state.performMaintenance();
    }


    public String getStatus() {
        return state.get();
    }


    public void setDate(LocalDate date) {
        this.date = date;
        inventory.setDate(date);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    // Changes electrical power
    public void setElectricalPower(ElectricalPower electricalPower) {
        inventory.add(electricalPower);
        state.evaluate();
    }

    // Changes command center
    public void setCommandCenter(CommandCenter commandCenter) {
        inventory.add(commandCenter);
        state.evaluate();
    }

    //Changes navigation system
    public void setNavigationSystem(NavigationSystem navigationSystem){
        inventory.add(navigationSystem);
        state.evaluate();
    }

    //Changes Thermal System
    public void setThermalSystem(ThermalSystem thermalSystem){
        inventory.add(thermalSystem);
        state.evaluate();
    }



    // Adds part to inventory
    public void addPart(SpaceShuttleParts part) {
        inventory.add(part);
        state.evaluate();
    }

    public void setEngineThrust(int engineThrust) {
        this.engineThrust = engineThrust;
    }

    public int getEngineThrust() {
        return this.engineThrust;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setRefuelingRate(int refuelingRate) {
        this.refuelingRate = refuelingRate;
    }

    public int getRefuelingRate() {
        return refuelingRate;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getRange() {
        return range;
    }

    public void setState(ShuttleHealth state) {
        this.state = state;
    }

    public ShuttleHealth getState() {
        return state;
    }

    public HealthyShuttleState getHealthyAircraftState() {
        return healthyShuttleState;
    }

    public CautionAndWarning getWarningAircraftState() {
        return cautionAndWarning;
    }

    public CriticalAlert getCriticalAircraftState() {
        return criticalAlert;
    }

    public Inventory getInventory() {
        return inventory;
    }

    // Prints aircraft specifications
    public void printSpecs() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("| Mars Pioneer Xi Model: " + modelName);
        System.out.println("| ID: " + id);

        printParts();

        System.out.println("| Refueling Rate: " + refuelingRate + " lb/sec");
        System.out.println("| Speed: " + speed + " mp/h");
        System.out.println("| Range: " + range + "mp");
        System.out.println("| Engine Thrust: " + engineThrust + " lb");
        System.out.println("| Weight: " + weight + " lb");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    // Prints aircraft inventory
    public void printParts() {
        System.out.println("| MARS PIONEER Xi PARTS: ");
        for (SpaceShuttleParts part: inventory.getParts()) {
            System.out.println("|    " + part.getName());
        }
    }

    // Prints aircraft health status
    public void printStatus() {
        System.out.println("**********************************");
        System.out.println("* " + modelName + " id: #" + id + " - STATUS: "
                + getStatus());
        System.out.println("**********************************\n");
    }
}


