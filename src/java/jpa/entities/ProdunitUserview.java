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
@Table(name = "produnit_userview")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProdunitUserview.findAll", query = "SELECT p FROM ProdunitUserview p"),
    @NamedQuery(name = "ProdunitUserview.findById", query = "SELECT p FROM ProdunitUserview p WHERE p.id = :id"),
    @NamedQuery(name = "ProdunitUserview.findByName", query = "SELECT p FROM ProdunitUserview p WHERE p.name = :name"),
    @NamedQuery(name = "ProdunitUserview.findByDescription", query = "SELECT p FROM ProdunitUserview p WHERE p.description = :description"),
    @NamedQuery(name = "ProdunitUserview.findByLevel", query = "SELECT p FROM ProdunitUserview p WHERE p.level = :level"),
    @NamedQuery(name = "ProdunitUserview.findByParent", query = "SELECT p FROM ProdunitUserview p WHERE p.parent = :parent"),
    @NamedQuery(name = "ProdunitUserview.findByRisk", query = "SELECT p FROM ProdunitUserview p WHERE p.risk = :risk"),
    @NamedQuery(name = "ProdunitUserview.findByImpact", query = "SELECT p FROM ProdunitUserview p WHERE p.impact = :impact"),
    @NamedQuery(name = "ProdunitUserview.findByStability", query = "SELECT p FROM ProdunitUserview p WHERE p.stability = :stability"),
    @NamedQuery(name = "ProdunitUserview.findByBizOwner", query = "SELECT p FROM ProdunitUserview p WHERE p.bizOwner = :bizOwner"),
    @NamedQuery(name = "ProdunitUserview.findByTechOwner", query = "SELECT p FROM ProdunitUserview p WHERE p.techOwner = :techOwner"),
    @NamedQuery(name = "ProdunitUserview.findByLvlName", query = "SELECT p FROM ProdunitUserview p WHERE p.lvlName = :lvlName"),
    @NamedQuery(name = "ProdunitUserview.findByBizOwnerName", query = "SELECT p FROM ProdunitUserview p WHERE p.bizOwnerName = :bizOwnerName"),
    @NamedQuery(name = "ProdunitUserview.findByTechOwnerName", query = "SELECT p FROM ProdunitUserview p WHERE p.techOwnerName = :techOwnerName")})
  public class ProdunitUserview implements Serializable {
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
    @Column(name = "name")
    private String name;
    @Size(max = 200)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "level")
    private short level;
    @Size(max = 20)
    @Column(name = "parent")
    private String parent;
    @Column(name = "risk")
    private Short risk;
    @Column(name = "impact")
    private Short impact;
    @Column(name = "stability")
    private Short stability;
    @Size(max = 20)
    @Column(name = "bizOwner")
    private String bizOwner;
    @Size(max = 20)
    @Column(name = "techOwner")
    private String techOwner;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "lvlName")
    private String lvlName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "bizOwnerName")
    private String bizOwnerName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "techOwnerName")
    private String techOwnerName;
    

    public ProdunitUserview() {
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

    public String getLvlName() {
        return lvlName;
    }

    public void setLvlName(String lvlName) {
        this.lvlName = lvlName;
    }

    public String getBizOwnerName() {
        return bizOwnerName;
    }

    public void setBizOwnerFname(String bizOwnerName) {
        this.bizOwnerName = bizOwnerName;
    }

    public String getTechOwnerName() {
        return techOwnerName;
    }

    public void setTechOwnerName(String techOwnerName) {
        this.techOwnerName = techOwnerName;
    }

    
}
