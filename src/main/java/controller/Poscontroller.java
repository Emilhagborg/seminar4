/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DTO.ItemDTO;
import DTO.ReceiptDTO;
import Module.InvalidQuantityException;
import Module.Receipt;
import Module.Sale;
import Module.SaleObserver;
import integration.AcoSystem;
import integration.CusData;
import integration.DatabaseFailureException;
import integration.ExternalInventorySystem;
import integration.InvalidAgeException;
import integration.ItemNotFoundException;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author emilhagborg
 */
public class Poscontroller {
    private Sale sale;
    private final ExternalInventorySystem externalInventorySystem;
    private final AcoSystem acoSystem;
    private final CusData cusData;
    private final List<SaleObserver> observers = new ArrayList<>();

    public Poscontroller() {
        this.sale = new Sale();
        this.externalInventorySystem = new ExternalInventorySystem();
        this.cusData = new CusData();
        this.acoSystem = new AcoSystem();
    }

    public void StartSale() {
        sale = new Sale();

        
        SaleObserver saleObserver = new SaleLogger();
        sale.addObserver(saleObserver);

        
        for (SaleObserver observer : observers) {
            sale.addObserver(observer);
        }
    }

    public ItemDTO registerItem(String itemIdentifier, int quantity)
            throws ItemNotFoundException, InvalidQuantityException, DatabaseFailureException {
        if (quantity <= 0) {
            throw new InvalidQuantityException("Antal måste vara större än 0.");
        }

        ItemDTO item = externalInventorySystem.findItem(itemIdentifier);
        if (item != null) {
            sale.registerItem(item, quantity);
        }
        return item;
    }

    public double applyDiscount(double customerAge)
            throws InvalidAgeException, DatabaseFailureException {
        double discount = cusData.getDiscount(customerAge);
        return sale.applyDiscount(discount);
    }

    public ReceiptDTO endSale() throws DatabaseFailureException {
        sale.endSale();
        acoSystem.addToAco(sale);
        Receipt receipt = new Receipt(sale);
        return receipt.toDTO();
    }

    public void addSaleObserver(SaleObserver observer) {
        observers.add(observer);
        if (sale != null) {
            sale.addObserver(observer);
        }
    }
}