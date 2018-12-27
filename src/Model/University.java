package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Al-Hussein
 */
public class University {

    private List<Subject> subjects;
    private List<Period> periods;
    private List<Specialization> Specializations;
    private List<Teacher> teachers;
    private List<Hall> halls;
//    private List<Lecture> lectures;

    public University() {
        subjects = new ArrayList<>();
        periods = new ArrayList<>();
        Specializations = new ArrayList<>();
        teachers = new ArrayList<>();
        halls = new ArrayList<>();
//        lectures = new ArrayList<>();

        subjects.add(new Subject(SubjectName.ALGO_AI, 1, 1, 0,true,false,false));
        subjects.add(new Subject(SubjectName.COMPILER_AI, 1, 0, 1,true,false,false));
        subjects.add(new Subject(SubjectName.ECONOMIE, 2, 0, 0,true,true,true));
        subjects.add(new Subject(SubjectName.NN_AI, 2, 1, 0,true,false,false));
        subjects.add(new Subject(SubjectName.OPERATING_SYSTEM, 2, 1, 0,true,true,true));
        subjects.add(new Subject(SubjectName.SOFTWARE_AI_N, 2, 0, 1,true,false,true));
        subjects.add(new Subject(SubjectName.ALGO_SE_N, 1, 1, 0,false,true,true));
        subjects.add(new Subject(SubjectName.COMPILER_SE, 1, 0, 1,false,true,false));
        subjects.add(new Subject(SubjectName.SOFTWARE_SE, 2, 0, 1,false,true,false));
        subjects.add(new Subject(SubjectName.AppNetworks_N, 2, 1, 0,false,false,true));
        subjects.add(new Subject(SubjectName.DATABASE_SE, 2, 1, 0,false,false,true));
        
        
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 4; j++) {
                periods.add(new Period(i, j));
            }
        }
        Specializations.add(new Specialization(SpecializationName.Artificial_Intelligence, 2, 3));
        Specializations.add(new Specialization(SpecializationName.Networks, 2, 3));
        Specializations.add(new Specialization(SpecializationName.Software_Engineering, 2, 4));



//        Teacher = new Teacher(TeacherName.Ammar_nahas,,100,100,);
        // Add Static Data To University
//        teachers.add(new Teacher(1,SubjectName.SOFTWARE_THEOR));
//        teachers.add(new Teacher(2,SubjectName.SOFTWARE_PRAC));
//        teachers.add(new Teacher(3,SubjectName.OPERATING_SYSTEM_THEOR));
//        teachers.add(new Teacher(4,SubjectName.OPERATING_SYSTEM_PRAC));
//        teachers.add(new Teacher(5,SubjectName.NN_THEOR));
//        teachers.add(new Teacher(6,SubjectName.NN_PRAC));
//        teachers.add(new Teacher(7,SubjectName.ECONOMIE_THEOR));
//        teachers.add(new Teacher(8,SubjectName.ECONOMIE_PRAC));
//        teachers.add(new Teacher(9,SubjectName.COMPILER_THEOR));
//        teachers.add(new Teacher(10,SubjectName.COMPILER_PRAC));
//        teachers.add(new Teacher(11,SubjectName.ALGO_THEOR));
//        teachers.add(new Teacher(12,SubjectName.ALGO_PRAC));
    }

}
