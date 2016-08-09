/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Loader;

import io.github.exercise3.enums.Nodes;
import io.github.exercise3.interfaces.Op1;
import java.rmi.Naming;
import io.github.exercise3.interfaces.Op2;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class Loader {

    public static void executeSum(int x, int y) {

        boolean connected = false;

        Op2 op2Supporter = null;

        while (!connected) {

            try {

                op2Supporter = (Op2) Naming.lookup("//localhost:"+Nodes.NODE3.getRegistryName());

                connected = true;

            } catch (MalformedURLException | NotBoundException | RemoteException ex) {

            }

            if (op2Supporter == null) {

                try {

                    op2Supporter = (Op2) Naming.lookup("//localhost:"+Nodes.NODE1.getRegistryName());

                    connected = true;

                } catch (MalformedURLException | NotBoundException | RemoteException ex) {

                }
            }

            if (op2Supporter == null) {

                System.err.println("Tentando novamente...");
            } else {

                try {
                    System.out.println("The sum result is: " + op2Supporter.sum(x, y));
                } catch (RemoteException ex) {
                }
            }

        }

    }

    public static void executeSubtract(int x, int y) {

        boolean connected = false;

        Op1 op1Supporter = null;

        while (!connected) {

            try {

                op1Supporter = (Op1) Naming.lookup("//localhost:"+Nodes.NODE2.getRegistryName());

                connected = true;

            } catch (MalformedURLException | NotBoundException | RemoteException ex) {

            }

            if (op1Supporter == null) {

                try {

                    op1Supporter = (Op1) Naming.lookup("//localhost:"+Nodes.NODE1.getRegistryName());

                    connected = true;

                } catch (MalformedURLException | NotBoundException | RemoteException ex) {

                }
            }

            if (op1Supporter == null) {

                try {

                    op1Supporter = (Op1) Naming.lookup("//localhost:"+Nodes.NODE3.getRegistryName());

                    connected = true;

                } catch (MalformedURLException | NotBoundException | RemoteException ex) {

                }
            }

            if (op1Supporter == null) {

                System.err.println("Tentando novamente...");
            } else {

                try {
                    System.out.println("The sum result is: " + op1Supporter.subtraction(x, y));
                } catch (RemoteException ex) {
                }
            }

        }

    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Executing the 2 + 2 sum");
        executeSum(2, 2);

        System.out.println("Executing the  5 - 3 subtraction");
        executeSubtract(5, 3);
    }

}
