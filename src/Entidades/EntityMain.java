/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jose
 */
public class EntityMain {
    
    private static EntityManagerFactory ent =Persistence.createEntityManagerFactory("proyectoTPS2PU");
    
    public EntityMain(){
    }
    
    public static EntityManagerFactory getInstance(){
    
    return ent;
    }
}
