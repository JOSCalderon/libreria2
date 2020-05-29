/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
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
@Table(name = "PRUEBAEMPLEADO")
@NamedQueries({
    @NamedQuery(name = "Pruebaempleado.findAll", query = "SELECT p FROM Pruebaempleado p")
    , @NamedQuery(name = "Pruebaempleado.findByIdempleado", query = "SELECT p FROM Pruebaempleado p WHERE p.idempleado = :idempleado")
    , @NamedQuery(name = "Pruebaempleado.findByTipoempleado", query = "SELECT p FROM Pruebaempleado p WHERE p.tipoempleado = :tipoempleado")
    , @NamedQuery(name = "Pruebaempleado.findByNombres", query = "SELECT p FROM Pruebaempleado p WHERE p.nombres = :nombres")
    , @NamedQuery(name = "Pruebaempleado.findByApellidos", query = "SELECT p FROM Pruebaempleado p WHERE p.apellidos = :apellidos")
    , @NamedQuery(name = "Pruebaempleado.findByFechaingreso", query = "SELECT p FROM Pruebaempleado p WHERE p.fechaingreso = :fechaingreso")
    , @NamedQuery(name = "Pruebaempleado.findByTelefono", query = "SELECT p FROM Pruebaempleado p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Pruebaempleado.findByDireccion", query = "SELECT p FROM Pruebaempleado p WHERE p.direccion = :direccion")
    , @NamedQuery(name = "Pruebaempleado.findByDui", query = "SELECT p FROM Pruebaempleado p WHERE p.dui = :dui")
    , @NamedQuery(name = "Pruebaempleado.findByNit", query = "SELECT p FROM Pruebaempleado p WHERE p.nit = :nit")})
public class Pruebaempleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "IDEMPLEADO")
    @Id
    private BigInteger idempleado;
    @Column(name = "TIPOEMPLEADO")
    private String tipoempleado;
    @Column(name = "NOMBRES")
    private String nombres;
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Column(name = "FECHAINGRESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaingreso;
    @Column(name = "TELEFONO")
    private String telefono;
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "DUI")
    private String dui;
    @Column(name = "NIT")
    private String nit;

    public Pruebaempleado() {
    }

    public BigInteger getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(BigInteger idempleado) {
        this.idempleado = idempleado;
    }

    public String getTipoempleado() {
        return tipoempleado;
    }

    public void setTipoempleado(String tipoempleado) {
        this.tipoempleado = tipoempleado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    
}
