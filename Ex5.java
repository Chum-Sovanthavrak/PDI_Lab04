package lab04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex5 {
    static class Student {
        String name;
        int id;
        String gender;

        Student(String name, int id, String gender) {
            this.name = name;
            this.id = id;
            this.gender = gender;
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        try {
            Scanner sc = new Scanner(new File("lab04/Ex3StudentData.csv"));
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(",");
                students.add(new Student(data[0], Integer.parseInt(data[1]), data[2]));
            }
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 1; i <= 3; i++) {
            System.out.println("Please enter new Student " + i + " Name: ");
            String name = input.nextLine();
            System.out.println("Please enter new Student " + i + " ID: ");
            int id = Integer.parseInt(input.nextLine());
            System.out.println("Please enter new Student " + i + " Gender: ");
            String gender = input.nextLine();
            students.add(new Student(name, id, gender));
        }
        input.close();

        students.sort((a, b) -> a.name.compareToIgnoreCase(b.name));

        try {
            FileWriter fw = new FileWriter("lab04/Ex3StudentData.csv");
            for (Student s : students) {
                fw.write(s.name + "," + s.id + "," + s.gender + "\n");
            }
            fw.close();
            System.out.println("Sorted data has been written to lab04/Ex3StudentData.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}