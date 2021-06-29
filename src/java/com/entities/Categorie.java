/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mbock
 */
@Entity
@Table(name = "categorie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categorie.findAll", query = "SELECT c FROM Categorie c"),
    @NamedQuery(name = "Categorie.findByIdcategorie", query = "SELECT c FROM Categorie c WHERE c.idcategorie = :idcategorie"),
    @NamedQuery(name = "Categorie.findByNomcategorie", query = "SELECT c FROM Categorie c WHERE c.nomcategorie = :nomcategorie"),
    @NamedQuery(name = "Categorie.findByDescriptioncategorie", query = "SELECT c FROM Categorie c WHERE c.descriptioncategorie = :descriptioncategorie"),
    @NamedQuery(name = "Categorie.findByStatutcategorie", query = "SELECT c FROM Categorie c WHERE c.statutcategorie = :statutcategorie")})
public class Categorie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcategorie")
    private Integer idcategorie;
    @Size(max = 254)
    @Column(name = "nomcategorie")
    private String nomcategorie;
    @Size(max = 254)
    @Column(name = "descriptioncategorie")
    private String descriptioncategorie;
    @Size(max = 254)
    @Column(name = "statutcategorie")
    private String statutcategorie;
    @JoinColumn(name = "iddomaine", referencedColumnName = "iddomaine")
    @ManyToOne(optional = false)
    private Domaine iddomaine;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcategorie")
    private Collection<Produit> produitCollection;

    public Categorie() {
    }

    public Categorie(Integer idcategorie) {
        this.idcategorie = idcategorie;
    }

    public Integer getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(Integer idcategorie) {
        this.idcategorie = idcategorie;
    }

    public String getNomcategorie() {
        return nomcategorie;
    }

    public void setNomcategorie(String nomcategorie) {
        this.nomcategorie = nomcategorie;
    }

    public String getDescriptioncategorie() {
        return descriptioncategorie;
    }

    public void setDescriptioncategorie(String descriptioncategorie) {
        this.descriptioncategorie = descriptioncategorie;
    }

    public String getStatutcategorie() {
        return statutcategorie;
    }

    public void setStatutcategorie(String statutcategorie) {
        this.statutcategorie = statutcategorie;
    }

    public Domaine getIddomaine() {
        return iddomaine;
    }

    public void setIddomaine(Domaine iddomaine) {
        this.iddomaine = iddomaine;
    }

    @XmlTransient
    public Collection<Produit> getProduitCollection() {
        return produitCollection;
    }

    public void setProduitCollection(Collection<Produit> produitCollection) {
        this.produitCollection = produitCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcategorie != null ? idcategorie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorie)) {
            return false;
        }
        Categorie other = (Categorie) object;
        if ((this.idcategorie == null && other.idcategorie != null) || (this.idcategorie != null && !this.idcategorie.equals(other.idcategorie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Categorie[ idcategorie=" + idcategorie + " ]";
    }
    
}
