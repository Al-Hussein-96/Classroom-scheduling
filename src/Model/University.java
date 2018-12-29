package Model;

import static Model.Hall.Type.LAB;
import static Model.Hall.Type.THEATER;
import java.lang.reflect.Array;
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

        halls.add(new Hall("2A", LAB));
        halls.add(new Hall("2B", LAB));
        halls.add(new Hall("2C", LAB));
        halls.add(new Hall("2D", LAB));
        halls.add(new Hall("2E", LAB));
        halls.add(new Hall("2F", LAB));
//        halls.add(new Hall("2G", LAB));
//        halls.add(new Hall("2H", LAB));
//        halls.add(new Hall("2I", LAB));
//        halls.add(new Hall("2J", LAB));

        subjects.add(new Subject(SubjectName.ALGO, 1, 1, 0, true, true, true, 6));
        subjects.add(new Subject(SubjectName.COMPILER_AI, 1, 0, 1, true, false, false, 6));
        subjects.add(new Subject(SubjectName.ECONOMIE, 2, 0, 0, true, true, true, 4));
        subjects.add(new Subject(SubjectName.NN_AI, 2, 1, 0, true, false, false, 7));
        subjects.add(new Subject(SubjectName.OPERATING_SYSTEM, 2, 1, 0, true, true, true, 5));
        subjects.add(new Subject(SubjectName.SOFTWARE_AI_N, 2, 0, 1, true, false, true, 5));
        subjects.add(new Subject(SubjectName.COMPILER_SE, 1, 0, 1, false, true, false, 7));
        subjects.add(new Subject(SubjectName.SOFTWARE_SE, 2, 0, 1, false, true, false, 6));
        subjects.add(new Subject(SubjectName.AppNetworks_N, 2, 1, 0, false, false, true, 5));
        subjects.add(new Subject(SubjectName.DATABASE_SE, 2, 1, 0, false, true, false, 6));


        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 4; j++) {
                periods.add(new Period(i, j));
            }
        }
        Specialization sp1 = new Specialization(SpecializationName.Artificial_Intelligence, 2, 3);
        Specializations.add(sp1);
        int a[] = {0, 1, 2};
        int b[] = {0, 2, 3};
        sp1.setStart(a);
        sp1.setEnd(b);

        Specialization sp2 = new Specialization(SpecializationName.Networks, 2, 3);
        Specializations.add(sp2);

        int c[] = {0, 1, 2};
        int d[] = {0, 2, 3};
        sp2.setStart(c);
        sp2.setEnd(d);

        Specialization sp3 = new Specialization(SpecializationName.Software_Engineering, 2, 4);
        Specializations.add(sp3);

        int E[] = {0, 1, 3};
        int F[] = {0, 2, 4};
        sp3.setStart(E);
        sp3.setEnd(F);

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
//        for(int i=1;i<=4;i++)
//        {
//            p.add(new Period(5,i));
//        }

        /**
         * ********************** Add Teacher
         * **********************************
         */
        List<SubjectName> list1 = new ArrayList<>();
        List<TypeLecture> list2 = new ArrayList<>();
        List<SpecializationName> list3 = new ArrayList<>();

        /// first Teacher
        List<Period> Love_Period = new ArrayList<>();
        for(int i=1;i<=4;i++)
        {
            Love_Period.add(new Period(1, i));
        }
        list1.add(SubjectName.SOFTWARE_AI_N);
        list2.add(TypeLecture.Theoretical);
        
        list3.add(SpecializationName.Networks);
        list3.add(SpecializationName.Artificial_Intelligence);
        
        teachers.add(new Teacher(TeacherName.Mohamad_alahmad, list1, p, list2, list3 , Love_Period ,2,1) );
        
        /// Second Teacher
        list1 = new ArrayList<>();
        list1.add(SubjectName.ALGO);
        list1.add(SubjectName.COMPILER_AI);

        list2 = new ArrayList<>();
        list2.add(TypeLecture.Theoretical);
        
        Love_Period = new ArrayList<>();
        for(int i=1;i<=4;i++)
        {
            Love_Period.add(new Period(2, i));
        }

        teachers.add(new Teacher(TeacherName.Basel_alkhateb, list1, p, list2, specializationNames , Love_Period , 2 , 1));

        /// Third Teacher
        list1 = new ArrayList<>();
        list1.add(SubjectName.ECONOMIE);

        list2 = new ArrayList<>();
        list2.add(TypeLecture.Theoretical);

        list3 = new ArrayList<>();
        list3.add(SpecializationName.Networks);
        list3.add(SpecializationName.Artificial_Intelligence);
        
        Love_Period = new ArrayList<>();
        for(int i=1;i<=4;i++)
        {
            Love_Period.add(new Period(1, i));
        }
        teachers.add(new Teacher(TeacherName.Nawras_watfa, list1, p, list2, specializationNames , Love_Period , 2 , 1));

        /// Fourth Teacher
        list1 = new ArrayList<>();
        list1.add(SubjectName.NN_AI);

        list2 = new ArrayList<>();
        list2.add(TypeLecture.Theoretical);

        list3 = new ArrayList<>();
        list3.add(SpecializationName.Artificial_Intelligence);
        
        Love_Period = new ArrayList<>();
        for(int i=1;i<=4;i++)
        {
            Love_Period.add(new Period(4, i));
        }
        teachers.add(new Teacher(TeacherName.Maysa_abo_kasem, list1, p, list2, list3 , Love_Period , 2 , 1));

        /// fifth Teacher
        list1 = new ArrayList<>();
        list1.add(SubjectName.OPERATING_SYSTEM);

        list2 = new ArrayList<>();
        list2.add(TypeLecture.Theoretical);
        
        Love_Period = new ArrayList<>();
        for(int i=1;i<=4;i++)
        {
            Love_Period.add(new Period(4, i));
        }

        teachers.add(new Teacher(TeacherName.Waseem_ahmad, list1, p, list2, specializationNames ,Love_Period,2 , 1));

        /// sixth Teacher
        list1 = new ArrayList<>();
        list1.add(SubjectName.AppNetworks_N);

        list2 = new ArrayList<>();
        list2.add(TypeLecture.Theoretical);

        list3 = new ArrayList<>();
        list3.add(SpecializationName.Networks);
        
        Love_Period = new ArrayList<>();
        for(int i=1;i<=4;i++)
        {
            Love_Period.add(new Period(4, i));
        }
        
        teachers.add(new Teacher(TeacherName.Ammar_Jokhdar, list1, p, list2, list3 , Love_Period , 2 , 1));

        /// seventh Teacher
        list1 = new ArrayList<>();
        list1.add(SubjectName.DATABASE_SE);

        list2 = new ArrayList<>();
        list2.add(TypeLecture.Theoretical);

        list3 = new ArrayList<>();
        list3.add(SpecializationName.Software_Engineering);
        
        Love_Period = new ArrayList<>();
        for(int i=1;i<=4;i++)
        {
            Love_Period.add(new Period(4, i));
        }

        teachers.add(new Teacher(TeacherName.Madeleine_Abboud, list1, p, list2, list3 , Love_Period , 2 , 1));

        /// 8 Teacher
        list1 = new ArrayList<>();
        list1.add(SubjectName.COMPILER_SE);

        list2 = new ArrayList<>();
        list2.add(TypeLecture.Theoretical);

        list3 = new ArrayList<>();
        list3.add(SpecializationName.Software_Engineering);
        
        Love_Period = new ArrayList<>();
        for(int i=1;i<=4;i++)
        {
            Love_Period.add(new Period(2, i));
        }
        
        teachers.add(new Teacher(TeacherName.Salah_aldohji, list1, p, list2, list3 , Love_Period , 1 , 1));

        /// 9 Teacher
        list1 = new ArrayList<>();
        list1.add(SubjectName.SOFTWARE_SE);

        list2 = new ArrayList<>();
        list2.add(TypeLecture.Theoretical);

        list3 = new ArrayList<>();
        list3.add(SpecializationName.Software_Engineering);
        
        Love_Period = new ArrayList<>();
        for(int i=1;i<=4;i++)
        {
            Love_Period.add(new Period(1, i));
        }

        teachers.add(new Teacher(TeacherName.Saeed_abotrab, list1, p, list2, list3 , Love_Period , 2 , 1));

        /// 10 Teacher
        list1 = new ArrayList<>();
        list1.add(SubjectName.COMPILER_SE);

        list2 = new ArrayList<>();
        list2.add(TypeLecture.Practical_THEATER);

        list3 = new ArrayList<>();
        list3.add(SpecializationName.Software_Engineering);
        
        Love_Period = new ArrayList<>();
        for(int i=1;i<=4;i++)
        {
            Love_Period.add(new Period(4, i));
        }
        Love_Period = new ArrayList<>();
        for(int i=1;i<=4;i++)
        {
            Love_Period.add(new Period(2, i));
        }
        teachers.add(new Teacher(TeacherName.Omar_Ibrahim, list1, p, list2, list3,Love_Period , 1 , 1));

        /// 11 Teacher
        list1 = new ArrayList<>();
        list1.add(SubjectName.COMPILER_SE);

        list2 = new ArrayList<>();
        list2.add(TypeLecture.Practical_THEATER);

        list3 = new ArrayList<>();
        list3.add(SpecializationName.Software_Engineering);
         Love_Period = new ArrayList<>();
        for(int i=1;i<=4;i++)
        {
            Love_Period.add(new Period(2, i));
        }
        teachers.add(new Teacher(TeacherName.Mohamed_Sheikha, list1, p, list2, list3 , Love_Period , 1 , 1));

        /// 12 Teacher
        list1 = new ArrayList<>();
        list1.add(SubjectName.SOFTWARE_SE);

        list2 = new ArrayList<>();
        list2.add(TypeLecture.Practical_THEATER);

        list3 = new ArrayList<>();
        list3.add(SpecializationName.Software_Engineering);
         Love_Period = new ArrayList<>();
        for(int i=1;i<=4;i++)
        {
            Love_Period.add(new Period(3, i));
        }
        teachers.add(new Teacher(TeacherName.Maher_Alsarem, list1, p, list2, list3 ,Love_Period ,2 , 1));

        /// 13 Teacher
        list1 = new ArrayList<>();
        list1.add(SubjectName.OPERATING_SYSTEM);

        list2 = new ArrayList<>();
        list2.add(TypeLecture.Practical_LAB);

        list3 = new ArrayList<>();
        list3.add(SpecializationName.Software_Engineering);
         Love_Period = new ArrayList<>();
        for(int i=1;i<=4;i++)
        {
            Love_Period.add(new Period(3, i));
        }
        teachers.add(new Teacher(TeacherName.Bushra_Dawood, list1, p, list2, list3 , Love_Period , 2 , 1));

        /// 14 Teacher
        list1 = new ArrayList<>();
        list1.add(SubjectName.ALGO);

        list2 = new ArrayList<>();
        list2.add(TypeLecture.Practical_LAB);

        list3 = new ArrayList<>();
        list3.add(SpecializationName.Software_Engineering);
        Love_Period = new ArrayList<>();
        for(int i=1;i<=4;i++)
        {
            Love_Period.add(new Period(3, i));
        }
        teachers.add(new Teacher(TeacherName.Ahmed_El_Hassan, list1, p, list2, list3 , Love_Period , 3 , 1));

        /// 15 Teacher
        list1 = new ArrayList<>();
        list1.add(SubjectName.DATABASE_SE);

        list2 = new ArrayList<>();
        list2.add(TypeLecture.Practical_LAB);

        list3 = new ArrayList<>();
        list3.add(SpecializationName.Software_Engineering);
         Love_Period = new ArrayList<>();
        for(int i=1;i<=4;i++)
        {
            Love_Period.add(new Period(3, i));
        }
        teachers.add(new Teacher(TeacherName.Rawan_karaone, list1, p, list2, list3 , Love_Period , 2 , 1));
        
        /// C Teacher
        list1 = new ArrayList<>();
        list1.add(SubjectName.DATABASE_SE);

        list2 = new ArrayList<>();
        list2.add(TypeLecture.Practical_LAB);

        list3 = new ArrayList<>();
        list3.add(SpecializationName.Software_Engineering);
        Love_Period = new ArrayList<>();
        for(int i=1;i<=4;i++)
        {
            Love_Period.add(new Period(3, i));
        }
        teachers.add(new Teacher(TeacherName.C, list1, p, list2, list3 , Love_Period , 2 , 1));

        /// 16 Teacher
        list1 = new ArrayList<>();
        list1.add(SubjectName.OPERATING_SYSTEM);

        list2 = new ArrayList<>();
        list2.add(TypeLecture.Practical_LAB);

        list3 = new ArrayList<>();
        list3.add(SpecializationName.Software_Engineering);
        Love_Period = new ArrayList<>();
        for(int i=1;i<=4;i++)
        {
            Love_Period.add(new Period(3, i));
        }
        teachers.add(new Teacher(TeacherName.Safa_Kiwan, list1, p, list2, list3 , Love_Period , 4 , 1));

        /// 17 Teacher
        list1 = new ArrayList<>();
        list1.add(SubjectName.ALGO);

        list2 = new ArrayList<>();
        list2.add(TypeLecture.Practical_LAB);

        list3 = new ArrayList<>();
        list3.add(SpecializationName.Software_Engineering);
        Love_Period = new ArrayList<>();
        for(int i=1;i<=4;i++)
        {
            Love_Period.add(new Period(3, i));
        }
        teachers.add(new Teacher(TeacherName.Islam_Kahilan, list1, p, list2, list3 , Love_Period , 4 , 1));

        /// 18 Teacher
        list1 = new ArrayList<>();
        list1.add(SubjectName.ALGO);

        list2 = new ArrayList<>();
        list2.add(TypeLecture.Practical_LAB);

        list3 = new ArrayList<>();
        list3.add(SpecializationName.Artificial_Intelligence);
        Love_Period = new ArrayList<>();
        for(int i=1;i<=4;i++)
        {
            Love_Period.add(new Period(3, i));
        }
        teachers.add(new Teacher(TeacherName.Zena_Dallal, list1, p, list2, list3 , Love_Period , 3 , 1));

        /// 19 Teacher
        list1 = new ArrayList<>();
        list1.add(SubjectName.COMPILER_AI);
 
        list2 = new ArrayList<>();
        list2.add(TypeLecture.Practical_THEATER);
 
        list3 = new ArrayList<>();
        list3.add(SpecializationName.Artificial_Intelligence);
        Love_Period = new ArrayList<>();
        Love_Period.add(new Period(2, 1));
        Love_Period.add(new Period(2, 2));
        Love_Period.add(new Period(2, 3));
        Love_Period.add(new Period(2, 4));
        teachers.add(new Teacher(TeacherName.Ammar_Al_Nahas, list1, p, list2, list3,Love_Period,2,1));
 
        /// 20 Teacher
        list1 = new ArrayList<>();
        list1.add(SubjectName.SOFTWARE_AI_N);
 
        list2 = new ArrayList<>();
        list2.add(TypeLecture.Practical_THEATER);
 
        list3 = new ArrayList<>();
        list3.add(SpecializationName.Artificial_Intelligence);
        Love_Period = new ArrayList<>();
        Love_Period.add(new Period(2, 1));
        Love_Period.add(new Period(2, 2));
        Love_Period.add(new Period(2, 3));
        Love_Period.add(new Period(2, 4));
        teachers.add(new Teacher(TeacherName.Lujain_Harmelani, list1, p, list2, list3,Love_Period,2,1));
 
        /// 21 Teacher
        list1 = new ArrayList<>();
        list1.add(SubjectName.NN_AI);
 
        list2 = new ArrayList<>();
        list2.add(TypeLecture.Practical_LAB);
 
        list3 = new ArrayList<>();
        list3.add(SpecializationName.Artificial_Intelligence);
        Love_Period = new ArrayList<>();
        Love_Period.add(new Period(3, 1));
        Love_Period.add(new Period(3, 2));
        Love_Period.add(new Period(3, 3));
        Love_Period.add(new Period(3, 4));
        teachers.add(new Teacher(TeacherName.Nadia_Al_Bekaie, list1, p, list2, list3,Love_Period,3,1));
 
        /// 22 Teacher
        list1 = new ArrayList<>();
        list1.add(SubjectName.OPERATING_SYSTEM);
 
        list2 = new ArrayList<>();
        list2.add(TypeLecture.Practical_LAB);
 
        list3 = new ArrayList<>();
        list3.add(SpecializationName.Artificial_Intelligence);
        Love_Period = new ArrayList<>();
        Love_Period.add(new Period(3, 1));
        Love_Period.add(new Period(3, 2));
        Love_Period.add(new Period(3, 3));
        Love_Period.add(new Period(3, 4));
        teachers.add(new Teacher(TeacherName.Anas_Hariri, list1, p, list2, list3,Love_Period,3,1));
 
        /// 23 Teacher
        list1 = new ArrayList<>();
        list1.add(SubjectName.OPERATING_SYSTEM);
 
        list2 = new ArrayList<>();
        list2.add(TypeLecture.Practical_LAB);
 
        list3 = new ArrayList<>();
        list3.add(SpecializationName.Networks);
        Love_Period = new ArrayList<>();
        Love_Period.add(new Period(2, 1));
        Love_Period.add(new Period(2, 2));
        Love_Period.add(new Period(2, 3));
        Love_Period.add(new Period(2, 4));
        teachers.add(new Teacher(TeacherName.A, list1, p, list2, list3,Love_Period,3,1));
 
        /// 24 Teacher
        list1 = new ArrayList<>();
        list1.add(SubjectName.ALGO);
 
        list2 = new ArrayList<>();
        list2.add(TypeLecture.Practical_LAB);
 
        list3 = new ArrayList<>();
        list3.add(SpecializationName.Networks);
        Love_Period = new ArrayList<>();
        Love_Period.add(new Period(2, 1));
        Love_Period.add(new Period(2, 2));
        Love_Period.add(new Period(2, 3));
        Love_Period.add(new Period(2, 4));
        teachers.add(new Teacher(TeacherName.B, list1, p, list2, list3,Love_Period,3,1));
 
        /// 25 Teacher
        list1 = new ArrayList<>();
        list1.add(SubjectName.SOFTWARE_AI_N);
 
        list2 = new ArrayList<>();
        list2.add(TypeLecture.Practical_THEATER);
 
        list3 = new ArrayList<>();
        list3.add(SpecializationName.Networks);
        Love_Period = new ArrayList<>();
        Love_Period.add(new Period(4, 1));
        Love_Period.add(new Period(4, 2));
        Love_Period.add(new Period(4, 3));
        Love_Period.add(new Period(4, 4));
        teachers.add(new Teacher(TeacherName.Sawsan_AlHasan, list1, p, list2, list3,Love_Period,2,1));
 
        /// 26 Teacher
        list1 = new ArrayList<>();
        list1.add(SubjectName.AppNetworks_N);
 
        list2 = new ArrayList<>();
        list2.add(TypeLecture.Practical_LAB);
 
        list3 = new ArrayList<>();
        list3.add(SpecializationName.Networks);
        Love_Period = new ArrayList<>();
        Love_Period.add(new Period(5, 1));
        Love_Period.add(new Period(5, 2));
        Love_Period.add(new Period(5, 3));
        Love_Period.add(new Period(5, 4));
        teachers.add(new Teacher(TeacherName.Hassan_Dirwan, list1, p, list2, list3,Love_Period,2,1));
 
        /// 27 Teacher
        list1 = new ArrayList<>();
        list1.add(SubjectName.AppNetworks_N);
 
        list2 = new ArrayList<>();
        list2.add(TypeLecture.Practical_LAB);
 
        list3 = new ArrayList<>();
        list3.add(SpecializationName.Networks);
 
        Love_Period = new ArrayList<>();
        Love_Period.add(new Period(5, 1));
        Love_Period.add(new Period(5, 2));
        Love_Period.add(new Period(5, 3));
        Love_Period.add(new Period(5, 4));
        teachers.add(new Teacher(TeacherName.Ahmed_Touhan, list1, p, list2, list3, Love_Period, 2, 1));
 
    }

}
