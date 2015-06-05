package com.ice1155.DA;

import java.io.Serializable;

import android.os.Parcel;
import android.os.Parcelable;

public class Entrenador implements Parcelable, Serializable {
	private static final long serialVersionUID = -6505451520579451706L;
	private String cedula;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;

	public Entrenador(String cedula, String nombre, String primerApellido,
			String segundoApellido) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
	}

	public Entrenador() {
		super();
	}

	public Entrenador(Parcel in) {
		readFromParcel(in);
	}

	private void readFromParcel(Parcel in) {
		cedula = in.readString();
		nombre = in.readString();
		primerApellido = in.readString();
		segundoApellido = in.readString();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(cedula);
		dest.writeString(nombre);
		dest.writeString(primerApellido);
		dest.writeString(segundoApellido);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
