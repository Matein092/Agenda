package model;

public class Subject {
    // Attributes

    private String name;
    private String teacherName;
    private String nrc;
    private int credits;
    private int enrolledStudent;

    // Constructor
    public Subject(String name, String teacherName, String nrc, int credits, int enrolledStudent) {
        this.nrc = nrc;
        this.name = name;
        this.credits = credits;
        this.teacherName = teacherName;
        this.enrolledStudent = enrolledStudent;
    }

    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getEnrolledStudent() {
        return enrolledStudent;
    }

    public void setEnrolledStudent(int enrolledStudent) {
        this.enrolledStudent = enrolledStudent;
    }

    @Override
    public String toString() {
        return nrc + "," + name;
    }

}
