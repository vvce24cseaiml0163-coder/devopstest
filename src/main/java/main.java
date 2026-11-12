import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MobileRecharge recharge = new MobileRecharge();

        System.out.println("=== MOBILE RECHARGE APPLICATION ===");

        System.out.print("Enter Mobile Number: ");
        String mobile = sc.nextLine();

        if (!recharge.validateMobile(mobile)) {
            System.out.println("Invalid Mobile Number!");
            sc.close();
            return;
        }

        System.out.println("\nAvailable Recharge Plans:");

        recharge.getPlans().forEach(
                (id, amount) ->
                        System.out.println(id + ". Rs." + amount)
        );

        System.out.print("\nSelect Plan ID: ");

        try {
            int planId = Integer.parseInt(sc.nextLine());

            String result = recharge.recharge(mobile, planId);

            System.out.println("\n" + result);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
