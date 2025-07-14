package smartex;

/**
 * ScholarStudent class
 * Inherits from Student, adds scholarshipAmount, overrides calculateGrade().
 */
public class ScholarStudent extends Student {
    private double scholarshipAmount;

    public ScholarStudent(int studentId, String name, double marks, String section, double scholarshipAmount) throws InvalidMarksException {
        super(studentId, name, marks, section);
        this.scholarshipAmount = scholarshipAmount;
    }

    @Override
    public String calculateGrade() {
        double newMarks = marks + 5; // bonus marks
        if (newMarks > 100) newMarks = 100;
        if (newMarks >= 90) return "A";
        else if (newMarks >= 75) return "B";
        else if (newMarks >= 60) return "C";
        else if (newMarks >= 40) return "D";
        else return "F";
    }

    @Override
    public String getType() {
        return "Scholar Student";
    }
}
