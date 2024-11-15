package com.es.segurosinseguros.model;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = " asistencias_medicas")
public class AsistenciaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asistencia_medica")
    private Long idAsistenciaMedica;

    @ManyToOne
    @JoinColumn(name = "id_seguro")
    private Seguro seguro;

    @Column(name = "breve_descripcion")
    private Seguro breveDescripcion;
    private String lugar;
    private String explicacion;

    @Column(name = "tipo_asistencia")
    private String tipoAsistencia;
    private LocalTime hora;
    private Double importe;

    public AsistenciaMedica() {
    }

    public AsistenciaMedica(Seguro seguro, Seguro breveDescripcion, String lugar, String explicacion, String tipoAsistencia, LocalTime hora, Double importe) {
        this.seguro = seguro;
        this.breveDescripcion = breveDescripcion;
        this.lugar = lugar;
        this.explicacion = explicacion;
        this.tipoAsistencia = tipoAsistencia;
        this.hora = hora;
        this.importe = importe;
    }

    public AsistenciaMedica(Long idAsistenciaMedica, Seguro seguro, Seguro breveDescripcion, String lugar, String explicacion, String tipoAsistencia, LocalTime hora, Double importe) {
        this.idAsistenciaMedica = idAsistenciaMedica;
        this.seguro = seguro;
        this.breveDescripcion = breveDescripcion;
        this.lugar = lugar;
        this.explicacion = explicacion;
        this.tipoAsistencia = tipoAsistencia;
        this.hora = hora;
        this.importe = importe;
    }

    public Long getIdAsistenciaMedica() {
        return idAsistenciaMedica;
    }

    public void setIdAsistenciaMedica(Long idAsistenciaMedica) {
        this.idAsistenciaMedica = idAsistenciaMedica;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    public Seguro getBreveDescripcion() {
        return breveDescripcion;
    }

    public void setBreveDescripcion(Seguro breveDescripcion) {
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
