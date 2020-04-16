package step2;

import java.io.Serializable;

public class TeamMember implements Comparable<TeamMember> {

    private String name;
    private Serializable employeeID;
    private String division;

    public TeamMember(String name, Serializable employeeID, String division) {
        this.name = name;
        this.employeeID = employeeID;
        this.division = division;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    @Override
    public int compareTo(TeamMember member) {
        return this.name.compareTo(member.name);
    }

    @Override
    public String toString() {
        String memberDetails = "";
        memberDetails +="Name: "+this.name + "\n" +"Employee ID: "+ this.employeeID+ "\n" + "Division: " + this.division;
        return memberDetails;
    }
}
