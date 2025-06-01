/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Module;

/**
 * Representerar ett undantag som kastas när antalet handlade varor är ogiltig.
 * Detta undantag visar att antalet är noll eller negativ,
 *
 * @author emilhagborg
 */
public class InvalidQuantityException extends Exception {
    /**
     * Skapar ett nytt undantag som representerar ett antal fel.
     * 
     * @param message Ett meddelande som beskriver orsaken till felet.
     */
    public InvalidQuantityException(String message) {
        super(message);
    }
}
