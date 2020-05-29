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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jose
 */
@Entity
@Table(name = "DETALLEVENTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalleventa.findAll", query = "SELECT d FROM Detalleventa d")
    , @NamedQuery(name = "Detalleventa.findByIddetalleventa", query = "SELECT d FROM Detalleventa d WHERE d.iddetalleventa = :iddetalleventa")
    , @NamedQuery(name = "Detalleventa.findByIdfactura", query = "SELECT d FROM Detalleventa d WHERE d.idfactura = :idfactura")
    , @NamedQuery(name = "Detalleventa.findByIdproducto", query = "SELECT d FROM Detalleventa d WHERE d.idproducto = :idproducto")
    , @NamedQuery(name = "Detalleventa.findByIdtipoprecio", query = "SELECT d FROM Detalleventa d WHERE d.idtipoprecio = :idtipoprecio")
    , @NamedQuery(name = "Detalleventa.findByCantidad", query = "SELECT d FROM Detalleventa d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "Detalleventa.findByPrecionominal", query = "SELECT d FROM Detalleventa d WHERE d.precionominal = :precionominal")
    , @NamedQuery(name = "Detalleventa.findBySubtotal", query = "SELECT d FROM Detalleventa d WHERE d.subtotal = :subtotal")
    , @NamedQuery(name = "Detalleventa.findByTotal", query = "SELECT d FROM Detalleventa d WHERE d.total = :total")
    , @NamedQuery(name = "Detalleventa.findByDescuento", query = "SELECT d FROM Detalleventa d WHERE d.descuento = :descuento")})
public class Detalleventa implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDDETALLEVENTA")
    private BigDecimal iddetalleventa;
    @Column(name = "IDFACTURA")
    private BigInteger idfactura;
    @Column(name = "IDPRODUCTO")
    private BigInteger idproducto;
    @Column(name = "IDTIPOPRECIO")
    private BigInteger idtipoprecio;
    @Column(name = "CANTIDAD")
    private BigInteger cantidad;
    @Column(name = "PRECIONOMINAL")
    private BigDecimal precionominal;
    @Column(name = "SUBTOTAL")
    private BigDecimal subtotal;
    @Column(name = "TOTAL")
    private BigDecimal total;
    @Column(name = "DESCUENTO")
    private BigDecimal descuento;

    public Detalleventa() {
    }

    public Detalleventa(BigDecimal iddetalleventa) {
        this.iddetalleventa = iddetalleventa;
    }

    public BigDecimal getIddetalleventa() {
        return iddetalleventa;
    }

    public void setIddetalleventa(BigDecimal iddetalleventa) {
        this.iddetalleventa = iddetalleventa;
    }

    public BigInteger getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(BigInteger idfactura) {
        this.idfactura = idfactura;
    }

    public BigInteger getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(BigInteger idproducto) {
        this.idproducto = idproducto;
    }

    public BigInteger getIdtipoprecio() {
        return idtipoprecio;
    }

    public void setIdtipoprecio(BigInteger idtipoprecio) {
        this.idtipoprecio = idtipoprecio;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecionominal() {
        return precionominal;
    }

    public void setPrecionominal(BigDecimal precionominal) {
        this.precionominal = precionominal;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
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
        hash += (iddetalleventa != null ? iddetalleventa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalleventa)) {
            return false;
        }
        Detalleventa other = (Detalleventa) object;
        if ((this.iddetalleventa == null && other.iddetalleventa != null) || (this.iddetalleventa != null && !this.iddetalleventa.equals(other.iddetalleventa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Detalleventa[ iddetalleventa=" + iddetalleventa + " ]";
    }
    
}
