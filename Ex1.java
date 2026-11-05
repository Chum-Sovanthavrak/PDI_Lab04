package lab04;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.io.File;


public class Ex1{
    public static void main(String[] args) {
        Random r = new Random();
        
        try{
            FileWriter fw = new FileWriter("LuckyNumber.csv");
            for(int i = 1; i <= 500; i++) {
                int luckyNumber = r.nextInt(10000);
                fw.write(luckyNumber + "\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
       
        try{
            Scanner sc = new Scanner(new File("LuckyNumber.csv"));
            while(sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

