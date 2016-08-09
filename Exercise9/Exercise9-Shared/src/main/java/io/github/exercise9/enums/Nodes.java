/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.exercise9.enums;

/**
 *
 * @author Victor Hugo <victor.hugo.origins@gmail.com>
 */
public enum Nodes {
    
    NODE1("4889/Node1Service");
    
    String registryName;
    
    Nodes(String rName){
        
        registryName = rName;
    }

    public String getRegistryName() {
        return registryName;
    }
    
}
