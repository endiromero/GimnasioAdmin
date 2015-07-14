package com.ice1155.DA;

import java.util.ArrayList;

/**
 * Created by root on 7/14/15.
 */
public class Dia {
    private int numDia;
    private ArrayList<Ejercicio> ejercicios;

    public Dia(int numDia, ArrayList<Ejercicio> ejercicios) {
        this.numDia = numDia;
        this.ejercicios = ejercicios;
    }

    public int getNumDia() {
        return numDia;
    }

    public void setNumDia(int numDia) {
        this.numDia = numDia;
    }

    public ArrayList<Ejercicio> getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(ArrayList<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }
}
