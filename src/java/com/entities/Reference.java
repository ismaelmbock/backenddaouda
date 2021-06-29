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
@Table(name = "reference")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reference.findAll", query = "SELECT r FROM Reference r"),
    @NamedQuery(name = "Reference.findByIdreference", query = "SELECT r FROM Reference r WHERE r.idreference = :idreference"),
    @NamedQuery(name = "Reference.findByNomreference", query = "SELECT r FROM Reference r WHERE r.nomreference = :nomreference"),
    @NamedQuery(name = "Reference.findByStatutreference", query = "SELECT r FROM Reference r WHERE r.statutreference = :statutreference")})
public class Reference implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idreference")
    private Integer idreference;
    @Size(max = 254)
    @Column(name = "nomreference")
    private String nomreference;
    @Size(max = 254)
    @Column(name = "statutreference")
    private String statutreference;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idreference")
    private Collection<Entreprise> entrepriseCollection;

    public Reference() {
    }

    public Reference(Integer idreference) {
        this.idreference = idreference;
    }

    public Integer getIdreference() {
        return idreference;
    }

    public void setIdreference(Integer idreference) {
        this.idreference = idreference;
    }

    public String getNomreference() {
        return nomreference;
    }

    public void setNomreference(String nomreference) {
        this.nomreference = nomreference;
    }

    public String getStatutreference() {
        return statutreference;
    }

    public void setStatutreference(String statutreference) {
        this.statutreference = statutreference;
    }

    @XmlTransient
    public Collection<Entreprise> getEntrepriseCollection() {
        return entrepriseCollection;
    }

    public void setEntrepriseCollection(Collection<Entreprise> entrepriseCollection) {
        this.entrepriseCollection = entrepriseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreference != null ? idreference.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reference)) {
            return false;
        }
        Reference other = (Reference) object;
        if ((this.idreference == null && other.idreference != null) || (this.idreference != null && !this.idreference.equals(other.idreference))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Reference[ idreference=" + idreference + " ]";
    }
    
}
