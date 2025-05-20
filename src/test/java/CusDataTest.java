/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Module.InvalidQuantityException;
import integration.DatabaseFailureException;
import integration.CusData;
import integration.InvalidAgeException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import controller.Poscontroller;

public class CusDataTest {

    @Test
    public void testGetDiscount() throws InvalidAgeException {
       
        CusData cusData = new CusData();

        
        assertEquals(0.9, cusData.getDiscount(15), 0.01);  
        assertEquals(0.9, cusData.getDiscount(75), 0.01);  

       
        assertEquals(1.0, cusData.getDiscount(25), 0.01);   
        assertEquals(1.0, cusData.getDiscount(65), 0.01);  
        
        
    
    }
}