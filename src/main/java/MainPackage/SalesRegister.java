/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import MainPackage.Furnitures.Furniture;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Я
 */
public class SalesRegister {
        private Map<Furniture, String> sales;
        
    public SalesRegister(){
        sales = new HashMap<>();
    }
    
    public Map<Furniture, String> getFurnituresMap(){
        return Collections.unmodifiableMap(sales);
    }
    public void add(Furniture furniture, String clientName){
        sales.put(furniture, clientName);
    }
}
