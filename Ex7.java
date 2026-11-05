package lab04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex7 {

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

    static void processGroup(String group, ArrayList<String[]> list) {
        ArrayList<String[]> inGroup = new ArrayList<>();
        int male = 0;
        for (String[] row : list) {
            if (row[2].equals(group)) {
                inGroup.add(row);
                if (row[1].equals("male")) male++;
            }
        }

        int total = inGroup.size();
        int female = total - male;
        String maleText = String.format("%d (%.2f%%)", male, male * 100.0 / total);
        String femaleText = String.format("%d (%.2f%%)", female, female * 100.0 / total);

        System.out.println(group + ": " + total);
        System.out.println("  Male: " + maleText);
        System.out.println("  Female: " + femaleText);

        String fileName = "lab04/" + group.replace(" ", "") + ".csv";
        try {
            FileWriter fw = new FileWriter(fileName);
            for (String[] row : inGroup) {
                fw.write(String.join(",", row) + "\n");
            }
            fw.write("Total students," + total + "\n");
            fw.write("Male," + maleText + "\n");
            fw.write("Female," + femaleText + "\n");
            fw.close();
            System.out.println("  Saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArrayList<String[]> data = loadData("lab04/CandidatePerformanceTest.csv");
        String[] groups = {"group A", "group B", "group C", "group D"};
        for (String g : groups) {
            processGroup(g, data);
        }
    }
}