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
@Table(name = "TIPOPRECIO")
@NamedQueries({
    @NamedQuery(name = "Tipoprecio.findAll", query = "SELECT t FROM Tipoprecio t")})
public class Tipoprecio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDTIPOPRECIO")
    private BigDecimal idtipoprecio;
    @Column(name = "TIPOPRECIO")
    private String tipoprecio;
    @Column(name = "DESCUENTO")
    private BigDecimal descuento;

    public Tipoprecio() {
    }

    public Tipoprecio(BigDecimal idtipoprecio) {
        this.idtipoprecio = idtipoprecio;
    }

    public BigDecimal getIdtipoprecio() {
        return idtipoprecio;
    }

    public void setIdtipoprecio(BigDecimal idtipoprecio) {
        this.idtipoprecio = idtipoprecio;
    }

    public String getTipoprecio() {
        return tipoprecio;
    }

    public void setTipoprecio(String tipoprecio) {
        this.tipoprecio = tipoprecio;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoprecio != null ? idtipoprecio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoprecio)) {
            return false;
        }
        Tipoprecio other = (Tipoprecio) object;
        if ((this.idtipoprecio == null && other.idtipoprecio != null) || (this.idtipoprecio != null && !this.idtipoprecio.equals(other.idtipoprecio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Tipoprecio[ idtipoprecio=" + idtipoprecio + " ]";
    }
    
}
