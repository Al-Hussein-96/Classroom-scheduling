/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

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

    

}
