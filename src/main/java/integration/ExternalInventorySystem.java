/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integration;

import DTO.Amount;
import DTO.ItemDTO;

/**
 *
 * @author emilhagborg
 */
public class ExternalInventorySystem {

    public ItemDTO findItem(String itemIdentifier) throws ItemNotFoundException,DatabaseFailureException{
        
        if (itemIdentifier.equals("dbfail")) {
            throw new DatabaseFailureException("Databasen är otillgänglig. Försök igen senare.");
        }

        if(itemIdentifier.equals("aaa111")){
            return new ItemDTO("Schampo", new Amount(30.0, 6), "aaa111");
        }
        else if(itemIdentifier.equals("aaa112")){
            return new ItemDTO("Pasta Penne", new Amount(6.5, 6), "aaa112");
        }
        else {
            throw new ItemNotFoundException(itemIdentifier);
        }
    }
}
