package Model;

import java.util.ArrayList;
import java.util.List;


public class MechanicShop<A extends VehicleFeatures> implements MiscFeatures {
    private List<A> objectsInShop;
    private double xPos;
    private double yPos;
    private int capacity;
    private String tag;

    public MechanicShop(int capacity, double xPos, double yPos, String tag) {
        this.objectsInShop = new ArrayList<>(capacity);
        this.capacity = capacity;
        this.xPos = xPos;
        this.yPos = yPos;
        this.tag = tag;
    }

    public List<A> getObjectsInShop() {
        return objectsInShop;
    }

    @Override
    public String getTag() {
        return tag;
    }

    public void addToRepairList(A repairObject) {
        if (getObjectsInShop().size() != capacity) {
            objectsInShop.add(repairObject);
            repairObject.setxPos((getObjectsInShop().size() - 1) * 100);
            repairObject.setyPos(0);
            repairObject.stopEngine();
        } else {
            System.out.println("Can't add object to the shop!");
        }
    }

    public A removeFromRepair(int spot) {
        if (carInShop(spot)) {
            A car = getObjectsInShop().get(spot);
            removeCar(spot);
            return car;
        } else {
            return null;
        }
    }

    @Override
    public double getxPos() {
        return xPos;
    }

    @Override
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

    public boolean carInShop(int spot) {
        return getObjectsInShop().size() >= spot;
    }

    public void removeCar(int spot) {
        getObjectsInShop().remove(spot - 1);
    }
}
