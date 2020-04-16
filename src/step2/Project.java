package step2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class Project implements Comparable<Project> {

    private String title;
    private Date start, end;
    private Queue<TeamMember> teamMembers = new LinkedList<>();

    public Project(String title, Date start, Date end) {
        this.title = title;
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy");
        return "Project title: " + title + "\nStarting date: " + simpleDateFormat.format(start) + "\nEnding date: " + simpleDateFormat.format(end);
    }

    public String getTitle() {
        return title;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    @Override
    public int compareTo(Project project) {
        return this.title.compareTo(project.title);
    }

    public boolean find(TeamMember tMember) {
        for (TeamMember name : teamMembers) {
            if (tMember == name) return true;

        }
        return false;
    }

    public boolean addMember(TeamMember tMember) {
        if (!find(tMember)) {
            teamMembers.add(tMember);
            return true;
        } else {
            return false;
        }
    }

    public TeamMember[] getAllMember() {

        return this.teamMembers.toArray(new TeamMember[0]);
    }

    public int getTeamMembersNumber() {
        return this.teamMembers.size();
    }

    public boolean findByName(String name) {
        for (TeamMember members : teamMembers) {
            if (members.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void remove(TeamMember member) {
        this.teamMembers.remove(member);
    }

    public TeamMember getByName(String name) {
        for (TeamMember members : teamMembers) {
            if (members.getName().equals(name)) {
                return members;
            }
        }
        return null;
    }
}