public class MoltDriver implements Comparable<MoltDriver>{
    private int id;
    private String name;
    private int nextAvailableTimeForDelivery;
    private int numberOfDeliveries;
    
    public MoltDriver(int id, String name, int nextAvailableTimeForDelivery, int numberOfDeliveries){
        this.id = id;
        this.name = name;
        this.nextAvailableTimeForDelivery = nextAvailableTimeForDelivery;
        this.numberOfDeliveries = numberOfDeliveries;
    }
    public String getName(){
        return this.name;
    }
    @Override
    public String toString(){
        return this.name + " " + this.id + " " + this.nextAvailableTimeForDelivery + " " + this.numberOfDeliveries;
    }
    public void incrementTotalOrdersDelivered(){
         this.numberOfDeliveries++;
    }
    public int getNextAvailableTimeForDelivery(){
        return this.nextAvailableTimeForDelivery;
    }
    public void setNextAvailableTimeForDelivery(int time){
        this.nextAvailableTimeForDelivery = time;
    }
    @Override
    public int compareTo(MoltDriver otherDriver){
        if (otherDriver == null) {
            throw new IllegalArgumentException("Cannot compare to null object.");}
       return Integer.compare(this.nextAvailableTimeForDelivery, otherDriver.nextAvailableTimeForDelivery);
    }
}
