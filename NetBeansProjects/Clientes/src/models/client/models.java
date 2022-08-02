package models.client;

import java.io.Serializable;
import java.util.Objects;
/**
 *
 * @author fsociety
 */
public class models implements Serializable{
    private String name;
    private int DNI;
    private String position;
    
    public models(String name, int DNI, String position) {
        this.name = name;
        this.DNI = DNI;
        this.position = position;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getDNI() {
        return this.DNI;
    }
    public void setDNI(int DNI) {
        this.DNI = DNI;
    }
    public String getPosition() {
        return this.position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + this.DNI;
        hash = 47 * hash + Objects.hashCode(this.position);
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
        final models other = (models) obj;
        if (this.DNI != other.DNI) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.position, other.position);
    }
    
}