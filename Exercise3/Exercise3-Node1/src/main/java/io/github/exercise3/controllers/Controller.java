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

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class Controller extends UnicastRemoteObject implements Op1, Op2 {

    public Controller() throws RemoteException {
        super();
    }

    @Override
    public long subtraction(int x, int y) {

        return x - y;
    }

    /**
     * 
     * @return The sum, or Long.MAX_VALUE if the sum fail
     */
    @Override
    public long sum(int x, int y) {

        boolean connected = false;

        while (!connected) {

            try {

                Op2 op2Supporter = (Op2) Naming.lookup("//localhost:"+Nodes.NODE3.getRegistryName());

                connected = true;

                return op2Supporter.sum(x, y);

            } catch (MalformedURLException | NotBoundException | RemoteException ex) {

                System.err.println("Tentando novamente...");
            }
        }

        return Long.MAX_VALUE;
    }

}
