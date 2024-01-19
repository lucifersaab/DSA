package Fakers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class reservation_faker extends Booking_faker{
        public static void main(String[] args) {
            int[] waiters={1,23,25};
            String filePath = "reservation.txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                 for (int i = 1; i <= 50; i++) {
                    int id = i;


                    String query = String.format("INSERT INTO RestaurantReservation (id, member_id, reserve_time, reserve_date, no_of_people, faculty_id) " +
                            "VALUES (%d, %d, '%s', '%s', %d, %d);", id, generateRandomNumber(1,50), generateRandomTime(), GenerateRandomDate(), generateRandomNumber(2,7),waiters[generateRandomNumber(0,2)] );

                    writer.write(query);
                    writer.newLine();
                }

                System.out.println("Queries generated and stored in the file successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

