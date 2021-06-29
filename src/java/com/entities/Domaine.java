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
@Table(name = "domaine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Domaine.findAll", query = "SELECT d FROM Domaine d"),
    @NamedQuery(name = "Domaine.findByIddomaine", query = "SELECT d FROM Domaine d WHERE d.iddomaine = :iddomaine"),
    @NamedQuery(name = "Domaine.findByNomdomaine", query = "SELECT d FROM Domaine d WHERE d.nomdomaine = :nomdomaine"),
    @NamedQuery(name = "Domaine.findByDescriptiondomaine", query = "SELECT d FROM Domaine d WHERE d.descriptiondomaine = :descriptiondomaine"),
    @NamedQuery(name = "Domaine.findByImagedomaine", query = "SELECT d FROM Domaine d WHERE d.imagedomaine = :imagedomaine"),
    @NamedQuery(name = "Domaine.findByStatutdomaine", query = "SELECT d FROM Domaine d WHERE d.statutdomaine = :statutdomaine")})
public class Domaine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddomaine")
    private Integer iddomaine;
    @Size(max = 254)
    @Column(name = "nomdomaine")
    private String nomdomaine;
    @Size(max = 254)
    @Column(name = "descriptiondomaine")
    private String descriptiondomaine;
    @Size(max = 254)
    @Column(name = "imagedomaine")
    private String imagedomaine;
    @Size(max = 254)
    @Column(name = "statutdomaine")
    private String statutdomaine;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddomaine")
    private Collection<Categorie> categorieCollection;

    public Domaine() {
    }

    public Domaine(Integer iddomaine) {
        this.iddomaine = iddomaine;
    }

    public Integer getIddomaine() {
        return iddomaine;
    }

    public void setIddomaine(Integer iddomaine) {
        this.iddomaine = iddomaine;
    }

    public String getNomdomaine() {
        return nomdomaine;
    }

    public void setNomdomaine(String nomdomaine) {
        this.nomdomaine = nomdomaine;
    }

    public String getDescriptiondomaine() {
        return descriptiondomaine;
    }

    public void setDescriptiondomaine(String descriptiondomaine) {
        this.descriptiondomaine = descriptiondomaine;
    }

    public String getImagedomaine() {
        return imagedomaine;
    }

    public void setImagedomaine(String imagedomaine) {
        this.imagedomaine = imagedomaine;
    }

    public String getStatutdomaine() {
        return statutdomaine;
    }

    public void setStatutdomaine(String statutdomaine) {
        this.statutdomaine = statutdomaine;
    }

    @XmlTransient
    public Collection<Categorie> getCategorieCollection() {
        return categorieCollection;
    }

    public void setCategorieCollection(Collection<Categorie> categorieCollection) {
        this.categorieCollection = categorieCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddomaine != null ? iddomaine.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Domaine)) {
            return false;
        }
        Domaine other = (Domaine) object;
        if ((this.iddomaine == null && other.iddomaine != null) || (this.iddomaine != null && !this.iddomaine.equals(other.iddomaine))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Domaine[ iddomaine=" + iddomaine + " ]";
    }
    
}
