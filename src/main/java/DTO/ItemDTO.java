/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author emilhagborg
 */
public class ItemDTO {

    private final String name;
    private final Amount Amount;

    private final String identifier;

    public ItemDTO(String name, Amount Amount, String identifier) {
        this.name = name;
        this.Amount = Amount;
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public int getVAT() {
        return Amount.getVAT();
    }

    public double getPrice() {
        return Amount.getPrice();
    }

    public String getIdentifier() {
        return identifier;
    }

}
