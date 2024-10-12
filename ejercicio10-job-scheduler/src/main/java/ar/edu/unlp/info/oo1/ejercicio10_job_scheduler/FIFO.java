package ar.edu.unlp.info.oo1.ejercicio10_job_scheduler;

public class FIFO extends JobScheduler{

	public JobDescription next() {
		JobDescription nextJob = null;
		nextJob = jobs.get(0);
		return super.returnJob(nextJob);
	}
}
