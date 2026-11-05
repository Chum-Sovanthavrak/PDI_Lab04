package lab04;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex4 {
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
        try{
        Scanner sc = new Scanner(new File("lab04/Ex3StudentData.csv"));
        while(sc.hasNextLine()) {
            String[] data = sc.nextLine().split(",");
            String name = data[0];
            int id = Integer.parseInt(data[1]);
            String gender = data[2];
            students.add(new Student(name, id, gender));
            
        } 
        sc.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        for(Student student : students) {
            System.out.println("Name: " + student.name + ", ID: " + student.id + ", Gender: " + student.gender);
        }
        
    }
}
