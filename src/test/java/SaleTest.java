/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import DTO.ItemDTO;
import DTO.Amount;
import DTO.SoldItem;
import Module.Sale;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SaleTest {

    @Test
    public void testRegisterItemAndQuantity() {
        Sale sale = new Sale();
        ItemDTO item = new ItemDTO("Kvarg", new Amount(10.0, 6), "abc123");

        sale.registerItem(item, 2);

        List<SoldItem> soldItems = sale.getSoldItems();
        assertEquals(1, soldItems.size(), "En vara bör vara registrerad.");
        assertEquals(2, soldItems.get(0).getQuantity(), "antalet borde vara 2.");
    }

    @Test
    public void testTotalPriceWithDiscount() {
        Sale sale = new Sale();
        ItemDTO item = new ItemDTO("Kvarg", new Amount(100.0, 25), "abc123");

        sale.registerItem(item, 1); 
        sale.applyDiscount(0.8);    

        double expected = 125.0 * 0.8;
        double actual = sale.getTotalPriceIncludingVATWitoutDiscount(); 

        assertEquals(expected, actual, 0.001, "Totalt pris med rabatt ska stämma.");
    }

    @Test
    public void testApplyDiscountChangesTotal() {
        Sale sale = new Sale();
        ItemDTO item = new ItemDTO("Kvarg", new Amount(50.0, 25), "abc124");

        sale.registerItem(item, 2); 
        double withoutDiscount = sale.getTotalPriceIncludingVAT();

        sale.applyDiscount(0.9); 
        double withDiscount = sale.getTotalPriceIncludingVATWitoutDiscount();

        assertEquals(withoutDiscount * 0.9, withDiscount, 0.001,
                "Priset med rabatt ska vara 90% av originalpriset.");
    }
}

