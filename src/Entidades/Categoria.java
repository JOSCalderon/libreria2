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
@Table(name = "CATEGORIA")
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c")})
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDCATEGORIA")
    private BigDecimal idcategoria;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "NPMBRECATEGORIA")
    private String npmbrecategoria;

    public Categoria() {
    }

    public Categoria(BigDecimal idcategoria) {
        this.idcategoria = idcategoria;
    }

    public BigDecimal getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(BigDecimal idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNpmbrecategoria() {
        return npmbrecategoria;
    }

    public void setNpmbrecategoria(String npmbrecategoria) {
        this.npmbrecategoria = npmbrecategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcategoria != null ? idcategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.idcategoria == null && other.idcategoria != null) || (this.idcategoria != null && !this.idcategoria.equals(other.idcategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Categoria[ idcategoria=" + idcategoria + " ]";
    }
    
}
