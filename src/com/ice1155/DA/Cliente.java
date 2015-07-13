package com.ice1155.DA;

import java.io.Serializable;
import java.util.Date;

import android.os.Parcel;
import android.os.Parcelable;

public class Cliente implements Serializable {
	private long carne;

	private Entrenador entrenador_id;
	// Informacion general
	private String primer_apellido;
	private String segundo_apellido;
	private String nombre;
	private String fecha_nacimiento;
	private int edad;
	private boolean sexo;
	private String fechaMed;

	// Medidas corporales
	private double estatura;
	private double pesoKgs;
	private double pecho;
	private double espalda;
	private double umbilical;
	private double caderas;
	private double musloDer;
	private double musloIzq;
	private double brazoDer;
	private double brazoIzq;
	private double antebrazoDer;
	private double antebrazoIzq;
	private double gastroDer;
	private double gastroIzq;

	// Porcentajes de grasa
	private double tricepsPorG;
	private double subescapularPorG;
	private double supraPorG;
	private double abdominalPorG;
	private double musculoPorG;
	private double gastroPorG;
	private double pechoPorG;
	private double porcentajeGrasa;
	private double porcenMasaMuscPorG;
	private double imcPorG;
	private double indVicePorG;
	private double calReposo;
	private double presionPorG;
	private String pulsoPorG;
	private double glucosaPorG;

	private String observaciones;
/*
	public static final Parcelable.Creator<Cliente> CREATOR = new Creator<Cliente>() {
		@Override
		public Cliente createFromParcel(Parcel source) {
			return new Cliente(source);
		}

		@Override
		public Cliente[] newArray(int size) {
			return new Cliente[size];
		}
	};*/

	public Cliente(long carne, Entrenador entrenador_id,
			String primer_apellido, String segundo_apellido, String nombre, String fechaMed,
			String fechaNacimiento, int edad, boolean sexo, double estatura,
			double pesoKgs, double pecho, double espalda, double umbilical,
			double caderas, double musloDer, double musloIzq, double brazoDer,
			double brazoIzq, double antebrazoDer, double antebrazoIzq,
			double gastroDer, double gastroIzq, double tricepsPorG,
			double subescapularPorG, double supraPorG, double abdominalPorG,
			double gastroPorG, double pechoPorG, double porcentajeGrasa,
			double porcenMasaMuscPorG, double imcPorG, double indVicePorG,
			double calReposoPorG, double presionPorG, String pulsoPorG,
			double glucosaPorG, double musculoPorG, String observaciones) {
		super();
		this.carne = carne;
		this.musculoPorG = musculoPorG;
		this.entrenador_id = entrenador_id;
		this.primer_apellido = primer_apellido;
		this.segundo_apellido = segundo_apellido;
		this.nombre = nombre;
		this.fecha_nacimiento = fechaNacimiento;
		this.fechaMed = fechaMed;
		this.edad = edad;
		this.sexo = sexo;
		this.estatura = estatura;
		this.pesoKgs = pesoKgs;
		this.pecho = pecho;
		this.espalda = espalda;
		this.umbilical = umbilical;
		this.caderas = caderas;
		this.musloDer = musloDer;
		this.musloIzq = musloIzq;
		this.brazoDer = brazoDer;
		this.brazoIzq = brazoIzq;
		this.antebrazoDer = antebrazoDer;
		this.antebrazoIzq = antebrazoIzq;
		this.gastroDer = gastroDer;
		this.gastroIzq = gastroIzq;
		this.tricepsPorG = tricepsPorG;
		this.subescapularPorG = subescapularPorG;
		this.supraPorG = supraPorG;
		this.abdominalPorG = abdominalPorG;
		this.gastroPorG = gastroPorG;
		this.pechoPorG = pechoPorG;
		this.porcentajeGrasa = porcentajeGrasa;
		this.porcenMasaMuscPorG = porcenMasaMuscPorG;
		this.imcPorG = imcPorG;
		this.indVicePorG = indVicePorG;
		this.calReposo = calReposoPorG;
		this.presionPorG = presionPorG;
		this.pulsoPorG = pulsoPorG;
		this.glucosaPorG = glucosaPorG;
		this.observaciones = observaciones;
	}

	public Cliente() {
		super();
	}

	public Cliente(Parcel in) {
		//readFromParcel(in);
	}

	public long getCarne() {
		return carne;
	}

	public void setCarne(long carne) {
		this.carne = carne;
	}

    public double getMusculoPorG() {
        return musculoPorG;
    }

    public void setMusculoPorG(double musculoPorG) {
        this.musculoPorG = musculoPorG;
    }

    public Entrenador getentrenador_id() {
		return entrenador_id;
	}

	public void setentrenador_id(Entrenador entrenador_id) {
		this.entrenador_id = entrenador_id;
	}

	public String getprimer_apellido() {
		return primer_apellido;
	}

	public void setprimer_apellido(String primer_apellido) {
		this.primer_apellido = primer_apellido;
	}

	public String getsegundo_apellido() {
		return segundo_apellido;
	}

	public void setsegundo_apellido(String segundo_apellido) {
		this.segundo_apellido = segundo_apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaNacimiento() {
		return fecha_nacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fecha_nacimiento = fechaNacimiento;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean isSexo() {
		return sexo;
	}

	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}

	public double getEstatura() {
		return estatura;
	}

	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}

	public double getPesoKgs() {
		return pesoKgs;
	}

	public void setPesoKgs(double pesoKgs) {
		this.pesoKgs = pesoKgs;
	}

	public double getPecho() {
		return pecho;
	}

	public void setPecho(double pecho) {
		this.pecho = pecho;
	}

	public double getEspalda() {
		return espalda;
	}

	public void setEspalda(double espalda) {
		this.espalda = espalda;
	}

	public double getUmbilical() {
		return umbilical;
	}

	public void setUmbilical(double umbilical) {
		this.umbilical = umbilical;
	}

	public double getCaderas() {
		return caderas;
	}

	public void setCaderas(double caderas) {
		this.caderas = caderas;
	}

	public double getMusloDer() {
		return musloDer;
	}

	public void setMusloDer(double musloDer) {
		this.musloDer = musloDer;
	}

	public double getMusloIzq() {
		return musloIzq;
	}

	public void setMusloIzq(double musloIzq) {
		this.musloIzq = musloIzq;
	}

	public double getBrazoDer() {
		return brazoDer;
	}

	public void setBrazoDer(double brazoDer) {
		this.brazoDer = brazoDer;
	}

	public double getBrazoIzq() {
		return brazoIzq;
	}

	public void setBrazoIzq(double brazoIzq) {
		this.brazoIzq = brazoIzq;
	}

	public double getAntebrazoDer() {
		return antebrazoDer;
	}

	public void setAntebrazoDer(double antebrazoDer) {
		this.antebrazoDer = antebrazoDer;
	}

	public double getAntebrazoIzq() {
		return antebrazoIzq;
	}

	public void setAntebrazoIzq(double antebrazoIzq) {
		this.antebrazoIzq = antebrazoIzq;
	}

	public double getGastroDer() {
		return gastroDer;
	}

	public void setGastroDer(double gastroDer) {
		this.gastroDer = gastroDer;
	}

	public double getGastroIzq() {
		return gastroIzq;
	}

	public void setGastroIzq(double gastroIzq) {
		this.gastroIzq = gastroIzq;
	}

	public double getTricepsPorG() {
		return tricepsPorG;
	}

	public void setTricepsPorG(double tricepsPorG) {
		this.tricepsPorG = tricepsPorG;
	}

	public double getSubescapularPorG() {
		return subescapularPorG;
	}

	public void setSubescapularPorG(double subescapularPorG) {
		this.subescapularPorG = subescapularPorG;
	}

	public double getSupraPorG() {
		return supraPorG;
	}

	public void setSupraPorG(double supraPorG) {
		this.supraPorG = supraPorG;
	}

	public double getAbdominalPorG() {
		return abdominalPorG;
	}

	public void setAbdominalPorG(double abdominalPorG) {
		this.abdominalPorG = abdominalPorG;
	}

	public double getGastroPorG() {
		return gastroPorG;
	}

	public void setGastroPorG(double gastroPorG) {
		this.gastroPorG = gastroPorG;
	}

	public double getPechoPorG() {
		return pechoPorG;
	}

	public void setPechoPorG(double pechoPorG) {
		this.pechoPorG = pechoPorG;
	}

	public double getPorcentajeGrasa() {
		return porcentajeGrasa;
	}

	public void setPorcentajeGrasa(double porcentajeGrasa) {
		this.porcentajeGrasa = porcentajeGrasa;
	}

	public double getPorcenMasaMuscPorG() {
		return porcenMasaMuscPorG;
	}

	public void setPorcenMasaMuscPorG(double porcenMasaMuscPorG) {
		this.porcenMasaMuscPorG = porcenMasaMuscPorG;
	}

	public double getImcPorG() {
		return imcPorG;
	}

	public void setImcPorG(double imcPorG) {
		this.imcPorG = imcPorG;
	}

	public double getIndVicePorG() {
		return indVicePorG;
	}

	public void setIndVicePorG(double indVicePorG) {
		this.indVicePorG = indVicePorG;
	}

	public double getCalReposoPorG() {
		return calReposo;
	}

	public void setCalReposoPorG(double calReposoPorG) {
		this.calReposo = calReposoPorG;
	}

	public double getPresionPorG() {
		return presionPorG;
	}

	public void setPresionPorG(double presionPorG) {
		this.presionPorG = presionPorG;
	}

	public String getPulsoPorG() {
		return pulsoPorG;
	}

	public void setPulsoPorG(String pulsoPorG) {
		this.pulsoPorG = pulsoPorG;
	}

	public double getGlucosaPorG() {
		return glucosaPorG;
	}

	public void setGlucosaPorG(double glucosaPorG) {
		this.glucosaPorG = glucosaPorG;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

    public String getFechaMed() {
        return fechaMed;
    }

    public void setFechaMed(String fechaMed) {
        this.fechaMed = fechaMed;
    }

    @Override
	public String toString() {
		return "Cliente [carne=" + carne + ", entrenador_id=" + entrenador_id
				+ ", primer_apellido=" + primer_apellido
				+ ", segundo_apellido=" + segundo_apellido + ", nombre="
				+ nombre + ", fechaNacimiento=" + fecha_nacimiento + ", edad="
				+ edad + ", sexo=" + sexo + ", estatura=" + estatura
				+ ", pesoKgs=" + pesoKgs + ", pecho=" + pecho + ", espalda="
				+ espalda + ", umbilical=" + umbilical + ", caderas=" + caderas
				+ ", musloDer=" + musloDer + ", musloIzq=" + musloIzq
				+ ", brazoDer=" + brazoDer + ", brazoIzq=" + brazoIzq
				+ ", antebrazoDer=" + antebrazoDer + ", antebrazoIzq="
				+ antebrazoIzq + ", gastroDer=" + gastroDer + ", gastroIzq="
				+ gastroIzq + ", tricepsPorG=" + tricepsPorG
				+ ", subescapularPorG=" + subescapularPorG + ", supraPorG="
				+ supraPorG + ", abdominalPorG=" + abdominalPorG
				+ ", gastroPorG=" + gastroPorG + ", pechoPorG=" + pechoPorG
				+ ", porcentajeGrasa=" + porcentajeGrasa
				+ ", porcenMasaMuscPorG=" + porcenMasaMuscPorG + ", imcPorG="
				+ imcPorG + ", indVicePorG=" + indVicePorG + ", calReposoPorG="
				+ calReposo + ", presionPorG=" + presionPorG
				+ ", pulsoPorG=" + pulsoPorG + ", glucosaPorG=" + glucosaPorG
				+ ", observaciones=" + observaciones + "]";
	}
/*
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	private void readFromParcel(Parcel in) {
		this.carne = in.readLong();

		this.entrenador_id = (Entrenador) in.readSerializable();
		// Informacion general
		this.primerApellido = in.readString();
		this.segundoApellido = in.readString();
		this.nombre = in.readString();
		this.fecha_nacimiento = (Date) in.readSerializable();
		this.musculoPorG = in.readDouble();
		this.edad = in.readInt();
		this.sexo = (Boolean) in.readSerializable();
		this.fechaMed = (Date) in.readSerializable();

		// Medidas corporales
		this.estatura = in.readDouble();
		this.pesoKgs = in.readDouble();
		this.pecho = in.readDouble();
		this.espalda = in.readDouble();
		this.umbilical = in.readDouble();
		this.caderas = in.readDouble();
		this.musloDer = in.readDouble();
		this.musloIzq = in.readDouble();
		this.brazoDer = in.readDouble();
		this.brazoIzq = in.readDouble();
		this.antebrazoDer = in.readDouble();
		this.antebrazoIzq = in.readDouble();
		this.gastroDer = in.readDouble();
		this.gastroIzq = in.readDouble();

		// Porcentajes de grasa
		this.tricepsPorG = in.readDouble();
		this.subescapularPorG = in.readDouble();
		this.supraPorG = in.readDouble();
		this.abdominalPorG = in.readDouble();
		this.gastroPorG = in.readDouble();
		this.pechoPorG = in.readDouble();
		this.porcentajeGrasa = in.readDouble();
		this.porcenMasaMuscPorG = in.readDouble();
		this.imcPorG = in.readDouble();
		this.indVicePorG = in.readDouble();
		this.calReposo = in.readDouble();
		this.presionPorG = in.readDouble();
		this.pulsoPorG = in.readDouble();
		this.glucosaPorG = in.readDouble();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeLong(carne);
		dest.writeDouble(musculoPorG);
		dest.writeSerializable(entrenador_id);
		dest.writeString(primerApellido);
		dest.writeString(segundoApellido);
		dest.writeString(nombre);
		dest.writeSerializable(fecha_nacimiento);
		dest.writeInt(edad);
		dest.writeSerializable(sexo);
		dest.writeDouble(estatura);
		dest.writeDouble(pesoKgs);
		dest.writeDouble(pecho);
		dest.writeDouble(espalda);
		dest.writeDouble(umbilical);
		dest.writeDouble(caderas);
		dest.writeDouble(musloDer);
		dest.writeDouble(musloIzq);
		dest.writeDouble(brazoDer);
		dest.writeDouble(brazoIzq);
		dest.writeDouble(antebrazoDer);
		dest.writeDouble(antebrazoIzq);
		dest.writeDouble(gastroDer);
		dest.writeDouble(gastroIzq);
		dest.writeDouble(tricepsPorG);
		dest.writeDouble(subescapularPorG);
		dest.writeDouble(supraPorG);
		dest.writeDouble(abdominalPorG);
		dest.writeDouble(gastroPorG);
		dest.writeDouble(pechoPorG);
		dest.writeDouble(porcentajeGrasa);
		dest.writeDouble(porcenMasaMuscPorG);
		dest.writeDouble(imcPorG);
		dest.writeDouble(indVicePorG);
		dest.writeDouble(calReposo);
		dest.writeDouble(presionPorG);
		dest.writeDouble(pulsoPorG);
		dest.writeDouble(glucosaPorG);
	}*/
}
