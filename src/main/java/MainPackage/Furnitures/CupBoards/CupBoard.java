/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage.Furnitures.CupBoards;

import MainPackage.Furnitures.Furniture;

/**
 *
 * @author Я
 */
public class CupBoard extends Furniture{
    
    public boolean IsDoorsClosed;
    
    
    public CupBoard(int price, int mass) {
        super(price, mass);
    }
    
    
    public boolean OpenDoors(){
        if (IsDoorsClosed) {
            IsDoorsClosed = false;
        }
        return IsDoorsClosed;
    }    
    
    public boolean CloseDoors(){
        if (!IsDoorsClosed) {
            IsDoorsClosed = true;
        }
        return !IsDoorsClosed;
    }
}
