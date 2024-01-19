package Fakers;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class facility_faker {


        public static void main(String[] args) {
            String filePath = "facilities.txt";
            String[] gymkhanaFacilityTypes = {
                    "Swimming Pool",
                    "Tennis Court",
                    "Gymnasium",
                    "Basketball Court",
                    "Yoga Studio",
                    "Fitness Center",
                    "Running Track",
                    "Soccer Field",
                    "Squash Court",
                    "Badminton Court"
            };

            String[] facilityLocations = {
                    "Main Building, 1st Floor",
                    "Outdoor Area, Next to Clubhouse",
                    "Fitness Center, Basement Level",
                    "Sports Complex, East Wing",
                    "Wellness Center, 2nd Floor",
                    "Recreation Center, Ground Floor",
                    "Outdoor Track Field, Behind the Gymnasium",
                    "Sports Ground, West Side",
                    "Indoor Sports Complex, 3rd Floor"
            };


            String[] arr={"yes","no"};


            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                for (int i = 1; i <= 10; i++) {
                    int rand=generateRandomNumber(20,40);
                    int ind=generateRandomNumber(0,1);
                    String query = String.format("INSERT INTO Facilities (id, faci_type, faci_location, availibility, capacity) VALUES (%d, '%s', ' %s', '%s' , %d);", i, gymkhanaFacilityTypes[i%8],facilityLocations[i%8], arr[ind%8], rand);
                    writer.write(query);
                    writer.newLine();
                }

                System.out.println("Queries generated and stored successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    public static int generateRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
