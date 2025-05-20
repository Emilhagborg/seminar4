/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integration;

/**
 *
 * @author emilhagborg
 */
public class CusData {
     public double getDiscount(double age)throws InvalidAgeException,DatabaseFailureException {
        if (age==0) {
        
            throw new DatabaseFailureException("Databasen är otillgänglig. Försök igen senare.");
         }

       
         if (age < 0||age >130){
        throw new InvalidAgeException("Ogiltig ålder: " + age);
        }
         
         
         
         if (age < 20 || age > 70) {
            return 0.9; 
        } else {
            return 1.0; 
        }
    }
}
