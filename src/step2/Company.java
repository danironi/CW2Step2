package step2;

import java.util.ArrayList;
import java.util.Arrays;

public class Company {

    private String name;
    private int id;
    private ArrayList<Project> projects = new ArrayList<>();

    public Company(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public boolean addProject(Project p) {
        if (!find(p)) {
            projects.add(p);
            return true;
        } else {
            return false;
        }
    }

    public boolean find(Project p) {
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).equals(p)) {
                return true;
            }
        }
        return false;
    }

    public boolean findByTitle(String title) {
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public Project getByTitle(String title) {
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getTitle().equals(title)) {
                return projects.get(i);
            }
        }
        return null;
    }

    public void remove(Project p) {
        this.projects.remove(p);
    }

    public Project[] getSortedList() {
        Project[] projects = this.projects.toArray(new Project[0]);
        Arrays.sort(projects);
        return projects;
    }

    public int getProjectsNumber() {
        return this.projects.size();
    }
}

