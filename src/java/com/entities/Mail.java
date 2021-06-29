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
@Table(name = "mail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mail.findAll", query = "SELECT m FROM Mail m"),
    @NamedQuery(name = "Mail.findByIdmail", query = "SELECT m FROM Mail m WHERE m.idmail = :idmail"),
    @NamedQuery(name = "Mail.findByAdressemail", query = "SELECT m FROM Mail m WHERE m.adressemail = :adressemail"),
    @NamedQuery(name = "Mail.findByStatutmail", query = "SELECT m FROM Mail m WHERE m.statutmail = :statutmail")})
public class Mail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmail")
    private Integer idmail;
    @Size(max = 254)
    @Column(name = "adressemail")
    private String adressemail;
    @Size(max = 254)
    @Column(name = "statutmail")
    private String statutmail;

    public Mail() {
    }

    public Mail(Integer idmail) {
        this.idmail = idmail;
    }

    public Integer getIdmail() {
        return idmail;
    }

    public void setIdmail(Integer idmail) {
        this.idmail = idmail;
    }

    public String getAdressemail() {
        return adressemail;
    }

    public void setAdressemail(String adressemail) {
        this.adressemail = adressemail;
    }

    public String getStatutmail() {
        return statutmail;
    }

    public void setStatutmail(String statutmail) {
        this.statutmail = statutmail;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmail != null ? idmail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mail)) {
            return false;
        }
        Mail other = (Mail) object;
        if ((this.idmail == null && other.idmail != null) || (this.idmail != null && !this.idmail.equals(other.idmail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Mail[ idmail=" + idmail + " ]";
    }
    
}
