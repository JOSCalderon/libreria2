/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "DEVOLUCIONES")
@NamedQueries({
    @NamedQuery(name = "Devoluciones.findAll", query = "SELECT d FROM Devoluciones d")})
public class Devoluciones implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDDEVOLUCION")
    private BigDecimal iddevolucion;
    @Column(name = "IDDETALLEVENTA")
    private BigInteger iddetalleventa;
    @Column(name = "DESCRIPCION")
    private String descripcion;

    public Devoluciones() {
    }

    public Devoluciones(BigDecimal iddevolucion) {
        this.iddevolucion = iddevolucion;
    }

    public BigDecimal getIddevolucion() {
        return iddevolucion;
    }

    public void setIddevolucion(BigDecimal iddevolucion) {
        this.iddevolucion = iddevolucion;
    }

    public BigInteger getIddetalleventa() {
        return iddetalleventa;
    }

    public void setIddetalleventa(BigInteger iddetalleventa) {
        this.iddetalleventa = iddetalleventa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddevolucion != null ? iddevolucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Devoluciones)) {
            return false;
        }
        Devoluciones other = (Devoluciones) object;
        if ((this.iddevolucion == null && other.iddevolucion != null) || (this.iddevolucion != null && !this.iddevolucion.equals(other.iddevolucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Devoluciones[ iddevolucion=" + iddevolucion + " ]";
    }
    
}
