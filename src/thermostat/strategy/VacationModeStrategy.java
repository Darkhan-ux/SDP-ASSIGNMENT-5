package thermostat.strategy;

/** Nobody is home: only protects the house from freezing. */
public class VacationModeStrategy implements HeatingStrategy {

    private static final double ANTI_FREEZE_TEMPERATURE = 12.0;

    @Override
    public double calculateTargetTemperature(double outsideTemperature) {
        return ANTI_FREEZE_TEMPERATURE;
    }

    @Override
    public String getModeName() {
        return "Vacation";
    }
}
