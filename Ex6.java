package lab04;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex6 {

    static ArrayList<String[]> loadData(String path) {
        ArrayList<String[]> list = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(path));
            for (int i = 0; i < 3; i++) {
                sc.nextLine();
            }
            while (sc.hasNextLine()) {
                list.add(sc.nextLine().split(","));
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    static void printSummary(String label, ArrayList<String[]> list) {
        int total = list.size();
        int male = 0;
        for (String[] row : list) {
            if (row[1].equals("male")) male++;
        }
        int female = total - male;
        System.out.println(label + ": " + total);
        System.out.printf("  Male: %d (%.2f%%)%n", male, male * 100.0 / total);
        System.out.printf("  Female: %d (%.2f%%)%n", female, female * 100.0 / total);
    }

    static void question1(ArrayList<String[]> list) {
        printSummary("Total candidates", list);
    }

    static void question2(ArrayList<String[]> list) {
        ArrayList<String[]> high = new ArrayList<>();
        for (String[] row : list) {
            if (Double.parseDouble(row[9]) >= 90) high.add(row);
        }
        printSummary("Candidates with average >= 90", high);
    }

    static void question3(ArrayList<String[]> list) {
        int math = 0, english = 0, computer = 0;
        for (String[] row : list) {
            if (Integer.parseInt(row[5]) >= 85) math++;
            if (Integer.parseInt(row[6]) >= 85) english++;
            if (Integer.parseInt(row[7]) >= 85) computer++;
        }
        System.out.println("Math >= 85: " + math);
        System.out.println("English >= 85: " + english);
        System.out.println("Computer >= 85: " + computer);
    }

    static void question4(ArrayList<String[]> list) {
        String[] groups = {"group A", "group B", "group C", "group D", "group E"};
        for (String g : groups) {
            ArrayList<String[]> inGroup = new ArrayList<>();
            for (String[] row : list) {
                if (row[2].equals(g)) inGroup.add(row);
            }
            printSummary(g, inGroup);
        }
    }

    public static void main(String[] args) {
        ArrayList<String[]> data = loadData("lab04/CandidatePerformanceTest.csv");
        question2(data);
        question3(data);
        question4(data);
    }
}