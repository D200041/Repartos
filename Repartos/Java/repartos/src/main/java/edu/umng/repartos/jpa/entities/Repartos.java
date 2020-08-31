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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jamesit0
 */
@Entity
@Table(name = "Repartos", schema = "Repartos")
@XmlRootElement
@NamedQueries
(
    {
        @NamedQuery(name = "Repartos.findAll", query = "SELECT r FROM Repartos r"),
        @NamedQuery(name = "Repartos.findById", query = "SELECT r FROM Repartos r WHERE r.id = :id"),
        @NamedQuery(name = "Repartos.findByFecha", query = "SELECT r FROM Repartos r WHERE r.fecha = :fecha"),
        @NamedQuery(name = "Repartos.findByEntregado", query = "SELECT r FROM Repartos r WHERE r.entregado = :entregado")
    }
)
public class Repartos implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "Entregado")
    private boolean entregado;
    
    @JoinColumn(name = "Cliente", referencedColumnName = "Id")
    @ManyToOne(optional = false)
    private Clientes cliente;

    public Repartos()
    {
    }

    public Repartos(Integer id)
    {
        this.id = id;
    }

    public Repartos(Integer id, Date fecha, boolean entregado)
    {
        this.id = id;
        this.fecha = fecha;
        this.entregado = entregado;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Date getFecha()
    {
        return fecha;
    }

    public void setFecha(Date fecha)
    {
        this.fecha = fecha;
    }

    public boolean getEntregado()
    {
        return entregado;
    }

    public void setEntregado(boolean entregado)
    {
        this.entregado = entregado;
    }

    public Clientes getCliente()
    {
        return cliente;
    }

    public void setCliente(Clientes cliente)
    {
        this.cliente = cliente;
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
        if (!(object instanceof Repartos))
        {
            return false;
        }
        Repartos other = (Repartos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.umng.repartos.jpa.entities.Repartos[ id=" + id + " ]";
    }
}