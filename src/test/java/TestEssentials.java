import Model.*;

import java.util.*;

public class TestEssentials {

    List<GradeLevel> gradeLevels = new ArrayList<>();
    List<SchoolClass> availableClasses = new ArrayList<>();
    List<Group> groups = new ArrayList<>();

    List<Subject> ninthGradeMandatorySubjects = new ArrayList<>();
    List<Subject> freeSubjects = new ArrayList<>();
    List<Subject> tenthGradeMandatorySubjects = new ArrayList<>();
    List<Subject> eleventhGradeMandatorySubjects = new ArrayList<>();


    Subject maths = new Subject("Mathematics I", "Math1b2020");
    Subject Physics = new Subject("Physics II ", "Phys2b2020");
    Subject History = new Subject("History ", "History1b2020");
    Subject maths2 = new Subject("Mathematics II ", "Math2b2020");
    Subject maths3 = new Subject("Mathematics III (Calculus) ", "Math3b2020");
    Subject History2 = new Subject("Byzantine history ", "HistoryByz2b2020");
    Subject Geography = new Subject("Geography ", "Geography2b2020");
    Subject chemistry, chemistry2;

    public TestEssentials() {

        chemistry = new Subject(); //Alternative construction of a subject
        chemistry.setSubjectId("Chem1b2020");
        chemistry.setSubjectName("Chemistry I");

        chemistry2 = new Subject(); //Alternative construction of a subject
        chemistry2.setSubjectId("Chem2b2020");
        chemistry2.setSubjectName("Chemistry II");

        ninthGradeMandatorySubjects.add(maths);
        ninthGradeMandatorySubjects.add(Physics);
        ninthGradeMandatorySubjects.add(History);

        tenthGradeMandatorySubjects.add(maths2);
        tenthGradeMandatorySubjects.add(Geography);
        eleventhGradeMandatorySubjects.add(maths3);
        freeSubjects.add(History2);
        freeSubjects.add(chemistry2);


    }


    protected List<Student> studentGeneratorForTesting(int numOfStudents, GradeLevel gradeLevel) {
        List<Student> studentsOfClass = new ArrayList<>();
        List<String> studentNames = Arrays.asList(new String[]{"George", "Dimitra", "John", "Marcus", "Susan", "Henry", "Bill", "Don", "Takis", "Nick", "Dmitri", "Johan", "Magnus", "Towu", "Tova", "Nicky"});
        List<String> studentSurnames = Arrays.asList(new String[]{"Malandrakis", "Johnson", "Marcusson", "Susanson", "Henryson", "Johanson", "Magnusson", "Papadopoulos", "Albertsson", "Muller"});
        Date date = new Date();

        Student bestStudent = new Student(); //First construction
        bestStudent.setStudentId(UUID.randomUUID().toString());
        bestStudent.setFirstName("George");
        bestStudent.setLastName("Malandrakis");
        bestStudent.setAddress("Domaregatan 10B");
        bestStudent.setDateOfBirth(new Date(1995, 8, 9, 0, 0));
        bestStudent.setGradeLevel(gradeLevel);
        studentsOfClass.add(bestStudent);

        for (int i = 0; i < numOfStudents - 1; i++) {
            String randomname = studentNames.get(new Random().nextInt(studentNames.size()));
            String randomsurname = studentSurnames.get(new Random().nextInt(studentSurnames.size()));
            String id = UUID.randomUUID().toString();
            studentsOfClass.add(new Student(id, randomname, randomsurname, date, null, gradeLevel));
        }

        return studentsOfClass;
    }


}




