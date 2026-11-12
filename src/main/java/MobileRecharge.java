import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class MobileRecharge {

    private final Map<Integer, Double> plans = new LinkedHashMap<>();

    public MobileRecharge() {
        plans.put(1, 199.0);
        plans.put(2, 299.0);
        plans.put(3, 499.0);
    }

    public boolean validateMobile(String mobile) {
        return mobile != null && mobile.matches("[6-9]\\d{9}");
    }

    public Map<Integer, Double> getPlans() {
        return Collections.unmodifiableMap(plans);
    }

    public double getRechargeAmount(int planId) {
        if (!plans.containsKey(planId)) {
            throw new IllegalArgumentException("Invalid plan selection");
        }

        return plans.get(planId);
    }

    public String recharge(String mobile, int planId) {
        if (!validateMobile(mobile)) {
            throw new IllegalArgumentException("Invalid mobile number");
        }

        double amount = getRechargeAmount(planId);

        return "Recharge Successful! Mobile: " + mobile
                + ", Amount: Rs." + amount;
    }
}
