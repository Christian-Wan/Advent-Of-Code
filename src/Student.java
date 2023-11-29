public class Student
{
    private String name;
    private int gradeLevel;
    private String school;

    public Student(String name, int gradeLevel, String school) {
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.school = school;
    }
    public Student(String name, int gradeLevel) {
        this.name = name;
        this.gradeLevel = gradeLevel;
        if (gradeLevel > 8) {
            school = "high school";
        }
        else if (gradeLevel > 5) {
            school = "middle school";
        }
        else {
            school = "elementary school";
        }
    }

    public String toString()
    {
        return name + " is in grade " + gradeLevel + " and goes to " + school;
    }
}
