/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.exercise4.controllers;

import io.github.exercise3.interfaces.Op1;
import io.github.exercise3.interfaces.Op2;
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
         
        System.out.println("My mobile device as received an word... this word is "+ word);
    }

    @Override
    public void sendNumber(int number) {
        
        System.out.println("My mobile device as received an number... this number is "+ number);
    }

}
