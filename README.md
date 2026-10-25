# Assignment #5 — Strategy Pattern: Smart Thermostat

A smart home thermostat that chooses the indoor target temperature using
interchangeable **heating modes** selected at runtime.

## Structure

| Role | Class |
|------|-------|
| Strategy interface | `HeatingStrategy` |
| Concrete strategies | `ComfortModeStrategy`, `EcoModeStrategy`, `VacationModeStrategy`, `NightModeStrategy` |
| Context | `Thermostat` (holds a strategy, delegates, `setHeatingStrategy()` switches at runtime) |
| Client | `Main` (selects strategy via `Map` lookup — no if/switch) |

## How to run

```bash
javac -d out $(find src -name "*.java")
java -cp out thermostat.Main          # default: eco
java -cp out thermostat.Main vacation # choose mode at runtime
```

## Clean Code principles applied

1. **Polymorphism instead of conditionals** — `Thermostat.regulate()` simply calls
   `heatingStrategy.calculateTargetTemperature()`. The client picks a strategy with
   a `Map` lookup, so there is no `if`/`switch` on the mode anywhere.
2. **Meaningful, intention-revealing names** — `EcoModeStrategy`, `calculateTargetTemperature`,
   `ANTI_FREEZE_TEMPERATURE`: the name tells what the code does, no comments needed.
3. **Single Responsibility Principle** — each strategy class contains exactly one
   algorithm; `Thermostat` only delegates; `Main` only configures.
4. **Algorithm-agnostic Context** — `Thermostat` depends only on the `HeatingStrategy`
   interface and never imports concrete classes (Dependency Inversion).
5. **Open/Closed Principle (easy extensibility)** — `NightModeStrategy` was added
   without changing `Thermostat` or any other strategy; only one line in the client map.
6. **No magic numbers** — all temperatures are named constants (`COMFORT_TEMPERATURE`, ...).
7. **Small classes and short methods** — every method does one thing and fits on screen.
