package thermostat.strategy;

/** Saves energy: the colder it is outside, the less it heats (within limits). */
public class EcoModeStrategy implements HeatingStrategy {

    private static final double BASE_TEMPERATURE = 20.0;
    private static final double MIN_TEMPERATURE = 18.0;
    private static final double SAVING_FACTOR = 0.1;

    @Override
    public double calculateTargetTemperature(double outsideTemperature) {
        double reducedTemperature = BASE_TEMPERATURE + outsideTemperature * SAVING_FACTOR;
        return Math.max(MIN_TEMPERATURE, Math.min(BASE_TEMPERATURE, reducedTemperature));
    }

    @Override
    public String getModeName() {
        return "Eco";
    }
}
