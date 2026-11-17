package OnlineStore;

public class Products { // stores the properties defined by csv file
    private final String sku;
    private final String name;
    private final double price;
    private final String department ;

    // Constructor - stores values
    public Products (String sku,
                     String name,
                     double price,
                     String department){
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.department = department;
    }
    //Methods - returns stored values
    //Getters
    public String getSku() {
        return sku;
    }public String getName() {
        return name;
    }public double getPrice() { // calculates the gross pay
        return price;
    }public String getDepartment(){
        return department;
    }
    void displayInfo(){
        System.out.printf("SKU: %s | Product Name: %s | Price: $%.2f | Department: %s%n", sku, name,
                          price, department);
    }
}

