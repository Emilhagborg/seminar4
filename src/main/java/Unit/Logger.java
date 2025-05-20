/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Unit;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
    private static final String LOG_FILE = "errorlog.txt";

    public void logException(Exception e) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(LocalDateTime.now() + " - " + e.getClass().getSimpleName() + ": " + e.getMessage() + "\n");
        } catch (IOException ioEx) {
            System.out.println("Kunde inte logga felet: " + ioEx.getMessage());
        }
    }
}