package com.company.methods;

import com.company.containers.BigContainer;
import com.company.containers.Container;
import com.company.containers.SmallContainer;
import items.Item;

import java.util.ArrayList;
import java.util.List;

public class Calculation {
    private List<Item> itemList;
    private List<Integer> orderList;
    private List<Container> containersList;

    public List<Container> getContainersList() {
        return containersList;
    }

    public Calculation() {
        itemList = new ArrayList<>(); //initializing arrayLists in constructors
        orderList = new ArrayList<>();
        containersList = new ArrayList<>();

    }

    // Add item to the list
    public void addProduct(Item item) {
        itemList.add(item);
    }


    // Add quantity of product to the order list
    public void addOrder(int quantity) {
        orderList.add(quantity);
    }


    // Calculate the total volume of all items
    public double calculateTotalVolume() {
        double totalVolume = 0;
        for (int i = 0; i < itemList.size(); i++) {
            totalVolume += itemList.get(i).calculateVolume() * orderList.get(i);
        }
        return totalVolume;
    }

    // Calculate the total weight of all items
    public double calculateTotalWeight() {
        double totalWeight = 0;
        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);
            int quantity = orderList.get(i);
            totalWeight += item.getWeight() * quantity;
        }
        return totalWeight;
    }


    //Calculate the shipping Price method
    public double shippingPrice() {
        double totalPrice = 0;

        for (Container container : containersList) {
            if (container instanceof BigContainer) {
                totalPrice += 1800;
            } else if (container instanceof SmallContainer) {
                if (calculateTotalWeight() <= 500) {
                    totalPrice += 1000;
                } else {
                    totalPrice += 1200;
                }
            }
        }
        return totalPrice;
    }

    //Calculate the best shipping method
    public void bestShipping() {
        double remainingVolume = calculateTotalVolume();
        double remainingWeight = calculateTotalWeight();
        double smallContainerVolume = 2.59 * 2.43 * 6.06;
        double bigContainerVolume = 2.59 * 2.43 * 12.01;

        int bigContainerCount = 0;
        int smallContainerCount = 0;

        if(remainingVolume > bigContainerVolume ){
            bigContainerCount++;
            remainingVolume -= bigContainerVolume;
        }

        while (remainingVolume >= 0 && remainingWeight > 0) {
            if (remainingVolume >= bigContainerVolume) {
                bigContainerCount++; //counter that saves the big containers
                remainingVolume -= bigContainerVolume;
            } else if (remainingVolume >= smallContainerVolume ) {
                smallContainerCount++; //counter that saves the small containers
                remainingVolume -= smallContainerVolume;
            }

            else{
                smallContainerCount++;
                remainingWeight = 0;
            }

        }
        //adding containers to the containerList
        for (int i = 0; i < bigContainerCount; i++) {
            containersList.add(new BigContainer(2.59, 2.43, 12.01));
        }

            for (int i = 0; i < smallContainerCount; i++) {
                containersList.add(new SmallContainer(2.59, 2.43, 6.06));
            }




    }



    // Print products information
    public void printProductInfo() {
        for (Item product : itemList) {
            product.printItemInfo();
        }
    }

    // Print order information
    public void printOrderInfo() {
        for (int i = 0; i < itemList.size(); i++) {
            Item product = itemList.get(i);
            int quantity = orderList.get(i);
            System.out.println("Product: " + product.getName());
            System.out.println("Quantity: " + quantity);
            System.out.println();
            System.out.println("Total price = " + shippingPrice());

        }
        //System.out.println("Shipping Price: " + shippingPrice() + " Euro");
    }

    // Print container information
    public void printContainerInformation() {
        System.out.println(containersList.size());

    }


}

