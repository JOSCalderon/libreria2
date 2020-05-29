/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jose
 */
@Entity
@Table(name = "INVENTARIO")
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i")})
public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDINVENTARIO")
    private BigDecimal idinventario;
    @Column(name = "IDCOMPRA")
    private BigInteger idcompra;
    @Column(name = "LOTE")
    private BigInteger lote;
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @Column(name = "FECHACADUCIDAD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacaducidad;

    public Inventario() {
    }

    public Inventario(BigDecimal idinventario) {
        this.idinventario = idinventario;
    }

    public BigDecimal getIdinventario() {
        return idinventario;
    }

    public void setIdinventario(BigDecimal idinventario) {
        this.idinventario = idinventario;
    }

    public BigInteger getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(BigInteger idcompra) {
        this.idcompra = idcompra;
    }

    public BigInteger getLote() {
        return lote;
    }

    public void setLote(BigInteger lote) {
        this.lote = lote;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechacaducidad() {
        return fechacaducidad;
    }

    public void setFechacaducidad(Date fechacaducidad) {
        this.fechacaducidad = fechacaducidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinventario != null ? idinventario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventario)) {
            return false;
        }
        Inventario other = (Inventario) object;
        if ((this.idinventario == null && other.idinventario != null) || (this.idinventario != null && !this.idinventario.equals(other.idinventario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Inventario[ idinventario=" + idinventario + " ]";
    }
    
}
