/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MainPackage;

import MainPackage.Furnitures.Furniture;

/**
 *
 * @author Я
 */
public class FurnituresSeller implements Seller {
    @Override
    public int sell(Warehouse warehouse, Furniture furniture, SalesRegister register) {
        warehouse.takeAway(furniture);
        register.add(furniture, "Bob");
        return furniture.Price;
    }
}
