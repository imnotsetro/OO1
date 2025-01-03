package ar.edu.unlp.info.oo1.ejercicio10_job_scheduler;

public class JobDescription {

	private final double effort;

	private final int priority;

	private final String description;

	public JobDescription (double anEffort, int aPriority, String aDescription) {
		this.effort = anEffort;
		this.priority = aPriority;
		this.description = aDescription;
	}

	public double getEffort() {
			return effort;
	}

	public int getPriority() {
		return priority;
	}

	public String getDescription() {
		return this.description;
	}
}
