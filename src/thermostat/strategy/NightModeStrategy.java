package thermostat.strategy;

/**
 * Added later to demonstrate extensibility:
 * a new strategy without modifying any existing class.
 */
public class NightModeStrategy implements HeatingStrategy {

    private static final double DAY_TEMPERATURE = 22.0;
    private static final double NIGHT_REDUCTION = 3.0;

    @Override
    public double calculateTargetTemperature(double outsideTemperature) {
        return DAY_TEMPERATURE - NIGHT_REDUCTION;
    }

    @Override
    public String getModeName() {
        return "Night";
    }
}
