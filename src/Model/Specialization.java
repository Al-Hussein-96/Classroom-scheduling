/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Al-Hussein
 */
public class Specialization implements Cloneable{

    private SpecializationName name;
    private int numGroup;
    private int numCategory;
    private int [] start;
    private int [] End;
    public Specialization(SpecializationName name, int numGroup, int numCategory) {
        this.name = name;
        this.numGroup = numGroup;
        this.numCategory = numCategory;
        this.start = new int [numGroup+1];
        this.End = new int [numGroup+1];
       
    }

    public int getStart(int x) {
        return start[x];
    }

    public void setStart(int[] start) {
        this.start = start;
    }

    public int getEnd(int x) {
        return End[x];
    }

    public void setEnd(int[] End) {
        this.End = End;
    }

    public SpecializationName getName() {
        return name;
    }

    public void setName(SpecializationName name) {
        this.name = name;
    }

    public int getNumGroup() {
        return numGroup;
    }

    public void setNumGroup(int numGroup) {
        this.numGroup = numGroup;
    }

    public int getNumCategory() {
        return numCategory;
    }

    public void setNumCategory(int numCategory) {
        this.numCategory = numCategory;
    }
    
    
    // TODO
//    List<Group>
//            List<فئات>
    // تابع اضافة لليست بالاعلى

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
}
