package com.ice1155.DA;

import java.util.ArrayList;

/**
 * Created by root on 7/14/15.
 */
public class Rutina {
    private String objetivo;
    private String observaciones;
    private String fechaRealizacion;
    private ArrayList<Dia> dias;

    public Rutina() {}

    public Rutina(String objetivo, String observaciones, String fechaRealizacion, ArrayList<Dia> dias) {
        this.objetivo = objetivo;
        this.observaciones = observaciones;
        this.fechaRealizacion = fechaRealizacion;
        this.dias = dias;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(String fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public ArrayList<Dia> getDias() {
        return dias;
    }

    public void setDias(ArrayList<Dia> dias) {
        this.dias = dias;
    }
}
