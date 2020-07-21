package org.launchcode.techjobs_oo.Tests;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    static Job firstJob = new Job();//id=1
    static Job secondJob = new Job();//id=2
    static Job newJob = new Job("Product tester",
                               new Employer("ACME"),
                               new Location("Desert"),
                               new PositionType("Quality control"),
                               new CoreCompetency("Persistence"));//id=3
    static Job newJob2 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));//id=4
    static Job newJob3 = new Job("",
                null,
                new Location(""),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));//id=5
    static Job newJob4 = new Job();//id=6
    static Job newJob5 = new Job("",null,null,null,null);//id=7

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
