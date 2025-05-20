/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Module.SaleObserver;
/**
 *
 * @author emilhagborg
 */




public class TotalRevenueView implements SaleObserver {
    private double totalRevenue = 0;

    /**
     *
     * @param saleTotal
     */
    @Override
    public void newSale(double saleTotal) {
        totalRevenue += saleTotal;
        System.out.println("Totala intäkter hittills: " + totalRevenue + " kr");
    }
}
        
