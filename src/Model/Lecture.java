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

/**
 *
 * @author Al-Hussein
 */
public class Lecture implements Cloneable {

    private int ID;
    private SubjectName subject;
    private SpecializationName specializationName;
    private TypeLecture typeLecture;
    private Teacher teacher;
    private Period period;
    private Hall hall;
    private int GroupNumber = 0;
    private int CategoryNumber = 0;

    public final static List<Lecture> All_Lectures;

//     public Lecture() {
//        this.teacher = new Teacher();
//        this.period = new Period();
//    }
    public Lecture(Lecture L) {
        this.ID = L.ID;
        this.subject = L.subject;
        this.specializationName = L.specializationName;
        this.typeLecture = L.typeLecture;
        this.teacher = new Teacher(L.teacher);
        this.period = new Period(L.period);
        this.hall = new Hall(L.hall);
        this.GroupNumber = L.GroupNumber;
        this.CategoryNumber = L.CategoryNumber;
    }

    public Lecture(int ID, SubjectName subject, SpecializationName specializationName, TypeLecture typeLecture, Teacher teacher, Period period, Hall hall, int GroupNumber, int CategoryNumber) {
        this.ID = ID;
        this.subject = subject;
        this.specializationName = specializationName;
        this.typeLecture = typeLecture;
        this.teacher = teacher;
        this.period = period;
        this.hall = hall;
        this.GroupNumber = GroupNumber;
        this.CategoryNumber = CategoryNumber;
    }

    public Lecture(SubjectName subject, SpecializationName specializationName, TypeLecture typeLecture, int GroupNumber, int CategoryNumber) {
        this.subject = subject;
        this.specializationName = specializationName;
        this.typeLecture = typeLecture;
        this.GroupNumber = GroupNumber;
        this.CategoryNumber = CategoryNumber;
        
        this.ID=0;
        this.teacher = new Teacher();
        this.period = new Period();
        this.hall=new Hall("-1",null);
    }

    static {
        All_Lectures = generateAllLecture();
    }

    private static List<Lecture> generateAllLecture() {
        List<Lecture> lectures = new ArrayList<>();

        for (Subject subject : subjects) {
            int x = 0;
            for (Specialization Spec : Specializations) {
                if (!SameSpecialization(subject, Spec.getName())) {
                    continue;
                }
                x++;
                int GNum = Spec.getNumGroup();
                int CNum = Spec.getNumCategory();
                if (x == 1) {
                    for (int i = 1; i <= subject.getNumTheoretical(); i++) {
                        lectures.add(new Lecture(subject.getName(), Spec.getName(), TypeLecture.Theoretical, 0, 0));
                    }
                }
//                for (int i = 1; i <= subject.getNumPractical_THEATER(); i++) {
//                    for (int j = 1; j <= GNum; j++) {
//                        lectures.add(new Lecture(subject.getName(), Spec.getName(), TypeLecture.Practical_THEATER, j, 0));
//                    }
//                }
//                for (int i = 1; i <= subject.getNumPractical_LAB(); i++) {
//                    for (int j = 1; j <= CNum; j++) {
//                        lectures.add(new Lecture(subject.getName(), Spec.getName(), TypeLecture.Practical_LAB, 0, j));
//                    }
//                }
            }
        }
        System.out.println("Size Of Lecture is " + lectures.size());
        return lectures;
    }

    private static boolean SameSpecialization(Subject subject, SpecializationName Sp) {
        if ((subject.isAI() && Sp.equals(SpecializationName.Artificial_Intelligence))
                || (subject.isN() && Sp.equals(SpecializationName.Networks))
                || (subject.isSE() && Sp.equals(SpecializationName.Software_Engineering))) {
            return true;
        }
        return false;
    }

    private static boolean isCompatible(Hall.Type type, TypeLecture typeLecture) {
        if (type == Hall.Type.THEATER && typeLecture == TypeLecture.Practical_THEATER) {
            return true;
        }
        if (type == Hall.Type.THEATER && typeLecture == TypeLecture.Theoretical) {
            return true;
        }
        if (type == Hall.Type.LAB && typeLecture == TypeLecture.Practical_LAB) {
            return true;
        }
        return false;
    }

    public Lecture() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public SubjectName getSubject() {
        return subject;
    }

    public void setSubject(SubjectName subject) {
        this.subject = subject;
    }

    public SpecializationName getSpecializationName() {
        return specializationName;
    }

    public void setSpecializationName(SpecializationName specializationName) {
        this.specializationName = specializationName;
    }

    public TypeLecture getTypeLecture() {
        return typeLecture;
    }

    public void setTypeLecture(TypeLecture typeLecture) {
        this.typeLecture = typeLecture;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public int getGroupNumber() {
        return GroupNumber;
    }

    public void setGroupNumber(int GroupNumber) {
        this.GroupNumber = GroupNumber;
    }

    public int getCategoryNumber() {
        return CategoryNumber;
    }

    public void setCategoryNumber(int CategoryNumber) {
        this.CategoryNumber = CategoryNumber;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.ID;
        hash = 71 * hash + Objects.hashCode(this.subject);
        hash = 71 * hash + Objects.hashCode(this.specializationName);
        hash = 71 * hash + Objects.hashCode(this.typeLecture);
        hash = 71 * hash + Objects.hashCode(this.teacher);
        hash = 71 * hash + Objects.hashCode(this.period);
        hash = 71 * hash + Objects.hashCode(this.hall);
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
        final Lecture other = (Lecture) obj;
        if (this.ID != other.ID) {
            return false;
        }
        if (this.subject != other.subject) {
            return false;
        }
        if (this.specializationName != other.specializationName) {
            return false;
        }
        if (this.typeLecture != other.typeLecture) {
            return false;
        }
        if (!Objects.equals(this.teacher, other.teacher)) {
            return false;
        }
        if (!Objects.equals(this.period, other.period)) {
            return false;
        }
        if (!Objects.equals(this.hall, other.hall)) {
            return false;
        }
        return true;
    }
    
    

    public void printLecture() {

        System.out.println("*****************************************");
        System.out.println("Name Subject: " + this.subject);
        System.out.println("Name Teacher: " + this.teacher.getName());
        System.out.println("Name Specialization: " + this.specializationName);
        System.out.println("Type Lecture: " + this.typeLecture);
        if (typeLecture != null && typeLecture.equals(TypeLecture.Practical_THEATER)) {
            System.out.println("Group: " + this.GroupNumber);
        }
        if (typeLecture != null && typeLecture.equals(TypeLecture.Practical_LAB)) {
            System.out.println("Category: " + this.CategoryNumber);
        }
        System.out.println("Period: " + this.period.toString());
        System.out.println("Hall: " + this.hall);

        System.out.println("*****************************************");

    }

}
