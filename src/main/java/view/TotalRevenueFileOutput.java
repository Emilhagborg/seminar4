/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author emilhagborg
 */


import Module.SaleObserver;
import java.io.FileWriter;
import java.io.IOException;

public class TotalRevenueFileOutput implements SaleObserver {
    private double totalRevenue = 0;
    private final String filename = "totalRevenueLog.txt";

    /**
     *
     * @param saleTotal
     */
    @Override
    public void newSale(double saleTotal) {
        totalRevenue += saleTotal;
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write("Total intäkt hittills: " + totalRevenue + " kr\n");
        } catch (IOException e) {
            System.err.println("Kunde inte skriva till loggfil: " + e.getMessage());
        }
    }
}