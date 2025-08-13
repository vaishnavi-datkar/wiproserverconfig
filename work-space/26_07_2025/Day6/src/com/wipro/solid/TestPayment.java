package com.wipro.solid;

import java.util.Scanner;

public class TestPayment {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter payment amount:");
        double amount = scanner.nextDouble();

        System.out.println("Choose Payment Method:");
        System.out.println("1. GooglePay");
        System.out.println("2. PhonePay");
        System.out.println("3. Paytm");

        int choice = scanner.nextInt();
        DigitalPayment paymentApp;

        if (choice == 1) {
            paymentApp = new GooglePay();
        } else if (choice == 2) {
            paymentApp = new PhonePay();
        } else if (choice == 3) {
            paymentApp = new Paytm();
        } else {
            System.out.println("Invalid choice. Exiting...");
            scanner.close();
            return;
        }

        PaymentService service = new PaymentService(paymentApp);
        service.pay(amount);

        scanner.close();
    }
}
