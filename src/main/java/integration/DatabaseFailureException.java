/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integration;
/**
 * Ett undantag som throws när det inte går att komma åt de externa systemen,
 * till exempel på grund av ett simulerat databasfel.
 * 
 * Detta undantag används för en situation där databasservern inte är igång
 * eller inte kan nås.
 * 
 * Detta är ett okontrollerat undantag  eftersom felet inte kan 
 * hanteras på ett meningsfullt sätt där det inträffar.
 * 
 * @author Emil Hagborg
 */
public class DatabaseFailureException extends RuntimeException {
    /**
     * Skapar ett nytt undantag som representerar ett databasfel.
     * 
     * @param message Ett meddelande som beskriver orsaken till felet.
     */
    public DatabaseFailureException(String message) {
        super(message);
    }
}
