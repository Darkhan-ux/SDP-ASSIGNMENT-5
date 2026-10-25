package thermostat;

import thermostat.strategy.HeatingStrategy;

/**
 * Context: holds a reference to a HeatingStrategy and delegates the
 * calculation to it. It knows nothing about concrete strategies.
 */
public class Thermostat {

    private HeatingStrategy heatingStrategy;

    public Thermostat(HeatingStrategy initialStrategy) {
        this.heatingStrategy = initialStrategy;
    }

    public void setHeatingStrategy(HeatingStrategy newStrategy) {
        this.heatingStrategy = newStrategy;
    }

    public double regulate(double outsideTemperature) {
        return heatingStrategy.calculateTargetTemperature(outsideTemperature);
    }

    public String getCurrentModeName() {
        return heatingStrategy.getModeName();
    }
}
