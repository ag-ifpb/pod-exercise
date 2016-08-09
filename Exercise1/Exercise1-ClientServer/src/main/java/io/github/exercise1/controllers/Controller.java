/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.exercise1.controllers;

import io.github.exercise1.interfaces.Node1;
import io.github.exercise1.interfaces.Node2;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import io.github.exercise1.interfaces.ClientServer;
import java.io.Serializable;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class Controller extends UnicastRemoteObject implements ClientServer, Serializable {

    public Controller() throws RemoteException {

        super();
    }

    @Override
    public long getTotalUsers() throws RemoteException {

        Node1 node1 = null;
        Node2 node2 = null;

        while (node1 == null || node2 == null) {

            try {

                if (node1 == null) {
                    node1 = (Node1) Naming.lookup("//localhost:4889/Node1Service");
                }

                if (node2 == null) {
                    node2 = (Node2) Naming.lookup("//localhost:4889/Node2Service");
                }
                
            } catch (NotBoundException | MalformedURLException | RemoteException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return node1.getTotalUsers()+node2.getTotalUsers();
    }

}
