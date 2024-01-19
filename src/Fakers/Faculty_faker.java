package Fakers;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;


public class Faculty_faker extends faker{
    static String[] designations = {
            "Fitness Trainer",
            "Yoga Instructor",
            "Sports Coordinator",
            "Nutritionist",
            "Exercise Instructor",
            "Gym Manager",
            "Sports Coach",
            "Restaurant Manager",
            "Head Chef",
            "Waiter/Waitress",
            "Kitchen Staff",
            "Cleaning Supervisor",
            "Janitor",
            "Guard"
    };
        public static void main(String[] args) {
            String filePath = "faculty.txt";
            faker obj=new faker();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                for (int i = 1; i <= 32; i++) {
                    String email = "faculty" + i + "@gymkhana.com";

                    // Create the INSERT query
                    String query = String.format("INSERT INTO Faculty (id, name, designation, salary, joining_date, email) " +
                            "VALUES (%d, '%s', '%s', %s, '%s', '%s'),", i, obj.names[i], designations[generateRandomNumber(1,100)  %13], generateRandomNumber(30000,80000),GenerateRandomDate(), email);

                    // Write the query to the file
                    writer.write(query);
                    writer.newLine();
                }

                System.out.println("Queries generated and stored in the file successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    public static String GenerateRandomDate(){
        LocalDate startDateRange = LocalDate.of(2018, 1, 1);
        LocalDate currentDate = LocalDate.now();

        String regDeadline;
        LocalDate randomDate = startDateRange.plusDays(ThreadLocalRandom.current().nextLong(currentDate.toEpochDay() - startDateRange.toEpochDay() + 1));
        regDeadline = randomDate.toString();
        return regDeadline;
    }
    }
