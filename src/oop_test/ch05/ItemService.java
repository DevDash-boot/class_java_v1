package oop_test.ch05;

import java.util.List;

public abstract class ItemService implements ItemDao{
    private ItemDao dao = new MemoryItemDao() {
        @Override
        public void insert(Item item) {
            super.insert(item);
        }

        @Override
        public List<Item> findAll() {
            return super.findAll();
        }
    };
    public void obtainItem(String name, String grade){
        Item item = new Item(name, grade);
        dao.insert(item);
    }
    public void printInventory(){
        List<Item> items =  dao.findAll();
        for(Item item : items){
            System.out.println("아이템 이름 : " + item.getName() + ", 등급 : " + item.getGrade());
        }
    }
}
