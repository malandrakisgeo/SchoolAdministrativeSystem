package Model;


import Core.ApplicationEntry;

import java.util.ArrayList;
import java.util.List;

public class SchoolClass {
    private String classId;
    private List<Student> studentsOfClass = new ArrayList<>();

    public SchoolClass(String classId, List<Student> studentsOfClass) {
        this.classId = classId;
        this.setStudentsOfClass(studentsOfClass);
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public List<Student> getStudentsOfClass() {
        return studentsOfClass;
    }

    public void setStudentsOfClass(List<Student> studentsOfClass) {
        this.studentsOfClass = studentsOfClass;
        for (Student student : studentsOfClass) {
            ApplicationEntry.schoolClassByStudent.put(student, this);
        }
    }

    public void addStudentToClass(Student st) {
        this.studentsOfClass.add(st);
        ApplicationEntry.schoolClassByStudent.put(st, this);
    }

    public void removeStudentFromClass(Student st) {

    }
}
