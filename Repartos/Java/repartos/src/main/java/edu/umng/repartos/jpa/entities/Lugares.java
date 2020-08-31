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
@Table(name = "Lugares", schema = "Repartos")
@XmlRootElement
@NamedQueries
(
    {
        @NamedQuery(name = "Lugares.findAll", query = "SELECT l FROM Lugares l"),
        @NamedQuery(name = "Lugares.findById", query = "SELECT l FROM Lugares l WHERE l.id = :id"),
        @NamedQuery(name = "Lugares.findByNombre", query = "SELECT l FROM Lugares l WHERE l.nombre = :nombre"),
        @NamedQuery(name = "Lugares.findByNacionalidad", query = "SELECT l FROM Lugares l WHERE l.nacionalidad = :nacionalidad")
    }
)
public class Lugares implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "Nombre")
    private String nombre;
    
    @Size(max = 32)
    @Column(name = "Nacionalidad")
    private String nacionalidad;
    
    @OneToMany(mappedBy = "padre")
    private Collection<Lugares> lugaresCollection;
    
    @JoinColumn(name = "Padre", referencedColumnName = "Id")
    @ManyToOne
    private Lugares padre;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "barrio")
    private Collection<Clientes> clientesCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nacionalidad")
    private Collection<Repartidores> repartidoresCollection;

    public Lugares()
    {
    }

    public Lugares(Integer id)
    {
        this.id = id;
    }

    public Lugares(Integer id, String nombre)
    {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
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

    public String getNacionalidad()
    {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad)
    {
        this.nacionalidad = nacionalidad;
    }

    @XmlTransient
    public Collection<Lugares> getLugaresCollection()
    {
        return lugaresCollection;
    }

    public void setLugaresCollection(Collection<Lugares> lugaresCollection)
    {
        this.lugaresCollection = lugaresCollection;
    }

    public Lugares getPadre()
    {
        return padre;
    }

    public void setPadre(Lugares padre)
    {
        this.padre = padre;
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
        if (!(object instanceof Lugares))
        {
            return false;
        }
        Lugares other = (Lugares) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "edu.umng.repartos.jpa.entities.Lugares[ id=" + id + " ]";
    }
}