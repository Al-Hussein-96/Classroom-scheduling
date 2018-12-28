package Model;

/**
 *
 * @author Al-Hussein
 */
public class Subject implements Cloneable{

    private SubjectName name;
    private int NumTheoretical;
    private int NumPractical_LAB;
    private int NumPractical_THEATER;
    private boolean AI,SE,N;

    public Subject(SubjectName name, int NumTheoretical, int NumPractical_LAB, int NumPractical_THEATER, boolean AI, boolean SE, boolean N) {
        this.name = name;
        this.NumTheoretical = NumTheoretical;
        this.NumPractical_LAB = NumPractical_LAB;
        this.NumPractical_THEATER = NumPractical_THEATER;
        this.AI = AI;
        this.SE = SE;
        this.N = N;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    

    
    
    /**
     * TODO
     *
     *
     */
}
