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
public abstract class Furniture implements Serializable{
        public int Price;
        public int Mass;
        
        public Furniture(int price, int mass){
            Price = price;
            Mass = mass;
        }

    @Override
    public String toString() {
        return "Furniture";
    }
        
}
