/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.exercise2.server;

import io.github.exercise2.controllers.Controller;
import io.github.exercise2.interfaces.ClientServer;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class Server {

    public void start() throws IOException {

        try {

            ClientServer clientServer = new Controller();

            try {
                LocateRegistry.createRegistry(4889);
            } catch (Exception ex) {
            }

            Naming.rebind("//localhost:4889/ClientServerService", clientServer);

        } catch (RemoteException | MalformedURLException ex) {
            System.err.println(ex);
        }
    }

}
