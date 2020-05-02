package edu.bu.met.cs665.SpaceExploration;
/**
 * Based on the exploration name, the first method will return
 * the exploration object that contains the description
 */
public class Exploration {

    private ExplorationTypes type;
    private String typeName;
    private String takeoffBase;
    private String landingBase;

    // Based on mission name,
    // returns appropriate Mission object that contains its  description
    public Exploration(String typeName) {
        this.typeName = typeName;
        switch (typeName) {
            case "AlgaeBiofuel":
                type = new AlgaeBiofuel();
                return;
            case "FlyBy":
                type = new FlyBy();
                return;
            case "SpaceProbe":
                type = new SpaceProbe();
                return;
            case "ExtraterrestrialLife":
                type = new ExtraterrestrialLife();
                return;
            default:
                return;
        }
    }

    public void setTakeoffBase(String baseIcao) {
        this.takeoffBase = baseIcao;
    }

    public String getTakeoffBase() {
        return takeoffBase;
    }

    public void setLandingBase(String baseIcao) {
        this.landingBase = baseIcao;
    }

    public String getLandingBase() {
        return landingBase;
    }

    public ExplorationTypes getType() {
        return type;
    }

    public void setType(ExplorationTypes type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    // Returns mission objective with takeoff and landing bases
    public String getDescription() {
        return type.getDescription()
                + "\n\t\t\t\tTakeoff Base: " + takeoffBase
                + "\n\t\t\t\tLanding Base: " + landingBase;
    }
}
