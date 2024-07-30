// AutomatedTrigger.java
public class AutomatedTrigger {
    private final String condition;
    private final String comparison;
    private final int value;
    private final String action;

    public AutomatedTrigger(String condition, String comparison, int value, String action) {
        this.condition = condition;
        this.comparison = comparison;
        this.value = value;
        this.action = action;
    }

    public String getCondition() { return condition; }
    public String getComparison() { return comparison; }
    public int getValue() { return value; }
    public String getAction() { return action; }
}
