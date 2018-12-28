/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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

    private int ID;
    private List<Lecture> lectures;

    public TimeProgram() {

    }

    public List<TimeProgram> getAllProgrm() {
        List<TimeProgram> list = new ArrayList<>();

        for (Lecture lecture : Lecture.All_Lectures) {
            TimeProgram newTimeProgram;
            try {
                newTimeProgram = (TimeProgram) this.clone();
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(TimeProgram.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
            newTimeProgram.addLecture(lecture);
            if (newTimeProgram.checkSubRestrictionforSubProgram()) {
                list.add(newTimeProgram);
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
        return fourthRestriction() && fifthRestriction() && sixthRestriction() && seventhRestriction();
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
        return fifthRestriction() && secondRestriction()
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

        return true;
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

        return true;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.ID;
        hash = 97 * hash + Objects.hashCode(this.lectures);
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
        if (this.ID != other.ID) {
            return false;
        }
        if (!Objects.equals(this.lectures, other.lectures)) {
            return false;
        }
        return true;
    }

    public void printProgram() {
        System.out.println("*************** Final Program ******************");

        Lecture[][] lec = new Lecture[5][4];

        for (Lecture lecture : lectures) {
            lec[lecture.getPeriod().getDay()][lecture.getPeriod().getTime()] = lecture;
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                lec[i][j].printLecture();
            }
        }
        System.out.println("*************************************************");

    }

}
