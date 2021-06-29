/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.models.ProduitmarqueModel;

/**
 *
 * @author mbock
 */
public class Produitmarquerequest {

    public static String listeproduits(String statut) {
        String sqllisteproduits = "select p.idproduit,p.nomproduit,p.descriptionproduit,p.imageproduit,p.statutproduit,"
                + "c.idcategorie,c.nomcategorie,c.descriptioncategorie,c.statutcategorie,"
                + "m.idmarque,m.nommarque,m.imagemarque,m.paysmarque,m.statutmarque,"
                + "d.iddomaine,d.nomdomaine,d.descriptiondomaine,d.imagedomaine,d.statutdomaine,\n"
                + "pm.idproduitmarque,pm.idproduit as idproduitpm,pm.idmarque as idmarquepm\n"
                + "from produitmarque pm\n"
                + "join produit p on p.idproduit = pm.idproduit\n"
                + "join marque m on m.idmarque = pm.idmarque\n"
                + "join categorie c on c.idcategorie = p.idcategorie\n"
                + "join domaine d on d.iddomaine = c.iddomaine\n"
                + "where p.statutproduit = '"+statut+"' and m.statutmarque = '"
                + statut+"' and c.statutcategorie = '"+statut+"' and d.statutdomaine='"+statut+"'";
        
        return sqllisteproduits;
    }
    
    public static String listeproduitsbyiddomaine(String statut,int iddomaine) {
        
        String sqllisteproduitsbyiddomaine = "select p.idproduit,p.nomproduit,p.descriptionproduit,p.imageproduit,p.statutproduit,"
                + "c.idcategorie,c.nomcategorie,c.descriptioncategorie,c.statutcategorie,"
                + "m.idmarque,m.nommarque,m.imagemarque,m.paysmarque,m.statutmarque,"
                + "d.iddomaine,d.nomdomaine,d.descriptiondomaine,d.imagedomaine,d.statutdomaine,\n"
                + "pm.idproduitmarque,pm.idproduit as idproduitpm,pm.idmarque as idmarquepm\n"
                + "from produitmarque pm\n"
                + "join produit p on p.idproduit = pm.idproduit\n"
                + "join marque m on m.idmarque = pm.idmarque\n"
                + "join categorie c on c.idcategorie = p.idcategorie\n"
                + "join domaine d on d.iddomaine = c.iddomaine\n"
                + "where p.statutproduit = '"+statut+"' and m.statutmarque = '"
                + statut+"' and c.statutcategorie = '"+statut+"' and d.statutdomaine='"+statut+"'"
                + " and d.iddomaine="+iddomaine;
        
        return sqllisteproduitsbyiddomaine;
    }
    
    public static String listeproduitsbynomdomaine(String statut,String nomdomaine) {
        
        String sqllisteproduitsbynomdomaine = "select p.idproduit,p.nomproduit,p.descriptionproduit,p.imageproduit,p.statutproduit,"
                + "c.idcategorie,c.nomcategorie,c.descriptioncategorie,c.statutcategorie,"
                + "m.idmarque,m.nommarque,m.imagemarque,m.paysmarque,m.statutmarque,"
                + "d.iddomaine,d.nomdomaine,d.descriptiondomaine,d.imagedomaine,d.statutdomaine,\n"
                + "pm.idproduitmarque,pm.idproduit as idproduitpm,pm.idmarque as idmarquepm\n"
                + "from produitmarque pm\n"
                + "join produit p on p.idproduit = pm.idproduit\n"
                + "join marque m on m.idmarque = pm.idmarque\n"
                + "join categorie c on c.idcategorie = p.idcategorie\n"
                + "join domaine d on d.iddomaine = c.iddomaine\n"
                + "where p.statutproduit = '"+statut+"' and m.statutmarque = '"
                + statut+"' and c.statutcategorie = '"+statut+"' and d.statutdomaine='"+statut+"'"
                + " and d.nomdomaine='"+nomdomaine+"'";
        
        return sqllisteproduitsbynomdomaine;
    }
    
    public static String listeproduitsbyidcategorie(String statut,int idcategorie) {
        String sqlsqllisteproduitsbyidcategorie = "select p.idproduit,p.nomproduit,p.descriptionproduit,p.imageproduit,p.statutproduit,"
                + "c.idcategorie,c.nomcategorie,c.descriptioncategorie,c.statutcategorie,"
                + "m.idmarque,m.nommarque,m.imagemarque,m.paysmarque,m.statutmarque,"
                + "d.iddomaine,d.nomdomaine,d.descriptiondomaine,d.imagedomaine,d.statutdomaine,\n"
                + "pm.idproduitmarque,pm.idproduit as idproduitpm,pm.idmarque as idmarquepm\n"
                + "from produitmarque pm\n"
                + "join produit p on p.idproduit = pm.idproduit\n"
                + "join marque m on m.idmarque = pm.idmarque\n"
                + "join categorie c on c.idcategorie = p.idcategorie\n"
                + "join domaine d on d.iddomaine = c.iddomaine\n"
                + "where p.statutproduit = '"+statut+"' and m.statutmarque = '"
                + statut+"' and c.statutcategorie = '"+statut+"' and d.statutdomaine='"+statut+"'"
                + " and c.idcategorie="+idcategorie;
        
        return sqlsqllisteproduitsbyidcategorie;
    }

    public static String ajouterproduit(ProduitmarqueModel produitmarquemodel) {
        String sqlajouterproduit = "insert into produit(nomproduit,descriptionproduit,imageproduit,"
                + "statutproduit,idcategorie)"
                + " values('"+produitmarquemodel.getProduit().getNomproduit()+"','"
                + produitmarquemodel.getProduit().getDescriptionproduit()+"','"
                + produitmarquemodel.getProduit().getImageproduit()+"','actif',"
                + produitmarquemodel.getCategorie().getIdcategorie()+")";
        
        return sqlajouterproduit;
    }

    public static String ajoutermarqueproduit(ProduitmarqueModel produitmarquemodel,int idproduit) {
        String sqlajoutermarqueproduit = "insert into produitmarque (idproduit,idmarque) "
                + "values("+idproduit+","+produitmarquemodel.getMarque().getIdmarque()+")";
        
        return sqlajoutermarqueproduit;
    }
    
}
