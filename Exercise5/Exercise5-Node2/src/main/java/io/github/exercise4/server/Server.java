/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.exercise4.server;

import io.github.exercise4.controllers.Controller;
import io.github.exercise3.enums.Nodes;
import io.github.exercise3.interfaces.Op2;
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

            Op2 node2Controller = new Controller();

            try {
                LocateRegistry.createRegistry(4889);
            } catch (Exception ex) {
            }

            Naming.rebind("//localhost:"+Nodes.NODE2.getRegistryName(), node2Controller);

        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

}
