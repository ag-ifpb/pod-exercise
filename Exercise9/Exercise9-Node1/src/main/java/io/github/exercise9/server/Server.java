/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.exercise9.server;

import io.github.exercise9.controllers.Controller;
import io.github.exercise9.enums.Nodes;
import io.github.exercise9.interfaces.Node1;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class Server {

    public void start() {

        try {

            Node1 node1Controller = new Controller();

            try {
                LocateRegistry.createRegistry(4889);
            } catch (Exception ex) {
            }

            Naming.rebind("//localhost:"+Nodes.NODE1.getRegistryName(), node1Controller);

        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

}
