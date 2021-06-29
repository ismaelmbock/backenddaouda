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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mbock
 */
@Entity
@Table(name = "entreprise")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entreprise.findAll", query = "SELECT e FROM Entreprise e"),
    @NamedQuery(name = "Entreprise.findByIdentreprise", query = "SELECT e FROM Entreprise e WHERE e.identreprise = :identreprise"),
    @NamedQuery(name = "Entreprise.findByNomentreprise", query = "SELECT e FROM Entreprise e WHERE e.nomentreprise = :nomentreprise"),
    @NamedQuery(name = "Entreprise.findByStatutentreprise", query = "SELECT e FROM Entreprise e WHERE e.statutentreprise = :statutentreprise")})
public class Entreprise implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "identreprise")
    private Integer identreprise;
    @Size(max = 254)
    @Column(name = "nomentreprise")
    private String nomentreprise;
    @Size(max = 254)
    @Column(name = "statutentreprise")
    private String statutentreprise;
    @JoinColumn(name = "idreference", referencedColumnName = "idreference")
    @ManyToOne(optional = false)
    private Reference idreference;

    public Entreprise() {
    }

    public Entreprise(Integer identreprise) {
        this.identreprise = identreprise;
    }

    public Integer getIdentreprise() {
        return identreprise;
    }

    public void setIdentreprise(Integer identreprise) {
        this.identreprise = identreprise;
    }

    public String getNomentreprise() {
        return nomentreprise;
    }

    public void setNomentreprise(String nomentreprise) {
        this.nomentreprise = nomentreprise;
    }

    public String getStatutentreprise() {
        return statutentreprise;
    }

    public void setStatutentreprise(String statutentreprise) {
        this.statutentreprise = statutentreprise;
    }

    public Reference getIdreference() {
        return idreference;
    }

    public void setIdreference(Reference idreference) {
        this.idreference = idreference;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identreprise != null ? identreprise.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entreprise)) {
            return false;
        }
        Entreprise other = (Entreprise) object;
        if ((this.identreprise == null && other.identreprise != null) || (this.identreprise != null && !this.identreprise.equals(other.identreprise))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Entreprise[ identreprise=" + identreprise + " ]";
    }
    
}
