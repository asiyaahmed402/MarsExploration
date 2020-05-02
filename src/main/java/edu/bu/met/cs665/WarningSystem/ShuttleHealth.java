package edu.bu.met.cs665.WarningSystem;
/**
 * This class evaluates the shuttles health, performs maintenance
 */
public interface ShuttleHealth {

    // Assesses status of shuttle based on part inventory's maintenance status
    void evaluate();

    // Prints evaluation results from assessment
    void printResults();

    // Performs required maintenance based on critical/warning parts
    void performMaintenance();

    // Retrieves status name
    String get();
}
