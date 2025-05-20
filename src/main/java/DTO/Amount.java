/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

public class Amount {
    private double price;
    private int VAT;

    public Amount(double price, int VAT) {
        this.price = price;
        this.VAT = VAT;
    }

    public double getPrice() {
        return price;
    }

    public int getVAT() {
        return VAT;
    }

   
}