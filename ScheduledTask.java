// ScheduledTask.java
public class ScheduledTask {
    private final int deviceId;
    private final String time;
    private final String command;

    public ScheduledTask(int deviceId, String time, String command) {
        this.deviceId = deviceId;
        this.time = time;
        this.command = command;
    }

    public int getDeviceId() { return deviceId; }
    public String getTime() { return time; }
    public String getCommand() { return command; }
}
