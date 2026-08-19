public class AgeCategoryAnalyzer {

    // This method determines the person's age group
    // based on their age.
    public String determineAgeGroup(int age) {

        // If the person's age is below 18, they are a minor.
        if (age < 18) {
            return "Minor";

        // If the age is 18 or above but 60 or below,
        // the person is classified as an adult.
        } else if (age <= 60) {
            return "Adult";

        // If neither condition above is true,
        // the person must be over 60 and is classified as a senior.
        } else {
            return "Senior";
        }
    }

    // This method checks whether the person belongs
    // to a special category.
    public boolean isSpecialCategory(int age) {

        // The || operator means OR.
        // A person is special if they are below 18
        // OR if they are above 60.
        return age < 18 || age > 60;
    }

    // Main method used to test the two methods.
    public static void main(String[] args) {

        // Create an object of the AgeCategoryAnalyzer class
        // so that we can use its methods.
        AgeCategoryAnalyzer analyzer = new AgeCategoryAnalyzer();

        // Three test ages:
        // 16 = minor
        // 30 = standard adult
        // 65 = over 60
        int age1 = 16;
        int age2 = 30;
        int age3 = 65;

        // Test case 1: Minor
        System.out.println("Age: " + age1);
        System.out.println("Age Group: " + analyzer.determineAgeGroup(age1));
        System.out.println("Special Category: " + analyzer.isSpecialCategory(age1));
        System.out.println();

        // Test case 2: Standard adult
        System.out.println("Age: " + age2);
        System.out.println("Age Group: " + analyzer.determineAgeGroup(age2));
        System.out.println("Special Category: " + analyzer.isSpecialCategory(age2));
        System.out.println();

        // Test case 3: Person over 60
        System.out.println("Age: " + age3);
        System.out.println("Age Group: " + analyzer.determineAgeGroup(age3));
        System.out.println("Special Category: " + analyzer.isSpecialCategory(age3));
    }
}