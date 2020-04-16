package step2;
// Java program to demonstrate working of Queue
// interface in Java

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TeamMemberTest {
    public static Project project1 = new Project("project", new Date(), new Date());

    public static void main(String[] args) {

        do {

            switch (menu()) {
                case 1:

                    String name = getString("Please enter name of team member");
                    if(project1.findByName(name)){
                        System.out.println("Team member "+name+" already exists.");

                    }
                    else{
                        Serializable id = getInt("Please enter a number with 6 digits", 6);
                        String division = getString("Please enter division name");

                        project1.addMember(new TeamMember(name, id, division));
                        System.out.println("Team member has been added.");
                    }
                    break;
                case 2:
                    boolean b = project1.findByName(getString("Please enter member's name"));
                    if (b) {
                        System.out.println("Member found");
                    }
                    else{
                        System.out.println("Member not found");
                    }
                    break;
                case 3:
                    TeamMember member = project1.getByName(getString("Please enter member's name"));
                    if (member != null) {
                        System.out.println(member.toString());
                    }
                    else {
                        System.out.println("Member not found");
                    }
                    break;
                case 4:
                    member = project1.getByName(getString("Please enter member's name"));
                    if (member != null) {
                        project1.remove(member);
                        System.out.println("Removed successfully");
                    } else {
                        System.out.println("Team member not found");
                    }
                    break;
                case 5:
                    if (project1.getTeamMembersNumber() == 0) {
                        System.out.println("No Members found");
                    }
                    for (TeamMember members : project1.getAllMember()) {
                        System.out.println(members.toString() + '\n');
                    }
                    break;
                case 6:
                    Set<String> answers = new HashSet<String>();
                    answers.add("y");
                    answers.add("Y");

                    String answer= getString("Quit? (y/n)");
                    if (answers.contains(answer)){
                        System.exit(0);
                    }

                    break;
            }

        } while (repeat());
    }

    public static int menu() {

        System.out.println("1 - Add a new team member");
        System.out.println("2 - Find a specific team member");
        System.out.println("3 - Display details of specific team member");
        System.out.println("4 - Remove a specific team member");
        System.out.println("5 - Display all the team members");
        System.out.println("6 - Quit");
        try {
            int option = Input.getInteger("Enter an option: ");
            if (option < 1 || option > 6) {
                System.out.println("Invalid menu option");
                return menu();
            }
            return option;
        } catch (Exception e) {
            System.out.println("Enter a valid option");
        }

        return menu();
    }

    public static Boolean repeat() {
        Boolean result = false;
        Character response;
        response = Input.getCharacter("continue(y/n)?  ");
        if ((response == 'y') || (response == 'Y')) {
            result = true;
        }
        return result;
    }

    private static String getString(String prompt) {
        System.out.println(prompt);
        System.out.print(" > ");
        String input = new Scanner(System.in).nextLine();
        if (input.length() == 0) {
            System.out.println("Please enter a valid value");
            return getString(prompt);
        }
        return input;
    }


    private static Serializable getInt(String prompt, int digits) {
        System.out.println(prompt);
        System.out.print(" > ");
        String input;
        Integer newNum;
        try {
            input = new Scanner(System.in).nextLine();
            if (input.length() != digits) {
                return getInt(prompt, digits);
            }
            newNum = Integer.valueOf(input);
        } catch (Exception e) {
            System.out.println("Please enter an integer");
            return getInt(prompt, digits);
        }
        return input;
    }
}

