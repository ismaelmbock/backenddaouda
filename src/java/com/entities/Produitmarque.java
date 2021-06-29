/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mbock
 */
@Entity
@Table(name = "produitmarque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produitmarque.findAll", query = "SELECT p FROM Produitmarque p"),
    @NamedQuery(name = "Produitmarque.findByIdproduitmarque", query = "SELECT p FROM Produitmarque p WHERE p.idproduitmarque = :idproduitmarque")})
public class Produitmarque implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproduitmarque")
    private Integer idproduitmarque;
    @JoinColumn(name = "idmarque", referencedColumnName = "idmarque")
    @ManyToOne(optional = false)
    private Marque idmarque;
    @JoinColumn(name = "idproduit", referencedColumnName = "idproduit")
    @ManyToOne(optional = false)
    private Produit idproduit;

    public Produitmarque() {
    }

    public Produitmarque(Integer idproduitmarque) {
        this.idproduitmarque = idproduitmarque;
    }

    public Integer getIdproduitmarque() {
        return idproduitmarque;
    }

    public void setIdproduitmarque(Integer idproduitmarque) {
        this.idproduitmarque = idproduitmarque;
    }

    public Marque getIdmarque() {
        return idmarque;
    }

    public void setIdmarque(Marque idmarque) {
        this.idmarque = idmarque;
    }

    public Produit getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(Produit idproduit) {
        this.idproduit = idproduit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproduitmarque != null ? idproduitmarque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produitmarque)) {
            return false;
        }
        Produitmarque other = (Produitmarque) object;
        if ((this.idproduitmarque == null && other.idproduitmarque != null) || (this.idproduitmarque != null && !this.idproduitmarque.equals(other.idproduitmarque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Produitmarque[ idproduitmarque=" + idproduitmarque + " ]";
    }
    
}
