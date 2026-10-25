package thermostat.strategy;

/** Keeps a constant, cozy temperature regardless of the weather. */
public class ComfortModeStrategy implements HeatingStrategy {

    private static final double COMFORT_TEMPERATURE = 23.0;

    @Override
    public double calculateTargetTemperature(double outsideTemperature) {
        return COMFORT_TEMPERATURE;
    }

    @Override
    public String getModeName() {
        return "Comfort";
    }
}
