package org.example.lab1;

import java.util.ArrayList;
import java.util.List;


public class MechanicShop<A extends Storable> {
    private List<A> objectsInShop;
    private double xPos;
    private double yPos;
    private int capacity;

    public MechanicShop(int capacity, double xPos, double yPos){
        this.objectsInShop = new ArrayList<>(capacity);
        this.capacity = capacity;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public List<A> getObjectsInShop() {
        return objectsInShop;
    }

    public void addToRepairList(A repairObject){
        if(Math.abs(repairObject.getxPos() - this.xPos) <= 10
        && Math.abs(repairObject.getyPos() - this.yPos) <= 10
        && getObjectsInShop().size() != capacity){
            objectsInShop.add(repairObject);
            System.out.println("Your car is at repair place: " + getObjectsInShop().size());
        }
        else{
            System.out.println("Can't add object to the shop!");
        }
    }

    public A removeFromRepair(int spot){
        if (getObjectsInShop().size() >= spot ) {
            A car = getObjectsInShop().get(spot);
            getObjectsInShop().remove(spot - 1);
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
}
