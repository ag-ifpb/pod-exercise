/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Loader;

import io.github.exercise7.interfaces.Node2;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class Loader {

    public static void main(String[] args) throws InterruptedException {

        boolean connected = false;
        
        Node2 node2Supporter = null;

        while (!connected) {

            try {

                node2Supporter = (Node2) Naming.lookup("//localhost:4889/Node2Service");

                connected = true;

                node2Supporter.saveData("oi".getBytes());
                
            } catch (MalformedURLException | NotBoundException | RemoteException ex) {

            }

        }
    }

}
