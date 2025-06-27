import java.util.Scanner;

public class ElectricityBillingSystem {

    // Method to calculate bill based on unit slabs
    public static double calculateBill(int units) {
        double bill = 0;
        if (units <= 10) {
            bill = units * 10; // Rs. 10 per unit
        } else if (units <= 20) {
            bill = 10 * 10 + (units - 10) * 15; // Rs. 15 per unit for next 10 units
        } else if (units <= 30) {
            bill = 10 * 10 + 10 * 15 + (units - 20) * 20; // Rs. 20 per unit for next 10 units
        } else {
            bill = 10 * 10 + 10 * 15 + 10 * 20 + (units - 30) * 25; // Rs. 25 per unit beyond 30
        }
        return bill;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    }
}