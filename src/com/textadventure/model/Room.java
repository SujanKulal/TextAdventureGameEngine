package com.textadventure.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.textadventure.model.Item;

public class Room {

    private String name;
    private String description;
    private Map<String,String> exits;
    private List<Item> items;

    public Room(String name, String description){

        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Room name cannot be null or empty");
        }
        if(description == null){
            throw new IllegalArgumentException("Description cannot be null");
        }

        this.name = name.trim();
        this.description = description;

        this.exits = new HashMap<>();
        this.items = new ArrayList<>();
    }
    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public Map<String , String > getExits(){
        return this.exits;
    }
    public List<Item> getItems(){
        return this.items;
    }

    public void addItem(Item item){
        if(item == null){
            throw new IllegalArgumentException("Cannot add a null item to the room");
        }
        this.items.add(item);
    }

    public boolean removeItem(Item item){
        if(item == null){
            throw new IllegalArgumentException("Cannot remove a null item from the room");
        }
        return this.items.remove(item);
    }

    public void addExit(String direction, String destinationRoomName){
        if(direction == null || direction.trim().isEmpty()){
            throw new IllegalArgumentException("Exit destination cannot be null or empty");
        }
        if(destinationRoomName == null){
            throw new IllegalArgumentException("Exit destination room cannot be null or empty");
        }
        String normalizedDirection = direction.trim().toLowerCase();
        String trimmedDestination = destinationRoomName.trim();

        this.exits.put(normalizedDirection,trimmedDestination);
    }
}
