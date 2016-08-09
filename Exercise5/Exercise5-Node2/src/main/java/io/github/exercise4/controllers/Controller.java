/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.exercise4.controllers;

import io.github.exercise3.enums.Nodes;
import io.github.exercise3.interfaces.Op1;
import io.github.exercise3.interfaces.Op2;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class Controller extends UnicastRemoteObject implements Op2 {

    private List<String> results;

    public Controller() throws RemoteException {

        super();
        results = new ArrayList<>();
    }

    @Override
    public void doQuery(String query) throws RemoteException {

        System.out.println("I'm doing the query: " + query);
        System.out.println("Query completed");
        results.add("Victor Hugo da Silva Ribeiro");
        
        responseQuery();
    }

    private void responseQuery() {

        boolean connected = false;

        Op1 op1Supporter = null;

        while (!connected) {

            try {

                op1Supporter = (Op1) Naming.lookup("//localhost:" + Nodes.NODE1.getRegistryName());

                connected = true;

                op1Supporter.receiveQueryResult(results);

            } catch (MalformedURLException | NotBoundException | RemoteException ex) {

            }

        }
    }

}
