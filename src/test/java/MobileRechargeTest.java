import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MobileRechargeTest {

    MobileRecharge recharge = new MobileRecharge();

    @Test
    void testValidMobile() {
        assertTrue(recharge.validateMobile("9876543210"));
    }

    @Test
    void testInvalidMobile() {
        assertFalse(recharge.validateMobile("1234567890"));
    }

    @Test
    void testNullMobile() {
        assertFalse(recharge.validateMobile(null));
    }

    @Test
    void testDisplayPlans() {
        assertEquals(3, recharge.getPlans().size());
    }

    @Test
    void testValidPlan() {
        assertEquals(199.0, recharge.getRechargeAmount(1));
    }

    @Test
    void testRechargeAmount() {
        assertEquals(299.0, recharge.getRechargeAmount(2));
    }

    @Test
    void testInvalidPlan() {
        assertThrows(
                IllegalArgumentException.class,
                () -> recharge.getRechargeAmount(10)
        );
    }

    @Test
    void testSuccessfulRecharge() {
        String result = recharge.recharge("9876543210", 1);

        assertTrue(result.contains("Recharge Successful"));
    }

    @Test
    void testRechargeInvalidMobile() {
        assertThrows(
                IllegalArgumentException.class,
                () -> recharge.recharge("1234567890", 1)
        );
    }
}
