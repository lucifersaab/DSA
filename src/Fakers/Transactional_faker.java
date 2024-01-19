package Fakers;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Transactional_faker extends Booking_faker{

        public static void main(String[] args) {
            String filePath = "Transaction.txt"; // Specify the file path where you want to store the queries

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                // Generate and store sample queries
                for (int i = 1; i <= 50; i++) {
                    String id = Integer.toString(i);


                    String query = String.format("INSERT INTO Transactions (id, t_date, t_time, t_amount, t_type, member_id, booking_id) " +
                            "VALUES (%s, '%s', '%s', %s, '%s', %s, %s);", id, GenerateRandomDate(), generateRandomTime(), generateRandomNumber(1231,85685), revenueTypes[i], generateRandomNumber(1,50), generateRandomNumber(1,50));

                    writer.write(query);
                    writer.newLine();
                }

                System.out.println("Queries generated and stored successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
