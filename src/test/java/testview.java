/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import controller.Poscontroller;
import view.view;

/**
 *
 * @author emilhagborg
 */
public class testview {
   public static void main(String[] args) {
       
        Poscontroller controller = new Poscontroller();

        
        view view = new view(controller);

        
        view.startSale();
        
       
        view.registerItem();
        
        
        view.applyDiscount();
        
       
        view.endSale();
    }
    
}
