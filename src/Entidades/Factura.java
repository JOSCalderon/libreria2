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
@Table(name = "FACTURA")
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDFACTURA")
    private BigDecimal idfactura;
    @Column(name = "IDTIPOVENTA")
    private BigInteger idtipoventa;
    @Column(name = "IDEMPLEADO")
    private BigInteger idempleado;
    @Column(name = "IDCLIENTE")
    private BigInteger idcliente;
    @Column(name = "FECHAHORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechahora;
    @Column(name = "TOTALFACTURA")
    private BigDecimal totalfactura;
    @Column(name = "IVA")
    private BigDecimal iva;
    @Column(name = "SUBTOTAL")
    private BigDecimal subtotal;

    public Factura() {
    }

    public Factura(BigDecimal idfactura) {
        this.idfactura = idfactura;
    }

    public BigDecimal getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(BigDecimal idfactura) {
        this.idfactura = idfactura;
    }

    public BigInteger getIdtipoventa() {
        return idtipoventa;
    }

    public void setIdtipoventa(BigInteger idtipoventa) {
        this.idtipoventa = idtipoventa;
    }

    public BigInteger getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(BigInteger idempleado) {
        this.idempleado = idempleado;
    }

    public BigInteger getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(BigInteger idcliente) {
        this.idcliente = idcliente;
    }

    public Date getFechahora() {
        return fechahora;
    }

    public void setFechahora(Date fechahora) {
        this.fechahora = fechahora;
    }

    public BigDecimal getTotalfactura() {
        return totalfactura;
    }

    public void setTotalfactura(BigDecimal totalfactura) {
        this.totalfactura = totalfactura;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfactura != null ? idfactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.idfactura == null && other.idfactura != null) || (this.idfactura != null && !this.idfactura.equals(other.idfactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Factura[ idfactura=" + idfactura + " ]";
    }
    
}
