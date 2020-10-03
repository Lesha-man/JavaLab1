/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage.Furnitures.CupBoards;

import MainPackage.Furnitures.Creater;

/**
 *
 * @author Я
 */
public class CupBoardCreater implements Creater {

    @Override
    public CupBoard Create() {
        return new CupBoard(100, 200); 
    }

}