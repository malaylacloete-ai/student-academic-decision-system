/**
* Evaluates a student's academic result based on their mark.
* Validates the mark and determines a performance category.
*/
public class AcademicResultEvaluator {
    
    // The student's mark, out of 100
    private final int mark;
    
    /**
    * Constructor to create an evaluator for a given mark.
    * @param mark the student's mark (expected range: 0-100)
    */ 
    public AcademicResultEvaluator(int mark) {
        this.mark = mark;
    }
    
    /**
    * Checks whether the mark falls within a valid range (0-100).
    * @return true if the mark is valid, false otherwise
    */
    public boolean isMarkValid() {
        return mark >= 0 && mark <= 100;
    }
   
    /**
    * Determines the academic result category based on the mark.
    * Returns "Invalid mark" if the mark is out of range.
    * @return a string describing the result (e.g. "Excellent", "Pass", "Fail")
    */
    public String determineAcademicResult() {

        // Reject marks that fall outside the valid 0-100 range
        if (!isMarkValid()) {
            return "Invalid mark";
        }
        // Categorize the mark into a result band
        if (mark >= 90) {
            return "Excellent";
        } else if (mark >= 75) {
            return "Very Good";
        } else if (mark >= 60) {
            return "Good";
        } else if (mark >= 50) {
            return "Pass";
        } else {
            return "Fail";
        }
    }
    
 /**
 * Entry point to test the evaluator with a set of sample marks,
 * including edge cases (negative and above 100).
 */
    public static void main(String[] args) {
        
        // Test marks, including invalid ones (-5 and 150)
        int[] testMarks = {95, 80, 65, 55, 40, -5, 150};
        
        // Loop through each mark, evaluate it, and print the result
        for (int mark : testMarks) {

            AcademicResultEvaluator student =
                    new AcademicResultEvaluator(mark);

            System.out.println(
                    "Mark: " + mark
                    + " | Valid: " + student.isMarkValid()
                    + " | Result: " + student.determineAcademicResult()
            );
        }
    }
}