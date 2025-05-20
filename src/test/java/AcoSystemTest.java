/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author emilhagborg
 */
import integration.AcoSystem;
import Module.Sale;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AcoSystemTest {

    @Test
public void testAddToAco() {
    AcoSystem acoSystem = new AcoSystem();
    Sale testSale = new Sale();

    acoSystem.addToAco(testSale);

    assertTrue(acoSystem.containsSale(testSale));
}
}