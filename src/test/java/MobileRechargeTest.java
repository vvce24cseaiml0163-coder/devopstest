
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

public class MobileRechargeTest {

    @Test
    void testValidMobileNumber() {
        assertTrue(MobileRecharge.validateMobile("9876543210"));
    }

    @Test
    void testInvalidMobileNumber() {
        assertFalse(MobileRecharge.validateMobile("1234abcd7890"));
        assertFalse(MobileRecharge.validateMobile("987654321"));
        assertFalse(MobileRecharge.validateMobile("98765432101"));
        assertFalse(MobileRecharge.validateMobile("abcdefghij"));
    }

    @Test
    void testDisplayPlans() {
        Map<Integer, Double> plans = MobileRecharge.getPlans();

        assertEquals(3, plans.size());
        assertTrue(plans.containsKey(1));
        assertTrue(plans.containsKey(2));
        assertTrue(plans.containsKey(3));
    }

    @Test
    void testSelectPlan() {
        assertEquals(199.0, MobileRecharge.selectPlan(1));
        assertEquals(299.0, MobileRecharge.selectPlan(2));
        assertEquals(399.0, MobileRecharge.selectPlan(3));
    }

    @Test
    void testInvalidPlanSelection() {
        assertThrows(IllegalArgumentException.class,
                () -> MobileRecharge.selectPlan(5));
    }

    @Test
    void testCorrectRechargeAmount() {
        String result = MobileRecharge.recharge("9876543210", 2);

        assertTrue(result.contains("Rs.299.0"));
        assertTrue(result.contains("Recharge Successful"));
    }

    @Test
    void testRechargeWithInvalidMobile() {
        assertThrows(IllegalArgumentException.class,
                () -> MobileRecharge.recharge("1234567890", 1));
    }

    @Test
    void testInvalidRechargeAmount() {
        assertThrows(IllegalArgumentException.class,
                () -> MobileRecharge.selectPlan(0));
    }
}
