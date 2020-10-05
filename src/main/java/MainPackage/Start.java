package MainPackage;

import MainPackage.Furnitures.Creater;
import MainPackage.Furnitures.CupBoards.CupBoardCreater;
import MainPackage.Furnitures.Tables.TableCreater;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alesh
 */
//import javassist.ClassPool;
public class Start {

    public static void main(String args[]) {
        Warehouse warehouse = new Warehouse();
        Scanner in = new Scanner(System.in);
        while (true) {
            try{
                
                System.out.println(
                        "1 - Create table and send to warehouse\n"
                        + "2 - Create cupboard and send to warehouse\n"
                        + "3 - Check all count of furnitures\n"
                        + "0 - Exit"
                );
                switch (in.nextInt()) {
                    case 1:
                        Creater tableCreater = new TableCreater();
                        warehouse.Add(tableCreater.Create());
                        break;
                    case 2:
                        Creater cupBoardCreater = new CupBoardCreater();
                        warehouse.Add(cupBoardCreater.Create());
                        break;
                    case 3:
                        if (warehouse.getFurnituresList().isEmpty()) {
                            throw new MyException();
                        }
                        System.out.println("Count: " + warehouse.getFurnituresList().size());
                        break;
                    default:
                        return;
                }
            }
            catch(MyException ex){
                System.err.println(ex);
            }
        }
    }
}
