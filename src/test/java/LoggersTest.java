/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author emilhagborg
 */
import Module.InvalidQuantityException;
import Unit.Logger;
import org.junit.jupiter.api.*;
import java.nio.file.*;
import java.io.IOException;
import controller.Poscontroller;
import integration.ItemNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import view.TotalRevenueFileOutput;

public class LoggersTest {

    private Logger logger;
    private static final Path LOG_FILE_PATH = Paths.get("errorlog.txt");

    @BeforeEach
    public void setUp() throws IOException {
        logger = new Logger();
        
        if (Files.exists(LOG_FILE_PATH)) {
            Files.delete(LOG_FILE_PATH);
        }
        Files.createFile(LOG_FILE_PATH);
    }

    @Test
    public void testLogExceptionWritesToFile() throws IOException {
        Exception testException = new Exception("Detta är ett testfel");

        logger.logException(testException);

        
        String content = Files.readString(LOG_FILE_PATH);

        assertTrue(content.contains("Exception"));
        assertTrue(content.contains("Detta är ett testfel"));
    }
      @Test
      public void testLogExceptionSale() throws ItemNotFoundException, InvalidQuantityException, IOException {
       Files.write(Paths.get("totalRevenueLog.txt"), new byte[0]);

    Poscontroller cont = new Poscontroller();
    
    cont.addSaleObserver(new TotalRevenueFileOutput());

    cont.StartSale();
    cont.registerItem("aaa111", 3);
    cont.endSale();

    List<String> logLines = Files.readAllLines(Paths.get("totalRevenueLog.txt"));
    assertFalse(logLines.isEmpty(), "Det ska finnas något");

    boolean containsItem = logLines.stream().anyMatch(line -> line.contains("aaa111"));
    assertFalse(containsItem, " den skriver bara intäkter");
}
}