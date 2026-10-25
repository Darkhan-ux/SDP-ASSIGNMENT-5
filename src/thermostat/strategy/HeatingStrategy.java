package thermostat.strategy;

/**
 * Strategy interface: a family of interchangeable algorithms
 * that decide which indoor temperature the thermostat should keep.
 */
public interface HeatingStrategy {

    double calculateTargetTemperature(double outsideTemperature);

    String getModeName();
}
