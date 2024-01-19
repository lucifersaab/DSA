package Fakers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class cost_faker {

        public static void main(String[] args) {
            String filePath = "data.txt"; // Specify the file path where you want to create the flat file

            LocalDate startDateRange = LocalDate.of(2018, 1, 1);
            LocalDate currentDate = LocalDate.now();

            String[] startDates = new String[50];
            for (int i = 0; i < 50; i++) {
                LocalDate randomDate = startDateRange.plusDays(ThreadLocalRandom.current().nextLong(currentDate.toEpochDay() - startDateRange.toEpochDay() + 1));
                startDates[i] = randomDate.toString();
            }
            String[] costTypes = {
                    "Annual Membership Fee",
                    "Swimming Pool Access",
                    "Tennis Court Rental",
                    "Fitness Class - Yoga",
                    "Fitness Class - Zumba",
                    "Fitness Class - Pilates",
                    "Golf Course Green Fee",
                    "Basketball Court Rental",
                    "Squash Court Rental",
                    "Table Tennis Membership",
                    "Badminton Court Rental",
                    "Pool Table Rental",
                    "Bowling Alley Rental",
                    "Sauna Access",
                    "Spa Treatment - Massage",
                    "Spa Treatment - Facial",
                    "Spa Treatment - Body Scrub",
                    "Kids Club Membership",
                    "Karate Class - Beginner",
                    "Karate Class - Intermediate",
                    "Karate Class - Advanced",
                    "Boxing Class - Beginner",
                    "Boxing Class - Intermediate",
                    "Boxing Class - Advanced",
                    "Dance Class - Ballet",
                    "Dance Class - Hip Hop",
                    "Dance Class - Salsa",
                    "Painting Workshop",
                    "Pottery Class",
                    "Cooking Class - Italian Cuisine",
                    "Cooking Class - Asian Cuisine",
                    "Cooking Class - Baking",
                    "Wine Tasting Event",
                    "Beer Tasting Event",
                    "Outdoor Adventure Trip - Hiking",
                    "Outdoor Adventure Trip - Camping",
                    "Outdoor Adventure Trip - Kayaking",
                    "Movie Night - Family",
                    "Movie Night - Action Movies",
                    "Movie Night - Comedy Movies",
                    "Live Music Performance",
                    "Stand-up Comedy Show",
                    "Charity Fundraising Event",
                    "Trivia Night",
                    "Photography Exhibition",
                    "Book Club Membership",
                    "Chess Club Membership",
                    "Escape Room Challenge",
                    "Art and Craft Fair"
            };


            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                // Write the header line
                writer.write("id,cost_type,cost_amount,cost_date,category");
                writer.newLine();

                // Generate and write sample data
                for (int i = 0; i < 50; i++) {
                    String id = Integer.toString(i+1);
                    String costType = "Cost Type " + i;
                    BigDecimal costAmount = BigDecimal.valueOf(i * 10);
                    String category = "Category " + i;
                    int randomNumber = generateRandomNumber(4, 6);
                    String line = String.format("INSERT INTO Cost (id, cost_type, cost_amount, cost_date, category) VALUES (%s, '%s', %s, '%s', '%s');", id, costTypes[i%48], randomNumber, startDates[i], category);
                    writer.write(line);
                    writer.newLine();
                }

                System.out.println("Flat file created successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    public static int generateRandomNumber(int minDigits, int maxDigits) {
        Random random = new Random();
        int min = (int) Math.pow(10, minDigits - 1);
        int max = (int) Math.pow(10, maxDigits) - 1;
        return random.nextInt(max - min + 1) + min;
    }

}

