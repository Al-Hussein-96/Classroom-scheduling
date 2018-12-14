/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Al-Hussein
 */
public class Lecture {

    private int ID;
    private Teacher teacher;
    private Section section;
    private Hall hall;
    private Period period;

    public final static List<Lecture> All_Lectures;

    static {
        All_Lectures = getnerateAllLecture();
    }

    private static List<Lecture> getnerateAllLecture() {
        List<Lecture> lectures = new ArrayList<>();
        // 6 Number Of Subject
        for(int sub_id=1;sub_id<=6;sub_id++)
        {
            for(int type_sub=1;type_sub<=2;type_sub++){
                
                
                
            }
            
            
        }
            
        
        

        return lectures;
    }
}
