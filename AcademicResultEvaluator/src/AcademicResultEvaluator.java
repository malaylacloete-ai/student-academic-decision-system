public class AcademicResultEvaluator {

    private final int mark;

    public AcademicResultEvaluator(int mark) {
        this.mark = mark;
    }

    public boolean isMarkValid() {
        return mark >= 0 && mark <= 100;
    }
    public String determineAcademicResult() {

        if (!isMarkValid()) {
            return "Invalid mark";
        }
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
    public static void main(String[] args) {

        int[] testMarks = {95, 80, 65, 55, 40, -5, 150};

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