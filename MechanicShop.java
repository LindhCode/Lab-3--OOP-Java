import java.util.ArrayList;
import java.util.List;


public class MechanicShop<A extends VehicleFeatures> implements MiscFeatures {
    private List<A> objectsInShop;
    private double xPos;
    private double yPos;
    private int capacity;
    private String tag;

    // I feel like poop writing the tag paramter
    // It is such a quick fix inerting a new parameter just to check generic type
    public MechanicShop(int capacity, double xPos, double yPos, String tag){
        this.objectsInShop = new ArrayList<>(capacity);
        this.capacity = capacity;
        this.xPos = xPos;
        this.yPos = yPos;
        this.tag = tag;
    }

    public List<A> getObjectsInShop() {
        return objectsInShop;
    }

    public String getTag() {
        return tag;
    }

    public void addToRepairList(A repairObject){
        if(posCheck(repairObject) && getObjectsInShop().size() != capacity){
            objectsInShop.add(repairObject);
        }
        else{
            System.out.println("Can't add object to the shop!");
        }
    }

    public A removeFromRepair(int spot){
        if (carInShop(spot))  {
            A car = getObjectsInShop().get(spot);
            removeCar(spot);
            return car;
        }
        else{
            return null;
        }
    }

    public double getxPos() {
        return xPos;
    }

    public double getyPos() {
        return yPos;
    }

    @Override
    public void setxPos(double x) {
        xPos = x;
    }
    @Override
    public void setyPos(double y) {
        yPos = y;
    }

    public boolean posCheck(A repairObject){
        return Math.abs(repairObject.getxPos() - this.xPos) <= 10 && Math.abs(repairObject.getyPos() - this.yPos) <= 10;
    }

    public boolean carInShop(int spot){
        return getObjectsInShop().size() >= spot;
    }
    public void removeCar(int spot){
        getObjectsInShop().remove(spot-1);
    }
}
