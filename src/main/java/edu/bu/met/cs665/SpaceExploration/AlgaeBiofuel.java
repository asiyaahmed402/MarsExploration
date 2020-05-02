package edu.bu.met.cs665.SpaceExploration;
/**
 * This class represents the algae fuel exploration
 */
public class AlgaeBiofuel implements ExplorationTypes {

    // Description for the Algae Bio-fuel exploration
    private String description = "Algae fuel, algal biofuel, or algal oil is an alternative to liquid fossil fuels that uses algae as its source of energy-rich oils.";

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
