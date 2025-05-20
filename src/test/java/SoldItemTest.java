
import DTO.Amount;
import DTO.ItemDTO;
import DTO.SoldItem;
import org.junit.jupiter.api.Test;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author emilhagborg
 */


import static org.junit.jupiter.api.Assertions.*;

public class SoldItemTest {

    @Test
    public void testConstructorAndGetters() {
        ItemDTO item = new ItemDTO("Kvarg", new Amount(20, 2), "abc123");
        SoldItem soldItem = new SoldItem(item, 2);

        assertEquals(item, soldItem.getItem(), "Vara ska matcha den som skickades in.");
        assertEquals(2, soldItem.getQuantity(), "antalet ska vara 2.");
    }

    @Test
    public void testIncreaseQuantity() {
        ItemDTO item = new ItemDTO("Schampo", new Amount(20, 2), "abc123");
        SoldItem soldItem = new SoldItem(item, 2);

        soldItem.increaseQuantity(3);
        assertEquals(5, soldItem.getQuantity(), "antalet ska vara 5 efter ökning med 3.");
    }

    @Test
    public void testTotalPriceWithVAT() {
        ItemDTO item = new ItemDTO("Kvarg", new Amount(20, 2), "abc123");
        SoldItem soldItem = new SoldItem(item, 2);

        
        double expected = 20 * 1.02 * 2;
        assertEquals(expected, soldItem.getTotalPriceWithVAT(), 0.001, "Totalpris inkl moms ska vara korrekt.");
    }
}
