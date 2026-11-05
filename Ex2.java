package lab04;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class Ex2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of files: ");
        int n = sc.nextInt();
        String name;
        Random r = new Random();
        sc.close();
        String folderPath = "lab04/Ex2LuckyNumber";
            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs();
            }
        for(int k = 1; k <= n ; k++){
            int randomNumber = r.nextInt(100) + 1;
            name = "file" + k + ".csv";
            File file = new File(folder, name);
            try {
                FileWriter fw = new FileWriter(file);
                for(int i = 1; i < 10 ; i++) {
                    fw.write(randomNumber + "\n");
                }
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            }
            ArrayList<Integer> numbers = new ArrayList<>();
            for  (int o = 1; o <= n; o++) {
                File file1 = new File(folder, "file" + o + ".csv");
                try {
                    Scanner reader = new Scanner(file1);
                    while (reader.hasNextLine()) {
                        numbers.add(Integer.parseInt(reader.nextLine()));
                    }
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Max: " + Collections.max(numbers));
            System.out.println("Min: " + Collections.min(numbers));


        }
        
        
    }
        