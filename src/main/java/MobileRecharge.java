import java.util.*;

public class MobileRecharge {

    private static final Map<Integer, Double> plans = new LinkedHashMap<>();

    static {
        plans.put(1, 199.0);
        plans.put(2, 299.0);
        plans.put(3, 399.0);
    }

    public static boolean validateMobile(String mobile) {
        return mobile != null && mobile.matches("[6-9]\\d{9}");
    }

    public static Map<Integer, Double> getPlans() {
        return Collections.unmodifiableMap(plans);
    }

    public static double selectPlan(int plan) {
        if (!plans.containsKey(plan)) {
            throw new IllegalArgumentException("Invalid plan selection");
        }
        return plans.get(plan);
    }

    public static String recharge(String mobile, int plan) {
        if (!validateMobile(mobile)) {
            throw new IllegalArgumentException("Invalid mobile number");
        }

        double amount = selectPlan(plan);

        return "Recharge Successful! Mobile: " + mobile
                + ", Amount: Rs." + amount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== MOBILE RECHARGE APPLICATION ===");

        System.out.print("Enter mobile number: ");
        String mobile = sc.nextLine();

        if (!validateMobile(mobile)) {
            System.out.println("Invalid mobile number!");
            return;
        }

        System.out.println("\nAvailable Recharge Plans:");
        System.out.println("1. Rs.199");
        System.out.println("2. Rs.299");
        System.out.println("3. Rs.399");

        System.out.print("Select a plan (1-3): ");
        int plan = sc.nextInt();

        try {
            System.out.println(recharge(mobile, plan));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
