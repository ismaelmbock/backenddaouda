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
@Table(name = "jour")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jour.findAll", query = "SELECT j FROM Jour j"),
    @NamedQuery(name = "Jour.findByIdjour", query = "SELECT j FROM Jour j WHERE j.idjour = :idjour"),
    @NamedQuery(name = "Jour.findByNomjour", query = "SELECT j FROM Jour j WHERE j.nomjour = :nomjour"),
    @NamedQuery(name = "Jour.findByHeureouverturejour", query = "SELECT j FROM Jour j WHERE j.heureouverturejour = :heureouverturejour"),
    @NamedQuery(name = "Jour.findByHeurefermeturejour", query = "SELECT j FROM Jour j WHERE j.heurefermeturejour = :heurefermeturejour")})
public class Jour implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idjour")
    private Integer idjour;
    @Column(name = "nomjour")
    private Integer nomjour;
    @Size(max = 254)
    @Column(name = "heureouverturejour")
    private String heureouverturejour;
    @Size(max = 254)
    @Column(name = "heurefermeturejour")
    private String heurefermeturejour;
    @JoinColumn(name = "idferie", referencedColumnName = "idferie")
    @ManyToOne
    private Ferie idferie;

    public Jour() {
    }

    public Jour(Integer idjour) {
        this.idjour = idjour;
    }

    public Integer getIdjour() {
        return idjour;
    }

    public void setIdjour(Integer idjour) {
        this.idjour = idjour;
    }

    public Integer getNomjour() {
        return nomjour;
    }

    public void setNomjour(Integer nomjour) {
        this.nomjour = nomjour;
    }

    public String getHeureouverturejour() {
        return heureouverturejour;
    }

    public void setHeureouverturejour(String heureouverturejour) {
        this.heureouverturejour = heureouverturejour;
    }

    public String getHeurefermeturejour() {
        return heurefermeturejour;
    }

    public void setHeurefermeturejour(String heurefermeturejour) {
        this.heurefermeturejour = heurefermeturejour;
    }

    public Ferie getIdferie() {
        return idferie;
    }

    public void setIdferie(Ferie idferie) {
        this.idferie = idferie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idjour != null ? idjour.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jour)) {
            return false;
        }
        Jour other = (Jour) object;
        if ((this.idjour == null && other.idjour != null) || (this.idjour != null && !this.idjour.equals(other.idjour))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Jour[ idjour=" + idjour + " ]";
    }
    
}
