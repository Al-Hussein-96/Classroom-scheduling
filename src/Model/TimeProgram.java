/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.University.Specializations;
import static Model.University.halls;
import static Model.University.periods;
import static Model.University.subjects;
import static Model.University.teachers;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Al-Hussein
 */
public class TimeProgram implements Cloneable {

    private List<Lecture> lectures = new ArrayList<>();

    public TimeProgram() {

    }

    public TimeProgram(TimeProgram TP) {
        for (Lecture L : TP.lectures) {
            this.lectures.add(new Lecture(L));
        }
    }

    /// this fuction to Now if teacher Can give Lector

    public boolean can_Give_Lecture(Teacher t, Lecture lecture, Period p) {
        SubjectName subject = lecture.getSubject();
        SpecializationName specializationName = lecture.getSpecializationName();
        TypeLecture typeLecture = lecture.getTypeLecture();
        /// have same subject
        for (SubjectName s : t.getSubjectNames()) {
            if (s.equals(subject)) {
                /// have same Specializatio
                for (SpecializationName spName : t.getSpecializationNames()) {
                    if (spName.equals(specializationName)) {
                        for (TypeLecture TypeL : t.getTypeLectures()) {
                            if (TypeL.equals(typeLecture)) {
                                return Teacher_can_Give_Lecture_In_this_Period(t, p);

                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /// sixthRestriction Hall should be empty
    public boolean Hall_is_Empty(Hall h, Period p) {
        for (Lecture lec : lectures) {
            if (lec.getPeriod().equals(p)) {
                if (lec.getHall().equals(h)) {
                    return false;
                }
            }
        }
        return true;
    }

    /// this solve fourth restriction && seventh restriction
    public boolean Teacher_can_Give_Lecture_In_this_Period(Teacher t, Period p) {
        /**
         * The fourth restriction The same teacher can not give more than one
         * lecture at the same time
         */
        for (Lecture lec : lectures) {
            if (lec.getTeacher().equals(t)) {
                if (lec.getPeriod().equals(p)) {
                    return false;
                }
            }
        }
        /**
         * The seventh restriction Lectures should not be given at a time when
         * the teacher can not be present.
         */
        for (Period cant_be : t.getPeriods()) {
            if (cant_be.equals(p)) {
                return false;
            }
        }
        return true;
    }

    public List<TimeProgram> getAllProgrm() {
        List<TimeProgram> list = new ArrayList<>();
        Lecture lecture = Lecture.All_Lectures.get(lectures.size());
        int out = 0;
        for (Period p : periods) {
            Hall h = null;
            /// first find palce then find teacher
            for (Hall H : halls) {
                /**
                 * ThirdRestriction The third restriction The theoretical
                 * lectures must be held in the stands and the process in the
                 * halls can accommodate the number of students
                 */
                if ((lecture.getTypeLecture().equals(TypeLecture.Practical_LAB) && !H.getType().equals(Hall.Type.LAB))
                        || !lecture.getTypeLecture().equals(TypeLecture.Practical_LAB) && H.getType().equals(Hall.Type.LAB)) {
                    continue;
                }

                /// sixthRestriction Hall should be empty
                if (!Hall_is_Empty(H, p)) {
                    continue;
                }
                /// when find first good place close
                h = H;
                break;
            }

            for (Teacher t : teachers) {

                /**
                 * fourth restriction && seventh restriction
                 */
                if (!can_Give_Lecture(t, lecture, p)) {
                    continue;
                }
                Lecture lec = new Lecture(lecture.getSubject(), lecture.getSpecializationName(), lecture.getTypeLecture(), lecture.getGroupNumber(), lecture.getCategoryNumber());
                lec.setPeriod(new Period(p));
                lec.setTeacher(new Teacher(t));
                lec.setHall(new Hall(h));

                TimeProgram newTimeProgram = new TimeProgram(this);
                newTimeProgram.addLecture(new Lecture(lec));
                if (newTimeProgram.checkSubRestrictionforSubProgram()) {
                    list.add(newTimeProgram);
                    /// when find first good  teacher close
                    ///   break;
                }
            }
        }
        System.out.println(list.size() + " : " + lectures.size() + " " + lecture.getSubject());
        return list;
    }

    public void addLecture(Lecture lecture) {
        this.lectures.add(lecture);
    }

    /**
     * for check from All restriction
     *
     * @return true if all restriction is true
     */
    public boolean checkSubRestrictionforSubProgram() {
        boolean res = fourthRestriction() && fifthRestriction() && sixthRestriction() && seventhRestriction();
        return res;
    }

    /**
     *
     * @return true if The program is final
     */
    public boolean isFinal() {
        return firstRestriction();
    }

    /**
     * for check from All restriction
     *
     * @return true if all restriction is true
     */
    public boolean checkAllrestriction() {
        return firstRestriction() && secondRestriction()
                && thirdRestriction() && fourthRestriction()
                && fifthRestriction() && sixthRestriction()
                && seventhRestriction();
    }

    /**
     * The first restriction
     * <p>
     * The Time Program should cover all theoretical or practical Subject for
     * all departments, groups and categories
     *
     * @return true if the restriction accepted else false
     */
    public boolean firstRestriction() {
        if (this.lectures.size() == Lecture.All_Lectures.size()) {
            return true;
        }
        return false;
    }

    /**
     * to get number of lecture with SubjectName subject and SpecializationName
     * specializationName and TypeLecture typeLecture
     *
     * @param subject
     * @param specializationName
     * @param typeLecture
     * @return
     */
    private int listContint(SubjectName subject, SpecializationName specializationName, TypeLecture typeLecture, int GroupNum, int CatNum) {
        int res = 0;
        for (Lecture L : lectures) {
            if (L.getSubject().equals(subject) && L.getSpecializationName().equals(specializationName) && L.getTypeLecture().equals(typeLecture)
                    && L.getGroupNumber() == GroupNum && L.getCategoryNumber() == CatNum) {
                res++;
            }
        }
        return res;
    }

    /**
     * The second restriction
     * <p>
     * The number of lectures per day should not exceed 4 lectures, 2 hours per
     * lecture.
     * </p>
     *
     * @return true if the restriction accepted else false
     */
    public boolean secondRestriction() {
        return true;
    }

    /**
     * The third restriction
     * <p>
     * The theoretical lectures must be held in the stands and the process in
     * the halls can accommodate the number of students
     * </p>
     *
     * @return true if the restriction accepted else false
     */
    public boolean thirdRestriction() {

        return true;
    }

    /**
     * The fourth restriction
     * <p>
     * The same teacher can not give more than one lecture at the same time
     * </p>
     *
     * @return true if the restriction accepted else false
     */
    public boolean fourthRestriction() {
//        for (int i = 0; i < lectures.size(); i++) {
//            for (int j = 0; j < lectures.size(); j++) {
//                if (i == j) {
//                    continue;
//                }
//                Lecture L1 = lectures.get(i);
//                Lecture L2 = lectures.get(j);
//                if (L1.getTeacher().getName().equals(L2.getTeacher().getName())
//                        && L1.getPeriod().equals(L2.getPeriod())) {
//                    return false;
//                }
//            }
//        }
        return true;
    }

    /**
     * The fifth restriction
     * <p>
     * The student can attend more than one lecture at the same time.
     * </p>
     *
     * @return true if the restriction accepted else false
     */
    public boolean fifthRestriction() {
        for (int i = 0; i < lectures.size(); i++) {
            for (int j = 0; j < lectures.size(); j++) {
                if (i == j) {
                    continue;
                }
                Lecture L1 = lectures.get(i);
                Lecture L2 = lectures.get(j);
                if (L1.getPeriod().equals(L2.getPeriod())) {
                    if(L1.getSpecializationName().equals(L2.getSpecializationName()))
                    {
                        if(cheack_if_one_lecture_inside_other(L1,L2))
                            return false;
                        if(cheack_if_one_lecture_inside_other(L2,L1))
                           return false;
                    }
                    else
                    {
                        if(L1.getTypeLecture().equals(TypeLecture.Theoretical))
                        {
                            if(checkCommonTwoSpec(L1.getSpecializationName() , L2.getSpecializationName(),L1.getSubject()))
                            {
                                return false;
                            }
                        }
                        if(L2.getTypeLecture().equals(TypeLecture.Theoretical))
                        {
                            if(checkCommonTwoSpec(L2.getSpecializationName() , L1.getSpecializationName(),L2.getSubject()))
                            {
                                return false;
                            }
                        }
                    }
                }

            }

        }
        return true;
    }

   public boolean checkCommonTwoSpec(SpecializationName sp1, SpecializationName sp2, SubjectName name) {
        for (Subject s : subjects) {
            if (s.getName().equals(name)) {
                SpecializationName s1 = null, s2 = null, s3 = null;
                if (s.isAI()) {
                    s1 = SpecializationName.Artificial_Intelligence;
                }
                if (s.isSE()) {
                    s2 = SpecializationName.Software_Engineering;
                }
                if (s.isN()) {
                    s3 = SpecializationName.Networks;
                }
 
                boolean ok1 = sp1.equals(s1) || sp1.equals(s2) || sp1.equals(s3);
                boolean ok2 = sp2.equals(s1) || sp2.equals(s2) || sp2.equals(s3);
 
                return ok1 && ok2;
 
            }
        }
        return false;
 
    }
    public boolean cheack_if_one_lecture_inside_other(Lecture L1 , Lecture L2)
    {
        TypeLecture Type1 = L1.getTypeLecture();
        TypeLecture Type2 = L2.getTypeLecture();
        if(Type1.equals(TypeLecture.Theoretical))
        {
            return true;
        }
        if(Type2.equals(TypeLecture.Theoretical))
        {
            return true;
        }
        if(Type1.equals(Type2))
        {
            if(Type1.equals(TypeLecture.Practical_LAB))
            {
                if(L1.getCategoryNumber() == L2.getCategoryNumber())
                    return true;
            }
            
            if(Type1.equals(TypeLecture.Practical_THEATER))
            {
                if(L1.getGroupNumber()== L2.getGroupNumber())
                    return true;
            }
        }
        else 
        {
            SpecializationName sp1 = L1.getSpecializationName();
            int Number_of_Group = 0;
            int Number_of_Category = 0;
            for(Specialization sp : Specializations)
            {
                if(sp.getName().equals(sp1))
                {
                    Number_of_Category = sp.getNumCategory();
                    Number_of_Group = sp.getNumGroup();
                }
            }
            int Start_Category = 0 ;
            int End_Category = 0;
            int x = (Number_of_Category+Number_of_Group-1)/Number_of_Group;
            
            if(Type1.equals(TypeLecture.Practical_LAB))
            {
                Start_Category = L2.getCategoryNumber()*(x-1)+1;
                End_Category = Start_Category+x-1;
                if(L2.getCategoryNumber() >= Start_Category && L2.getCategoryNumber() <= End_Category)
                    return true;
            }
            else 
            {
                 Start_Category = L2.getCategoryNumber()*(x-1)+1;
                 End_Category = Start_Category+x-1;
                 if(L1.getCategoryNumber() >= Start_Category && L1.getCategoryNumber() <= End_Category)
                    return true;
            }
            
        }
        return false;
    }
    /**
     * The sixth restriction
     * <p>
     * A hall / THEATER can not give more than one lecture at the same time.
     * </p>
     *
     * @return true if the restriction accepted else false
     */
    public boolean sixthRestriction() {
        for (int i = 0; i < lectures.size(); i++) {
            for (int j = 0; j < lectures.size(); j++) {
                if (i == j) {
                    continue;
                }
                Lecture L1 = lectures.get(i);
                Lecture L2 = lectures.get(j);
                if (L1.getHall().equals(L2.getHall())
                        && L1.getPeriod().equals(L2.getPeriod())) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * The seventh restriction
     * <p>
     * Lectures should not be given at a time when the teacher can not be
     * present.
     * </p>
     *
     * @return true if the restriction accepted else false
     */
    public boolean seventhRestriction() {
//        for (Lecture L : lectures) {
//            Teacher t = L.getTeacher();
//            for (Period p : L.getPeriods()) {
//                if (L.getPeriod().equals(p)) {
//                    return false;
//                }
//            }
//        }
        return true;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.lectures);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TimeProgram other = (TimeProgram) obj;
        if (!Objects.equals(this.lectures, other.lectures)) {
            return false;
        }
        return true;
    }

    public void printProgram() {
        System.out.println("*************** Final Program ******************");

        Lecture[][] lec = new Lecture[6][5];
        Boolean[][] bo = new Boolean[6][5];
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 4; j++) {
                bo[i][j] = new Boolean(false);
            }
        }
        for (Lecture lecture : lectures) {
            int Day = lecture.getPeriod().getDay();
            int Time = lecture.getPeriod().getTime();
            lec[Day][Time] = new Lecture(lecture);
            bo[Day][Time] = true;
        }
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 4; j++) {
                if (bo[i][j]) {
                    lec[i][j].printLecture();
                }
            }
        }
        System.out.println("*************************************************");

    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    public boolean canAddLecture(Lecture u, Period period) {
        u.setPeriod(period);
        addLecture(u);
        if (this.checkSubRestrictionforSubProgram()) {
            this.lectures.remove(u);
            return true;
        }

        this.lectures.remove(u);
        return false;
    }

    
    
    
}
