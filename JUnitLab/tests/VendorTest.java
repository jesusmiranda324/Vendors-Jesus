import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendorTest {
    private Vendor vendor;

    @BeforeEach
    void setUp(){
        vendor = new Vendor(10,20);
    }

    @Test
    void addMoneyTest(){
        vendor.addMoney(5.0);
        assertEquals(5.0, vendor.getBalance()
        );
    }

}