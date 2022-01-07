/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udec.seminario.luismiguelsabalza.computadores.bd.entidades;

import java.io.Serializable;
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
 * @author EQUIPO
 */
@Entity
@Table(name = "computadores", catalog = "bd_seminario2021computadores", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Computador.findAll", query = "SELECT c FROM Computador c"),
    @NamedQuery(name = "Computador.findById", query = "SELECT c FROM Computador c WHERE c.id = :id"),
    @NamedQuery(name = "Computador.findByPassword", query = "SELECT c FROM Computador c WHERE c.password = :password"),
    @NamedQuery(name = "Computador.findByMarca", query = "SELECT c FROM Computador c WHERE c.marca = :marca"),
    @NamedQuery(name = "Computador.findByCategoria", query = "SELECT c FROM Computador c WHERE c.categoria = :categoria"),
    @NamedQuery(name = "Computador.findByMarcaCpu", query = "SELECT c FROM Computador c WHERE c.marcaCpu = :marcaCpu"),
    @NamedQuery(name = "Computador.findByVelocidadCpU", query = "SELECT c FROM Computador c WHERE c.velocidadCpU = :velocidadCpU"),
    @NamedQuery(name = "Computador.findByTecnologiaRam", query = "SELECT c FROM Computador c WHERE c.tecnologiaRam = :tecnologiaRam"),
    @NamedQuery(name = "Computador.findByCapacidadRam", query = "SELECT c FROM Computador c WHERE c.capacidadRam = :capacidadRam"),
    @NamedQuery(name = "Computador.findByTecnologiaDisco", query = "SELECT c FROM Computador c WHERE c.tecnologiaDisco = :tecnologiaDisco"),
    @NamedQuery(name = "Computador.findByCapacidadDisco", query = "SELECT c FROM Computador c WHERE c.capacidadDisco = :capacidadDisco"),
    @NamedQuery(name = "Computador.findByNumPuertosUSB", query = "SELECT c FROM Computador c WHERE c.numPuertosUSB = :numPuertosUSB"),
    @NamedQuery(name = "Computador.findByNumPuertosHDMI", query = "SELECT c FROM Computador c WHERE c.numPuertosHDMI = :numPuertosHDMI"),
    @NamedQuery(name = "Computador.findByMarcaMonitor", query = "SELECT c FROM Computador c WHERE c.marcaMonitor = :marcaMonitor"),
    @NamedQuery(name = "Computador.findByPulgadas", query = "SELECT c FROM Computador c WHERE c.pulgadas = :pulgadas"),
    @NamedQuery(name = "Computador.findByPrecio", query = "SELECT c FROM Computador c WHERE c.precio = :precio")})
public class Computador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id", nullable = false, length = 15)
    private String id;
    @Column(name = "password", length = 30)
    private String password;
    @Column(name = "marca", length = 20)
    private String marca;
    @Column(name = "categoria", length = 20)
    private String categoria;
    @Column(name = "marcaCpu", length = 20)
    private String marcaCpu;
    @Column(name = "velocidadCpU", length = 30)
    private String velocidadCpU;
    @Column(name = "tecnologiaRam", length = 20)
    private String tecnologiaRam;
    @Column(name = "capacidadRam", length = 30)
    private String capacidadRam;
    @Column(name = "tecnologiaDisco", length = 20)
    private String tecnologiaDisco;
    @Column(name = "capacidadDisco", length = 30)
    private String capacidadDisco;
    @Column(name = "numPuertosUSB", length = 10)
    private String numPuertosUSB;
    @Column(name = "numPuertosHDMI", length = 10)
    private String numPuertosHDMI;
    @Column(name = "MarcaMonitor", length = 20)
    private String marcaMonitor;
    @Column(name = "pulgadas", length = 15)
    private String pulgadas;
    @Column(name = "precio", length = 50)
    private String precio;

    public Computador() {
    }

    public Computador(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getMarcaCpu() {
        return marcaCpu;
    }

    public void setMarcaCpu(String marcaCpu) {
        this.marcaCpu = marcaCpu;
    }

    public String getVelocidadCpU() {
        return velocidadCpU;
    }

    public void setVelocidadCpU(String velocidadCpU) {
        this.velocidadCpU = velocidadCpU;
    }

    public String getTecnologiaRam() {
        return tecnologiaRam;
    }

    public void setTecnologiaRam(String tecnologiaRam) {
        this.tecnologiaRam = tecnologiaRam;
    }

    public String getCapacidadRam() {
        return capacidadRam;
    }

    public void setCapacidadRam(String capacidadRam) {
        this.capacidadRam = capacidadRam;
    }

    public String getTecnologiaDisco() {
        return tecnologiaDisco;
    }

    public void setTecnologiaDisco(String tecnologiaDisco) {
        this.tecnologiaDisco = tecnologiaDisco;
    }

    public String getCapacidadDisco() {
        return capacidadDisco;
    }

    public void setCapacidadDisco(String capacidadDisco) {
        this.capacidadDisco = capacidadDisco;
    }

    public String getNumPuertosUSB() {
        return numPuertosUSB;
    }

    public void setNumPuertosUSB(String numPuertosUSB) {
        this.numPuertosUSB = numPuertosUSB;
    }

    public String getNumPuertosHDMI() {
        return numPuertosHDMI;
    }

    public void setNumPuertosHDMI(String numPuertosHDMI) {
        this.numPuertosHDMI = numPuertosHDMI;
    }

    public String getMarcaMonitor() {
        return marcaMonitor;
    }

    public void setMarcaMonitor(String marcaMonitor) {
        this.marcaMonitor = marcaMonitor;
    }

    public String getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(String pulgadas) {
        this.pulgadas = pulgadas;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Computador)) {
            return false;
        }
        Computador other = (Computador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.udec.seminario.luismiguelsabalza.computadores.bd.entidades.Computador[ id=" + id + " ]";
    }
    
}
