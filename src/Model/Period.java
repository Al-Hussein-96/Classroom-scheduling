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
public class Period implements Cloneable {

    private int Day;
    private int time;

    public Period(int Day, int time) {
        this.Day = Day;
        this.time = time;
    }

    public int getDay() {
        return Day;
    }

    public int getTime() {
        return time;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.Day;
        hash = 71 * hash + this.time;
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
        final Period other = (Period) obj;
        if (this.Day != other.Day) {
            return false;
        }
        if (this.time != other.time) {
            return false;
        }
        return true;
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
