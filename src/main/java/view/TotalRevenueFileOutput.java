package view;

import Module.SaleObserver;
import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class TotalRevenueFileOutput implements SaleObserver {
    private double totalRevenue = 0;
    private final String filename = "totalRevenueLog.txt";

    public TotalRevenueFileOutput() {
        
        totalRevenue = readTotalRevenueFromFile();
        System.out.printf("Tidigare sparad total intäkt: %.2f kr%n", totalRevenue);
    }

    @Override
    public void newSale(double saleTotal) {
        totalRevenue += saleTotal;
        try (FileWriter writer = new FileWriter(filename, true)) {
            
            writer.write(String.format(Locale.US, "Total intäkt hittills: %.2f kr%n", totalRevenue));
        } catch (IOException e) {
            System.err.println("Kunde inte skriva till loggfil: " + e.getMessage());
        }
    }

    private double readTotalRevenueFromFile() {
        double lastTotal = 0;
        File file = new File(filename);
        if (!file.exists()) {
            return 0; 
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            String lastLine = null;
            
            while ((line = br.readLine()) != null) {
                lastLine = line;
            }

            if (lastLine != null) {
               
                String numberPart = lastLine.replaceAll("[^0-9\\.,]", ""); 
                numberPart = numberPart.replace(',', '.');

                
                NumberFormat format = NumberFormat.getInstance(Locale.US);
                Number number = format.parse(numberPart);
                lastTotal = number.doubleValue();
            }

        } catch (IOException | ParseException e) {
            System.err.println("Fel vid läsning av totalRevenue från fil: " + e.getMessage());
        }

        return lastTotal;
    }
}
