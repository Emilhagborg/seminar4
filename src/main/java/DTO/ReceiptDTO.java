/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class ReceiptDTO {
    private final LocalDateTime saleTime;
    private final List<SoldItem> soldItems;
    private final double totalPrice;
    private final double discountRate;

    public ReceiptDTO(LocalDateTime saleTime, List<SoldItem> soldItems, double totalPrice, double discountRate) {
        this.saleTime = saleTime;
        this.soldItems = Collections.unmodifiableList(soldItems);
        this.totalPrice = totalPrice;
        this.discountRate = discountRate;
    }

    public LocalDateTime getSaleTime() {
        return saleTime;
    }

    public List<SoldItem> getSoldItems() {
        return soldItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getDiscountRate() {
        return discountRate;
    }
}
