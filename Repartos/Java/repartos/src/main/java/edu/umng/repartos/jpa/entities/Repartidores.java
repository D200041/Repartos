/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.umng.repartos.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jamesit0
 */
@Entity
@Table(name = "Repartidores", schema = "Repartos")
@XmlRootElement
@NamedQueries
(
    {
        @NamedQuery(name = "Repartidores.findAll", query = "SELECT r FROM Repartidores r"),
        @NamedQuery(name = "Repartidores.findById", query = "SELECT r FROM Repartidores r WHERE r.id = :id"),
        @NamedQuery(name = "Repartidores.findByDocumento", query = "SELECT r FROM Repartidores r WHERE r.documento = :documento"),
        @NamedQuery(name = "Repartidores.findByNombre1", query = "SELECT r FROM Repartidores r WHERE r.nombre1 = :nombre1"),
        @NamedQuery(name = "Repartidores.findByNombre2", query = "SELECT r FROM Repartidores r WHERE r.nombre2 = :nombre2"),
        @NamedQuery(name = "Repartidores.findByApellido1", query = "SELECT r FROM Repartidores r WHERE r.apellido1 = :apellido1"),
        @NamedQuery(name = "Repartidores.findByApellido2", query = "SELECT r FROM Repartidores r WHERE r.apellido2 = :apellido2"),
        @NamedQuery(name = "Repartidores.findByNacimiento", query = "SELECT r FROM Repartidores r WHERE r.nacimiento = :nacimiento")
    }
)

public class Repartidores implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "Documento")
    private String documento;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "Nombre1")
    private String nombre1;
    
    @Size(max = 32)
    @Column(name = "Nombre2")
    private String nombre2;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "Apellido1")
    private String apellido1;
    
    @Size(max = 32)
    @Column(name = "Apellido2")
    private String apellido2;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "Nacimiento")
    @Temporal(TemporalType.DATE)
    private Date nacimiento;
    
    @JoinColumn(name = "Nacionalidad", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Lugares nacionalidad;
    
    @JoinColumn(name = "TipoDocumento", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private TipoDocumentos tipoDocumento;

    public Repartidores()
    {
    }

    public Repartidores(Integer id)
    {
        this.id = id;
    }

    public Repartidores(Integer id, String documento, String nombre1, String apellido1, Date nacimiento)
    {
        this.id = id;
        this.documento = documento;
        this.nombre1 = nombre1;
        this.apellido1 = apellido1;
        this.nacimiento = nacimiento;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getDocumento()
    {
        return documento;
    }

    public void setDocumento(String documento)
    {
        this.documento = documento;
    }

    public String getNombre1()
    {
        return nombre1;
    }

    public void setNombre1(String nombre1)
    {
        this.nombre1 = nombre1;
    }

    public String getNombre2()
    {
        return nombre2;
    }

    public void setNombre2(String nombre2)
    {
        this.nombre2 = nombre2;
    }

    public String getApellido1()
    {
        return apellido1;
    }

    public void setApellido1(String apellido1)
    {
        this.apellido1 = apellido1;
    }

    public String getApellido2()
    {
        return apellido2;
    }

    public void setApellido2(String apellido2)
    {
        this.apellido2 = apellido2;
    }

    public Date getNacimiento()
    {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento)
    {
        this.nacimiento = nacimiento;
    }

    public Lugares getNacionalidad()
    {
        return nacionalidad;
    }

    public void setNacionalidad(Lugares nacionalidad)
    {
        this.nacionalidad = nacionalidad;
    }

    public TipoDocumentos getTipoDocumento()
    {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumentos tipoDocumento)
    {
        this.tipoDocumento = tipoDocumento;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Repartidores))
        {
            return false;
        }
        Repartidores other = (Repartidores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "edu.umng.repartos.jpa.entities.Repartidores[ id=" + id + " ]";
    }
}