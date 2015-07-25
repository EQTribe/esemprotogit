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
@Table(name = "ProductUnit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductUnit.findAll", query = "SELECT p FROM ProductUnit p"),
    @NamedQuery(name = "ProductUnit.findById", query = "SELECT p FROM ProductUnit p WHERE p.id = :id"),
    @NamedQuery(name = "ProductUnit.findByName", query = "SELECT p FROM ProductUnit p WHERE p.name = :name"),
    @NamedQuery(name = "ProductUnit.findByDescription", query = "SELECT p FROM ProductUnit p WHERE p.description = :description"),
    @NamedQuery(name = "ProductUnit.findByLevel", query = "SELECT p FROM ProductUnit p WHERE p.level = :level"),
    @NamedQuery(name = "ProductUnit.findByParent", query = "SELECT p FROM ProductUnit p WHERE p.parent = :parent"),
    @NamedQuery(name = "ProductUnit.findByRisk", query = "SELECT p FROM ProductUnit p WHERE p.risk = :risk"),
    @NamedQuery(name = "ProductUnit.findByImpact", query = "SELECT p FROM ProductUnit p WHERE p.impact = :impact"),
    @NamedQuery(name = "ProductUnit.findByStability", query = "SELECT p FROM ProductUnit p WHERE p.stability = :stability"),
    @NamedQuery(name = "ProductUnit.findByBizOwner", query = "SELECT p FROM ProductUnit p WHERE p.bizOwner = :bizOwner"),
    @NamedQuery(name = "ProductUnit.findByTechOwner", query = "SELECT p FROM ProductUnit p WHERE p.techOwner = :techOwner")})
public class ProductUnit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Name")
    private String name;
    @Size(max = 200)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Level")
    private short level;
    @Size(max = 20)
    @Column(name = "Parent")
    private String parent;
    @Column(name = "Risk")
    private Short risk;
    @Column(name = "Impact")
    private Short impact;
    @Column(name = "Stability")
    private Short stability;
    @Size(max = 20)
    @Column(name = "BizOwner")
    private String bizOwner;
    @Size(max = 20)
    @Column(name = "TechOwner")
    private String techOwner;

    public ProductUnit() {
    }

    public ProductUnit(String id) {
        this.id = id;
    }

    public ProductUnit(String id, String name, short level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public short getLevel() {
        return level;
    }

    public void setLevel(short level) {
        this.level = level;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public Short getRisk() {
        return risk;
    }

    public void setRisk(Short risk) {
        this.risk = risk;
    }

    public Short getImpact() {
        return impact;
    }

    public void setImpact(Short impact) {
        this.impact = impact;
    }

    public Short getStability() {
        return stability;
    }

    public void setStability(Short stability) {
        this.stability = stability;
    }

    public String getBizOwner() {
        return bizOwner;
    }

    public void setBizOwner(String bizOwner) {
        this.bizOwner = bizOwner;
    }

    public String getTechOwner() {
        return techOwner;
    }

    public void setTechOwner(String techOwner) {
        this.techOwner = techOwner;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductUnit)) {
            return false;
        }
        ProductUnit other = (ProductUnit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ProductUnit[ id=" + id + " ]";
    }
    
}
