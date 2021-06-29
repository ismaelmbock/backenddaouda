/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "ferie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ferie.findAll", query = "SELECT f FROM Ferie f"),
    @NamedQuery(name = "Ferie.findByIdferie", query = "SELECT f FROM Ferie f WHERE f.idferie = :idferie"),
    @NamedQuery(name = "Ferie.findByJourferie", query = "SELECT f FROM Ferie f WHERE f.jourferie = :jourferie"),
    @NamedQuery(name = "Ferie.findByMoisferie", query = "SELECT f FROM Ferie f WHERE f.moisferie = :moisferie"),
    @NamedQuery(name = "Ferie.findByAnneeferie", query = "SELECT f FROM Ferie f WHERE f.anneeferie = :anneeferie"),
    @NamedQuery(name = "Ferie.findByHeureouvertureferie", query = "SELECT f FROM Ferie f WHERE f.heureouvertureferie = :heureouvertureferie"),
    @NamedQuery(name = "Ferie.findByHeurefermetureferie", query = "SELECT f FROM Ferie f WHERE f.heurefermetureferie = :heurefermetureferie")})
public class Ferie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idferie")
    private Integer idferie;
    @Column(name = "jourferie")
    private Integer jourferie;
    @Column(name = "moisferie")
    private Integer moisferie;
    @Column(name = "anneeferie")
    private Integer anneeferie;
    @Size(max = 254)
    @Column(name = "heureouvertureferie")
    private String heureouvertureferie;
    @Size(max = 254)
    @Column(name = "heurefermetureferie")
    private String heurefermetureferie;
    @OneToMany(mappedBy = "idferie")
    private Collection<Jour> jourCollection;

    public Ferie() {
    }

    public Ferie(Integer idferie) {
        this.idferie = idferie;
    }

    public Integer getIdferie() {
        return idferie;
    }

    public void setIdferie(Integer idferie) {
        this.idferie = idferie;
    }

    public Integer getJourferie() {
        return jourferie;
    }

    public void setJourferie(Integer jourferie) {
        this.jourferie = jourferie;
    }

    public Integer getMoisferie() {
        return moisferie;
    }

    public void setMoisferie(Integer moisferie) {
        this.moisferie = moisferie;
    }

    public Integer getAnneeferie() {
        return anneeferie;
    }

    public void setAnneeferie(Integer anneeferie) {
        this.anneeferie = anneeferie;
    }

    public String getHeureouvertureferie() {
        return heureouvertureferie;
    }

    public void setHeureouvertureferie(String heureouvertureferie) {
        this.heureouvertureferie = heureouvertureferie;
    }

    public String getHeurefermetureferie() {
        return heurefermetureferie;
    }

    public void setHeurefermetureferie(String heurefermetureferie) {
        this.heurefermetureferie = heurefermetureferie;
    }

    @XmlTransient
    public Collection<Jour> getJourCollection() {
        return jourCollection;
    }

    public void setJourCollection(Collection<Jour> jourCollection) {
        this.jourCollection = jourCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idferie != null ? idferie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ferie)) {
            return false;
        }
        Ferie other = (Ferie) object;
        if ((this.idferie == null && other.idferie != null) || (this.idferie != null && !this.idferie.equals(other.idferie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Ferie[ idferie=" + idferie + " ]";
    }
    
}
