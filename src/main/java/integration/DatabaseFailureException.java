/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integration;

/**
 *
 * @author emilhagborg
 */
public class DatabaseFailureException extends RuntimeException {
    public DatabaseFailureException(String message) {
        super(message);
    }
}
