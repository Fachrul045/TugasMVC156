/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author ACER
 */
public class Main {
    public static void main(String[] args) {
        AdminView view = new AdminView ();
        ModelAdmin model = new ModelAdmin();
        new ControllerAdmin(view,model);
    }
}
