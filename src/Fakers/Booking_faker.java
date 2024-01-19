package Fakers;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class Booking_faker extends faker{

    static String[] revenueTypes = {
            "Sales",
            "Advertising",
            "Subscription",
            "Consulting",
            "Rental",
            "Licensing",
            "Royalties",
            "Service Fees",
            "Product Returns"
    };

        public static void main(String[] args) {
            String filePath = "booking_queries.txt";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                String [] available={"booked","available"};
                for (int i = 1; i <= 50; i++) {

                    String query = "INSERT INTO Booking (id, booking_date, booking_time, facility_id, member_id, revenue_id, cost_id, book_status) VALUES ("
                            + i + ", '"+GenerateRandomDate()+"', '"+generateRandomTime()+"', " + generateRandomNumber(1,8) + ", " + generateRandomNumber(1,50) + ", " + generateRandomNumber(1,50) + ", " + generateRandomNumber(1,50) + ", '"+available[generateRandomNumber(0,1)]+"');";
                    writer.write(query);
                    writer.newLine();
                }

                System.out.println("Queries generated and saved to file.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public static String generateRandomTime() {
        int hour = ThreadLocalRandom.current().nextInt(0, 24);
        int minute = ThreadLocalRandom.current().nextInt(0, 60);
        int second = ThreadLocalRandom.current().nextInt(0, 60);

        String formattedHour = String.format("%02d", hour);
        String formattedMinute = String.format("%02d", minute);
        String formattedSecond = String.format("%02d", second);

        return formattedHour + ":" + formattedMinute + ":" + formattedSecond;
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
