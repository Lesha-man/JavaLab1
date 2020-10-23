/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import MainPackage.Furnitures.Furniture;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Я
 */
public class Warehouse implements Serializable {
    private List<Furniture> furnitures;
        
    public Warehouse(){
        furnitures = new ArrayList<>();
    }
    
    public List<Furniture> getFurnituresList(){
        return Collections.unmodifiableList(furnitures);
    }
    
    public void add(Furniture furniture){
        furnitures.add(furniture);
    }    
    
    public Furniture takeAway(Furniture furniture){
        if (furnitures.contains(furniture)) {
            furnitures.remove(furniture);
            return furniture;
        }
        return null;
    }
    public Furniture takeAway(int index){
        if (furnitures.size() > index) {
            Furniture temp = furnitures.get(index);
            furnitures.remove(index);
            return temp;
        }
        return null;
    }
}
