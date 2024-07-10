package Lab01_Simsek;

import java.util.*;

public class FoodOrder {
    //instance data members
    private ArrayList<MenuItem> yemekSepeti;

    //constructor
    public FoodOrder() {
        yemekSepeti = new ArrayList<MenuItem>();
    }

    //getter
    public ArrayList<MenuItem> getYemekSepeti() {
        return yemekSepeti;
    }

    //service methods
    public void addItemToYemekSepeti(MenuItem item) {
        boolean isAdded;

        isAdded = false;

        for(int n = 0; n < yemekSepeti.size() && !isAdded; n++) {
            if(yemekSepeti.get(n).getItemCost() > item.getItemCost()) {
                yemekSepeti.add(n, item);
                isAdded = true;
            }
        }

        if(!isAdded) {
            if(yemekSepeti.size() == 0) {
                yemekSepeti.add(item);
            }
            else {
            yemekSepeti.add(yemekSepeti.size() - 1, item);
            }
        }
    }

    public void emptyYemekSepeti() {
        yemekSepeti.clear();
    }

    public int calculateTotalCalories() {
        int totalCalories;

        totalCalories = 0;

        for(int n = 0; n < yemekSepeti.size(); n++) {
            totalCalories += yemekSepeti.get(n).getItemCalories();
        }
        
        return totalCalories;
    }

    public ArrayList<MenuItem> searchYemekSepeti(String keyword) {
        ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
        
        for(int n = 0; n < yemekSepeti.size(); n++) {
            if(yemekSepeti.get(n).getItemDescription().contains(keyword)) {
                menuItems.add(yemekSepeti.get(n));
            }  
        }
        
        return menuItems;
    }

    public String toString() {
        String listOfItems;

        listOfItems = "List of items contained in this customer:";

        for(int n = 0; n < yemekSepeti.size(); n++) {
            listOfItems += yemekSepeti.get(n);
        }

        return listOfItems;
    }
}