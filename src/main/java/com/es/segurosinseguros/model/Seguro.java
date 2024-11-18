package com.es.segurosinseguros.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>Clase que representa la entidad 'Seguro' en el sistema de gestión de seguros médicos.</p>
 * <p>Esta clase mapea la tabla 'seguros' de la base de datos y contiene información básica
 * de cada seguro médico, incluyendo datos personales del asegurado y su estado civil.</p>
 * <p>Tabla: <code>seguros</code>.</p>
 */

@Entity
@Table(name = "seguros")
public class Seguro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_seguro")
    private Long idSeguro;

    @Column(name = "nif", nullable = false, unique = true)
    private String nif;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido_1", nullable = false)
    private String ape1;

    @Column(name = "apellido_2")
    private String ape2;

    @Column(name = "edad", nullable = false)
    private int edad;

    @Column(name = "numero_hijos", nullable = false)
    private int numHijos;

    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private Date fechaCreacion;

    @Column(name = "sexo", nullable = false)
    private String sexo;

    @Column(name = "estado_civil", nullable = false)
    private Boolean casado;

    @Column(name = "embarazada", nullable = false)
    private Boolean embarazada;

    @OneToMany(mappedBy = "seguro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AsistenciaMedica> asistenciasMedicas = new ArrayList<>();

    /**
     * Método que asigna automáticamente la fecha de creación antes de persistir en la base de datos.
     */
    @PrePersist
    protected void onCreate() {
        this.fechaCreacion = new Date();
    }

    // Constructores // Getters&Setters
    public Seguro() {
    }

    /**
     * Constructor con todos los atributos.
     * Este constructor incluye el identificador único del seguro.
     *
     * @param idSeguro      Identificador único del seguro.
     * @param nif           NIF del asegurado.
     * @param nombre        Nombre del asegurado.
     * @param ape1          Primer apellido del asegurado.
     * @param ape2          Segundo apellido del asegurado.
     * @param edad          Edad del asegurado.
     * @param numHijos      Número de hijos del asegurado.
     * @param fechaCreacion Fecha de creación del seguro.
     * @param sexo          Sexo del asegurado.
     * @param casado        Estado civil del asegurado.
     * @param embarazada    Indica si el asegurado está embarazado.
     */
    public Seguro(Long idSeguro, String nif, String nombre, String ape1, String ape2, int edad, int numHijos, Date fechaCreacion, String sexo, Boolean casado, Boolean embarazada) {
        this.idSeguro = idSeguro;
        this.nif = nif;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
        this.edad = edad;
        this.numHijos = numHijos;
        this.fechaCreacion = fechaCreacion;
        this.sexo = sexo;
        this.casado = casado;
        this.embarazada = embarazada;
    }

    public Seguro(String nif, String nombre, String ape1, String ape2, int edad, int numHijos, Date fechaCreacion, String sexo, Boolean casado, Boolean embarazada) {
        this.nif = nif;
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
        this.edad = edad;
        this.numHijos = numHijos;
        this.fechaCreacion = fechaCreacion;
        this.sexo = sexo;
        this.casado = casado;
        this.embarazada = embarazada;
    }


    public Long getIdSeguro() {
        return idSeguro;
    }

    public void setIdSeguro(Long idSeguro) {
        this.idSeguro = idSeguro;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNumHijos() {
        return numHijos;
    }

    public void setNumHijos(int numHijos) {
        this.numHijos = numHijos;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Boolean getCasado() {
        return casado;
    }

    public void setCasado(Boolean casado) {
        this.casado = casado;
    }

    public Boolean getEmbarazada() {
        return embarazada;
    }

    public void setEmbarazada(Boolean embarazada) {
        this.embarazada = embarazada;
    }

}
