/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.University.Specializations;
import static Model.University.halls;
import static Model.University.periods;
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

    static {
        All_Lectures = generateAllLecture();
    }

    private static List<Lecture> generateAllLecture() {
        List<Lecture> lectures = new ArrayList<>();

        int cnt = 1;
        for (Teacher teacher : teachers) {
            for (SubjectName name : teacher.getSubjectNames()) {
                for (Period period : periods) {
                    for (TypeLecture typeLecture : teacher.getTypeLectures()) {
                        for (SpecializationName specializationName : teacher.getSpecializationNames()) {
                            int GNum = 0;
                            int CNum = 0;
                            if (specializationName.equals(SpecializationName.Artificial_Intelligence)) {
                                GNum = Specializations.get(0).getNumGroup();
                                CNum = Specializations.get(0).getNumCategory();
                            }
                            if (specializationName.equals(SpecializationName.Networks)) {
                                GNum = Specializations.get(1).getNumGroup();
                                CNum = Specializations.get(1).getNumCategory();
                            }
                            if (specializationName.equals(SpecializationName.Software_Engineering)) {
                                GNum = Specializations.get(2).getNumGroup();
                                CNum = Specializations.get(2).getNumCategory();
                            }
                            for (Hall hall : halls) {
                                int x = 1;
                                if (typeLecture.equals(TypeLecture.Practical_LAB)) {
                                    x = CNum;
                                } else if (typeLecture.equals(TypeLecture.Practical_THEATER)) {
                                    x = GNum;
                                }
                                for (int i = 1; i <= x; i++) {
                                    Lecture lecture;
                                    if (typeLecture.equals(TypeLecture.Practical_LAB)) {
                                        lecture = new Lecture(cnt++, name, specializationName, typeLecture, teacher, period, hall, 0, i);
                                    } else if (typeLecture.equals(TypeLecture.Practical_THEATER)) {
                                        lecture = new Lecture(cnt++, name, specializationName, typeLecture, teacher, period, hall, i, 0);
                                    } else {
                                        lecture = new Lecture(cnt++, name, specializationName, typeLecture, teacher, period, hall, 0, 0);
                                    }
                                    //     System.out.println("Cnt: " + cnt);
                                    if (isCompatible(hall.getType(), typeLecture)) {
                                        lectures.add(lecture);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Size Of Lecture is " + lectures.size());
        return lectures;
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
    protected Object clone() throws CloneNotSupportedException {
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
        System.out.println("Hall: "+ this.hall);

        System.out.println("*****************************************");

    }

}
