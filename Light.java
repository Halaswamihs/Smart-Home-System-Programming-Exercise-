// Light.java
public class Light extends SmartDevice {
    public Light(int id, String status) { super(id, status); }
    @Override
    public String getDeviceType() { return "Light"; }
}
