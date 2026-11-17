package OnlineStore;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {
    public static void generateReceipt(Cart cart,
                                       double amountPaid,
                                       double changeGiven) {

        String receiptText = generateReceiptText(cart, amountPaid, changeGiven); //Creates all receipt text and stores it as a String

        System.out.print(receiptText);  // Display receipt to screen
        storeReceipt(receiptText); // Creates/saves receipt to a file
    }
    //Returns the entire receipt as a String; make it private because only the Receipt class uses it.
    private static String generateReceiptText(Cart cart,
                                       double amountPaid,
                                       double changeGiven){

        StringBuilder receipt = new StringBuilder(); //Used for building large strings efficiently

        receipt.append("+=====================+\n");
        receipt.append("+    SALES RECEIPT    +\n");
        receipt.append("+=====================+\n");

        LocalDateTime now = LocalDateTime.now(); // gets current date/time

        receipt.append("Order Date:\n");
        receipt.append(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))); // formats the date to be more readable
        receipt.append("\n\n");

        for (CartItem item : cart.getItems()) { // cycles through all cart items
            receipt.append(String.format("%s x%d%n", item.getProduct().getName(), item.getQuantity())); // how the system will print out the product(s) on receipt
        }

        receipt.append("\n---------------------------------------\n"); // creates a line to separate the items from the total
        receipt.append(String.format("Sales Total: $%.2f%n", cart.getTotal()));
        receipt.append(String.format("Amount Paid: $%.2f%n", amountPaid));
        receipt.append(String.format("Change Due: $%.2f%n", changeGiven));
        receipt.append("=======================================\n");
        receipt.append("Thank You For Shopping!\n");

        return receipt.toString(); // Converts StringBuilder into a String so it can be printed and saved
    }
    public static void storeReceipt(String receiptText){ //Receives the completed receipt and saves it

        File folder = new File("Receipts"); // represents the folder name Receipts but doesn't create it just yet
        if (!folder.exists() && !folder.mkdirs()) { //checks if file doesn't(!) exist; creates the folder if it doesn't exist; checks whether the folder was successfully created
            System.out.println("Could not create Receipts folder."); // displays error message if error creating folder
            return;
        }

        LocalDateTime now = LocalDateTime.now(); // assigns the local date/time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss"); //produces date/time in specified format

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("Receipts/" + now.format(formatter) + ".txt"))){ // creates the name of the file
            writer.write(receiptText); // Writes the receipt contents into the file
            System.out.println("Receipt successfully saved to: " + writer); //

        }
        catch (IOException e){
            System.out.println("Error saving receipt:" + e.getMessage()); // displays the actual error
        }
    }
}
