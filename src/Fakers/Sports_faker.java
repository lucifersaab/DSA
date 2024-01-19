package Fakers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Sports_faker {

        public static void main(String[] args) {
            String[] arr={"Tennis","Aerobics","Basketball","Yoga","Workout","Cardio","Races","Marathon","Football","Swimming"};

            String filePath = "sport.txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

                for (int i = 1; i <= 10; i++) {

                    String query = String.format("INSERT INTO Sports (id, s_name, facility_id) VALUES (%d, '%s', %d);", i, arr[i%10], i);

                    writer.write(query);
                    writer.newLine();
                }

                System.out.println("Queries generated and stored successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


}
