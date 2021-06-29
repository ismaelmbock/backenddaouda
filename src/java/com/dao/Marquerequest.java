/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entities.Marque;

/**
 *
 * @author mbock
 */
public class Marquerequest {

    public static String listemarques(String statut) {
        
        String sqllistemarques = "select * from marque where statutmarque = '"+statut+"'";
        
        return sqllistemarques;
    }

    public static String singlemarque(String statut, int idmarque) {
        
        String sqlsinglemarque = "select * from marque where statutmarque = '"+statut+"' and idmarque = "+ idmarque;
        
        return sqlsinglemarque;
    }

    public static String ajoutermarque(Marque marqueparam) {
        String statut ="actif";
    
        String sqlajoutermarque = "insert into marque(nommarque,imagemarque,paysmarque,statutmarque) "
                + "values('"+marqueparam.getNommarque()+"','"
                + marqueparam.getImagemarque()+"','"
                + marqueparam.getPaysmarque()+"','"
                + statut+"')";
        
        return sqlajoutermarque;
    }
    
}
