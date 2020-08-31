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
import javax.persistence.Id;
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
@Table(name = "TipoDocumentos", schema = "Repartos")
@XmlRootElement
@NamedQueries
(
    {
        @NamedQuery(name = "TipoDocumentos.findAll", query = "SELECT t FROM TipoDocumentos t"),
        @NamedQuery(name = "TipoDocumentos.findById", query = "SELECT t FROM TipoDocumentos t WHERE t.id = :id"),
        @NamedQuery(name = "TipoDocumentos.findByNombre", query = "SELECT t FROM TipoDocumentos t WHERE t.nombre = :nombre")
    }
)

public class TipoDocumentos implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Short id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "Nombre")
    private String nombre;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDocumento")
    private Collection<Clientes> clientesCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoDocumento")
    private Collection<Repartidores> repartidoresCollection;

    public TipoDocumentos()
    {
    }

    public TipoDocumentos(Short id)
    {
        this.id = id;
    }

    public TipoDocumentos(Short id, String nombre)
    {
        this.id = id;
        this.nombre = nombre;
    }

    public Short getId()
    {
        return id;
    }

    public void setId(Short id)
    {
        this.id = id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Clientes> getClientesCollection()
    {
        return clientesCollection;
    }

    public void setClientesCollection(Collection<Clientes> clientesCollection)
    {
        this.clientesCollection = clientesCollection;
    }

    @XmlTransient
    public Collection<Repartidores> getRepartidoresCollection()
    {
        return repartidoresCollection;
    }

    public void setRepartidoresCollection(Collection<Repartidores> repartidoresCollection)
    {
        this.repartidoresCollection = repartidoresCollection;
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
        if (!(object instanceof TipoDocumentos))
        {
            return false;
        }
        TipoDocumentos other = (TipoDocumentos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "edu.umng.repartos.jpa.entities.TipoDocumentos[ id=" + id + " ]";
    }
}