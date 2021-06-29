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
@Table(name = "produit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produit.findAll", query = "SELECT p FROM Produit p"),
    @NamedQuery(name = "Produit.findByIdproduit", query = "SELECT p FROM Produit p WHERE p.idproduit = :idproduit"),
    @NamedQuery(name = "Produit.findByNomproduit", query = "SELECT p FROM Produit p WHERE p.nomproduit = :nomproduit"),
    @NamedQuery(name = "Produit.findByDescriptionproduit", query = "SELECT p FROM Produit p WHERE p.descriptionproduit = :descriptionproduit"),
    @NamedQuery(name = "Produit.findByImageproduit", query = "SELECT p FROM Produit p WHERE p.imageproduit = :imageproduit"),
    @NamedQuery(name = "Produit.findByStatutproduit", query = "SELECT p FROM Produit p WHERE p.statutproduit = :statutproduit")})
public class Produit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproduit")
    private Integer idproduit;
    @Size(max = 254)
    @Column(name = "nomproduit")
    private String nomproduit;
    @Size(max = 254)
    @Column(name = "descriptionproduit")
    private String descriptionproduit;
    @Size(max = 254)
    @Column(name = "imageproduit")
    private String imageproduit;
    @Size(max = 254)
    @Column(name = "statutproduit")
    private String statutproduit;
    @JoinColumn(name = "idcategorie", referencedColumnName = "idcategorie")
    @ManyToOne(optional = false)
    private Categorie idcategorie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idproduit")
    private Collection<Produitmarque> produitmarqueCollection;

    public Produit() {
    }

    public Produit(Integer idproduit) {
        this.idproduit = idproduit;
    }

    public Integer getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(Integer idproduit) {
        this.idproduit = idproduit;
    }

    public String getNomproduit() {
        return nomproduit;
    }

    public void setNomproduit(String nomproduit) {
        this.nomproduit = nomproduit;
    }

    public String getDescriptionproduit() {
        return descriptionproduit;
    }

    public void setDescriptionproduit(String descriptionproduit) {
        this.descriptionproduit = descriptionproduit;
    }

    public String getImageproduit() {
        return imageproduit;
    }

    public void setImageproduit(String imageproduit) {
        this.imageproduit = imageproduit;
    }

    public String getStatutproduit() {
        return statutproduit;
    }

    public void setStatutproduit(String statutproduit) {
        this.statutproduit = statutproduit;
    }

    public Categorie getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(Categorie idcategorie) {
        this.idcategorie = idcategorie;
    }

    @XmlTransient
    public Collection<Produitmarque> getProduitmarqueCollection() {
        return produitmarqueCollection;
    }

    public void setProduitmarqueCollection(Collection<Produitmarque> produitmarqueCollection) {
        this.produitmarqueCollection = produitmarqueCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproduit != null ? idproduit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.idproduit == null && other.idproduit != null) || (this.idproduit != null && !this.idproduit.equals(other.idproduit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Produit[ idproduit=" + idproduit + " ]";
    }
    
}
