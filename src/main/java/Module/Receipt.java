/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Module;


import DTO.ReceiptDTO;

/**
 *
 * @author emilhagborg
 */
public class Receipt {
    private final Sale sale;

    public Receipt(Sale sale) {
        this.sale = sale;
    }

    public ReceiptDTO toDTO() {
    return new ReceiptDTO(sale.getSaleTime(),sale.getSoldItems(),sale.getTotalPriceIncludingVAT(),sale.getDiscountRate());
    }
    
}
