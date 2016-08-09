/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.exercise3.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public interface Op1 extends Remote{
    
    void sendWord(String word) throws RemoteException;
    
}
