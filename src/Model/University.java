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

        halls.add(new Hall("1A", LAB));
        halls.add(new Hall("1B", LAB));
        halls.add(new Hall("1C", LAB));
        halls.add(new Hall("1D", LAB));
        halls.add(new Hall("1E", LAB));
        halls.add(new Hall("1F", LAB));

        halls.add(new Hall("2A", LAB));
        halls.add(new Hall("2B", LAB));
        halls.add(new Hall("2C", LAB));
        halls.add(new Hall("2D", LAB));
        halls.add(new Hall("2E", LAB));
        halls.add(new Hall("2F", LAB));
        halls.add(new Hall("2G", LAB));
        halls.add(new Hall("2H", LAB));
        halls.add(new Hall("2I", LAB));
        halls.add(new Hall("2J", LAB));
        halls.add(new Hall("2K", LAB));
        halls.add(new Hall("2L", LAB));

        subjects.add(new Subject(SubjectName.ALGO_AI, 1, 1, 0, true, false, false));
        subjects.add(new Subject(SubjectName.COMPILER_AI, 1, 0, 1, true, false, false));
        subjects.add(new Subject(SubjectName.ECONOMIE, 2, 0, 0, true, true, true));
        subjects.add(new Subject(SubjectName.NN_AI, 2, 1, 0, true, false, false));
        subjects.add(new Subject(SubjectName.OPERATING_SYSTEM, 2, 1, 0, true, true, true));
        subjects.add(new Subject(SubjectName.SOFTWARE_AI_N, 2, 0, 1, true, false, true));
        subjects.add(new Subject(SubjectName.ALGO_SE_N, 1, 1, 0, false, true, true));
        subjects.add(new Subject(SubjectName.COMPILER_SE, 1, 0, 1, false, true, false));
        subjects.add(new Subject(SubjectName.SOFTWARE_SE, 2, 0, 1, false, true, false));
        subjects.add(new Subject(SubjectName.AppNetworks_N, 2, 1, 0, false, false, true));
        subjects.add(new Subject(SubjectName.DATABASE_SE, 2, 1, 0, false, false, true));

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
        subjectNames.add(SubjectName.ALGO_SE_N);
        subjectNames.add(SubjectName.ALGO_AI);
        subjectNames.add(SubjectName.OPERATING_SYSTEM);
        subjectNames.add(SubjectName.NN_AI);
        subjectNames.add(SubjectName.ECONOMIE);
        subjectNames.add(SubjectName.COMPILER_AI);
        subjectNames.add(SubjectName.COMPILER_SE);
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

        teachers.add(new Teacher(TeacherName.A, subjectNames, periods, typeLectures, specializationNames));
        teachers.add(new Teacher(TeacherName.B, subjectNames, periods, typeLectures, specializationNames));
        teachers.add(new Teacher(TeacherName.C, subjectNames, periods, typeLectures, specializationNames));
        teachers.add(new Teacher(TeacherName.D, subjectNames, periods, typeLectures, specializationNames));
        teachers.add(new Teacher(TeacherName.E, subjectNames, periods, typeLectures, specializationNames));
        teachers.add(new Teacher(TeacherName.F, subjectNames, periods, typeLectures, specializationNames));
        teachers.add(new Teacher(TeacherName.G, subjectNames, periods, typeLectures, specializationNames));
        teachers.add(new Teacher(TeacherName.H, subjectNames, periods, typeLectures, specializationNames));
        teachers.add(new Teacher(TeacherName.I, subjectNames, periods, typeLectures, specializationNames));
        teachers.add(new Teacher(TeacherName.J, subjectNames, periods, typeLectures, specializationNames));
        teachers.add(new Teacher(TeacherName.K, subjectNames, periods, typeLectures, specializationNames));
        teachers.add(new Teacher(TeacherName.L, subjectNames, periods, typeLectures, specializationNames));
        teachers.add(new Teacher(TeacherName.M, subjectNames, periods, typeLectures, specializationNames));
        teachers.add(new Teacher(TeacherName.N, subjectNames, periods, typeLectures, specializationNames));
        teachers.add(new Teacher(TeacherName.O, subjectNames, periods, typeLectures, specializationNames));
        teachers.add(new Teacher(TeacherName.P, subjectNames, periods, typeLectures, specializationNames));
        teachers.add(new Teacher(TeacherName.Q, subjectNames, periods, typeLectures, specializationNames));
        teachers.add(new Teacher(TeacherName.R, subjectNames, periods, typeLectures, specializationNames));
        teachers.add(new Teacher(TeacherName.S, subjectNames, periods, typeLectures, specializationNames));
        teachers.add(new Teacher(TeacherName.T, subjectNames, periods, typeLectures, specializationNames));
        teachers.add(new Teacher(TeacherName.U, subjectNames, periods, typeLectures, specializationNames));
        teachers.add(new Teacher(TeacherName.V, subjectNames, periods, typeLectures, specializationNames));
        teachers.add(new Teacher(TeacherName.W, subjectNames, periods, typeLectures, specializationNames));
        teachers.add(new Teacher(TeacherName.X, subjectNames, periods, typeLectures, specializationNames));
        teachers.add(new Teacher(TeacherName.Y, subjectNames, periods, typeLectures, specializationNames));
        teachers.add(new Teacher(TeacherName.Z, subjectNames, periods, typeLectures, specializationNames));

    }

}
