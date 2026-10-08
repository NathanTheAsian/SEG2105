package ums;
/**
 * Travis Zhang 300488899
 *  
 * Teaching Assistant is a instructor who can help teach up to {@value #MAX_COURSES} courses at a time.
*/
public class TeachingAssistant extends Instructor {

    /**The maximum courses a TA can help teach */
    private final int MAX_COURSES = 2;

    /**
     * Creates a TA
     * 
     * @param firstName
     * @param lastName
     * @param salary
     */
    protected TeachingAssistant(String firstName, String lastName, double salary) {
        super(firstName, lastName, salary);
    }

    /**
     * Returns the number of courses a TA can help teach at a time 
     * 
     * @return {@value MAX_COURSES}
     */
    @Override
    public int getMaxCourses() {
        return  MAX_COURSES;
    }
    
    /**    
     * Returns a multi-line discription of the TA
     * 
     * @return string represenation of the TA 
     */
    @Override
    public String toString() {
        return "TA " + getFullName() + " (Employee ID: " + getEmployeeId() + ")\n"
                + "  Salary: " + getFormattedSalary() + "\n"
                + "  Courses (" + getCourses().size() + "/" + getMaxCourses() + "):\n"
                + getCoursesList();
    }


}
