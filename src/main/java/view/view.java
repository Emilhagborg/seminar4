/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import DTO.ItemDTO;
import DTO.ReceiptDTO;
import DTO.SoldItem;
import Module.InvalidQuantityException;
import Unit.Logger;
import controller.Poscontroller;
import integration.DatabaseFailureException;
import integration.InvalidAgeException;
import integration.ItemNotFoundException;
import java.util.Scanner;
import Module.SaleObserver;
import view.TotalRevenueFileOutput;

/**
 *
 * @author emilhagborg
 */
public class view {

    private Poscontroller controller;
    private Scanner scanner;
    private final Logger logger;
    public view(Poscontroller controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
        this.logger = new Logger();
        controller.addSaleObserver(new TotalRevenueFileOutput());
        
    }

    public void startSale() {
        controller.StartSale();
        System.out.println("försäljning har startat");
    }

    public void registerItem() {
    boolean produkter = true;

    while (produkter) {
        System.out.print("Ange ItemID tills varorna är slut:skriv då end ");
        String itemIdentifier = scanner.nextLine().trim();

        if (itemIdentifier.equalsIgnoreCase("end")) {
            System.out.println("inga fler varor.");
            break;
        }

        System.out.print("Ange antal: ");
        String quantityInput = scanner.nextLine().trim();

        try {
            int quantity = Integer.parseInt(quantityInput);

            controller.registerItem(itemIdentifier, quantity);
            System.out.println("Produkt registrerad.");
        } catch (NumberFormatException e) {
            System.out.println("Fel: Du måste mata in ett  heltal för antal.");
        } catch (InvalidQuantityException e) {
            System.out.println("Fel: " + e.getMessage());
        } catch (ItemNotFoundException e) {
            System.out.println("Fel: Produkten med ID '" + itemIdentifier + "' finns inte i lagret.");
        }catch (DatabaseFailureException e) {
            System.out.println(" fel: Databasen gick inte att nå.");
            logger.logException(e);
        }
    }
}
    public void applyDiscount() {
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Ange kundens ålder: ");
            String input = scanner.nextLine();

            try {
                double age = Double.parseDouble(input.replace(',', '.'));
                controller.applyDiscount(age);
                System.out.println("Rabatt utförd.");
                validInput = true;
            } catch (InvalidAgeException e) {
                System.out.println("Fel: " + e.getMessage());
            }catch (NumberFormatException e) {
            System.out.println("Fel: Du måste mata in ett  heltal för antal.");
      
            }catch (DatabaseFailureException e) {
            System.out.println(" fel: Databasen gick inte att nå.");
            logger.logException(e);
        }
        }
    }

   public void endSale() {
    try {
        System.out.println("Försäljning avslutad.");
        ReceiptDTO receipt = controller.endSale();
        printReceipt(receipt);
    } catch (DatabaseFailureException e) {
        System.out.println(" fel: Databasen gick inte att nå.");
        logger.logException(e);
    }
}

    public void printReceipt(ReceiptDTO receipt) {
        System.out.println("\n\nKvitto:");
        System.out.println("Datum: " + receipt.getSaleTime());

        for (SoldItem soldItem : receipt.getSoldItems()) {
            ItemDTO item = soldItem.getItem();
            int quantity = soldItem.getQuantity();
            double price = item.getPrice();
            double totalItemPrice = soldItem.getTotalPriceWithVAT();

            System.out.println(item.getName() + " (" + quantity + " x " + price + " kr): " + totalItemPrice + " kr inkl. moms");
        }

        double totalPrice = receipt.getTotalPrice();
        double discountRate = receipt.getDiscountRate();
        double discountedPrice = totalPrice * discountRate;

        System.out.println("Totalt före rabatt: " + totalPrice + " kr");
        System.out.println("Efter rabatt: " + discountedPrice + " kr (" + (int) (discountRate * 100) + "%)");
        System.out.println("Tack för att du handlat!\n");
    }

}
