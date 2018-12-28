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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
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
