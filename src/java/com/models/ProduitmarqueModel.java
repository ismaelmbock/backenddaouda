/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import com.entities.Categorie;
import com.entities.Domaine;
import com.entities.Marque;
import com.entities.Produit;
import com.entities.Produitmarque;

/**
 *
 * @author mbock
 */
public class ProduitmarqueModel {

    private Marque marque;
    
    private Produit produit;
    
    private Produitmarque produitmarque;
    
    private Categorie categorie;
    
    private Domaine domaine;

    public Marque getMarque() {
        return marque;
    }

    public Produit getProduit() {
        return produit;
    }

    public Produitmarque getProduitmarque() {
        return produitmarque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public void setProduitmarque(Produitmarque produitmarque) {
        this.produitmarque = produitmarque;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Domaine getDomaine() {
        return domaine;
    }

    public void setDomaine(Domaine domaine) {
        this.domaine = domaine;
    }
    
}
