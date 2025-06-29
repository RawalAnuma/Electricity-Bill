import java.util.Date;

public class Customer {
    String name;
    String houseNumber;
    int unitsConsumed;
    double bill;
    String billDetails = "";
    Date billDate;

    public Customer(String name, String houseNumber, int unitsConsumed) {
        this.name = name;
        this.houseNumber = houseNumber;
        this.unitsConsumed = unitsConsumed;
        this.billDate = new Date();
        calculateBill();
    }
    public void calculateBill() {
        int remainingUnits = unitsConsumed;
        double totalBill = 0;
        billDetails = "";

        if (remainingUnits < 10) {
            // Less than 10 units
            totalBill = remainingUnits * (100/10);
            billDetails += remainingUnits + " units × Rs. 10 = Rs. " + String.format("%.2f", totalBill) + "\n";

        } else if (remainingUnits == 10) {
            // Exactly 10 units
            totalBill = 100;
            billDetails += "10 units = Rs. 100\n";

        } else if (remainingUnits > 10 && remainingUnits < 30) {
            // More than 10 but less than 30 units i.e. 20 units
            totalBill += 100;
            billDetails += "First 10 units = Rs. 100\n";

            int unitsAbove10 = remainingUnits - 10;
            double rate = 250.0 / 20;  // Rs. 12.5 per unit for units above 10
            double partialCharge = unitsAbove10 * rate;
            totalBill += partialCharge;
            billDetails += "Next " + unitsAbove10 + " units × Rs. " + String.format("%.2f", rate) + " = Rs. " + String.format("%.2f", partialCharge) + "\n";

        } else if (remainingUnits == 30) {
            // Exactly 30 units
            totalBill = 100 + 250;
            billDetails += "First 10 units = Rs. 100\n";
            billDetails += "Next 20 units = Rs. 250\n";

        } else {
            // More than 30 units
            totalBill += 100;  // First 10 units
            billDetails += "First 10 units = Rs. 100\n";

            totalBill += 250;  // Next 20 units
            billDetails += "Next 20 units = Rs. 250\n";

            remainingUnits -= 30;
            double above30Charge = remainingUnits * 2;
            totalBill += above30Charge;
            billDetails += "Remaining " + remainingUnits + " units × Rs. 2 = Rs. " + String.format("%.2f", above30Charge) + "\n";
        }

        this.bill = totalBill;
    }

    public void printBill(int billNumber) {
        System.out.println("\n--- Bill #" + billNumber + " ---");
        System.out.println("Date: " + billDate);
        System.out.println("Customer Name: " + name);
        System.out.println("House Number: " + houseNumber);
        System.out.println("Units Consumed: " + unitsConsumed);
        System.out.println("Billing Details:\n" + billDetails);
        System.out.println("Total Bill: Rs. " + String.format("%.2f", bill));
    }
}
