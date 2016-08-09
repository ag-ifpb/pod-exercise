/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.exercise5.controllers;

import io.github.exercise3.enums.Nodes;
import io.github.exercise3.interfaces.Op1;
import io.github.exercise3.interfaces.Op2;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class Controller extends UnicastRemoteObject implements Op1 {

    public Controller() throws RemoteException {
        super();
    }

    @Override
    public void receiveQueryResult(List<String> results) throws RemoteException {

        System.out.println("I received my results: " + results);
        System.out.println("Now I'll store them.");
    }

    public void requestQuery(String query) {

        boolean connected = false;

        Op2 op2Supporter = null;

        while (!connected) {

            try {

                op2Supporter = (Op2) Naming.lookup("//localhost:" + Nodes.NODE2.getRegistryName());

                connected = true;

                op2Supporter.doQuery(query);

            } catch (MalformedURLException | NotBoundException | RemoteException ex) {

            }

        }
    }

}
