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
    Job newJob3;
    Job newJob4;
    Job newJob5;
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
        newJob3 = new Job("",
                null,
                new Location(""),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        newJob4 = new Job();
        newJob5 = new Job("",null,null,null,null);
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
    @Test
    public void testToStringReturnDataNotAvailable(){
        String expectedResult = "\n"+
                "ID: 5\n"+
                "Name: Data not available\n"+
                "Employer: Data not available\n"+
                "Location: Data not available\n"+
                "Position Type: Quality control\n"+
                "Core Competency: Persistence\n";
        assertEquals(expectedResult, newJob3.toString());

    }
    @Test
    public void testToStringReturnJobDoesNotExist(){
        String expectedResult = "\nOOPS! This job does not seem to exist.\n";
        assertEquals(expectedResult, newJob4.toString());
        assertEquals(expectedResult, newJob5.toString());
    }


}
