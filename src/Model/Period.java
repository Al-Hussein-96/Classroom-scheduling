/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Al-Hussein
 */
public class Period implements Cloneable {

    private int Day;
    private int time;

    public Period(int Day, int time) {
        this.Day = Day;
        this.time = time;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        String startEnd;
        switch (time) {
            case 0:
                startEnd = "8:30 to 10:30";
                break;
            case 1:
                startEnd = "10:30 to 12:30";
                break;
            case 2:
                startEnd = "12:30 to 2:30";
                break;
            case 3:
                startEnd = "2:30 to 4:30";
                break;
            default:
                startEnd = "-1";
                break;
        }

        String nameDay;
        switch (Day) {
            case 0:
                nameDay = "Sunday";
                break;
            case 1:
                nameDay = "Monday";
                break;
            case 2:
                nameDay = "Tuesday";
                break;
            case 3:
                nameDay = "Wednesday";
                break;
            case 4:
                nameDay = "Thursday";
                break;
            default:
                nameDay = "-1";
                break;
        }

        return "Day=" + nameDay + ", time=" + startEnd;
    }

}
