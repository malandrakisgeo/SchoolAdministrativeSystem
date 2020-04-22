package Model;

import java.util.List;

public class GradeLevel {
    String gradeLevel;
    List<Subject> mandatorySubjects;

    public GradeLevel() {
    }

    public GradeLevel(String gradeLevel, List<Subject> mandatorySubjects) {
        this.gradeLevel = gradeLevel;
        this.mandatorySubjects = mandatorySubjects;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public List<Subject> getMandatorySubjects() {
        return mandatorySubjects;
    }


    public void setMandatorySubjects(List<Subject> mandatorySubjects) {
        this.mandatorySubjects = mandatorySubjects;
    }

    public void addMandatorysubject(Subject mandatorySubject) {
        if (!this.mandatorySubjects.contains(mandatorySubject)) {
            this.mandatorySubjects.add(mandatorySubject);
        }
    }



}
