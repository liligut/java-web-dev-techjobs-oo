package org.launchcode.techjobs_oo.Tests;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job firstJob;
    Job secondJob;
    Job newJob;
    Job newJob2;
    @Before
    public void createJobObjects(){
        firstJob = new Job();
        secondJob = new Job();
        newJob = new Job("Product tester",
                               new Employer("ACME"),
                               new Location("Desert"),
                               new PositionType("Quality control"),
                               new CoreCompetency("Persistence"));
        newJob2 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
    }
    @Test
    public void testSettingJobId() {
        assertTrue(secondJob.getId()-firstJob.getId()==1);
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        //the id field with data type int is pending
        assertTrue(newJob.getName() instanceof String && newJob.getName().equals("Product tester"));
        assertTrue(newJob.getEmployer() instanceof Employer && newJob.getEmployer().toString().equals("ACME"));
        assertTrue(newJob.getLocation() instanceof Location && newJob.getLocation().toString().equals("Desert"));
        assertTrue(newJob.getPositionType() instanceof PositionType && newJob.getPositionType().toString().equals("Quality control"));
        assertTrue(newJob.getCoreCompetency() instanceof CoreCompetency && newJob.getCoreCompetency().toString() == "Persistence");
    }
    @Test
    public void testJobsForEquality(){
        assertFalse(newJob.equals(newJob2));
    }
    @Test
    public void testToStringReturnAValidOutput(){
        String expectedResult = "\n"+
                                "ID: 3\n"+
                                "Name: Product tester\n"+
                                "Employer: ACME\n"+
                                "Location: Desert\n"+
                                "Position Type: Quality control\n"+
                                "Core Competency: Persistence\n";
        assertTrue(expectedResult.equals(newJob.toString()));

    }


}
