/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage.Furnitures.Cupboard;

import MainPackage.Furnitures.Creater;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Я
 */
public class CupboardCreater implements Creater {

    @Override
    public Cupboard create() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(CupboardCreater.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Cupboard(100, 200);
    }

}