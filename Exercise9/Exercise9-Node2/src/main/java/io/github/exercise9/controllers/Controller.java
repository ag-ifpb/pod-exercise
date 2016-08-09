/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.exercise9.controllers;

import io.github.exercise9.enums.Nodes;
import java.io.File;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import io.github.exercise9.interfaces.Node1;
import java.io.IOException;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class Controller {

    private long lastSize;

    public Controller() {

        lastSize = getCurrentSize();
    }

    public static long getCurrentSize() {

        String path = System.getProperty("user.home") + "/archive.txt";
        
        File file = new File(path);
        
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException ex) {
            }
        }

        return file.length();
    }

    public void startListenningDisk() {

        while (true) {

            if (lastSize != getCurrentSize()) {

                notifyNode1();

                lastSize = getCurrentSize();
            }

        }

    }

    private void notifyNode1() {
        
        boolean connected = false;

        Node1 node1Supporter = null;

        while (!connected) {

            try {

                node1Supporter = (Node1) Naming.lookup("//localhost:" + Nodes.NODE1.getRegistryName());

                connected = true;

                node1Supporter.update("Someone has changed the file");

            } catch (MalformedURLException | NotBoundException | RemoteException ex) {

            }

        }
    }

}
