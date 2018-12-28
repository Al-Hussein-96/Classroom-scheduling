/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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

    public final static List<Lecture> All_Lectures;

    public Lecture() {
    }

    public Lecture(int ID, SubjectName subject, SpecializationName specializationName, TypeLecture typeLecture, Teacher teacher, Period period, Hall hall) {
        this.ID = ID;
        this.subject = subject;
        this.specializationName = specializationName;
        this.typeLecture = typeLecture;
        this.teacher = teacher;
        this.period = period;
        this.hall = hall;
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
                            for (Hall hall : halls) {
                                Lecture lecture = new Lecture(cnt++, name, specializationName, typeLecture, teacher, period, hall);
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
        System.out.println("Period: " + this.period.toString());

        System.out.println("*****************************************");

    }

}
