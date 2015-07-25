/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rachnashukla
 */
@Entity
@Table(name = "ProdLevelDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProdLevelDetail.findAll", query = "SELECT p FROM ProdLevelDetail p"),
    @NamedQuery(name = "ProdLevelDetail.findByLevel", query = "SELECT p FROM ProdLevelDetail p WHERE p.level = :level"),
    @NamedQuery(name = "ProdLevelDetail.findByName", query = "SELECT p FROM ProdLevelDetail p WHERE p.name = :name"),
    @NamedQuery(name = "ProdLevelDetail.findByDescription", query = "SELECT p FROM ProdLevelDetail p WHERE p.description = :description")})
public class ProdLevelDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Level")
    private Short level;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Name")
    private String name;
    @Size(max = 200)
    @Column(name = "Description")
    private String description;

    public ProdLevelDetail() {
    }

    public ProdLevelDetail(Short level) {
        this.level = level;
    }

    public ProdLevelDetail(Short level, String name) {
        this.level = level;
        this.name = name;
    }

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (level != null ? level.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProdLevelDetail)) {
            return false;
        }
        ProdLevelDetail other = (ProdLevelDetail) object;
        if ((this.level == null && other.level != null) || (this.level != null && !this.level.equals(other.level))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ProdLevelDetail[ level=" + level + " ]";
    }
    
}
