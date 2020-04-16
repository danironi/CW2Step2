package step2;

import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CompanyTest {

    private static Company testCompany = new Company("Test", 001);

    public static void main(String[] args) {

        do {

            switch (menu()) {
                case 1:
                    String title = getString("Please enter project title");
                    if (testCompany.findByTitle(title)) {
                        System.out.println("Project already exists by this name");
                    } else {
                        Date start, end;
                        while (true) {
                            start = getDate("Please enter project starting date");
                            end = getDate("Please enter project ending date");
                            if (end.before(start)) {
                                System.out.println("End date should be after start date");
                            } else {
                                break;
                            }
                        }
                        testCompany.addProject(new Project(title, start, end));
                        System.out.println("Project added");
                    }
                    break;

                case 2:
                    boolean b = testCompany.findByTitle(getString("Please enter project title"));
                    if (b){
                        System.out.println("Project found");
                    }
                    else{
                        System.out.println("Project not found");
                    }
                    break;
                case 3:
                    Project p = testCompany.getByTitle(getString("Please enter project title"));
                    if (p != null) {
                        System.out.println(p.toString());
                    }
                    else {
                        System.out.println("Project not found");
                    }
                    break;

                case 4:
                    p = testCompany.getByTitle(getString("Please enter project title"));
                    if (p != null) {
                        testCompany.remove(p);
                        System.out.println("Removed successfully");
                    } else {
                        System.out.println("Project not found");
                    }
                    break;
                case 5:
                    if (testCompany.getProjectsNumber() == 0) {
                        System.out.println("No Projects");
                    }
                    for (Project pj : testCompany.getSortedList()) {
                        System.out.println(pj.toString()+'\n');
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
        }while (repeat());
    }

    public static int menu() {

        System.out.println("1 - Add a new project");
        System.out.println("2 - Find a specific project");
        System.out.println("3 - Display details of specific project");
        System.out.println("4 - Remove a specific project");
        System.out.println("5 - Display all the projects");
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

    private static int getInt(String prompt, int lowerLimit, int upperLimit) {
        System.out.println(prompt);
        System.out.print(" > ");
        int input;
        try {
            input = new Scanner(System.in).nextInt();
        } catch (Exception e) {
            System.out.println("Please enter an integer");
            return getInt(prompt, lowerLimit, upperLimit);
        }
        if (input < lowerLimit || input > upperLimit) {
            System.out.println("Please enter a value between " + lowerLimit + " and " + upperLimit);
            return getInt(prompt, lowerLimit, upperLimit);
        }
        return input;
    }

    private static Date getDate(String prompt) {
        System.out.println(prompt);
        int day, month, year;
        day = getInt("Please enter day", 1, 31);
        month = getInt("Please enter month", 1, 12) - 1;
        year = getInt("Please enter year", 2020, 2024) - 1900;
        Date date = new Date(year, month, day);
        return date;
    }

}

