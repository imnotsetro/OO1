package ar.edu.unlp.info.oo1.ejercicio10_job_scheduler;

public class MostEffort extends JobScheduler{
	
	public JobDescription next() {
		JobDescription nextJob = null;
		nextJob = jobs.stream()
        .max((j1,j2) -> Double.compare(j1.getEffort(), j2.getEffort()))
        .orElse(null);
		return super.returnJob(nextJob);
	}

}
