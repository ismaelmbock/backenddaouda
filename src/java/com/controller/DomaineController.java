/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.connexion.Connexion;
import com.entities.Categorie;
import com.entities.Domaine;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ws.rs.GET;

import javax.ws.rs.Produces;

import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;

/**
 *
 * @author mbock
 */
@Path("controllerdomaine")
public class DomaineController {

    @GET
    @Produces({"application/json"})
    @Path("/listedomaines")
    public ArrayList<Domaine> listedomaines() {
        ArrayList<Domaine> listedomaines = new ArrayList();

        String etat = "actif";

        try {
            Statement statedomaine = Connexion.seconnecter().createStatement();
            ResultSet resultstatedomaine = statedomaine.executeQuery(com.dao.Domainerequest.listedomaine(etat));

            int domaineexistant = 0;
            while (resultstatedomaine.next()) {
                domaineexistant = 1;
                Domaine domaine = new Domaine();

                domaine.setIddomaine(resultstatedomaine.getInt("iddomaine"));
                domaine.setNomdomaine(resultstatedomaine.getString("nomdomaine"));
                domaine.setDescriptiondomaine(resultstatedomaine.getString("descriptiondomaine"));
                domaine.setImagedomaine(resultstatedomaine.getString("imagedomaine"));
                domaine.setStatutdomaine(resultstatedomaine.getString("statutdomaine"));

                listedomaines.add(domaine);
            }
            if(domaineexistant == 0){
                Domaine domaine = new Domaine();
                domaine.setIddomaine(0);
                
                listedomaines.add(domaine);
            }
        } catch (SQLException e) {
            System.out.println("erreur au niveau de la requete " + e.getMessage());
        }

        return listedomaines;
    }

    @GET
    @Produces({"application/json"})
    @Path("/singledomaine")
    public Domaine singledomaine(@QueryParam("id") int id) {

        Domaine domaine = null;
        String etat = "actif";
        try {
            Statement statedomaine = Connexion.seconnecter().createStatement();
            ResultSet resultstatedomaine = statedomaine.executeQuery(com.dao.Domainerequest.singledomaine(id,etat));

            while (resultstatedomaine.next()) {
                domaine = new Domaine();

                domaine.setIddomaine(resultstatedomaine.getInt("iddomaine"));
                domaine.setNomdomaine(resultstatedomaine.getString("nomdomaine"));
                domaine.setDescriptiondomaine(resultstatedomaine.getString("descriptiondomaine"));
                domaine.setImagedomaine(resultstatedomaine.getString("imagedomaine"));
                domaine.setStatutdomaine(resultstatedomaine.getString("statutdomaine"));
            }
            if(domaine == null){
                domaine = new Domaine();
                domaine.setIddomaine(0);
            }
        } catch (SQLException e) {
            System.out.println("erreur au niveau de la requete " + e.getMessage());
        }

        return domaine;
    }
    
    @GET
    @Produces({"application/json"})
    @Path("/getcategoriesbyiddomaine")
    public ArrayList<Categorie> getcategoriesbyiddomaine(@QueryParam("iddomaine") int iddomaine){
        ArrayList<Categorie> getcategories = new ArrayList<>();
        String statut = "actif";
        int existe = 0;
        try{
            Statement statecategorie = Connexion.seconnecter().createStatement();
            ResultSet resultstatecategorie = statecategorie.executeQuery(com.dao.Domainerequest.getcategoriesbyiddomaine(statut,iddomaine));
            
            while(resultstatecategorie.next()){
                existe = 1;
                Categorie categorie = new Categorie();
                
                categorie.setIdcategorie(resultstatecategorie.getInt("idcategorie"));
                categorie.setNomcategorie(resultstatecategorie.getString("nomcategorie"));
                categorie.setDescriptioncategorie(resultstatecategorie.getString("descriptioncategorie"));
                categorie.setStatutcategorie(resultstatecategorie.getString("statutcategorie"));
                getcategories.add(categorie);
            }
            if(existe ==0){
               Categorie categorie = new Categorie();
               categorie.setIdcategorie(0);
            }
        
        }catch(SQLException e){
            System.out.println("erreur au niveau de la requete"+ e.getMessage());
        }
        return getcategories;
    }
    
    /***
     Ajout d'un domaine
     */
    @POST
    @Produces({"application/json"})
    @Path("/ajouterdomaine")
    public Domaine ajouterdomaine(Domaine domaineparam) throws SQLException {

        Domaine domaine = null;
        int iddomaine;

        Statement statedomaine = Connexion.seconnecter().createStatement();
        statedomaine.executeUpdate(com.dao.Domainerequest.ajouterdomaine(domaineparam), Statement.RETURN_GENERATED_KEYS);
        try ( ResultSet resultstatedomaine = statedomaine.getGeneratedKeys()) {
            while (resultstatedomaine.next()) {
                iddomaine = resultstatedomaine.getInt(1);
                domaine = new Domaine();
                domaine.setIddomaine(iddomaine);
            }
        } catch (SQLException e) {
            System.out.println("erreur au niveau de la requete au niveau de l'insertion du domaine" + e.getMessage());
        }

        return domaine;
    }

}
