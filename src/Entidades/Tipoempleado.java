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
@Table(name = "TIPOEMPLEADO")
@NamedQueries({
    @NamedQuery(name = "Tipoempleado.findAll", query = "SELECT t FROM Tipoempleado t")})
public class Tipoempleado implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "IDTIPOEMPLEADO")
    private BigDecimal idtipoempleado;
    @Column(name = "TIPOEMPLEADO")
    private String tipoempleado;
    @Column(name = "ESTADO")
    private String estado;

    public Tipoempleado() {
    }

    public Tipoempleado(BigDecimal idtipoempleado) {
        this.idtipoempleado = idtipoempleado;
    }

    public BigDecimal getIdtipoempleado() {
        return idtipoempleado;
    }

    public void setIdtipoempleado(BigDecimal idtipoempleado) {
        this.idtipoempleado = idtipoempleado;
    }

    public String getTipoempleado() {
        return tipoempleado;
    }

    public void setTipoempleado(String tipoempleado) {
        this.tipoempleado = tipoempleado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoempleado != null ? idtipoempleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoempleado)) {
            return false;
        }
        Tipoempleado other = (Tipoempleado) object;
        if ((this.idtipoempleado == null && other.idtipoempleado != null) || (this.idtipoempleado != null && !this.idtipoempleado.equals(other.idtipoempleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Tipoempleado[ idtipoempleado=" + idtipoempleado + " ]";
    }
    
}
