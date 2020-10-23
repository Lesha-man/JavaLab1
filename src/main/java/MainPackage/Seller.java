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
public interface Seller {
    public int sell(Warehouse warehouse, Furniture furniture, SalesRegister register);
}
