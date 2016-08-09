/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.exercise3.controllers;

import io.github.exercise3.interfaces.Op1;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class Controller extends UnicastRemoteObject implements Op1 {

    public Controller() throws RemoteException {
        super();
    }

    @Override
    public long subtraction(int x, int y) {

        return x - y;
    }

}
