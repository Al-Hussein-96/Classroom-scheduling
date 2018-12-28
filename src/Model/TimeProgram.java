/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Al-Hussein
 */
public class TimeProgram implements Cloneable{

    private int ID;
    private List<Lecture> lectures;

    public TimeProgram() {

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    public List<TimeProgram> getAllMoves() {
        List<TimeProgram> list = new ArrayList<>();
        
        
        
        
        
        return null;
    }

        
    /**
     * for check from All restriction
     *
     * @return true if all restriction is true
     */
    public boolean checkAllrestriction() {
        return fifthRestriction() && secondRestriction() && thirdRestriction() && fourthRestriction() && fifthRestriction() && sixthRestriction()
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

}
