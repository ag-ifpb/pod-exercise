/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Loader;

import io.github.exercise4.controllers.Controller;
import java.rmi.RemoteException;


/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class Loader {
 
    public static void main(String[] args) throws RemoteException {
        
        Controller controller = new Controller();
        
        System.out.println("Sending an word...This word is 'POD'");
        controller.sendWord("POD");
        
        System.out.println("Sending an number...This number is '1994'");
        controller.sendNumber(1994);
        
    }
    
}
