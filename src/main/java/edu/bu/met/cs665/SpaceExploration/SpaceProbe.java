package edu.bu.met.cs665.SpaceExploration;
/**
 * This class represents the space probe exploration
 */
public class SpaceProbe implements ExplorationTypes {

    // Description for the space probe exploration
    private String description = "A space probe is a robotic spacecraft that does not orbit Earth, but instead, explores further into outer space. A space probe may approach the Moon; travel through interplanetary space; flyby, orbit, or land on other planetary bodies; or enter interstellar space.";

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
