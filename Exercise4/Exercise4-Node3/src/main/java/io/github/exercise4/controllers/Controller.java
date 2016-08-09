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

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class Controller extends UnicastRemoteObject implements Op1, Op2 {

    public Controller() throws RemoteException {
        super();
    }

    @Override
    public void sendWord(String word) {

        boolean connected = false;

        Op1 op1Supporter = null;

        while (!connected) {

            try {

                op1Supporter = (Op1) Naming.lookup("//localhost:" + Nodes.NODE2.getRegistryName());

                connected = true;

                op1Supporter.sendWord(word);

            } catch (MalformedURLException | NotBoundException | RemoteException ex) {

            }

        }

    }

    @Override
    public void sendNumber(int number) {

        boolean connected = false;

        Op2 op2Supporter = null;

        while (!connected) {

            try {

                op2Supporter = (Op2) Naming.lookup("//localhost:" + Nodes.NODE4.getRegistryName());

                connected = true;

                op2Supporter.sendNumber(number);

            } catch (MalformedURLException | NotBoundException | RemoteException ex) {

            }

        }

    }

}
