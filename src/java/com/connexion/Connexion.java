/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author mbock
 */
public class Connexion {
    
private static Connection conex;
    
    private String url = "jdbc:postgresql://postgresql-ismaelmbock.alwaysdata.net:5432/ismaelmbock_daoudaeclairage";
    private String user = "ismaelmbock";
    private String passwd = "Mismael10'";
   
    private Connexion() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        }
        try {
            conex = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            System.err.println("une erreur de connexion a la bd postgres : "+e.getMessage());
        }
    }

    public static Connection seconnecter() {
        if (conex == null) {
            Connexion connexion = new Connexion();
        }
        return conex;
    }

}
