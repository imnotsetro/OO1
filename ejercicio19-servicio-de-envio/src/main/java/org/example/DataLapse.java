package org.example;

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
	
	public boolean overlaps(DataLapse other) {
		return (this.from.isBefore(other.getTo()) || this.to.isAfter(other.getFrom()));
	}
	
	public boolean includesDate(LocalDate other) {
        return other.isBefore(this.to) && other.isAfter(this.from);
	}
}
