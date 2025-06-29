import java.util.Scanner;

public class ElectricityBillingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of customers (3 to 5): ");
        int number = scanner.nextInt();

        while (number < 3 || number > 5) {
            System.out.println("Invalid input! Please enter a number between 3 and 5.");
            System.out.print("Enter number of customers (3 to 5): ");
            number = scanner.nextInt();
        }

        Customer highestPaying = null;
        double maxBill = 0;

        for (int i = 1; i <= number; i++) {
            scanner.nextLine();  // Consume newline

            System.out.println("\nEnter details for customer " + i + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("House Number: ");
            String houseNo = scanner.nextLine();

            System.out.print("Units Consumed: ");
            int units = scanner.nextInt();

            Customer cust = new Customer(name, houseNo, units);
            cust.printBill(i);

            if (cust.bill > maxBill) {
                maxBill = cust.bill;
                highestPaying = cust;
            }
        }

        System.out.println("\n=== Highest Paying Customer ===");
        if (highestPaying != null) {
            System.out.println("Name: " + highestPaying.name);
            System.out.println("House Number: " + highestPaying.houseNumber);
            System.out.println("Paid Amount: Rs. " + String.format("%.2f", highestPaying.bill));
        }

        scanner.close();
    }
}