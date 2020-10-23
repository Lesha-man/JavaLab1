/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage.Furnitures.Tables;

import MainPackage.Furnitures.Creater;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Я
 */
public class TableCreater implements Creater {

    @Override
    public Table create() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(TableCreater.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Table(15, 20);
    }
}