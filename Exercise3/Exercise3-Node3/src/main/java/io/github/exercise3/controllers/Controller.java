/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.exercise3.controllers;

import io.github.exercise3.enums.Nodes;
import io.github.exercise3.interfaces.Op1;
import io.github.exercise3.interfaces.Op2;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class Controller extends UnicastRemoteObject implements Op2, Op1 {

    public Controller() throws RemoteException {
        super();
    }

    /**
     * 
     * @return The subtraction, or Long.MAX_VALUE if the subtraction fail
     */
    @Override
    public long subtraction(int x, int y) {

        boolean connected = false;

        Op1 op1Supporter = null;

        while (!connected) {

            try {

                op1Supporter = (Op1) Naming.lookup("//localhost:"+Nodes.NODE1.getRegistryName());

                connected = true;

            } catch (MalformedURLException | NotBoundException | RemoteException ex) {

            }

            if (op1Supporter == null) {

                try {

                    op1Supporter = (Op1) Naming.lookup("//localhost:"+Nodes.NODE2.getRegistryName());

                    connected = true;

                } catch (MalformedURLException | NotBoundException | RemoteException ex) {

                }
            }

            if (op1Supporter == null) {

                System.err.println("Tentando novamente...");
            } else {

                try {
                    return op1Supporter.subtraction(x, y);
                } catch (RemoteException ex) {
                }
            }

        }

        return Long.MAX_VALUE;
    }

    @Override
    public long sum(int x, int y) {

        return x + y;
    }

}
