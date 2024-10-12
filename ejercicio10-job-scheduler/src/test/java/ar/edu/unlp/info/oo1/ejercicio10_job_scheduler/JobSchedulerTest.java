package ar.edu.unlp.info.oo1.ejercicio10_job_scheduler;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JobSchedulerTest {
    protected JobDescription firstJob;
    protected JobDescription highestPriorityJob;
    protected JobDescription mostEffortJob;
    protected JobDescription lastJob;

    private void initializeJobs() {

        firstJob = new JobDescription (1, 1, "Este es el primero");
        highestPriorityJob = new JobDescription (1, 100, "Este es el de más prioridad");
        mostEffortJob = new JobDescription (100, 1, "Este es el de más esfuerzo");
        lastJob = new JobDescription (1, 1, "Este es el último");
    }

    @BeforeEach
    void setUp() {
        this.initializeJobs();
    }

    private JobScheduler newFifoScheduler() {
        FIFO fifoScheduler = new FIFO();
        return fifoScheduler;
    }

    private JobScheduler newLifoScheduler() {
        LIFO lifoScheduler = new LIFO();
        return lifoScheduler;
    }

    private JobScheduler newPriorityScheduler() {
        HighestPriority priorityScheduler = new HighestPriority();
        return priorityScheduler;
    }

    private JobScheduler newEffortScheduler() {
        MostEffort effortScheduler = new MostEffort();
        return effortScheduler;
    }

    private void scheduleJobsIn(JobScheduler aJobScheduler) {
        aJobScheduler.schedule(firstJob);
        aJobScheduler.schedule(highestPriorityJob);
        aJobScheduler.schedule(mostEffortJob);
        aJobScheduler.schedule(lastJob);
    }

    @Test
    void testSchedule() {
        HighestPriority aScheduler = new HighestPriority();
        aScheduler.schedule(highestPriorityJob);
        assertTrue(aScheduler.getJobs().contains(highestPriorityJob));
    }

    @Test
    void testUnschedule() {
    	HighestPriority aScheduler = new HighestPriority();
        this.scheduleJobsIn(aScheduler);
        aScheduler.unschedule(highestPriorityJob);
        assertFalse(aScheduler.getJobs().contains(highestPriorityJob));
    }

    @Test
    void testNext() {
        FIFO schedulerA = (FIFO) this.newFifoScheduler();
        this.scheduleJobsIn(schedulerA);
        assertEquals(schedulerA.next(), firstJob);
        assertEquals(schedulerA.getJobs().size(), 3);

        LIFO schedulerB = (LIFO) this.newLifoScheduler();
        this.scheduleJobsIn(schedulerB);
        assertEquals(schedulerB.next(), lastJob);
        assertEquals(schedulerB.getJobs().size(), 3);

        HighestPriority schedulerC = (HighestPriority) this.newPriorityScheduler();
        this.scheduleJobsIn(schedulerC);
        assertEquals(schedulerC.next(), highestPriorityJob);
        assertEquals(schedulerC.getJobs().size(), 3);

        MostEffort schedulerD = (MostEffort) this.newEffortScheduler();
        this.scheduleJobsIn(schedulerD);
        assertEquals(schedulerD.next(), mostEffortJob);
        assertEquals(schedulerD.getJobs().size(), 3);
    }
}
