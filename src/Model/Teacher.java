/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Al-Hussein
 */
public class Teacher implements Cloneable {

    private TeacherName Name;
    private List<SubjectName> subjectNames;
    private int MaximumLecture;
    private int MaximumDay;
    private List<Period> periods; /// the time that teather cannot found in university
    private List<TypeLecture> typeLectures;
    private List<SpecializationName> specializationNames;

    public Teacher(TeacherName Name, List<SubjectName> subjectNames, List<Period> periods, List<TypeLecture> typeLectures, List<SpecializationName> specializationNames) {
        this.Name = Name;
        this.subjectNames = subjectNames;
        this.periods = periods;
        this.typeLectures = typeLectures;
        this.specializationNames = specializationNames;
    }

    public Teacher(TeacherName Name, List<SubjectName> subjectNames, List<Period> periods) {
        this.Name = Name;
        this.subjectNames = subjectNames;
        this.periods = periods;
    }

    public Teacher(TeacherName Name, List<SubjectName> subjectNames, int MaximumLecture, int MaximumDay, List<Period> periods) {
        this.Name = Name;
        this.subjectNames = subjectNames;
        this.MaximumLecture = MaximumLecture;
        this.MaximumDay = MaximumDay;
        this.periods = periods;
    }

    
    
    
    
    
    
    
    
    
    
    

    public TeacherName getName() {
        return Name;
    }

    public void setName(TeacherName Name) {
        this.Name = Name;
    }

    public List<SubjectName> getSubjectNames() {
        return subjectNames;
    }

    public void setSubjectNames(List<SubjectName> subjectNames) {
        this.subjectNames = subjectNames;
    }

    public int getMaximumLecture() {
        return MaximumLecture;
    }

    public void setMaximumLecture(int MaximumLecture) {
        this.MaximumLecture = MaximumLecture;
    }

    public int getMaximumDay() {
        return MaximumDay;
    }

    public void setMaximumDay(int MaximumDay) {
        this.MaximumDay = MaximumDay;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    public void setPeriods(List<Period> periods) {
        this.periods = periods;
    }

    public List<TypeLecture> getTypeLectures() {
        return typeLectures;
    }

    public void setTypeLectures(List<TypeLecture> typeLectures) {
        this.typeLectures = typeLectures;
    }

    public List<SpecializationName> getSpecializationNames() {
        return specializationNames;
    }

    public void setSpecializationNames(List<SpecializationName> specializationNames) {
        this.specializationNames = specializationNames;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.Name);
        hash = 31 * hash + Objects.hashCode(this.subjectNames);
        hash = 31 * hash + this.MaximumLecture;
        hash = 31 * hash + this.MaximumDay;
        hash = 31 * hash + Objects.hashCode(this.periods);
        hash = 31 * hash + Objects.hashCode(this.typeLectures);
        hash = 31 * hash + Objects.hashCode(this.specializationNames);
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
        final Teacher other = (Teacher) obj;
        if (this.MaximumLecture != other.MaximumLecture) {
            return false;
        }
        if (this.MaximumDay != other.MaximumDay) {
            return false;
        }
        if (this.Name != other.Name) {
            return false;
        }
        if (!Objects.equals(this.subjectNames, other.subjectNames)) {
            return false;
        }
        if (!Objects.equals(this.periods, other.periods)) {
            return false;
        }
        if (!Objects.equals(this.typeLectures, other.typeLectures)) {
            return false;
        }
        if (!Objects.equals(this.specializationNames, other.specializationNames)) {
            return false;
        }
        return true;
    }

}
