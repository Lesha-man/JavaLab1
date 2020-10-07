package MainPackage;

import MainPackage.Furnitures.Creater;
import MainPackage.Furnitures.CupBoards.CupBoardCreater;
import MainPackage.Furnitures.Tables.TableCreater;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
                        + "4 - Sell all furnitures\n"
                        + "5 - Serialization\n"
                        + "6 - Deserialization\n"
                        + "0 - Exit"
                );
                switch (in.nextInt()) {
                    case 1:
                        Creater tableCreater = new TableCreater();
                        warehouse.add(tableCreater.Create());
                        break;
                    case 2:
                        Creater cupBoardCreater = new CupBoardCreater();
                        warehouse.add(cupBoardCreater.Create());
                        break;
                    case 3:
                        if (warehouse.getFurnituresList().isEmpty()) {
                            throw new MyException();
                        }   
                        System.out.println("Count: " + warehouse.getFurnituresList().size());
                        break;
                    case 4:
                        System.out.println("Profit: " + warehouse.sellAllFur() + '$');
                        break;
                    case 5:
                    {
                        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.dat"))) {
                            oos.writeObject(warehouse);
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    }
                    case 6: {
                        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.dat"))) {
                            warehouse = ((Warehouse) ois.readObject());
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    }
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
