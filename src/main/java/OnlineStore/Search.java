package OnlineStore;

import java.util.ArrayList;

public class Search {
    public static ArrayList<Products> searchByProductName(ArrayList<Products> inventory, String nameSearch) {
        ArrayList<Products> matchingName = new ArrayList<>();
        for (Products products : inventory) { // runs through the inventory list
            if (products.getName().trim().toUpperCase().contains(nameSearch.trim().toUpperCase())) { // compares if the input contains the same info as an item(s) on the inventory list; removes any extra spaces
                matchingName.add(products); // if the product is found it will return result
            }
        }
        return matchingName; // if the product isn't found, it will return nothing
    }
    public static ArrayList<Products> searchByProductPrice(ArrayList<Products> inventory, double priceSearch) {
        ArrayList<Products> matchingPrice = new ArrayList<>();
        for (Products products : inventory) { // runs through the inventory list
            if (products.getPrice() == priceSearch) { // compares the input vs the product; removes any extra spaces
                matchingPrice.add(products); // if the product is found it will return result
            }
        }
        return matchingPrice; // if the product isn't found, it will return nothing
    }
    public static ArrayList<Products> searchByProductDepartment(ArrayList<Products> inventory, String departmentSearch) {
        ArrayList<Products> matchingDepartment = new ArrayList<>(); // creates a list of all items in the same department
        for (Products products : inventory) { // runs through the inventory list
            if (products.getName().trim().toUpperCase().contains(departmentSearch.trim().toUpperCase())) { // // compares if the input contains the same info as an item(s) on the inventory list; removes any extra spaces
                matchingDepartment.add(products); // adds product in matching department to list

            }
        }
        return matchingDepartment; // returns the result
    }
}

//search one product
//        public static Products searchByProductName(ArrayList<Products> inventory, String nameSearch) {
//            for (Products products : inventory) { // runs through the inventory list
//                if (products.getName().equalsIgnoreCase(nameSearch)) { // compares the input vs the product
//                    return products; // if the product is found it will return result
//                }
//            }
//            return null; // if the product isn't found, it will return nothing
//        }

