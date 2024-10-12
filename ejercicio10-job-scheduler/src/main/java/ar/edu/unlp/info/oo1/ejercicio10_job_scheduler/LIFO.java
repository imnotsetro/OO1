package ar.edu.unlp.info.oo1.ejercicio10_job_scheduler;

public class LIFO extends JobScheduler{
	
	public JobDescription next() {
		JobDescription nextJob = null;
		nextJob = jobs.get(jobs.size()-1);
		return super.returnJob(nextJob);
	}

}
