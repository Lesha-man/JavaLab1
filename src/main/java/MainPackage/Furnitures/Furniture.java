/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage.Furnitures;

import java.io.Serializable;

/**
 *
 * @author Я
 */
public abstract class Furniture implements Serializable {

    public int Price;
    public int Mass;

    public Furniture(int price, int mass) {
        Price = price;
        Mass = mass;
    }

    @Override
    public String toString() {
        return "Furniture";
    }
    
    public abstract String info ();

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.Price;
        hash = 79 * hash + this.Mass;
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
        final Furniture other = (Furniture) obj;
        if (this.Price != other.Price) {
            return false;
        }
        if (this.Mass != other.Mass) {
            return false;
        }
        return true;
    }
    
    

}
