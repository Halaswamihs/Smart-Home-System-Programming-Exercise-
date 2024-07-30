// Main.java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SmartHomeSystem system = new SmartHomeSystem(); 

        while (true) {
            System.out.println("\nSmart Home System Menu:");
            System.out.println("1. Add Device");
            System.out.println("2. Remove Device");
            System.out.println("3. Turn On Device");
            System.out.println("4. Turn Off Device");
            System.out.println("5. Set Schedule");
            System.out.println("6. Add Trigger");
            System.out.println("7. Execute Scheduled Tasks");
            System.out.println("8. Execute Automated Triggers");
            System.out.println("9. Show Status Report");
            System.out.println("10. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Add Device
                    System.out.print("Enter device type (light/thermostat/door): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter device ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    if (type.equalsIgnoreCase("light")) {
                        system.addDevice(new Light(id, "Off"));
                    } else if (type.equalsIgnoreCase("thermostat")) {
                        System.out.print("Enter initial temperature: ");
                        int temp = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        system.addDevice(new Thermostat(id, temp));
                    } else if (type.equalsIgnoreCase("door")) {
                        system.addDevice(new DoorLock(id, "Locked"));
                    }
                    break;
                case 2: // Remove Device
                    System.out.print("Enter device ID to remove: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    system.removeDevice(removeId);
                    break;
                case 3: // Turn On Device
                    System.out.print("Enter device ID to turn on: ");
                    int turnOnId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    system.turnOn(turnOnId);
                    break;
                case 4: // Turn Off Device
                    System.out.print("Enter device ID to turn off: ");
                    int turnOffId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    system.turnOff(turnOffId);
                    break;
                case 5: // Set Schedule
                    System.out.print("Enter device ID for schedule: ");
                    int scheduleId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter time (HH:MM): ");
                    String time = scanner.nextLine();
                    System.out.print("Enter command (e.g., turnOn/turnOff): ");
                    String command = scanner.nextLine();
                    system.setSchedule(scheduleId, time, command);
                    break;
                case 6: // Add Trigger
                    System.out.print("Enter condition (e.g., temperature): ");
                    String condition = scanner.nextLine();
                    System.out.print("Enter comparison operator (e.g., >): ");
                    String comparison = scanner.nextLine();
                    System.out.print("Enter value for trigger: ");
                    int value = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter action (e.g., turnOff(1)): ");
                    String action = scanner.nextLine();
                    system.addTrigger(condition, comparison, value, action);
                    break;
                case 7: // Execute Scheduled Tasks
                    System.out.print("Enter current time (HH:MM): ");
                    String currentTime = scanner.nextLine();
                    system.executeScheduledTasks(currentTime);
                    break;
                case 8: // Execute Automated Triggers
                    System.out.print("Enter current temperature: ");
                    int temp = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Map<String, Integer> conditions = new HashMap<>();
                    conditions.put("temperature", temp);
                    system.executeAutomatedTriggers(conditions);
                    break;
                case 9: // Show Status Report
                    System.out.println("Status Report: " + system.statusReport());
                    break;
                case 10: // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
