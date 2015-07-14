package com.ice1155.DA;

/**
 * Created by root on 7/14/15.
 */
public class Ejercicio {
    private String[] descripcionO;
    private String idHoja;
    private String nombre;

    public Ejercicio(String[] descripcionO, String idHoja, String nombre) {
        this.descripcionO = descripcionO;
        this.idHoja = idHoja;
        this.nombre = nombre;
    }

    public String[] getDescripcionO() {
        return descripcionO;
    }

    public void setDescripcionO(String[] descripcionO) {
        this.descripcionO = descripcionO;
    }

    public String getIdHoja() {
        return idHoja;
    }

    public void setIdHoja(String idHoja) {
        this.idHoja = idHoja;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
