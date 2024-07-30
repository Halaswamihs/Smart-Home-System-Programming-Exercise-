// DoorLock.java
public class DoorLock extends SmartDevice {
    public DoorLock(int id, String status) { super(id, status); }
    @Override
    public String getDeviceType() { return "Door Lock"; }
}
