/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.models.CategorieModel;

/**
 *
 * @author mbock
 */
public class Categorierequest {
    
    
    public static String listecategorie(String statut){
        
        String sqllistecategorie = "select c.idcategorie,c.nomcategorie,c.descriptioncategorie,c.statutcategorie, \n"
                + "d.iddomaine,d.nomdomaine,d.descriptiondomaine,d.imagedomaine,d.statutdomaine\n"
                + "from categorie c\n"
                + "join domaine d on c.iddomaine=d.iddomaine\n"
                + "where c.statutcategorie = '"+ statut +"' and d.statutdomaine='"+ statut +"'";
        
        return sqllistecategorie;
    }
    
    public static String ajoutercategorie(CategorieModel categoriemodel){
        
        String sqlajoutercategorie = "insert into categorie(nomcategorie,descriptioncategorie,iddomaine,statutcategorie) "
                + "values('"+categoriemodel.getCategorie().getNomcategorie()+"','"
                + categoriemodel.getCategorie().getDescriptioncategorie()+"',"
                + categoriemodel.getDomaine().getIddomaine()+","
                + "'actif')";
        
        return sqlajoutercategorie;
    }
}
