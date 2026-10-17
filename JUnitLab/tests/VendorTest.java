import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

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
    @Test
    void restockExistingVendorItemTest(){
        vendor.restockExistingVendorItem("Candy",10);
        assertEquals(20, vendor.getItemStock("Candy"));
    }
    @Test
    void restockExistingVendorItemAndNewItems(){
        vendor.restockExistingVendorItemAndNewItems("Candy",1.25,15);
        assertEquals(25,vendor.getItemStock("Candy"));
        vendor.restockExistingVendorItemAndNewItems("Chips",3.25,5);
        assertEquals(5,vendor.getItemStock("Chips"));
    }
    @Test
    void changeExistingNameOfItem(){
        vendor.changeExistingNameOfItem("Candy", "Chips");
        assertTrue(vendor.hasItem("Chips"));
        assertFalse(vendor.hasItem("Candy"));
    }
    @Test
    void multipleVendorsTest(){
        Vendor vendor2 = new Vendor(10, 20);
        assertEquals(10,vendor.getItemStock("Candy"));
        assertEquals(10,vendor2.getItemStock("Candy"));
        vendor2.restockExistingVendorItem("Candy",10);
        assertEquals(20, vendor2.getItemStock("Candy"));
        assertEquals(10,vendor.getItemStock("Candy"));

    }
}