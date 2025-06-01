/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integration;

/**
 *
 * @author emilhagborg
 * Representerar ett undantag som kastas när en vara inte kunde hittas.
 * Detta undantag visar att en sökning efter en vara i invemtorysytem misslyckades
 * eftersom inget objekt med det angivna ID matchade.
 */
public class ItemNotFoundException extends Exception {
    /**
     * Skapar ett nytt undantag som representerar att varan gick inte att komma åt.
     * Meddelandet förklarar varför Id anses vara ogiltig.
     *
     * @param itemID är det id som inte funkade.
     */
    public ItemNotFoundException(String itemID) {
        super("varan med detta ID " + itemID + " hittades inte.");
    }
}
