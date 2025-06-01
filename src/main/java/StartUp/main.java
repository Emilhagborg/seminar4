/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StartUp;

import Module.SaleObserver;
import controller.Poscontroller;
import view.TotalRevenueFileOutput;
import view.TotalRevenueView;
import view.view;

/**
 *
 * @author emilhagborg
 */
public class main {
    public static void main(String[] args) {
        Poscontroller contr = new Poscontroller();

        SaleObserver revenueObserver = new TotalRevenueView();
        TotalRevenueFileOutput totalRevenueFileOutput = new TotalRevenueFileOutput();

        
        contr.addSaleObserver(totalRevenueFileOutput);
        contr.addSaleObserver(revenueObserver);

        view delta = new view(contr);
        delta.startSale(); 

        delta.registerItem();
        delta.applyDiscount();
        delta.endSale();
    }
}
