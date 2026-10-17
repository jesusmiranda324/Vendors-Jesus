import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class VendorTest {
    private Vendor vendor;

    @BeforeEach
    void setUp(){
        vendor = new Vendor(10,20);
    }

    @Test
    void addMoneyTest(){
        vendor.addMoney(5.0);
        assertEquals(5.0, vendor.getBalance(),0.001);
    }

    @Test
    void buyItemTest(){
        vendor.addMoney(1.25);
        vendor.select("Candy");
        assertEquals(0.0, vendor.getBalance(),0.001);
    }

    @Test
    void emptyInventoryTest(){
        vendor.emptyInventory();
        assertFalse(vendor.hasItem("Candy"));
        assertFalse(vendor.hasItem("Gum"));
    }
}