package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
    /*
        Contains information about the student.

        A student is expected to read all mandatory subjects of his/her grade,
        and perhaps some individually chosen subjects. The former can be found
        by the grade level, and only a list for the latter is included.

    */


public class Student {

    private String studentId;

    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String address;

    private GradeLevel gradeLevel;
    private List<Subject> individuallyChosenSubjects = new ArrayList<>();

    public Student() {

    }

    public Student(String studentId, String firstName, String lastName, Date dateOfBirth, String address, GradeLevel gradeLevel) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.gradeLevel = gradeLevel;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Subject> getIndividuallyChosenSubjects() {
        return individuallyChosenSubjects;
    }

    public void setIndividuallyChosenSubjects(List<Subject> individuallyChosenSubjects) {
        this.individuallyChosenSubjects = individuallyChosenSubjects;
    }

    public void addIndividuallyChosenSubject(Subject individuallyChosenSubject) {
        this.individuallyChosenSubjects.add(individuallyChosenSubject);
    }

    public void addSubject(Subject subject) {
        //Adds subjects avoiding duplicate values.
        if (!this.individuallyChosenSubjects.contains(subject)) {
            this.individuallyChosenSubjects.add(subject);
        }
    }

    public void removeSubject(Subject subject) {
        this.individuallyChosenSubjects.remove(subject);
    }

    public GradeLevel getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(GradeLevel gradeLevel) {
        this.gradeLevel = gradeLevel;
    }
}
