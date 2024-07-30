// Thermostat.java
public class Thermostat extends SmartDevice {
    private int temperature;

    public Thermostat(int id, int temperature) {
        super(id, "Off");
        this.temperature = temperature;
    }

    public int getTemperature() { return temperature; }
    public void setTemperature(int temperature) { this.temperature = temperature; }

    @Override
    public String getStatus() {
        return "Thermostat is set to " + temperature + " degrees";
    }

    @Override
    public String getDeviceType() { return "Thermostat"; }
}
