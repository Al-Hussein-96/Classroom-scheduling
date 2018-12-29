package Model;

import static Model.Hall.Type.LAB;
import static Model.Hall.Type.THEATER;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Al-Hussein
 */
public class University {

    public static List<Subject> subjects;
    public static List<Period> periods;
    public static List<Specialization> Specializations;
    public static List<Teacher> teachers;
    public static List<Hall> halls;

    public University() {
        subjects = new ArrayList<>();
        periods = new ArrayList<>();
        Specializations = new ArrayList<>();
        teachers = new ArrayList<>();
        halls = new ArrayList<>();

        halls.add(new Hall("1", THEATER));
        halls.add(new Hall("2", THEATER));
        halls.add(new Hall("3", THEATER));
        halls.add(new Hall("4", THEATER));
        halls.add(new Hall("5", THEATER));
        halls.add(new Hall("12", THEATER));
        halls.add(new Hall("14", THEATER));
        halls.add(new Hall("16", THEATER));
        halls.add(new Hall("21", THEATER));
        halls.add(new Hall("22", THEATER));
        halls.add(new Hall("23", THEATER));
        halls.add(new Hall("25", THEATER));

//        halls.add(new Hall("1A", LAB));
//        halls.add(new Hall("1B", LAB));
//        halls.add(new Hall("1C", LAB));
//        halls.add(new Hall("1D", LAB));
//        halls.add(new Hall("1E", LAB));
//        halls.add(new Hall("1F", LAB));
//
//        halls.add(new Hall("2A", LAB));
//        halls.add(new Hall("2B", LAB));
//        halls.add(new Hall("2C", LAB));
//        halls.add(new Hall("2D", LAB));
//        halls.add(new Hall("2E", LAB));
//        halls.add(new Hall("2F", LAB));
//        halls.add(new Hall("2G", LAB));
//        halls.add(new Hall("2H", LAB));
//        halls.add(new Hall("2I", LAB));
//        halls.add(new Hall("2J", LAB));
//        halls.add(new Hall("2K", LAB));
//        halls.add(new Hall("2L", LAB));

        subjects.add(new Subject(SubjectName.ALGO, 1, 1, 0, true, true, true));
        subjects.add(new Subject(SubjectName.COMPILER_AI, 1, 0, 1, true, false, false));
        subjects.add(new Subject(SubjectName.ECONOMIE, 1, 1, 0, true, true, true));
        subjects.add(new Subject(SubjectName.NN_AI, 2, 1, 0, true, false, false));
        subjects.add(new Subject(SubjectName.OPERATING_SYSTEM, 2, 1, 0, true, true, true));
        subjects.add(new Subject(SubjectName.SOFTWARE_AI_N, 2, 0, 1, true, false, true));
        subjects.add(new Subject(SubjectName.COMPILER_SE, 1, 0, 1, false, true, false));
        subjects.add(new Subject(SubjectName.SOFTWARE_SE, 2, 0, 1, false, true, false));
        subjects.add(new Subject(SubjectName.AppNetworks_N, 2, 1, 0, false, false, true));
        subjects.add(new Subject(SubjectName.DATABASE_SE, 2, 1, 0, false, true, false));

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 4; j++) {
                periods.add(new Period(i, j));
            }
        }
        Specializations.add(new Specialization(SpecializationName.Artificial_Intelligence, 2, 3));
        Specializations.add(new Specialization(SpecializationName.Networks, 2, 3));
        Specializations.add(new Specialization(SpecializationName.Software_Engineering, 2, 4));

        List<SubjectName> subjectNames = new ArrayList<>();
        subjectNames.add(SubjectName.SOFTWARE_AI_N);
        subjectNames.add(SubjectName.SOFTWARE_SE);
        subjectNames.add(SubjectName.ALGO);
        subjectNames.add(SubjectName.OPERATING_SYSTEM);
        subjectNames.add(SubjectName.ECONOMIE);
        subjectNames.add(SubjectName.COMPILER_AI);
        subjectNames.add(SubjectName.COMPILER_SE);
        subjectNames.add(SubjectName.NN_AI);
        subjectNames.add(SubjectName.AppNetworks_N);
        subjectNames.add(SubjectName.DATABASE_SE);

        List<TypeLecture> typeLectures = new ArrayList<>();
        typeLectures.add(TypeLecture.Theoretical);
        typeLectures.add(TypeLecture.Practical_THEATER);
        typeLectures.add(TypeLecture.Practical_LAB);

        List<SpecializationName> specializationNames = new ArrayList<>();
        specializationNames.add(SpecializationName.Networks);
        specializationNames.add(SpecializationName.Software_Engineering);
        specializationNames.add(SpecializationName.Artificial_Intelligence);

        List<Period> p = new ArrayList<>();

        /**
         * ********************** Add Teacher
         * **********************************
         */
        List<SubjectName> list1 = new ArrayList<>();
        List<TypeLecture> list2 = new ArrayList<>();
        List<SpecializationName> list3 = new ArrayList<>();

        /// first Teacher
        list1.add(SubjectName.SOFTWARE_AI_N);
        list2.add(TypeLecture.Theoretical);

        list3.add(SpecializationName.Networks);
        list3.add(SpecializationName.Artificial_Intelligence);

        teachers.add(new Teacher(TeacherName.Mohamad_alahmad, list1, p, list2, list3));

        /// Second Teacher
        list1.clear();
        list1.add(SubjectName.ALGO);
        list1.add(SubjectName.COMPILER_AI);

        teachers.add(new Teacher(TeacherName.Basel_alkhateb, list1, p, list2, specializationNames));

        /// Third Teacher
        list1.clear();
        list1.add(SubjectName.ECONOMIE);

        teachers.add(new Teacher(TeacherName.Nawras_watfa, list1, p, list2, list3));

        /// Fourth Teacher
        list1.clear();
        list1.add(SubjectName.NN_AI);

        list3.clear();
        list3.add(SpecializationName.Artificial_Intelligence);

        teachers.add(new Teacher(TeacherName.Maysa_abo_kasem, list1, p, list2, list3));

        /// fifth Teacher
        list1.clear();
        list1.add(SubjectName.OPERATING_SYSTEM);

        teachers.add(new Teacher(TeacherName.Waseem_ahmad, list1, p, list2, specializationNames));

        /// sixth Teacher
        list1.clear();
        list1.add(SubjectName.AppNetworks_N);

        list3.clear();
        list3.add(SpecializationName.Networks);

        teachers.add(new Teacher(TeacherName.Ammar_Jokhdar, list1, p, list2, list3));

        /// seventh Teacher
        list1.clear();
        list1.add(SubjectName.DATABASE_SE);

        list3.clear();
        list3.add(SpecializationName.Software_Engineering);

        teachers.add(new Teacher(TeacherName.Madeleine_Abboud, list1, p, list2, list3));
        
        

//        teachers.add(new Teacher(TeacherName.H, subjectNames, p, typeLectures, specializationNames));
//        teachers.add(new Teacher(TeacherName.I, subjectNames, p, typeLectures, specializationNames));
//        teachers.add(new Teacher(TeacherName.J, subjectNames, p, typeLectures, specializationNames));
//        teachers.add(new Teacher(TeacherName.K, subjectNames, p, typeLectures, specializationNames));
//        teachers.add(new Teacher(TeacherName.L, subjectNames, p, typeLectures, specializationNames));
//        teachers.add(new Teacher(TeacherName.M, subjectNames, p, typeLectures, specializationNames));
//        teachers.add(new Teacher(TeacherName.N, subjectNames, p, typeLectures, specializationNames));
//        teachers.add(new Teacher(TeacherName.O, subjectNames, p, typeLectures, specializationNames));
//        teachers.add(new Teacher(TeacherName.P, subjectNames, p, typeLectures, specializationNames));
//        teachers.add(new Teacher(TeacherName.Q, subjectNames, p, typeLectures, specializationNames));
//        teachers.add(new Teacher(TeacherName.R, subjectNames, p, typeLectures, specializationNames));
//        teachers.add(new Teacher(TeacherName.S, subjectNames, p, typeLectures, specializationNames));
//        teachers.add(new Teacher(TeacherName.T, subjectNames, p, typeLectures, specializationNames));
//        teachers.add(new Teacher(TeacherName.U, subjectNames, p, typeLectures, specializationNames));
//        teachers.add(new Teacher(TeacherName.V, subjectNames, p, typeLectures, specializationNames));
//        teachers.add(new Teacher(TeacherName.W, subjectNames, p, typeLectures, specializationNames));
//        teachers.add(new Teacher(TeacherName.X, subjectNames, p, typeLectures, specializationNames));
//        teachers.add(new Teacher(TeacherName.Y, subjectNames, p, typeLectures, specializationNames));
//        teachers.add(new Teacher(TeacherName.Z, subjectNames, p, typeLectures, specializationNames));
        /**
         * ********************** End Add Teacher
         * **********************************
         */

    }

}
