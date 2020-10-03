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
    private List<Furniture> Furnitures;
        
    public Warehouse(){
        Furnitures = new ArrayList<>();
    }
    
    public List<Furniture> getFurnituresList(){
        return Collections.unmodifiableList(Furnitures);
    }
    
    public void Add(Furniture furniture){
        Furnitures.add(furniture);
    }
}
