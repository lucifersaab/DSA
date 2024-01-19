package Fakers;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class revenue_faker {
    static String[] source = {
            "Swimming Pool",
            "Tennis Court",
            "Gymnasium",
            "Basketball Court",
            "Yoga Studio",
            "Fitness Center",
            "Running Track",
            "Soccer Field",
            "Squash Court",
            "Badminton Court",
            "Membership Fee",
            "Monthly Charges"
    };
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
            String filePath = "revenue.txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                for (int i = 1; i <= 50; i++) {

                    LocalDate startDateRange = LocalDate.of(2018, 1, 1);
                    LocalDate currentDate = LocalDate.now();

                    String regDeadline;
                        LocalDate randomDate = startDateRange.plusDays(ThreadLocalRandom.current().nextLong(currentDate.toEpochDay() - startDateRange.toEpochDay() + 1));
                        regDeadline = randomDate.toString();
                    String query = "INSERT INTO Revenue (id, rev_type, rev_amount, rev_date, sources) VALUES (" +
                            i + ", '"+revenueTypes[i%9]+"'," + generateRandomNumber(3411,22342)+",'" +regDeadline +"','"+source[i%12]+"');";
                    writer.write(query);
                    writer.newLine();
                }

                System.out.println("Queries generated and saved to " + filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public static int generateRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
