public class AcademicResultEvaluator {

    private final int mark;

    public AcademicResultEvaluator(int mark) {
        this.mark = mark;
    }

    public boolean isMarkValid() {
        return mark >= 0 && mark <= 100;
    }
}