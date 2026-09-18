package oop_test.ch05;

import java.util.List;

public interface ItemDao {
    public abstract void insert(Item item);
    public abstract List<Item> findAll();
}
