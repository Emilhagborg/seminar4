/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Module;

import DTO.ItemDTO;
import DTO.SoldItem;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
       
/**
 *
 * @author emilhagborg
 */
public class Sale {
private final List<SaleObserver> observers = new ArrayList<>();
    private final LocalDateTime saleTime;
    private final List<SoldItem> soldItems;
    private double discount = 1.0;

    public Sale() {
        this.saleTime = LocalDateTime.now();
        this.soldItems = new ArrayList<>();
        
    }

    public void registerItem(ItemDTO item, int quantity) {
        for (SoldItem soldItem : soldItems) {
            if (soldItem.getItem().getIdentifier().equals(item.getIdentifier())) {
                soldItem.increaseQuantity(quantity);
                
                return;
            }
        }
        soldItems.add(new SoldItem(item, quantity));
        
    }

    public double getTotalPriceIncludingVAT() {
        double total = 0;
        for (SoldItem item : soldItems) {
            total += item.getTotalPriceWithVAT();
        }
        return total;
    }

    public LocalDateTime getSaleTime() {
        return saleTime;
    }

    public Receipt endSale() {
        double totalWithDiscount = getTotalPriceIncludingVATWitoutDiscount();
        notifyObservers(totalWithDiscount);
       return new Receipt(this);

    }

    public List<SoldItem> getSoldItems() {
        return soldItems;
    }

    public double applyDiscount(double discount) {
        this.discount = discount;
        return discount;
    }

    public double getDiscountRate() {
        return discount;
    }
    public double getTotalPriceIncludingVATWitoutDiscount() {
        double total = 0;
        for (SoldItem item : soldItems) {
            total += item.getTotalPriceWithVAT();
        }
        return total*discount;
    }
    public void addObserver(SaleObserver observer) {
    observers.add(observer);
}
    private void notifyObservers(double saleTotal) {
    for (SaleObserver obs : observers) {
        obs.newSale(saleTotal);
    }
}


    
}
