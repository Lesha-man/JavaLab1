package MainPackage;

import MainPackage.Furnitures.Creater;
import MainPackage.Furnitures.CupBoards.CupBoardCreater;
import MainPackage.Furnitures.Furniture;
import MainPackage.Furnitures.Tables.TableCreater;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
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

    private static Seller seller = new FurnituresSeller();
    private static SalesRegister register = new SalesRegister();
    private static Warehouse warehouse = new Warehouse();
   
    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        while (true) {
            try{
                System.out.println(
                          "1 - Create table and send to warehouse\n"
                        + "2 - Create cupboard and send to warehouse\n"
                        + "3 - Check all count of furnitures\n"
                        + "4 - Sell all furnitures\n"
                        + "5 - Check Sales register\n"
                        + "6 - Serialization\n"
                        + "7 - Deserialization\n"
                        + "8 - Factorio start\n"
                        + "0 - Exit\n"
                );
                if (!in.hasNextInt()) {
                    continue;
                }
                switch (in.nextInt()) {
                    case 1:{
                        Creater tableCreater = new TableCreater();
                        warehouse.add(tableCreater.create());
                        break;
                    }
                    case 2: {
                        Creater cupBoardCreater = new CupBoardCreater();
                        warehouse.add(cupBoardCreater.create());
                        break;
                    }
                    case 3: {
                        if (warehouse.getFurnituresList().isEmpty()) {
                            throw new MyException();
                        }
                        System.out.println("Count: " + warehouse.getFurnituresList().size());
                        break;
                    }
                    case 4: {
                        for (Furniture furniture : warehouse.getFurnituresList()) {
                            seller.sell(warehouse, furniture, register);
                        }
                        System.out.println("Profit: " + warehouse.sellAllFur(register) + '$');
                        break;
                    }
                    case 5: {
                        int i = 0;
                        for (Furniture f : register.getFurnituresMap().keySet()) {
                            i++;
                        System.out.println("Furniture " + i + " sold to client " + register.getFurnituresMap().get(f));
                        }
                        break;
                    }
                    case 6: {
                        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("warehouse.dat"))) {
                            oos.writeObject(warehouse);
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    }
                    case 7: {
                        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("warehouse.dat"))) {
                            warehouse = ((Warehouse) ois.readObject());
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;
                    }
                    case 8: {
                        do {
                            System.out.println("Ticks count: ");
                        } while (!in.hasNextInt());
                        int ticks = in.nextInt();
                        Thread t = new Thread(() -> {
                            for (int i = 0; i < ticks ; i++) {
                                while (warehouse.getFurnituresList().isEmpty());
                                
                                System.out.println("+" + seller.sell(warehouse, warehouse.getFurnituresList().get(0), register) + "$");
                            }
                        });
                        t.start();
                        for (int i = 0; i < ticks; i++) {
                            Creater tableCreater = new TableCreater();
                            warehouse.add(tableCreater.create());
                        }
                        break;
                    }
                    case 0: {
                        return;
                    }
                    default:
                        break;
                }
            }
            catch(MyException ex){
                System.err.println(ex);
            }
        }
    }
}
