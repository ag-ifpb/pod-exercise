/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.exercise9.controllers;

import java.rmi.RemoteException;
import io.github.exercise9.interfaces.Node1;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class Controller extends UnicastRemoteObject implements Node1 {

    public Controller() throws RemoteException {
        
        super();
    }
    
    @Override
    public void update(String message) throws RemoteException {
        
        System.out.println("I received an update, lets see: " + message);
    }


}
