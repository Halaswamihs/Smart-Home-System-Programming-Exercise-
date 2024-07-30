// SmartDevice.java
import java.util.*;

public abstract class SmartDevice {
    private final int id;
    private String status;

    public SmartDevice(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public int getId() { return id; }
    public String getStatus() { return status; }

    public void turnOn() { status = "On"; }
    public void turnOff() { status = "Off"; }

    public abstract String getDeviceType();
}
