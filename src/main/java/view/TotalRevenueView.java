package view;

import Module.SaleObserver;
/**
 *
 * @author emilhagborg
 */




public class TotalRevenueView implements SaleObserver {
 private double totalRevenue; 

    
    public TotalRevenueView() {
        this.totalRevenue = 0.0;
        System.out.println("Total intäkt startar på: 0.0 kr");
    }

    
    @Override
    public void newSale(double saleTotal) {
        totalRevenue += saleTotal; 
        System.out.printf("Total intäkt sedan programstart: %.2f kr%n", totalRevenue);
    }
}
      
        
