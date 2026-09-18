package oop_test.ch05;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ItemService itemService = new ItemService() {
            @Override
            public void insert(Item item) {

            }

            @Override
            public List<Item> findAll() {
                return List.of();
            }
        };
        itemService.obtainItem("검", "노멀");
        itemService.obtainItem("희귀검", "희귀");
        itemService.obtainItem("에픽검", "에픽");
        System.out.println("\n===== 인벤토리 =====");
        itemService.printInventory();
    }
}
