
import DTO.Amount;
import DTO.ItemDTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
 
/**
 *
 * @author emilhagborg
 */



public class ItemDTOTest {

    @Test
    public void testItemDTOGetters() {
       
        Amount amount = new Amount(50.0, 25); 

        
        ItemDTO item = new ItemDTO("Schampo", amount, "aaa111");

       
        assertEquals("Schampo", item.getName());  
        assertEquals(25, item.getVAT());         
        assertEquals(50.0, item.getPrice());    
        assertEquals("aaa111", item.getIdentifier());
    }
}