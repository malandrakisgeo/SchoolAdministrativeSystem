package Model;


import java.util.ArrayList;
import java.util.List;

public class Group {

    private String groupId;
    private GradeLevel gradeLevel;
    private int maxNumberOfStudents;
    private int minimumNumberOfStudents;

    private boolean exceedsMinimumNumber = false;

    private List<Student> students = new ArrayList<>();
    private List<Subject> subjectsTaught = new ArrayList<>();
    private List<SchoolClass> schoolClasses = new ArrayList<>(); //Which schoolClasses was this group created for

    public Group() {

    }

    public Group(String groupId, GradeLevel gradeLevel, int maxNumberOfStudents, int minimumNumberOfStudents) {
        this.groupId = groupId;
        this.gradeLevel = gradeLevel;
        this.maxNumberOfStudents = maxNumberOfStudents;
        this.minimumNumberOfStudents = minimumNumberOfStudents;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<Student> getStudents() {
        return students;
    }

    public boolean setStudents(List<Student> students) {
        if (subjectsTaught.size() < this.getMaxNumberOfStudents()) {
            exceedsMinimumNumber = (students.size() >= minimumNumberOfStudents) ? true : false; //Once the minimum number of the students is exceeded, it turns to true
            this.students = students;
            return true;
        }
        return false;
    }

    public List<Subject> getSubjectsTaught() {
        return subjectsTaught;
    }

    public void setSubjectsTaught(List<Subject> subjectsTaught) {
        this.subjectsTaught = subjectsTaught;

    }

    public void addSubjectTaught(Subject subject) {
        this.subjectsTaught.add(subject);
    }

    public boolean addStudentToGroup(Student st) {
        //The student should be added only if (s)he is not already in the group, and the maximum number has not been reached
        if (this.students.size() < this.maxNumberOfStudents) {
            this.students.add(st);
            exceedsMinimumNumber = (this.students.size() >= minimumNumberOfStudents) ? true : false; //Once the minimum number of the students is exceeded, it turns to true
            return true;
        } else {
            return false;
        }
    }


    public void addClass(SchoolClass schoolClass) {
        this.schoolClasses.add(schoolClass);
    }


    public List<SchoolClass> getClasses() {
        return this.schoolClasses;
    }

    public GradeLevel getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(GradeLevel gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public int getMaxNumberOfStudents() {
        return maxNumberOfStudents;
    }

    public void setMaxNumberOfStudents(int maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public int getMinimumNumberOfStudents() {
        return minimumNumberOfStudents;
    }

    public void setMinimumNumberOfStudents(int minimumNumberOfStudents) {
        this.minimumNumberOfStudents = minimumNumberOfStudents;
    }

    public List<SchoolClass> getSchoolClasses() {
        return schoolClasses;
    }

    public void setSchoolClasses(List<SchoolClass> schoolClasses) {
        this.schoolClasses = schoolClasses;
    }

    public boolean isExceedsMinimumNumber() {
        return exceedsMinimumNumber;
    }
}

