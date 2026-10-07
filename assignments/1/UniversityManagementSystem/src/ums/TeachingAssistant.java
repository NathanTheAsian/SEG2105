package ums;

public class TeachingAssistant extends Instructor {

    private final int MAX_COURSES = 2;

    protected TeachingAssistant(String firstName, String lastName, double salary) {
        super(firstName, lastName, salary);
        //TODO Auto-generated constructor stub
    }

    @Override
    public int getMaxCourses() {
        return  MAX_COURSES;
    }
    
    @Override
    public String toString() {
        return "TA " + getFullName() + " (Employee ID: " + getEmployeeId() + ")\n"
                + "  Salary: " + getFormattedSalary() + "\n"
                + "  Courses (" + getCourses().size() + "/" + getMaxCourses() + "):\n"
                + getCoursesList();
    }


}
