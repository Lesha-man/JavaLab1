package MainPackage.Furnitures.Tables;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import MainPackage.Furnitures.Furniture;

/**
 *
 * @author Я
 */
public class Table extends Furniture{

    public Table(int price, int mass) {
        super(price, mass);
    }
    
    
    public boolean standStill(){
        return true;
    }
    
    @Override
    public String toString() {
        return "Table";
    }

    @Override
    public String info() {
        return "Table info"; 
    }
}
