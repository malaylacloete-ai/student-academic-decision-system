public class EligibilityChecker {

    /*Requirement 3- Attendance
    Attendance must be at least 75% to be considered "Sufficienct".
    */ 
     
    public static boolean isAttendanceSufficient(double attendance) {
        return attendance >= 75;
    }

    /*Requirement 5: Combined Decision AND (&&) 
      A student only qualifies for the exam if BOTH the mark and the
      attendance requirements are met at the same time.
    */
    public static boolean isExamEligible(double mark, double attendance) {
        return (mark >= 50) && isAttendanceSufficient(attendance);
    }

    //Step 9: Nested Decision Making
    /*checks student attendance, checks if student  pass or fail on the mark,
     *checks whether the pass is a Distinction or a normalPass.
    */
    public static void nestedDecisionMaking(String name, double mark, double attendance) {
        System.out.println("---- Decision Report for " + name + " ----");

        // Student attendance check
        if (isAttendanceSufficient(attendance)) {

            // check student mark is pass or fail (only checked if attendance is OK)
            if (mark >= 50) {

                // checks if it is  normal Pass vs Distinction pass (only checked if mark passed)
                if (mark >= 75) {
                    System.out.println("Result: DISTINCTION");
                } else {
                    System.out.println("Result: PASS");
                }
                System.out.println("Exam Eligibility: ELIGIBLE (mark and attendance both met)");

            } else {
                System.out.println("Result: FAIL (mark below 50)");
                System.out.println("Exam Eligibility: NOT ELIGIBLE - mark requirement not met");
            }

        } else {
            // Attendance checked failed at first, so then it is not  
            // required to check mark eligibility.
            System.out.println("Result: ATTENDANCE INSUFFICIENT (" + attendance + "% < 75%)");
            System.out.println("Exam Eligibility: NOT ELIGIBLE - attendance requirement not met");
        }

        System.out.println();
    }

    
    public static void main(String[] args) {

        // Test 1: pass mark with pass attendance
        nestedDecisionMaking("Aisha Adams", 82, 90);

        // Test  2: pass mark with  fail attendance
        nestedDecisionMaking("Bongani Khumalo", 65, 60);

        // Test  3: fail mark
        nestedDecisionMaking("Chloe van der Merwe", 42, 95);

        // Test 4:mark exactly 50, attendance exactly 75
        nestedDecisionMaking("David Petersen", 50, 75);

        
        System.out.println("=== isAttendanceSufficient() / isExamEligible() checks ===");
        System.out.println("Aisha  -> attendance sufficient: " + isAttendanceSufficient(90)
                + " | exam eligible: " + isExamEligible(82, 90));
        System.out.println("Bongani-> attendance sufficient: " + isAttendanceSufficient(60)
                + " | exam eligible: " + isExamEligible(65, 60));
        System.out.println("Chloe  -> attendance sufficient: " + isAttendanceSufficient(95)
                + " | exam eligible: " + isExamEligible(42, 95));
    }
}
    