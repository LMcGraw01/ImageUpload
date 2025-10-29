package com.example.imageupload.repository;

import com.example.imageupload.MyApp;
import com.example.imageupload.model.Item;

import java.util.List;

import io.objectbox.Box;

public class ItemRepo {

    public final Box<Item> itemRepo;

    public ItemRepo() {
        itemRepo = MyApp.getBoxStore().boxFor(Item.class);
    }

    // push / insert item
    // prevent duplicates
    public long addItem(Item item) {
        return itemRepo.put(item);
    }

    // pull / get all items
    public List<Item> getAllItems() {
        return itemRepo.getAll();
    }


    // delete item
    public void deleteItem(long id) {
        itemRepo.remove(id);
    }

    // clear all items
    public void clearAll() {
        itemRepo.removeAll();
    }
}