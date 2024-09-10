
public class MoltOrder implements Comparable<MoltOrder> {
    private String name;
    private String orderDescription;
    private int orderReadyTime;
    private int timeNeededToDeliver;
    private int priority;

    public MoltOrder(String name, String orderDescription, int orderReadyTime, int timeNeededToDeliver, int priority) {
        this.name = name;
        this.orderDescription = orderDescription;
        this.orderReadyTime = orderReadyTime;
        this.timeNeededToDeliver = timeNeededToDeliver;
        this.priority = priority;
    }
    @Override
    public String toString() {
        return this.name + " " + this.orderDescription + " " + this.orderReadyTime + " " + this.timeNeededToDeliver
                + " " + this.priority;
    }

    public int getOrderReadyTime() {
        return this.orderReadyTime;
    }

    public int getTimeNeededToDeliver() {
        return this.timeNeededToDeliver;
    }

    public String getName() {
        return this.name;
    }

    public String getOrderDescription() {
        return this.orderDescription;
    }
    @Override
    public int compareTo(MoltOrder otherOrder) {
        if (otherOrder == null) {
            throw new NullPointerException("Cannot compare to null object.");}
        return Integer.compare(this.priority, otherOrder.priority);
    }
    public static void main (String[]args){
        System.out.println("hello world");
    }
}
