import static org.junit.Assert.assertEquals;
import java.util.Scanner;

import org.junit.Test;

public class mainTest {
    
    @Test
    public void testSave(){
        UserInterface ui = new UserInterface();
        Scanner scan = new Scanner("Tenant.List.txt");

        ui.saveData(scan);
        assertEquals("FLYING TURTLES", "FLYING TURTLES");
    }
}