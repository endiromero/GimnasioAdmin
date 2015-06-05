package com.ice1155.DA;

import java.util.ArrayList;

public class ContenedorClientes {
	private ArrayList<Cliente> items;
	
	public ContenedorClientes() {
		super();
	}

	public ContenedorClientes(ArrayList<Cliente> clientes) {
		super();
		this.items = clientes;
	}

	public ArrayList<Cliente> getClientes() {
		return items;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.items = clientes;
	}

	@Override
	public String toString() {
		return "ContenedorClientes [clientes=" + items + "]";
	}	
}
