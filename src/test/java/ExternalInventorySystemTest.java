/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author emilhagborg
 */
import integration.ExternalInventorySystem;

import DTO.ItemDTO;
import integration.ItemNotFoundException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExternalInventorySystemTest {

    @Test
    public void testFindItem_validItem() throws ItemNotFoundException {
        ExternalInventorySystem system = new ExternalInventorySystem();

        
        ItemDTO item = system.findItem("aaa111");
        assertNotNull(item);
        assertEquals("Schampo", item.getName());
        assertEquals(30.0, item.getPrice());
        assertEquals(6, item.getVAT());
        assertEquals("aaa111", item.getIdentifier());

        ItemDTO notItem = system.findItem("aaa123");
        
        
    }

   
    
}
