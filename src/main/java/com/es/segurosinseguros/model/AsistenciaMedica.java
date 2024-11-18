package com.es.segurosinseguros.model;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa la entidad 'AsistenciaMedica' en el sistema de gestión de seguros médicos.
 * Esta clase mapea la tabla 'asistencias_medicas' de la base de datos y contiene información
 * sobre las asistencias médicas asociadas a un seguro.
 * <p>
 * Tabla: 'asistencias_medicas'
 */
@Entity
@Table(name = "asistencias_medicas")
public class AsistenciaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asistencia_medica")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_seguro", nullable = false)
    private Seguro seguro;

    @Column(name = "breve_descripcion", nullable = false)
    private String breveDescripcion;

    @Column(name = "lugar", nullable = false)
    private String lugar;

    @Column(name = "explicacion", nullable = false)
    private String explicacion;

    @Column(name = "tipo_asistencia", nullable = false)
    private String tipoAsistencia;

    @Column(name = "hora", nullable = false)
    private LocalTime hora;

    @Column(name = "importe", nullable = false)
    private Double importe;

    // Constructores // Getters&Setters
    public AsistenciaMedica() {
    }

    /**
     * Constructor con todos los atributos.
     *
     * @param seguro           Seguro al que pertenece la asistencia.
     * @param breveDescripcion Breve descripción de la asistencia.
     * @param lugar            Lugar de la asistencia.
     * @param explicacion      Explicación detallada de la asistencia.
     * @param tipoAsistencia   Tipo de asistencia.
     * @param hora             Hora de la asistencia.
     * @param importe          Importe asociado a la asistencia.
     */
    public AsistenciaMedica(Long id, Seguro seguro, String breveDescripcion, String lugar, String explicacion, String tipoAsistencia, LocalTime hora, Double importe) {
        this.id = id;
        this.seguro = seguro;
        this.breveDescripcion = breveDescripcion;
        this.lugar = lugar;
        this.explicacion = explicacion;
        this.tipoAsistencia = tipoAsistencia;
        this.hora = hora;
        this.importe = importe;
    }

    public AsistenciaMedica(Seguro seguro, String breveDescripcion, String lugar, String explicacion, String tipoAsistencia, LocalTime hora, Double importe) {
        this.seguro = seguro;
        this.breveDescripcion = breveDescripcion;
        this.lugar = lugar;
        this.explicacion = explicacion;
        this.tipoAsistencia = tipoAsistencia;
        this.hora = hora;
        this.importe = importe;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    public String getBreveDescripcion() {
        return breveDescripcion;
    }

    public void setBreveDescripcion(String breveDescripcion) {
        this.breveDescripcion = breveDescripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getExplicacion() {
        return explicacion;
    }

    public void setExplicacion(String explicacion) {
        this.explicacion = explicacion;
    }

    public String getTipoAsistencia() {
        return tipoAsistencia;
    }

    public void setTipoAsistencia(String tipoAsistencia) {
        this.tipoAsistencia = tipoAsistencia;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }
}
