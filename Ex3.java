package lab04;

import java.io.FileWriter;
import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            FileWriter fw = new FileWriter("lab04/Ex3StudentData.csv");
            for (int i = 1; i <= 3; i++){
                System.out.println("Please enter Student " + i + " Name: ");
                String name = input.nextLine();
                System.out.println("Please enter Student " + i + " ID: ");
                int id = input.nextInt();
                input.nextLine(); 
                System.out.println("Please enter Student " + i + " Gender: ");
                String gender = input.nextLine();
                fw.write(name + "," + id + "," + gender + "\n");
            }
            fw.close();
            System.out.println("Data has been written to lab04/Ex3StudentData.csv");

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred.");
        } finally {
            input.close();
        }
    }
}
