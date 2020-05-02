package edu.bu.met.cs665.SpaceExploration;
/**
 * This class represents the extraterrestrial life exploration
 */
public class ExtraterrestrialLife implements ExplorationTypes {

    // Description for the Extraterrestrial life exploration
    private String description = "Extraterrestrial life is hypothetical life which may occur outside of Earth and which did not originate on Earth. Such life might range from simple prokaryotes to beings with civilizations far more advanced than humanity.";

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
