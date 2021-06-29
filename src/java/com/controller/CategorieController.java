/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.connexion.Connexion;
import com.entities.Categorie;
import com.entities.Domaine;
import com.models.CategorieModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author mbock
 */
@Path("controllercategorie")
public class CategorieController {

    @GET
    @Produces({"application/json"})
    @Path("/listecategories")
    public ArrayList<CategorieModel> listecategories() {

        ArrayList<CategorieModel> listecategories = new ArrayList<>();
        Categorie categorie;
        Domaine domaine;
        String statut = "actif";
        int categorieexistante = 0;

        try {
            Statement statecategorie = Connexion.seconnecter().createStatement();
            ResultSet resultstatecategorie = statecategorie.executeQuery(com.dao.Categorierequest.listecategorie(statut));

            while (resultstatecategorie.next()) {
                categorieexistante = 1;

                CategorieModel bma = new CategorieModel();

                categorie = new Categorie();
                categorie.setDescriptioncategorie(resultstatecategorie.getString("descriptioncategorie"));
                categorie.setNomcategorie(resultstatecategorie.getString("nomcategorie"));
                categorie.setIdcategorie(resultstatecategorie.getInt("idcategorie"));
                categorie.setStatutcategorie(resultstatecategorie.getString("statutcategorie"));
                bma.setCategorie(categorie);

                domaine = new Domaine();
                domaine.setIddomaine(resultstatecategorie.getInt("iddomaine"));
                domaine.setNomdomaine(resultstatecategorie.getString("nomdomaine"));
                domaine.setDescriptiondomaine(resultstatecategorie.getString("descriptiondomaine"));
                domaine.setStatutdomaine(resultstatecategorie.getString("statutdomaine"));
                domaine.setImagedomaine(resultstatecategorie.getString("imagedomaine"));
                bma.setDomaine(domaine);

                listecategories.add(bma);
            }
            if (categorieexistante == 0) {
                CategorieModel bma = new CategorieModel();
                categorie = new Categorie();
                categorie.setNomcategorie("aucune categorie existante");
                bma.setCategorie(categorie);
                listecategories.add(bma);
            }

        } catch (SQLException e) {
            System.out.println("erreur au niveau de la requete" + e.getMessage());
        }

        return listecategories;
    }

    @POST
    @Produces({"application/json"})
    @Path("/ajoutercategorie")
    public CategorieModel ajoutercategorie(CategorieModel categoriemodelparam) throws SQLException {

        CategorieModel categoriesave = new CategorieModel();
        int idcategorie = 0;

        Statement statecategoriemodel = Connexion.seconnecter().createStatement();
        statecategoriemodel.executeUpdate(com.dao.Categorierequest.ajoutercategorie(categoriemodelparam), Statement.RETURN_GENERATED_KEYS);
        try ( ResultSet resultstatecategoriemodel = statecategoriemodel.getGeneratedKeys()) {
            while (resultstatecategoriemodel.next()) {
                idcategorie = resultstatecategoriemodel.getInt(1);
                Categorie categorie = new Categorie();

                categorie.setIdcategorie(idcategorie);
                categoriesave.setCategorie(categorie);
            }
        } catch (SQLException e) {
            System.out.println("erreur au niveau de " + e.getMessage());
        }
        return categoriesave;
    }
}
