/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entities.Domaine;

/**
 *
 * @author mbock
 */
public class Domainerequest {

    public static String listedomaine(String etat) {
        String sqllistedomaine = " select * from domaine\n"
                + "where statutdomaine = '" + etat + "'";

        return sqllistedomaine;
    }

    public static String singledomaine(int id, String etat) {
        String sqlsingledomaine = "select * from domaine\n"
                + "where statutdomaine = '" + etat + "' and iddomaine = " + id;
        return sqlsingledomaine;
    }

    public static String ajouterdomaine(Domaine domaineparam) {
        String sqlajouterdomaine = "insert into domaine(nomdomaine,descriptiondomaine,imagedomaine,statutdomaine)\n"
                + "values('" + domaineparam.getNomdomaine() + "','" 
                + domaineparam.getDescriptiondomaine() + "','"
                + domaineparam.getImagedomaine() + "','actif')";
        return sqlajouterdomaine;

    }

    public static String getcategoriesbyiddomaine(String statut, int id) {
        String sqlgetcategoriesbyiddomaine = "select c.idcategorie,c.nomcategorie,c.descriptioncategorie,\n"
                + "c.statutcategorie from categorie c\n"
                + "join domaine d on c.iddomaine = d.iddomaine\n"
                + "where c.statutcategorie = '" + statut+ "' and d.statutdomaine = '"+ statut + "' and \n"
                + "d.iddomaine="+id ;
        
        return sqlgetcategoriesbyiddomaine;
    }

}
