/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage.Furnitures.Tables;

import MainPackage.Furnitures.Creater;

/**
 *
 * @author Я
 */
public class TableCreater implements Creater {

    @Override
    public Table Create() {
        return new Table(10, 20); 
    }

}