import Core.ApplicationEntry;
import Model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;


//A part of the data, as well as some functions, are inherited from TestEssentials.

/*
    This big school has multiple classes for each grade. Two groups for the ninth grade are created.
    The first offers both physics and mathematics, and the second one only physics.

    The total number of students that can attend physics in the two groups is exactly
    equal to the number of students in the ninth grade, but only 20/31 students
    can attend maths in them.

    The part of the algorithm that marks students as unplaced for a particular subject is tested.

    Eleven students should be marked as unplaced for maths, and zero for physics.


 */
public class BigSchoolScenario extends TestEssentials {

    @Test
    public void initializeData() {


        //Creates Grade levels
        GradeLevel ninthGrade = new GradeLevel();
        ninthGrade.setGradeLevel("Ninth grade");
        ninthGrade.setMandatorySubjects(ninthGradeMandatorySubjects);
        ninthGrade.addMandatorysubject(chemistry);
        gradeLevels.add(ninthGrade);

        //Creates school classes with an automatically generated student list
        SchoolClass ninthGradeFirstClass = new SchoolClass("9a2020c", this.studentGeneratorForTesting(18, ninthGrade));
        SchoolClass ninthGradeSecondClass = new SchoolClass("9b2020c", this.studentGeneratorForTesting(13, ninthGrade));
        availableClasses.add(ninthGradeFirstClass);
        availableClasses.add(ninthGradeSecondClass);

        //First group for physics and maths
        Group gr = new Group("PhysAndMathGroup1b2020a5856", ninthGrade, 20, 0);
        gr.addSubjectTaught(maths);
        gr.addSubjectTaught(Physics);
        gr.addClass(ninthGradeFirstClass);
        gr.addClass(ninthGradeSecondClass);

        //Second group for physics and maths. Alternative construction.
        Group gr2 = new Group();
        gr2.setGradeLevel(ninthGrade);
        gr2.setGroupId("PhysGroup1c2020a5857");
        gr2.setMaxNumberOfStudents(11);
        gr2.setMinimumNumberOfStudents(0);
        gr2.addSubjectTaught(Physics);
        gr2.addClass(ninthGradeFirstClass);
        gr2.addClass(ninthGradeSecondClass);

        groups.add(gr);
        groups.add(gr2);

        ApplicationEntry.existingGroups.addAll(groups);
        ApplicationEntry.populateGroupsWithStudents(ninthGradeFirstClass.getStudentsOfClass());
        ApplicationEntry.populateGroupsWithStudents(ninthGradeSecondClass.getStudentsOfClass());
        Assert.assertEquals(11, ApplicationEntry.unplacedStudentsBySubject.get(maths).size());
        Assert.assertEquals(31, ApplicationEntry.unplacedStudentsBySubject.get(History).size()); //No group for the subject of History exists.
        Assert.assertEquals(0, ApplicationEntry.unplacedStudentsBySubject.get(Physics).size());

        ApplicationEntry.showUnplacedStudents();

    }




}
