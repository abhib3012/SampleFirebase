package com.hungservers.samplefirebase.model;

/**
 * Created by abhishek on 14/06/16.
 */
public class ShoppingList {

    String listName;
    String owner;

    public ShoppingList() {
        //The empty constructor - the first step
    }

    public ShoppingList(String listName, String owner) {

        this.listName = listName;
        this.owner = owner;
    }

    public String getListName() {
        return listName;
    }

    public String getOwner() {
        return owner;
    }
}
