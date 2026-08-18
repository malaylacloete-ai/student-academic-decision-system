public class StudentServiceCalculator {

    // Exercise 2 — Fee Discount (if-else)
    public static double determineFeeDiscount(boolean specialCategory) {
        double discount;
        if (specialCategory) {
            discount = 0.20; // 20% discountS
        } else {
            discount = 0.05; // 5% discount
        }
        return discount;
    }

    // Exercise 3 — Admission Decision (&& triple condition)
    public static boolean isAdmitted(int age, int mark, int attendance) {
        return age >= 18 && mark >= 50 && attendance >= 75;
    }

    // Exercise 4 — Emergency Academic Support (||)
    public static boolean checkEmergencySupport(int mark, int attendance) {
        return mark < 40 || attendance < 50;
    }

    public static void main(String[] args) {

        System.out.println("=== Test 1: Special-category student (expect 20% discount) ===");
        double discount1 = determineFeeDiscount(true);
        System.out.println("Discount: " + (discount1 * 100) + "%");

        System.out.println("\n=== Test 2: Standard student (expect 5% discount) ===");
        double discount2 = determineFeeDiscount(false);
        System.out.println("Discount: " + (discount2 * 100) + "%");

        System.out.println("\n=== Test 3: Admitted case (age 20, mark 65, attendance 80) ===");
        boolean admitted1 = isAdmitted(20, 65, 80);
        System.out.println("Admitted: " + admitted1);

        System.out.println("\n=== Test 4: Not-admitted case (age 17, mark 65, attendance 80) ===");
        boolean admitted2 = isAdmitted(17, 65, 80);
        System.out.println("Admitted: " + admitted2);

        System.out.println("\n=== Test 5: Emergency support trigger (mark 35, attendance 60) ===");
        boolean emergency = checkEmergencySupport(35, 60);
        System.out.println("Emergency support required: " + emergency);
    }
}
