/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage.Menus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Я
 */
public class Menu {
    private List<MenuItem> items;
        
    public Menu(MenuItem... menuItems){
        items = new ArrayList<>();
        items.add(new MenuItem(""));
        items.addAll(Arrays.asList(menuItems));
    }
    
    public void add(MenuItem... menuItems){
        items.addAll(Arrays.asList(menuItems));
    }
    
    public void setZeroItem(MenuItem zeroItem){
        items.set(0, zeroItem);
    }
    
    public int call(){
        try {
            for (int i = 1; i < items.size(); i++) {
                System.out.println(i + " - " + items.get(i).viewItem);
            }
            if (items.get(0).viewItem != "" && items.get(0).viewItem != null) {
                System.out.println("0 - " + items.get(0).viewItem);
            }
            Scanner in = new Scanner(System.in);
            while (!in.hasNextInt()){
                in.next();
            }
            int n = in.nextInt();
            items.get(n).modelItem.invoke();
            return n;
        } catch (Exception e) {
            System.err.println(e);
        }
        return -1;
    }
}

