/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integration;

/**
 *
 * @author emilhagborg
 * Representerar ett undantag som kastas när en ålder som är ogiltig.
 * Detta kan inträffa om en ålder är negativ, noll, eller om personen är över 130(orimligt).
 */
public class InvalidAgeException extends Exception {
    /**
     * Skapar ett nytt undantag som representerar ogiltig ålder.
     * Meddelandet förklarar varför åldern anses vara ogiltig.
     *
     * @param message Det meddelande som beskriver orsaken till undantaget.
     */
    public InvalidAgeException(String message) {
        super(message);
    }
}

