/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.connexion.Connexion;
import com.entities.Categorie;
import com.entities.Domaine;
import com.entities.Marque;
import com.entities.Produit;
import com.entities.Produitmarque;
import com.models.ProduitmarqueModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author mbock
 */
@Path("produitmarquecontroller")
public class ProduitmarqueController {

    @GET
    @Produces({"application/json"})
    @Path("/listeproduits")
    public ArrayList<ProduitmarqueModel> listeproduits() {

        ArrayList<ProduitmarqueModel> listeproduits = new ArrayList<>();

        String statut = "actif";

        Categorie categorie;
        Produit produit;
        Marque marque;
        Produitmarque produitmarque;
        Domaine domaine;

        try {
            Statement stateproduit = Connexion.seconnecter().createStatement();
            ResultSet resultstateproduit = stateproduit.executeQuery(com.dao.Produitmarquerequest.listeproduits(statut));

            while (resultstateproduit.next()) {
                ProduitmarqueModel bma = new ProduitmarqueModel();

                categorie = new Categorie();
                categorie.setIdcategorie(resultstateproduit.getInt("idcategorie"));
                categorie.setNomcategorie(resultstateproduit.getString("nomcategorie"));
                categorie.setDescriptioncategorie(resultstateproduit.getString("descriptioncategorie"));
                categorie.setStatutcategorie(resultstateproduit.getString("statutcategorie"));
                bma.setCategorie(categorie);

                produit = new Produit();
                produit.setIdproduit(resultstateproduit.getInt("idproduit"));
                produit.setNomproduit(resultstateproduit.getString("nomproduit"));
                produit.setDescriptionproduit(resultstateproduit.getString("descriptionproduit"));
                produit.setImageproduit(resultstateproduit.getString("imageproduit"));
                produit.setStatutproduit(resultstateproduit.getString("statutcategorie"));
                bma.setProduit(produit);

                marque = new Marque();
                marque.setIdmarque(resultstateproduit.getInt("idmarque"));
                marque.setNommarque(resultstateproduit.getString("nommarque"));
                marque.setImagemarque(resultstateproduit.getString("imagemarque"));
                marque.setPaysmarque(resultstateproduit.getString("paysmarque"));
                marque.setStatutmarque(resultstateproduit.getString("statutmarque"));
                bma.setMarque(marque);

                produitmarque = new Produitmarque();
                produitmarque.setIdproduitmarque(resultstateproduit.getInt("idproduitmarque"));
                bma.setProduitmarque(produitmarque);

                domaine = new Domaine();
                domaine.setIddomaine(resultstateproduit.getInt("iddomaine"));
                domaine.setNomdomaine(resultstateproduit.getString("nomdomaine"));
                domaine.setDescriptiondomaine(resultstateproduit.getString("descriptiondomaine"));
                domaine.setImagedomaine(resultstateproduit.getString("imagedomaine"));
                domaine.setStatutdomaine(resultstateproduit.getString("statutdomaine"));
                bma.setDomaine(domaine);

                listeproduits.add(bma);
            }
        } catch (SQLException e) {
            System.out.println("erreur au niveau de " + e.getMessage());
        }

        return listeproduits;
    }

    @GET
    @Produces({"application/json"})
    @Path("/listeproduitsbyiddomaine")
    public ArrayList<ProduitmarqueModel> listeproduitsbyiddomaine(@QueryParam("iddomaine") int iddomaine) {

        ArrayList<ProduitmarqueModel> listeproduits = new ArrayList<>();

        int existe = 0;
        String statut = "actif";

        Categorie categorie;
        Produit produit;
        Marque marque;
        Produitmarque produitmarque;
        Domaine domaine;

        try {
            Statement stateproduit = Connexion.seconnecter().createStatement();
            ResultSet resultstateproduit = stateproduit.executeQuery(com.dao.Produitmarquerequest.listeproduitsbyiddomaine(statut, iddomaine));

            while (resultstateproduit.next()) {
                existe = 1;
                ProduitmarqueModel bma = new ProduitmarqueModel();

                categorie = new Categorie();
                categorie.setIdcategorie(resultstateproduit.getInt("idcategorie"));
                categorie.setNomcategorie(resultstateproduit.getString("nomcategorie"));
                categorie.setDescriptioncategorie(resultstateproduit.getString("descriptioncategorie"));
                categorie.setStatutcategorie(resultstateproduit.getString("statutcategorie"));
                bma.setCategorie(categorie);

                produit = new Produit();
                produit.setIdproduit(resultstateproduit.getInt("idproduit"));
                produit.setNomproduit(resultstateproduit.getString("nomproduit"));
                produit.setDescriptionproduit(resultstateproduit.getString("descriptionproduit"));
                produit.setImageproduit(resultstateproduit.getString("imageproduit"));
                produit.setStatutproduit(resultstateproduit.getString("statutcategorie"));
                bma.setProduit(produit);

                marque = new Marque();
                marque.setIdmarque(resultstateproduit.getInt("idmarque"));
                marque.setNommarque(resultstateproduit.getString("nommarque"));
                marque.setImagemarque(resultstateproduit.getString("imagemarque"));
                marque.setPaysmarque(resultstateproduit.getString("paysmarque"));
                marque.setStatutmarque(resultstateproduit.getString("statutmarque"));
                bma.setMarque(marque);

                produitmarque = new Produitmarque();
                produitmarque.setIdproduitmarque(resultstateproduit.getInt("idproduitmarque"));
                bma.setProduitmarque(produitmarque);

                domaine = new Domaine();
                domaine.setIddomaine(resultstateproduit.getInt("iddomaine"));
                domaine.setNomdomaine(resultstateproduit.getString("nomdomaine"));
                domaine.setDescriptiondomaine(resultstateproduit.getString("descriptiondomaine"));
                domaine.setImagedomaine(resultstateproduit.getString("imagedomaine"));
                domaine.setStatutdomaine(resultstateproduit.getString("statutdomaine"));
                bma.setDomaine(domaine);

                listeproduits.add(bma);
            }
        } catch (SQLException e) {
            System.out.println("erreur au niveau de " + e.getMessage());
        }

        return listeproduits;
    }

    @GET
    @Produces({"application/json"})
    @Path("/listeproduitsbyidcategorie")
    public ArrayList<ProduitmarqueModel> listeproduitsbyidcategorie(@QueryParam("idcategorie") int idcategorie) {

        ArrayList<ProduitmarqueModel> listeproduits = new ArrayList<>();

        int existe = 0;
        String statut = "actif";

        Categorie categorie;
        Produit produit;
        Marque marque;
        Produitmarque produitmarque;
        Domaine domaine;

        try {
            Statement stateproduit = Connexion.seconnecter().createStatement();
            ResultSet resultstateproduit = stateproduit.executeQuery(com.dao.Produitmarquerequest.listeproduitsbyidcategorie(statut, idcategorie));

            while (resultstateproduit.next()) {
                existe = 1;
                ProduitmarqueModel bma = new ProduitmarqueModel();

                categorie = new Categorie();
                categorie.setIdcategorie(resultstateproduit.getInt("idcategorie"));
                categorie.setNomcategorie(resultstateproduit.getString("nomcategorie"));
                categorie.setDescriptioncategorie(resultstateproduit.getString("descriptioncategorie"));
                categorie.setStatutcategorie(resultstateproduit.getString("statutcategorie"));
                bma.setCategorie(categorie);

                produit = new Produit();
                produit.setIdproduit(resultstateproduit.getInt("idproduit"));
                produit.setNomproduit(resultstateproduit.getString("nomproduit"));
                produit.setDescriptionproduit(resultstateproduit.getString("descriptionproduit"));
                produit.setImageproduit(resultstateproduit.getString("imageproduit"));
                produit.setStatutproduit(resultstateproduit.getString("statutcategorie"));
                bma.setProduit(produit);

                marque = new Marque();
                marque.setIdmarque(resultstateproduit.getInt("idmarque"));
                marque.setNommarque(resultstateproduit.getString("nommarque"));
                marque.setImagemarque(resultstateproduit.getString("imagemarque"));
                marque.setPaysmarque(resultstateproduit.getString("paysmarque"));
                marque.setStatutmarque(resultstateproduit.getString("statutmarque"));
                bma.setMarque(marque);

                produitmarque = new Produitmarque();
                produitmarque.setIdproduitmarque(resultstateproduit.getInt("idproduitmarque"));
                bma.setProduitmarque(produitmarque);

                domaine = new Domaine();
                domaine.setIddomaine(resultstateproduit.getInt("iddomaine"));
                domaine.setNomdomaine(resultstateproduit.getString("nomdomaine"));
                domaine.setDescriptiondomaine(resultstateproduit.getString("descriptiondomaine"));
                domaine.setImagedomaine(resultstateproduit.getString("imagedomaine"));
                domaine.setStatutdomaine(resultstateproduit.getString("statutdomaine"));
                bma.setDomaine(domaine);

                listeproduits.add(bma);
            }
            if (existe == 0) {
                produit = new Produit();
                produit.setIdproduit(0);
                ProduitmarqueModel bma = new ProduitmarqueModel();
                bma.setProduit(produit);
                listeproduits.add(bma);
            }
        } catch (SQLException e) {
            System.out.println("erreur au niveau de " + e.getMessage());
        }

        return listeproduits;
    }

    @POST
    @Produces({"application/json"})
    @Path("/ajouterproduit")
    public ProduitmarqueModel ajouterproduit(ProduitmarqueModel produitmarqueModelParam) throws SQLException {

        ProduitmarqueModel produitmarquemodel = new ProduitmarqueModel();
        int idproduit = 0;

        Statement stateproduit = Connexion.seconnecter().createStatement();
        stateproduit.executeUpdate(com.dao.Produitmarquerequest.ajouterproduit(produitmarqueModelParam), Statement.RETURN_GENERATED_KEYS);
        try ( ResultSet resultstateproduit = stateproduit.getGeneratedKeys()) {
            while (resultstateproduit.next()) {
                idproduit = resultstateproduit.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("erreur au niveau de la requete " + e.getMessage());
        }
        Statement stateproduitmarque = Connexion.seconnecter().createStatement();
        stateproduitmarque.executeUpdate(com.dao.Produitmarquerequest.ajoutermarqueproduit(produitmarqueModelParam, idproduit), Statement.RETURN_GENERATED_KEYS);
        try ( ResultSet resultstateproduitmarque = stateproduitmarque.getGeneratedKeys()) {
            while (resultstateproduitmarque.next()) {
                int idproduitmarque = 0;
                idproduitmarque = resultstateproduitmarque.getInt(1);
                Produitmarque produitmarque = new Produitmarque();
                produitmarque.setIdproduitmarque(idproduitmarque);

                produitmarquemodel.setProduitmarque(produitmarque);
            }
        } catch (SQLException e) {
            System.out.println("erreur au niveau de la requete d'ajout marque produit" + e.getMessage());
        }
        return produitmarquemodel;
    }

    @GET
    @Produces({"application/json"})
    @Path("/listeproduitsbynomdomaine")
    public ArrayList<ProduitmarqueModel> listeproduitsbynomdomaine(@QueryParam("nomdomaine") String nomdomaine) {

        ArrayList<ProduitmarqueModel> listeproduits = new ArrayList<>();

        int existe = 0;
        String statut = "actif";

        Categorie categorie;
        Produit produit;
        Marque marque;
        Produitmarque produitmarque;
        Domaine domaine;

        try {
            Statement stateproduit = Connexion.seconnecter().createStatement();
            ResultSet resultstateproduit = stateproduit.executeQuery(com.dao.Produitmarquerequest.listeproduitsbynomdomaine(statut, nomdomaine));

            while (resultstateproduit.next()) {
                existe = 1;
                ProduitmarqueModel bma = new ProduitmarqueModel();

                categorie = new Categorie();
                categorie.setIdcategorie(resultstateproduit.getInt("idcategorie"));
                categorie.setNomcategorie(resultstateproduit.getString("nomcategorie"));
                categorie.setDescriptioncategorie(resultstateproduit.getString("descriptioncategorie"));
                categorie.setStatutcategorie(resultstateproduit.getString("statutcategorie"));
                bma.setCategorie(categorie);

                produit = new Produit();
                produit.setIdproduit(resultstateproduit.getInt("idproduit"));
                produit.setNomproduit(resultstateproduit.getString("nomproduit"));
                produit.setDescriptionproduit(resultstateproduit.getString("descriptionproduit"));
                produit.setImageproduit(resultstateproduit.getString("imageproduit"));
                produit.setStatutproduit(resultstateproduit.getString("statutcategorie"));
                bma.setProduit(produit);

                marque = new Marque();
                marque.setIdmarque(resultstateproduit.getInt("idmarque"));
                marque.setNommarque(resultstateproduit.getString("nommarque"));
                marque.setImagemarque(resultstateproduit.getString("imagemarque"));
                marque.setPaysmarque(resultstateproduit.getString("paysmarque"));
                marque.setStatutmarque(resultstateproduit.getString("statutmarque"));
                bma.setMarque(marque);

                produitmarque = new Produitmarque();
                produitmarque.setIdproduitmarque(resultstateproduit.getInt("idproduitmarque"));
                bma.setProduitmarque(produitmarque);

                domaine = new Domaine();
                domaine.setIddomaine(resultstateproduit.getInt("iddomaine"));
                domaine.setNomdomaine(resultstateproduit.getString("nomdomaine"));
                domaine.setDescriptiondomaine(resultstateproduit.getString("descriptiondomaine"));
                domaine.setImagedomaine(resultstateproduit.getString("imagedomaine"));
                domaine.setStatutdomaine(resultstateproduit.getString("statutdomaine"));
                bma.setDomaine(domaine);

                listeproduits.add(bma);
            }
        } catch (SQLException e) {
            System.out.println("erreur au niveau de " + e.getMessage());
        }

        return listeproduits;
    }
}
