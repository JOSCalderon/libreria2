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
@Table(name = "PRODUCTO")
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDPRODUCTO")
    private BigDecimal idproducto;
    @Column(name = "IDINVENTARIO")
    private BigInteger idinventario;
    @Column(name = "IDPROVEEDOR")
    private BigInteger idproveedor;
    @Column(name = "IDCATEGORIA")
    private BigInteger idcategoria;
    @Column(name = "EXISTENCIAMINIMA")
    private BigInteger existenciaminima;
    @Column(name = "EXISTENCIALOTE")
    private BigInteger existencialote;
    @Column(name = "PRECIOVENTA")
    private BigDecimal precioventa;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "MARCA")
    private String marca;

    public Producto() {
    }

    public Producto(BigDecimal idproducto) {
        this.idproducto = idproducto;
    }

    public BigDecimal getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(BigDecimal idproducto) {
        this.idproducto = idproducto;
    }

    public BigInteger getIdinventario() {
        return idinventario;
    }

    public void setIdinventario(BigInteger idinventario) {
        this.idinventario = idinventario;
    }

    public BigInteger getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(BigInteger idproveedor) {
        this.idproveedor = idproveedor;
    }

    public BigInteger getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(BigInteger idcategoria) {
        this.idcategoria = idcategoria;
    }

    public BigInteger getExistenciaminima() {
        return existenciaminima;
    }

    public void setExistenciaminima(BigInteger existenciaminima) {
        this.existenciaminima = existenciaminima;
    }

    public BigInteger getExistencialote() {
        return existencialote;
    }

    public void setExistencialote(BigInteger existencialote) {
        this.existencialote = existencialote;
    }

    public BigDecimal getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(BigDecimal precioventa) {
        this.precioventa = precioventa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproducto != null ? idproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idproducto == null && other.idproducto != null) || (this.idproducto != null && !this.idproducto.equals(other.idproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Producto[ idproducto=" + idproducto + " ]";
    }
    
}
