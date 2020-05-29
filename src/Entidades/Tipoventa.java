/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Jose
 */
@Entity
@Table(name = "TIPOVENTA")
@NamedQueries({
    @NamedQuery(name = "Tipoventa.findAll", query = "SELECT t FROM Tipoventa t")})
public class Tipoventa implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDTIPOVENTA")
    private BigDecimal idtipoventa;
    @Column(name = "TIPOVENTA")
    private String tipoventa;

    public Tipoventa() {
    }

    public Tipoventa(BigDecimal idtipoventa) {
        this.idtipoventa = idtipoventa;
    }

    public BigDecimal getIdtipoventa() {
        return idtipoventa;
    }

    public void setIdtipoventa(BigDecimal idtipoventa) {
        this.idtipoventa = idtipoventa;
    }

    public String getTipoventa() {
        return tipoventa;
    }

    public void setTipoventa(String tipoventa) {
        this.tipoventa = tipoventa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoventa != null ? idtipoventa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoventa)) {
            return false;
        }
        Tipoventa other = (Tipoventa) object;
        if ((this.idtipoventa == null && other.idtipoventa != null) || (this.idtipoventa != null && !this.idtipoventa.equals(other.idtipoventa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Tipoventa[ idtipoventa=" + idtipoventa + " ]";
    }
    
}
