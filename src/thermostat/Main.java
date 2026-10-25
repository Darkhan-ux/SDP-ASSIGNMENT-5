package thermostat;

import thermostat.strategy.ComfortModeStrategy;
import thermostat.strategy.EcoModeStrategy;
import thermostat.strategy.HeatingStrategy;
import thermostat.strategy.NightModeStrategy;
import thermostat.strategy.VacationModeStrategy;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Client: selects and configures strategies. Selection is done through
 * a Map lookup, so there is no if/switch on the strategy type.
 */
public class Main {

    private static final double OUTSIDE_TEMPERATURE = -15.0;

    public static void main(String[] args) {
        Map<String, HeatingStrategy> availableModes = createAvailableModes();

        Thermostat thermostat = new Thermostat(availableModes.get("comfort"));
        System.out.println("Outside temperature: " + OUTSIDE_TEMPERATURE + " C");
        System.out.println("-----------------------------------");

        for (HeatingStrategy mode : availableModes.values()) {
            thermostat.setHeatingStrategy(mode);
            printStatus(thermostat);
        }

        System.out.println("-----------------------------------");
        String userChoice = args.length > 0 ? args[0] : "eco";
        thermostat.setHeatingStrategy(availableModes.getOrDefault(userChoice, new ComfortModeStrategy()));
        System.out.print("User selected '" + userChoice + "' at runtime -> ");
        printStatus(thermostat);
    }

    private static Map<String, HeatingStrategy> createAvailableModes() {
        Map<String, HeatingStrategy> modes = new LinkedHashMap<>();
        modes.put("comfort", new ComfortModeStrategy());
        modes.put("eco", new EcoModeStrategy());
        modes.put("vacation", new VacationModeStrategy());
        modes.put("night", new NightModeStrategy());
        return modes;
    }

    private static void printStatus(Thermostat thermostat) {
        System.out.printf("Mode: %-9s | Target indoor temperature: %.1f C%n",
                thermostat.getCurrentModeName(),
                thermostat.regulate(OUTSIDE_TEMPERATURE));
    }
}
