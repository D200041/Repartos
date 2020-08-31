/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.umng.repartos.jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jamesit0
 */
@Entity
@Table(name = "Clientes", schema = "Repartos")
@XmlRootElement
@NamedQueries
(
    {
        @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
        @NamedQuery(name = "Clientes.findById", query = "SELECT c FROM Clientes c WHERE c.id = :id"),
        @NamedQuery(name = "Clientes.findByDocumento", query = "SELECT c FROM Clientes c WHERE c.documento = :documento"),
        @NamedQuery(name = "Clientes.findByNombre1", query = "SELECT c FROM Clientes c WHERE c.nombre1 = :nombre1"),
        @NamedQuery(name = "Clientes.findByNombre2", query = "SELECT c FROM Clientes c WHERE c.nombre2 = :nombre2"),
        @NamedQuery(name = "Clientes.findByApellido1", query = "SELECT c FROM Clientes c WHERE c.apellido1 = :apellido1"),
        @NamedQuery(name = "Clientes.findByApellido2", query = "SELECT c FROM Clientes c WHERE c.apellido2 = :apellido2"),
        @NamedQuery(name = "Clientes.findByDomicilio", query = "SELECT c FROM Clientes c WHERE c.domicilio = :domicilio")
    }
)
public class Clientes implements Serializable
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
    @Size(min = 1, max = 64)
    @Column(name = "Domicilio")
    private String domicilio;
    
    @JoinColumn(name = "Barrio", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Lugares barrio;
    
    @JoinColumn(name = "TipoDocumento", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private TipoDocumentos tipoDocumento;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private Collection<Repartos> repartosCollection;

    public Clientes()
    {
    }

    public Clientes(Integer id)
    {
        this.id = id;
    }

    public Clientes(Integer id, String documento, String nombre1, String apellido1, String domicilio)
    {
        this.id = id;
        this.documento = documento;
        this.nombre1 = nombre1;
        this.apellido1 = apellido1;
        this.domicilio = domicilio;
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

    public String getDomicilio()
    {
        return domicilio;
    }

    public void setDomicilio(String domicilio)
    {
        this.domicilio = domicilio;
    }

    public Lugares getBarrio()
    {
        return barrio;
    }

    public void setBarrio(Lugares barrio)
    {
        this.barrio = barrio;
    }

    public TipoDocumentos getTipoDocumento()
    {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumentos tipoDocumento)
    {
        this.tipoDocumento = tipoDocumento;
    }

    @XmlTransient
    public Collection<Repartos> getRepartosCollection()
    {
        return repartosCollection;
    }

    public void setRepartosCollection(Collection<Repartos> repartosCollection)
    {
        this.repartosCollection = repartosCollection;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes))
        {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "edu.umng.repartos.jpa.entities.Clientes[ id=" + id + " ]";
    }
}