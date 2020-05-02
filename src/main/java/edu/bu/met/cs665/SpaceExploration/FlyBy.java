package edu.bu.met.cs665.SpaceExploration;
/**
 * This class represents the flyby  exploration
 */
public class FlyBy implements ExplorationTypes {

    // Description for the flyby exploration
    private String description = "A flyby is a spaceflight operation in which a spacecraft passes in close proximity to another body, usually a target of its space exploration mission and/or a source of a gravity assist to impel it towards another target. O";

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
