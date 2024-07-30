// SmartHomeSystem.java
import java.util.*;

public class SmartHomeSystem {
    private final Map<Integer, SmartDevice> devices = new HashMap<>();
    private final List<ScheduledTask> scheduledTasks = new ArrayList<>();
    private final List<AutomatedTrigger> automatedTriggers = new ArrayList<>();

    public void addDevice(SmartDevice device) {
        devices.put(device.getId(), device);
    }

    public void removeDevice(int deviceId) {
        devices.remove(deviceId);
    }

    public void turnOn(int deviceId) {
        SmartDevice device = devices.get(deviceId);
        if (device != null) device.turnOn();
    }

    public void turnOff(int deviceId) {
        SmartDevice device = devices.get(deviceId);
        if (device != null) device.turnOff();
    }

    public void setSchedule(int deviceId, String time, String command) {
        scheduledTasks.add(new ScheduledTask(deviceId, time, command));
    }

    public void addTrigger(String condition, String comparison, int value, String action) {
        automatedTriggers.add(new AutomatedTrigger(condition, comparison, value, action));
    }

    public void executeScheduledTasks(String currentTime) {
        for (ScheduledTask task : scheduledTasks) {
            if (task.getTime().equals(currentTime)) {
                executeCommand(task.getCommand(), task.getDeviceId());
            }
        }
    }

    public void executeAutomatedTriggers(Map<String, Integer> currentConditions) {
        for (AutomatedTrigger trigger : automatedTriggers) {
            Integer conditionValue = currentConditions.get(trigger.getCondition());
            if (conditionValue != null && compare(conditionValue, trigger.getComparison(), trigger.getValue())) {
                executeCommand(trigger.getAction());
            }
        }
    }

    private boolean compare(int value, String comparison, int threshold) {
        switch (comparison) {
            case ">": return value > threshold;
            case "<": return value < threshold;
            default: return false;
        }
    }

    private void executeCommand(String command, Integer deviceId) {
        if (command.startsWith("turnOn")) {
            turnOn(deviceId);
        } else if (command.startsWith("turnOff")) {
            turnOff(deviceId);
        }
    }

    public String statusReport() {
        StringBuilder report = new StringBuilder();
        for (SmartDevice device : devices.values()) {
            report.append(device.getStatus()).append(". ");
        }
        return report.toString().trim();
    }

    public List<ScheduledTask> getScheduledTasks() { return scheduledTasks; }
    public List<AutomatedTrigger> getAutomatedTriggers() { return automatedTriggers; }
}
