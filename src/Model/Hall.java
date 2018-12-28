/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Objects;

/**
 *
 * @author Al-Hussein
 */
public class Hall implements Cloneable {

    private String ID;
    private Type type;

    
    public enum Type {
        THEATER, LAB;
    }
    
    public Hall(String ID, Type type) {
        this.ID = ID;
        this.type = type;
    }
    public Hall(Hall h) {
        this.ID = new String(h.ID);
        this.type = h.type;
    }

    @Override
    public String toString() {
        return  "ID=" + ID + ", type=" + type ;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.ID);
        hash = 67 * hash + Objects.hashCode(this.type);
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
        final Hall other = (Hall) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        return true;
    }

}
