/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Loader;

import io.github.exercise5.controllers.Controller;
import io.github.exercise5.server.Server;
import java.rmi.RemoteException;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class Loader {

    public static void main(String[] args) throws InterruptedException, RemoteException {
        
        Server server = new Server();
        server.start();
        
        Controller controller = new Controller();
        
        controller.requestQuery("All my users with age > 10 years old");
        
    }

}
