import java.util.Scanner;

/**
 * Person 6 - ServiceMenuSystem
 * Covers: Step 10 (Create the Service Menu), Step 11 (Implement switch), Requirement 7 (Service Menu, Exercise 5 (Operator Precedence)
 * 
 * This class also contains main() and acts as the integration point that brings together everyone else classes:
 *  -StudentProfile
 *  -AgeCatergoryAnalyzer
 *  -AcademicResultevaluator
 *  -EligibilityChecker
 *  -StudentServiceCalculator
 * 
 * @author Student
 */
public class ServiceMenuSystem{
    
    private final Scanner sc = new Scanner(System.in);
    
    //Collaboratoring objects from the other group memebers classes
    private final StudentProfile profile = new StudentProfile();
    private final AgeCategoryAnalyzer ageAnalyzer = new AgeCategoryAnalyzer();
    
    public static void main(String[] args){
        ServiceMenuSystem system = new ServiceMenuSystem();
        system.run();
    }
    
    public void run(){
        try (sc) {
            System.out.println();
            System.out.println("Student Academic Decision");
            System.out.println();
            
            // Person 1's work
            profile.captureStudentInfo(sc);
            profile.displayStudentInfo();
            
            int age = profile.getAge();
            double mark = profile.getMark();
            double attendance = profile.getAttendance();
            
            // Person 2's work
            System.out.println("\nAge Category:" + ageAnalyzer. determineAgeGroup(age));
            boolean specialCategory = ageAnalyzer.isSpecialCategory(age);
            System.out.println("Student Catergory:" + (specialCategory ? "Special Category": "Standard Category"));
            
            //Person 3's work - AcademicResultEvaluator
            AcademicResultEvaluator evaluator = new AcademicResultEvaluator((int) mark);
            boolean markValid = evaluator.isMarkValid();
            if(!markValid){
                System.out.println("\nERROR: Mark" + mark + "is invalid. It must be between 0 and 100.");
            } else{
                System.out.println("mark validation: VALID (0-100 range");
            }
            System.out.println("Academic result (" + mark + "%):" + evaluator.determineAcademicResult());
            
            //Person 4's work - ElegibilityChecker
           System.out.println("\nAttendance: " + attendance + "% -> " +
                    (EligibilityChecker.isAttendanceSufficient(attendance) ? "Meets 75% minimum" : "Below 75% minimum"));
           System.out.println("Examination Eligibility: " +
                   (EligibilityChecker.isExamEligible(mark, attendance) ? "Eligible" : "Not Eligible"));
           EligibilityChecker.nestedDecisionMaking(profile.getName(), mark, attendance);
            
            //Person 5's work
            double discount = StudentServiceCalculator.determineFeeDiscount(specialCategory);
            System.out.println("\nFee Discount:" +(discount * 100) + "%");
            
            boolean admitted = StudentServiceCalculator.isAdmitted(age, (int)mark, (int) attendance);
            System.out.println("Admission Eligibility:" + (admitted ? "Admitted" : "Not Admitted"));
            
            boolean needsSupport = StudentServiceCalculator.checkEmergencySupport((int)mark, (int)attendance);
            System.out.println(needsSupport ? "Academic support required.": "Emergency Support: Not required.");
            
            // Person 6's work
            operatorPrecedanceDemo();
            serviceMenuLoop();
        }
       
    }
    
     private void operatorPrecedanceDemo(){
        System.out.println("\\n----- Exercise 5: Operator Precedence -----");
        
        boolean result1 = true || false && false;
        System.out.println("boolean result = true || false && false;");
        System.out.println(" -> Evaluates as: true || (false && false) = " + result1);
        
        boolean result2 = (true || false) && false;
        System.out.println("boolean result = (true || false && false;");
        System.out.println(" -> Evauluates as: (true || false) && false = " + result2);
        
        System.out.println("Comparison: result1 = " + result1 + ", result2" + result2 + 
                " -> Different results because parentheses change evaluation order.");
        System.out.println();
    }
    
    private void serviceMenuLoop(){
        boolean exit = false;
        while(!exit){
            System.out.println("\n----- Service Menu -----");
            System.out.println("1. Academic Results");
            System.out.println("2. Attendance");
            System.out.println("3. Fees");
            System.out.println("4. Student support");
            System.out.println("5. Exit");
            int serviceSelection = readInt("select a service (1-5)");
            
            switch (serviceSelection){
                case 1 -> {
                    AcademicResultEvaluator evaluator = new AcademicResultEvaluator((int) profile.getMark());
                    System.out.println("\n[academic Results]" + profile.getName() + ", your mark is" + 
                            profile.getMark() + " -> " + evaluator.determineAcademicResult());
                }
                    
                case 2 -> System.out.println("\n[Attendance]" + profile.getName() + ", your attendance is" +
                             profile.getAttendance()+ "%.");
                    
                case 3 -> {
                    boolean special = ageAnalyzer.isSpecialCategory(profile.getAge());
                    double discount = StudentServiceCalculator.determineFeeDiscount(special);
                    System.out.println("\n[Fees]" + profile.getName() + ", your fee discount is" + 
                            (discount * 100) + "%.");
                }
                    
                case 4 -> {
                   System.out.println("\n[Student Support] Please contact the Student Support office for assistance.");
                   boolean needsSupport = StudentServiceCalculator.checkEmergencySupport(
                   (int) profile.getMark(), (int) profile.getAttendance());
                   System.out.println(needsSupport ? "Academic support required." : "Emergency Academic Support: Not required.");
                }
                    
                case 5 -> {
                    System.out.println("\nExiting the Student academic Decision System. Goodbye," + profile.getName() + "!");
                    exit = true;
                }
                    
                default -> System.out.println("\nInvalid menu selection. Please choose a number between 1 and 5.");
            }
            
        }
    }

    private int readInt(String prompt) {
        int value = 0;
        boolean valid = false;
        while (!valid){
            System.out.print(prompt);
            String input = sc.nextLine();
            try{
                value = Integer.parseInt(input.trim());
                valid = true;
            } catch (NumberFormatException e){
                System.out.println("Please enter a valid whole number.");
            }
        }
        return value;
        
    }

    

    
    
    
}