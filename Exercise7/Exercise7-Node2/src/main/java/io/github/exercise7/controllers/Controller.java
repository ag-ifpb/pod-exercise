/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.exercise7.controllers;

import io.github.exercise7.interfaces.Node2;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public class Controller extends UnicastRemoteObject implements Node2, Serializable {

    private static boolean isUpdating = false;
    
    public Controller() throws RemoteException {
        super();
    }

    @Override
    public void saveData(byte[] bytes) throws RemoteException {

        while(isUpdating){}
        
        isUpdating = true;
        
        Connection connection = null;
        PreparedStatement ps = null;

        try {

            connection = getMysqlConnection();

            ps = connection.prepareCall("INSERT INTO datas VALUES(?)");
            ps.setBytes(1, bytes);

            ps.executeUpdate();

            try {
                ps.close();
                connection.close();
            } catch (SQLException ex1) {
            }

            connection = getPostgreConnection();
            ps = connection.prepareCall("INSERT INTO datas VALUES(?)");
            ps.setBytes(1, bytes);

            ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex2) {
            ex2.printStackTrace();
        }

        try {

            ps.close();
            connection.close();
        } catch (SQLException | NullPointerException ex3) {
            ex3.printStackTrace();
        }
        
        isUpdating = false; 

    }

    private Connection getMysqlConnection() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/pod", "root", "victor");
    }

    private Connection getPostgreConnection() throws SQLException, ClassNotFoundException {

        Class.forName("org.postgresql.Driver");

        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/pod", "postgres", "123456");
    }

}
