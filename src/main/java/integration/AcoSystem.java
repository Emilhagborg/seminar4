/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integration;
import java.util.ArrayList;
import Module.Sale;
import java.util.List;

/**
 *
 * @author emilhagborg
 */



public class AcoSystem {
    private List<Sale> allSales = new ArrayList<>();

    public void addToAco(Sale sale)throws DatabaseFailureException{
       if (sale == null) {
            throw new DatabaseFailureException("Kunde inte spara försäljningen – försäljningsobjektet var null.");
        }
        allSales.add(sale);
        
    }

    
    public boolean containsSale(Sale sale) {
        if (sale == null) {
            throw new DatabaseFailureException("Kunde inte spara försäljningen – försäljningsobjektet var null.");
        }
        return allSales.contains(sale);
    }

    
    public List<Sale> getAllSales(){
       if (allSales == null) {
        throw new DatabaseFailureException("Försäljningslistan är inte tillgänglig.");
    }
        return allSales;
    }
}