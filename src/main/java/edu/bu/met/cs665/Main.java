package edu.bu.met.cs665;
import edu.bu.met.cs665.GalacticGasStations.*;
import edu.bu.met.cs665.MarsPioneerParts.*;
import edu.bu.met.cs665.NASABranch.*;
import edu.bu.met.cs665.SpaceExploration.*;
import java.time.*;

/**
 * @Name: Asiya Ahmed
 *
 *
 * */
public class Main {


  public static void main(String[] args) {

    //Define Mars Pioneer Xi specs
    final long id = 1L;
    final String modelName = "Xeyron Xi";
    final LocalDate currentDate = LocalDate.of(2010, Month.APRIL, 1);
    final int refuelingRate = 1000;
    final int speed = 2410;
    final int range = 1600;
    final int engineThrust = 35000;
    final int weight = 38000;

    // Defining the shuttle parts
    CommandCenter commandCenter = new CommandCenter("command center");
    commandCenter.setLifespan(10);
    commandCenter.setStartDate(LocalDate.of(2000, Month.APRIL, 1));

    ElectricalPower electricalPower = new ElectricalPower("electrical power");
    electricalPower.setLifespan(15);
    electricalPower.setStartDate(LocalDate.of(2010, Month.APRIL, 1));

    NavigationSystem navigationSystem = new NavigationSystem("navigation system");
    navigationSystem.setLifespan(18);
    navigationSystem.setStartDate(LocalDate.of(2020, Month.APRIL, 1));

    ThermalSystem thermalSystem = new ThermalSystem("thermal system");
    thermalSystem.setLifespan(20);
    thermalSystem.setStartDate(LocalDate.of(2004, Month.APRIL, 1));;



   //builder
    System.out.println("\n--------------------------------------------------------------------");
    System.out.println("BUILDING MARS PIONEER XI w/ Specifications:");
    System.out.println("--------------------------------------------------------------------");
    // Building shuttle with specifications and parts
    ShuttleManufacturer atlasV = new ShuttleManufacturer.Builder(id)
            .withModelName(modelName)
            .withDate(currentDate)
            .withCommandCenter(commandCenter)
            .withElectricalPower(electricalPower)
            .withNavigationSystem(navigationSystem)
            .withThermalSystem(thermalSystem)
            .withRefuelRate(refuelingRate)
            .withSpeed(speed)
            .withRange(range)
            .withEngineThrust(engineThrust)
            .withWeight(weight)
            .build();

    // Printing the inventory and specs
    atlasV.printSpecs();
    atlasV.getInventory().print();


    System.out.println("\n--------------------------------------------------------------------");
    System.out.println("MARS PIONEER XI HEALTH STATUS & MAINTENANCE");
    System.out.println("--------------------------------------------------------------------");
    // Printing status
    atlasV.printStatus();
    atlasV.performMaintenance();
    atlasV.printStatus();



    System.out.println("\n--------------------------------------------------------------------");
    System.out.println("REFUEL AT OUTER SPACE GAS STATIONS");
    System.out.println("--------------------------------------------------------------------");
    //DEFAULT: DEIMOS STATION
    atlasV.refuel();
    atlasV.setGgsLocation(new DeimosStation());
    atlasV.refuel();



    System.out.println("\n--------------------------------------------------------------------");
    System.out.println("ASSIGNMENT OF MISSION & TRACKING ");
    System.out.println("--------------------------------------------------------------------");
    //FIELD CENTERS
    CanberraDeepSpace canberra = new CanberraDeepSpace("CANBERRA DEEP SPACE CENTER");
    GoddardFlightCenter goddard = new GoddardFlightCenter("GODDARD FLIGHT CENTER");
    atlasV.addFieldCenter(canberra);
    atlasV.addFieldCenter(goddard);

    // Creating exploration type
    Exploration algaeBioFuel = new Exploration("AlgaeBiofuel");
    algaeBioFuel.setTakeoffBase("Kennedy Space Center");
    algaeBioFuel.setLandingBase("Vandenberg Air Force Base");


    atlasV.setMission(algaeBioFuel);
    atlasV.notifyFieldCenters();
  }




  }






