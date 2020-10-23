/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage.Furnitures.CupBoards;

import MainPackage.Furnitures.Creater;
import MainPackage.Furnitures.Tables.TableCreater;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Я
 */
public class CupBoardCreater implements Creater {

    @Override
    public CupBoard create() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(TableCreater.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new CupBoard(100, 200);
    }

}