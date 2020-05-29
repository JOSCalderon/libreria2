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
@Table(name = "CARGARPRODUCTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargarproductos.findAll", query = "SELECT c FROM Cargarproductos c")
    , @NamedQuery(name = "Cargarproductos.findByIdproducto", query = "SELECT c FROM Cargarproductos c WHERE c.idproducto = :idproducto")
    , @NamedQuery(name = "Cargarproductos.findByNombre", query = "SELECT c FROM Cargarproductos c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Cargarproductos.findByMarca", query = "SELECT c FROM Cargarproductos c WHERE c.marca = :marca")
    , @NamedQuery(name = "Cargarproductos.findByCategoria", query = "SELECT c FROM Cargarproductos c WHERE c.categoria = :categoria")
    , @NamedQuery(name = "Cargarproductos.findByProveedor", query = "SELECT c FROM Cargarproductos c WHERE c.proveedor = :proveedor")
    , @NamedQuery(name = "Cargarproductos.findByPrecioventa", query = "SELECT c FROM Cargarproductos c WHERE c.precioventa = :precioventa")
    , @NamedQuery(name = "Cargarproductos.findByExistenciaminima", query = "SELECT c FROM Cargarproductos c WHERE c.existenciaminima = :existenciaminima")
    , @NamedQuery(name = "Cargarproductos.findByExistencialote", query = "SELECT c FROM Cargarproductos c WHERE c.existencialote = :existencialote")
    , @NamedQuery(name = "Cargarproductos.findByIdinventario", query = "SELECT c FROM Cargarproductos c WHERE c.idinventario = :idinventario")})
public class Cargarproductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "IDPRODUCTO")
    @Id
    private BigInteger idproducto;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "MARCA")
    private String marca;
    @Column(name = "CATEGORIA")
    private String categoria;
    @Column(name = "PROVEEDOR")
    private String proveedor;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIOVENTA")
    private BigDecimal precioventa;
    @Column(name = "EXISTENCIAMINIMA")
    private BigInteger existenciaminima;
    @Column(name = "EXISTENCIALOTE")
    private BigInteger existencialote;
    @Column(name = "IDINVENTARIO")
    private BigInteger idinventario;

    public Cargarproductos() {
    }

    public BigInteger getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(BigInteger idproducto) {
        this.idproducto = idproducto;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public BigDecimal getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(BigDecimal precioventa) {
        this.precioventa = precioventa;
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

    public BigInteger getIdinventario() {
        return idinventario;
    }

    public void setIdinventario(BigInteger idinventario) {
        this.idinventario = idinventario;
    }
    
}
