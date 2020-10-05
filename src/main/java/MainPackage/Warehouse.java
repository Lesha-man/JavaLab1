/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import MainPackage.Furnitures.Furniture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Я
 */
public class Warehouse {
    private List<Furniture> furnitures;
        
    public Warehouse(){
        furnitures = new ArrayList<>();
    }
    
    public List<Furniture> getFurnituresList(){
        return Collections.unmodifiableList(furnitures);
    }
    
    public void Add(Furniture furniture){
        furnitures.add(furniture);
    }
}
