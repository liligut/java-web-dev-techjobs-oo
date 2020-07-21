package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name,
               Employer employer,
               Location location,
               PositionType positionType,
               CoreCompetency coreCompetency){
        this();
        setName(name);
        setEmployer(employer);
        setLocation(location);
        setPositionType(positionType);
        setCoreCompetency(coreCompetency);
    }

    public int getId() {
        return id;
    }


    public String getName() {
        if (name== "" || name == null) {
            return "Data not available";
        }else{
            return name;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        String output;
        if (getName() == "Data not available" && getInfo(getEmployer()) == "Data not available" &&
            getInfo(getLocation()) == "Data not available" && getInfo(getPositionType()) == "Data not available" &&
            getInfo(getCoreCompetency()) == "Data not available") {
            output = "\nOOPS! This job does not seem to exist.\n";
        }else{
            output = "\n"+
                    "ID: "+getId()+"\n"+
                    "Name: "+getName()+"\n"+
                    "Employer: "+getInfo(getEmployer())+"\n"+
                    "Location: "+getInfo(getLocation())+"\n"+
                    "Position Type: "+getInfo(getPositionType())+"\n"+
                    "Core Competency: "+getInfo(getCoreCompetency())+"\n";
        }
        return output;
    }
    private String getInfo(JobField field){
        if (field == null){
            return "Data not available";
        }
        else{
            return field.toString();
        }
    }
}
