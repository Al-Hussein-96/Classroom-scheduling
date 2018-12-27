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
public class Teacher {
    private TeacherName Name;
    private List<SubjectName> subjectNames;
    private int MaximumLecture;
    private int MaximumDay;
    private List<Period> periods; /// the time that teather cannot found in university

    public Teacher(TeacherName Name, List<SubjectName> subjectNames, int MaximumLecture, int MaximumDay, List<Period> periods) {
        this.Name = Name;
        this.subjectNames = subjectNames;
        this.MaximumLecture = MaximumLecture;
        this.MaximumDay = MaximumDay;
        this.periods = periods;
    }


    
    
    
    
    
    
    
 
}
