package OnlineStore;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Products> inventory = Inventory.addProducts(); // receives the ArrayList returned by the Inventory class and stores it in a variable called inventory
        Menu.homeMenu(inventory); // passes the inventory list into the menu.


    }
}