/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Module.Sale;
import Module.Receipt;
import DTO.Amount;
/**
 *
 * @author emilhagborg
 */


public class TestReceipt {
    public static void main(String[] args) {
       
        
        Sale sale = new Sale();
        

        sale.registerItem(new DTO.ItemDTO("Cola",new Amount(20,2) , "cola001"), 3);

        Receipt receipt = new Receipt(sale);
        
    }
}

