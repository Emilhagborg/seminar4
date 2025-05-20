
import Module.InvalidQuantityException;
import controller.Poscontroller;
import integration.DatabaseFailureException;
import integration.InvalidAgeException;
import integration.ItemNotFoundException;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author emilhagborg
 */
public class ExceptionTest{
@Test
void exception() {
    Poscontroller controller = new Poscontroller();
    controller.StartSale();  
    
    
    assertThrows(InvalidQuantityException.class, () -> {
        controller.registerItem("aaa111", 0);
    });
    
    assertThrows(InvalidQuantityException.class, () -> {
        controller.registerItem("aaa111", -5);
    });
    
     assertThrows(DatabaseFailureException.class, () -> {
        controller.registerItem("dbfail", 5);
    });
     
     assertThrows(ItemNotFoundException.class, () -> {
        controller.registerItem("grrrr", 5);
    }); 
      
     assertThrows(InvalidAgeException.class, () -> {
        controller.applyDiscount(-5);
    }); 
      assertThrows(InvalidAgeException.class, () -> {
        controller.applyDiscount(300);
    });
      assertThrows(DatabaseFailureException.class, () -> {
        controller.applyDiscount(0);
    });
      
}


}