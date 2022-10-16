package app;

import model.services.BrazilTaxService;
import model.services.RentalService;
import model.utilities.CarRental;
import model.utilities.Vehicle;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");


        System.out.println("Enter renting details: ");
        System.out.print("Car model: ");
        String carModel = sc.nextLine();
        System.out.print("Retrieve (dd/MM/yyyy hh:mm): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
        System.out.print("Return (dd/MM/yyyy hh:mm): ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);


        CarRental cr = new CarRental(start, finish, new Vehicle(carModel));

        System.out.print("Enter price per hour: ");
        double pricePerHour = sc.nextDouble();
        System.out.print("Enter price per day: ");
        double pricePerDay = sc.nextDouble();

        RentalService rentalService = new RentalService(pricePerDay, pricePerDay, new BrazilTaxService());
        rentalService.processInvoice(cr);

        System.out.println("Invoice: ");
        System.out.println("Basic payment: " + String.format("%.2f",cr.getInVoice().getBasicPayment()));
        System.out.println("Taxes: " + String.format("%.2f",cr.getInVoice().getTax()));
        System.out.println("Total: " + String.format("%.2f",cr.getInVoice().getTotalPayment()));



        sc.close();
    }
}
