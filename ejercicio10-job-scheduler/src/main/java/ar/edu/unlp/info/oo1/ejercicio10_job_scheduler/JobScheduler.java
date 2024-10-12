package ar.edu.unlp.info.oo1.ejercicio10_job_scheduler;

import java.util.ArrayList;
import java.util.List;

public abstract class JobScheduler {
    protected List<JobDescription> jobs;

    public JobScheduler () {
        this.jobs = new ArrayList<>();
    }

    public void schedule(JobDescription job) {
        this.jobs.add(job);
    }

    public void unschedule(JobDescription job) {
        if (job != null) {
            this.jobs.remove(job);
        }
    }

    public List<JobDescription> getJobs(){
        return jobs;
    }
    
    public JobDescription returnJob (JobDescription nextJob) {
    	if (nextJob != null) { 
        	this.unschedule(nextJob);
            return nextJob;
        }
        return null;
    }
}
