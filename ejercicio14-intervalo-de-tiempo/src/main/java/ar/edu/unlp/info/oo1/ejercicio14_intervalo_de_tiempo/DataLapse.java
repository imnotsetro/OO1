package ar.edu.unlp.info.oo1.ejercicio14_intervalo_de_tiempo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DataLapse {
	LocalDate from;
	LocalDate to;
	
	public DataLapse(LocalDate from, LocalDate to) {
		this.from = from;
		this.to = to;
	}

	public LocalDate getFrom() {
		return from;
	}
	
	public LocalDate getTo() {
		return to;
	}
	
	public int sizeInDays() {
		return (int) ChronoUnit.DAYS.between(this.from, this.to);
	}
	
	public boolean includesDate(LocalDate other) {
		if (other.isBefore(this.to) && other.isAfter(this.from)) {
			return true;
		} else {
			return false;
		}
	}
}
