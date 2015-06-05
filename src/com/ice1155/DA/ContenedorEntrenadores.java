package com.ice1155.DA;

import java.util.ArrayList;

public class ContenedorEntrenadores {
	private ArrayList<Entrenador> entrenadores;

	public ContenedorEntrenadores() {
		super();
	}

	public ContenedorEntrenadores(ArrayList<Entrenador> entrenadores) {
		super();
		this.entrenadores = entrenadores;
	}

	public ArrayList<Entrenador> getEntrenadores() {
		return entrenadores;
	}

	public void setEntrenadores(ArrayList<Entrenador> entrenadores) {
		this.entrenadores = entrenadores;
	}

	@Override
	public String toString() {
		return "ContenedorEntrenadores [entrenadores=" + entrenadores + "]";
	}
}
