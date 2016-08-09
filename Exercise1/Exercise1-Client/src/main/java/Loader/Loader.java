/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Loader;

import java.rmi.Naming;
import io.github.exercise1.interfaces.ClientServer;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class Loader {

    public static void main(String[] args) throws InterruptedException {

        long total = -1;

        while (total == -1) {
            
            try {

                ClientServer clientServer = (ClientServer) Naming.lookup("//localhost:4889/ClientServerService");

                total = clientServer.getTotalUsers();

                System.out.println("O total de usuario dos dois sistemas são: "+ total);

            } catch (MalformedURLException | NotBoundException | RemoteException ex) {
                
                System.err.println("Tentando de novo em 1 segundo...");
                Thread.sleep(1000);
            }
            
        }

    }

}
