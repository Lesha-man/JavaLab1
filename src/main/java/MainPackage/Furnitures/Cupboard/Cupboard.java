/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage.Furnitures.Cupboard;

import MainPackage.Furnitures.Furniture;

/**
 *
 * @author Я
 */
public class Cupboard extends Furniture{
    
    public boolean IsDoorsClosed;
    
    
    public Cupboard(int price, int mass) {
        super(price, mass);
    }
    
    
    public boolean openDoors(){
        if (IsDoorsClosed) {
            IsDoorsClosed = false;
        }
        return IsDoorsClosed;
    }    
    
    public boolean closeDoors(){
        if (!IsDoorsClosed) {
            IsDoorsClosed = true;
        }
        return !IsDoorsClosed;
    }
    
    @Override
    public String toString() {
        return "Cupboard"; 
    }
}
