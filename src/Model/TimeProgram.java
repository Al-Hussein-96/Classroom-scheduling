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

    public List<TimeProgram> getAllProgrm() {
        List<TimeProgram> list = new ArrayList<>();
        Lecture lecture = Lecture.All_Lectures.get(lectures.size());
        for (Period p : periods) {
            for (Teacher t : teachers) {
                for (Hall h : halls) {
                    if ((lecture.getTypeLecture().equals(TypeLecture.Practical_LAB) && !h.getType().equals(Hall.Type.LAB))
                            || !lecture.getTypeLecture().equals(TypeLecture.Practical_LAB) && h.getType().equals(Hall.Type.LAB)) {
                        continue;
                    }
                    Lecture lec = new Lecture(lecture.getSubject(), lecture.getSpecializationName(), lecture.getTypeLecture(), lecture.getGroupNumber(), lecture.getCategoryNumber());
                    lec.setPeriod(new Period(p));
                    lec.setTeacher(new Teacher(t));
                    lec.setHall(new Hall(h));
                    
                    TimeProgram newTimeProgram = new TimeProgram(this);
                    newTimeProgram.addLecture(new Lecture(lec));
                    if(newTimeProgram.checkSubRestrictionforSubProgram())
                        list.add(newTimeProgram);
                }
            }
        }
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
        for (int i = 0; i < lectures.size(); i++) {
            for (int j = 0; j < lectures.size(); j++) {
                if (i == j) {
                    continue;
                }
                Lecture L1 = lectures.get(i);
                Lecture L2 = lectures.get(j);
                if (L1.getTeacher().getName().equals(L2.getTeacher().getName())
                        && L1.getPeriod().equals(L2.getPeriod())) {
                    return false;
                }
            }
        }
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
                if (L1.getSpecializationName().equals(L2.getSpecializationName())
                        && L1.getTypeLecture().equals(L2.getTypeLecture())
                        && L1.getGroupNumber() == L2.getGroupNumber()
                        && L1.getCategoryNumber() == L2.getCategoryNumber()
                        && L1.getPeriod().equals(L2.getPeriod())) {
                    return false;
                }
            }
        }
        return true;
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
        for (Lecture L : lectures) {
            Teacher t = L.getTeacher();
            for (Period p : t.getPeriods()) {
                if (L.getPeriod().equals(p)) {
                    return false;
                }
            }
        }
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

}
