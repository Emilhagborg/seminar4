/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author emilhagborg
 */
public class SoldItem {
    private final ItemDTO item;
    private int quantity;

    public SoldItem(ItemDTO item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public void increaseQuantity(int amount) {
        this.quantity += amount;
    }

    public ItemDTO getItem() {
        return item;
    }

    public double getTotalPriceWithVAT() {
        double priceWithVAT = item.getPrice() * (1 + (item.getVAT() / 100.0));
        return priceWithVAT * quantity;
    }
    public int getQuantity(){
        return quantity;
    }
    
}
