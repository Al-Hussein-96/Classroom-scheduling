package Model;

import java.util.Objects;

/**
 *
 * @author Al-Hussein
 */
public class Subject implements Cloneable {

    private SubjectName name;
    private int NumTheoretical;
    private int NumPractical_LAB;
    private int NumPractical_THEATER;
    private boolean AI, SE, N;

    private int difficulty;

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public Subject(SubjectName name, int NumTheoretical, int NumPractical_LAB, int NumPractical_THEATER, boolean AI, boolean SE, boolean N, int difficulty) {
        this.name = name;
        this.NumTheoretical = NumTheoretical;
        this.NumPractical_LAB = NumPractical_LAB;
        this.NumPractical_THEATER = NumPractical_THEATER;
        this.AI = AI;
        this.SE = SE;
        this.N = N;
        this.difficulty = difficulty;
    }

    public SubjectName getName() {
        return name;
    }

    public void setName(SubjectName name) {
        this.name = name;
    }

    public int getNumTheoretical() {
        return NumTheoretical;
    }

    public void setNumTheoretical(int NumTheoretical) {
        this.NumTheoretical = NumTheoretical;
    }

    public int getNumPractical_LAB() {
        return NumPractical_LAB;
    }

    public void setNumPractical_LAB(int NumPractical_LAB) {
        this.NumPractical_LAB = NumPractical_LAB;
    }

    public int getNumPractical_THEATER() {
        return NumPractical_THEATER;
    }

    public void setNumPractical_THEATER(int NumPractical_THEATER) {
        this.NumPractical_THEATER = NumPractical_THEATER;
    }

    public boolean isAI() {
        return AI;
    }

    public void setAI(boolean AI) {
        this.AI = AI;
    }

    public boolean isSE() {
        return SE;
    }

    public void setSE(boolean SE) {
        this.SE = SE;
    }

    public boolean isN() {
        return N;
    }

    public void setN(boolean N) {
        this.N = N;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + this.NumTheoretical;
        hash = 71 * hash + this.NumPractical_LAB;
        hash = 71 * hash + this.NumPractical_THEATER;
        hash = 71 * hash + (this.AI ? 1 : 0);
        hash = 71 * hash + (this.SE ? 1 : 0);
        hash = 71 * hash + (this.N ? 1 : 0);
        hash = 71 * hash + this.difficulty;
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
        final Subject other = (Subject) obj;
        if (this.NumTheoretical != other.NumTheoretical) {
            return false;
        }
        if (this.NumPractical_LAB != other.NumPractical_LAB) {
            return false;
        }
        if (this.NumPractical_THEATER != other.NumPractical_THEATER) {
            return false;
        }
        if (this.AI != other.AI) {
            return false;
        }
        if (this.SE != other.SE) {
            return false;
        }
        if (this.N != other.N) {
            return false;
        }
        if (this.difficulty != other.difficulty) {
            return false;
        }
        if (this.name != other.name) {
            return false;
        }
        return true;
    }

    

    /**
     * TODO
     *
     *
     */
}
