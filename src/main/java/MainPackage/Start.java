package MainPackage;

import MainPackage.Furnitures.Creater;
import MainPackage.Furnitures.Cupboard.CupboardCreater;
import MainPackage.Furnitures.Furniture;
import MainPackage.Furnitures.Tables.TableCreater;
import MainPackage.Menus.Menu;
import MainPackage.Menus.MenuItem;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;


public class Start {

    private static Seller seller = new FurnituresSeller();
    private static SalesRegister register = new SalesRegister();
    private static Warehouse warehouse = new Warehouse();

    public static void main(String args[]) {
        Menu menu = new Menu(
            new MenuItem("Create table and send to warehouse", () -> tableCreate()),
            new MenuItem("Create cupboard and send to warehouse", () -> cupboardCreate()),
            new MenuItem("Check all count of furnitures", () -> count()),
            new MenuItem("Sell all furnitures", () -> sellAll()),
            new MenuItem("Check Sales register", () -> checkRegister()),
            new MenuItem("Serialization", () -> serialize()),
            new MenuItem("Deserialization", () -> deserialize()),
            new MenuItem("Factorio start", () -> factorioStart())
        );
        menu.setZeroItem(new MenuItem("Exit"));
        while (menu.call() != 0) ;
    }

    private static void tableCreate() {
        System.out.println("Creation...");
        Creater tableCreater = new TableCreater();
        warehouse.add(tableCreater.create());
        System.out.println("Done!");
    }

    private static void cupboardCreate() {
        System.out.println("Creation...");
        Creater cupBoardCreater = new CupboardCreater();
        warehouse.add(cupBoardCreater.create());
        System.out.println("Done!");
    }

    private static void count() {
        try {
            if (warehouse.getFurnituresList().isEmpty()) {
                throw new MyException();
            }
            System.out.println("Count: " + warehouse.getFurnituresList().size());
        } catch (MyException ex) {
            System.err.println(ex);
        }
    }

    private static void sellAll() {
        int profit = 0;
        int size = warehouse.getFurnituresList().size();
        for (int i = 0; i < size; i++) {
            profit += seller.sell(warehouse, warehouse.getFurnituresList().get(0), register);
        }
        System.out.println("Profit: " + profit + '$');
    }

    private static void checkRegister() {
        int i = 0;
        for (Furniture furniture : register.getFurnituresMap().keySet()) {
            i++;
            System.out.println(furniture.toString() + " sold to client " + register.getFurnituresMap().get(furniture));
        }
    }

    private static void serialize() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("warehouse.dat"))) {
            oos.writeObject(warehouse);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void deserialize() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("warehouse.dat"))) {
            warehouse = ((Warehouse) ois.readObject());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void factorioStart() {
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Ticks count: ");
        } while (!in.hasNextInt());
        int ticks = in.nextInt();
        Thread t = new Thread(() -> {
            for (int i = 0; i < ticks; i++) {
                while (warehouse.getFurnituresList().isEmpty()) ;
                System.out.println("+" + seller.sell(warehouse, warehouse.getFurnituresList().get(0), register) + "$");
            }
        });
        t.start();
        for (int i = 0; i < ticks; i++) {
            Creater tableCreater = new TableCreater();
            warehouse.add(tableCreater.create());
        }
    }
}
