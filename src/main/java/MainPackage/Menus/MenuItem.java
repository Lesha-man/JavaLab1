/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage.Menus;

/**
 *
 * @author Я
 */
public class MenuItem {

    public String viewItem;
    public Invokable modelItem;
    
    public MenuItem(String viewItem, Invokable modelItem){
        this.modelItem = modelItem;
        this.viewItem = viewItem;
    }   
    public MenuItem(String viewItem){
        this.modelItem = () -> emptyMethod();
        this.viewItem = viewItem;
    }
    
    private void emptyMethod(){}
}

