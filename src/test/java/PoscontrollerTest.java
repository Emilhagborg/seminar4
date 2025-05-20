
import Module.InvalidQuantityException;
import controller.Poscontroller;
import integration.InvalidAgeException;
import integration.ItemNotFoundException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author emilhagborg
 */



public class PoscontrollerTest {

    @Test
    public void testFullSaleFlow() throws ItemNotFoundException, InvalidQuantityException, InvalidAgeException {
        Poscontroller controller = new Poscontroller();

        
        controller.StartSale();

       
        controller.registerItem("aaa111", 2); 

        
        controller.applyDiscount(75); 

        
        controller.endSale();

        
    }
}