/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integration;

/**
 *
 * @author emilhagborg
 */
public class ItemNotFoundException extends Exception {
    
    public ItemNotFoundException(String itemID) {
        super("varan med detta ID " + itemID + " hittades inte.");
    }
}