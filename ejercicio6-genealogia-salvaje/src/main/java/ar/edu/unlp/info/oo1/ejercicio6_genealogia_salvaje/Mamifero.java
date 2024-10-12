package ar.edu.unlp.info.oo1.ejercicio6_genealogia_salvaje;

import java.sql.Date;

public class Mamifero {
	String identificador;
	String especie;
	Date fechaNacimiento;
	Mamifero padre;
	Mamifero madre;
	
	public Mamifero() {
	}
	
	public Mamifero(String identificador) {
		super();
		this.identificador = identificador;
	}
	
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Mamifero getPadre() {
		return padre;
	}
	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}
	public Mamifero getMadre() {
		return madre;
	}
	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}
	public Mamifero getAbuelaMaterna() {
		if (this.getMadre() != null) {
			return this.getMadre().getMadre();
		} else {
			return null;
		}
	}
	public Mamifero getAbueloMaterno() {
		if (this.getMadre() != null) {
			return this.getMadre().getPadre();
		} else {
			return null;
		}
	}
	public void setAbuelaMaterna(Mamifero abuela) {
		this.getMadre().setMadre(abuela);
	}
	public void setAbueloMaterno(Mamifero abuelo) {
		this.getMadre().setPadre(abuelo);
	}
	public Mamifero getAbuelaPaterna() {
		if (this.getPadre() != null) {
			return this.getPadre().getMadre();
		} else {
			return null;
		}
	}
	public Mamifero getAbueloPaterno() {
		if (this.getPadre() != null) {
			return this.getPadre().getPadre();
		} else {
			return null;
		}
	}
	public void setAbueloPaterno(Mamifero abuelo) {
		this.getPadre().setPadre(abuelo);
	}
	public void setAbuelaPaterna(Mamifero abuela) {
		this.getPadre().setMadre(abuela);
	}
	
	public boolean tieneComoAncestroA (Mamifero unMamifero) {
		/*
		if (unMamifero.equals(this.padre) || unMamifero.equals(this.madre)) return true;
		if ((this.padre != null && this.padre.tieneComoAncestroA(unMamifero)) ||
				(this.madre != null && this.madre.tieneComoAncestroA(unMamifero))) 
					return true;
		return false;
		*/
		if ((this.padre != null && this.padre.equals(unMamifero)) || (this.madre != null && this.madre.equals(unMamifero))) {
			return true;
		} else {
			boolean res = false;
			if (this.padre != null) {
				res = this.padre.tieneComoAncestroA(unMamifero);
			}
			if ((!res) && (this.madre != null)) {
				res = this.madre.tieneComoAncestroA(unMamifero);
			}
			return res;
		}
	}
	
}
