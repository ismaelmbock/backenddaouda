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
@Table(name = "marque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marque.findAll", query = "SELECT m FROM Marque m"),
    @NamedQuery(name = "Marque.findByIdmarque", query = "SELECT m FROM Marque m WHERE m.idmarque = :idmarque"),
    @NamedQuery(name = "Marque.findByNommarque", query = "SELECT m FROM Marque m WHERE m.nommarque = :nommarque"),
    @NamedQuery(name = "Marque.findByImagemarque", query = "SELECT m FROM Marque m WHERE m.imagemarque = :imagemarque"),
    @NamedQuery(name = "Marque.findByStatutmarque", query = "SELECT m FROM Marque m WHERE m.statutmarque = :statutmarque"),
    @NamedQuery(name = "Marque.findByPaysmarque", query = "SELECT m FROM Marque m WHERE m.paysmarque = :paysmarque")})
public class Marque implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmarque")
    private Integer idmarque;
    @Size(max = 254)
    @Column(name = "nommarque")
    private String nommarque;
    @Size(max = 254)
    @Column(name = "imagemarque")
    private String imagemarque;
    @Size(max = 254)
    @Column(name = "paysmarque")
    private String paysmarque;
    @Size(max = 254)
    @Column(name = "statutmarque")
    private String statutmarque;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmarque")
    private Collection<Produitmarque> produitmarqueCollection;

    public Marque() {
    }

    public Marque(Integer idmarque) {
        this.idmarque = idmarque;
    }

    public Integer getIdmarque() {
        return idmarque;
    }

    public void setIdmarque(Integer idmarque) {
        this.idmarque = idmarque;
    }

    public String getNommarque() {
        return nommarque;
    }

    public void setNommarque(String nommarque) {
        this.nommarque = nommarque;
    }

    public String getImagemarque() {
        return imagemarque;
    }

    public void setImagemarque(String imagemarque) {
        this.imagemarque = imagemarque;
    }

    public String getPaysmarque() {
        return paysmarque;
    }

    public void setPaysmarque(String paysmarque) {
        this.paysmarque = paysmarque;
    }

    public String getStatutmarque() {
        return statutmarque;
    }

    public void setStatutmarque(String statutmarque) {
        this.statutmarque = statutmarque;
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
        hash += (idmarque != null ? idmarque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marque)) {
            return false;
        }
        Marque other = (Marque) object;
        if ((this.idmarque == null && other.idmarque != null) || (this.idmarque != null && !this.idmarque.equals(other.idmarque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Marque[ idmarque=" + idmarque + " ]";
    }

}
