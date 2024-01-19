package Fakers;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class event_faker {


        public static void main(String[] args) {
            String filePath = "events.txt";

            LocalDate startDateRange = LocalDate.of(2018, 1, 1);
            LocalDate currentDate = LocalDate.now();

            String[] regDeadline = new String[50];
            for (int i = 0; i < 50; i++) {
                LocalDate randomDate = startDateRange.plusDays(ThreadLocalRandom.current().nextLong(currentDate.toEpochDay() - startDateRange.toEpochDay() + 1));
                regDeadline[i] = randomDate.toString();
            } String[] foodCompanyNames = {
                    "Tasty Treats",
                    "FreshBites",
                    "Delicious Delights",
                    "Gourmet Goodies",
                    "Nourish & Co.",
                    "Flavor Fusion",
                    "Savory Spice",
                    "Quality Eats",
                    "Yummy Munchies",
                    "Taste Haven",
                    "Crunchy Cravings",
                    "Organic Oasis",
                    "Pure Plates",
                    "Wholesome Harvest",
                    "Dairy Delights",
                    "Farm Fresh Foods",
                    "Healthy Nibbles",
                    "Sweet Sensations",
                    "Tasty Temptations",
                    "Satisfy & Co.",
                    "Sips & Snacks",
                    "Hearty Bites",
                    "Tropical Tastes",
                    "Spicy Delights",
                    "Treats Galore",
                    "Cocoa Corner",
                    "Nature's Bounty",
                    "Fresh Catch",
                    "The Grains Emporium",
                    "NutriNectar",
                    "Juicy Juices",
                    "Flourish Foods",
                    "MunchBox",
                    "Zesty Zing",
                    "Crispy Crunch",
                    "The Dairy Patch",
                    "Garden Greens",
                    "Flavorful Feasts",
                    "Wholesome Snacks",
                    "The Spice Emporium",
                    "Sweet Tooth Delights",
                    "Pure Pleasures",
                    "Farm Fresh Fare",
                    "Healthy Mornings",
                    "Satisfying Sips",
                    "Crave Cuisine",
                    "Nuts & Seeds",
                    "ChocoLicious",
                    "Freshly Frozen",
                    "Taste Tempters"
            };
            String[] eventData = {
                    "Conference on Artificial Intelligence",
                    "Workshop: Web Development Techniques",
                    "Networking Dinner & Awards Ceremony",
                    "Product Launch: New Smartphone Series",
                    "Seminar on Digital Marketing Strategies",
                    "Panel Discussion: Future of Technology",
                    "Hackathon: Building Innovative Solutions",
                    "Exhibition: Art and Creativity Showcase",
                    "Training Program: Leadership Skills",
                    "Music Concert: Jazz Night",
                    "Trade Show: Fashion and Lifestyle",
                    "Sports Tournament: Football Championship",
                    "Charity Gala: Fundraising for a Cause",
                    "Industry Symposium: Renewable Energy",
                    "Movie Night: Outdoor Cinema Experience",
                    "Career Fair: Connecting Job Seekers and Employers",
                    "Fashion Show: Latest Trends and Designs",
                    "Health and Wellness Expo: Fitness and Nutrition",
                    "Art Workshop: Painting Techniques",
                    "Startup Pitch Competition: Entrepreneurship",
                    "Book Reading and Signing: Bestselling Authors",
                    "Tech Conference: Emerging Technologies",
                    "Culinary Festival: Food Tasting and Demonstrations",
                    "Educational Seminar: Study Abroad Opportunities",
                    "Motivational Speaker Series: Personal Growth",
                    "Photography Exhibition: Capturing Moments",
                    "Automotive Show: Cars and Motorcycles",
                    "Science Fair: Discovering Innovations",
                    "Comedy Show: Stand-Up Comedy Night",
                    "Career Development Workshop: Resume Writing",
                    "Wellness Retreat: Mindfulness and Meditation",
                    "E-commerce Conference: Online Business Strategies",
                    "Artisan Market: Handcrafted Goods",
                    "Environmental Awareness Campaign: Go Green",
                    "Tech Startup Demo Day: Showcasing Innovations",
                    "Dance Performance: Cultural Extravaganza",
                    "Finance Seminar: Investment Strategies",
                    "Theater Play: Dramatic Performances",
                    "Science Fiction Convention: Pop Culture Celebration",
                    "Fitness Boot Camp: Intensive Workout Sessions",
                    "Sustainability Conference: Eco-friendly Solutions",
                    "Gaming Tournament: eSports Championship",
                    "Charity Run: Raising Funds for a Cause",
                    "Virtual Reality Experience: Immersive Technology",
                    "Music Festival: Live Performances and Bands",
                    "Career Workshop: Interview Skills",
                    "Design Exhibition: Creative Works Display",
                    "Wellness Conference: Health and Happiness",
                    "Literary Festival: Author Talks and Readings",
                    "Art Therapy Workshop: Expressive Healing",
                    "Entrepreneurship Summit: Business Strategies"
            };

            String[] eventdetail = {
                    "Explore the latest trends and advancements in AI.",
                    "Learn modern web development tools and practices.",
                    "Connect with industry professionals and celebrate achievements.",
                    "Witness the unveiling of the latest smartphone innovations.",
                    "Discover effective strategies for digital marketing success.",
                    "Engage in insightful discussions on the future of technology.",
                    "Collaborate and create innovative solutions within a time constraint.",
                    "Immerse yourself in a display of artistic expressions and creativity.",
                    "Enhance your leadership abilities through a comprehensive training program.",
                    "Experience a captivating evening of soulful jazz music performances.",
                    "Discover the latest trends in fashion and lifestyle products.",
                    "Witness thrilling football matches among top teams.",
                    "Support a noble cause while enjoying an elegant evening.",
                    "Learn about sustainable energy solutions and industry advancements.",
                    "Enjoy a movie screening under the stars with friends and family.",
                    "Explore job opportunities and connect with potential employers.",
                    "Witness the glamour and creativity of the fashion industry.",
                    "Discover the latest health and wellness products and services.",
                    "Learn various painting techniques from skilled artists.",
                    "Showcase your startup idea and compete for valuable prizes.",
                    "Meet renowned authors and get your books signed.",
                    "Stay updated with the latest advancements in technology.",
                    "Indulge in a culinary journey with delicious food and live cooking demonstrations.",
                    "Explore study abroad options and get guidance from experts.",
                    "Gain inspiration and motivation from renowned speakers.",
                    "Appreciate the art of photography through captivating visual displays.",
                    "Discover the latest models and innovations in the automotive industry.",
                    "Explore scientific experiments and inventions by young minds.",
                    "Laugh out loud with hilarious stand-up comedy performances.",
                    "Learn effective techniques for crafting impressive resumes.",
                    "Relax and rejuvenate through meditation and wellness practices.",
                    "Gain insights into successful online business strategies.",
                    "Shop for unique and handcrafted products by talented artisans.",
                    "Promote environmental sustainability and eco-friendly practices.",
                    "Witness innovative startups pitching their groundbreaking ideas.",
                    "Enjoy vibrant dance performances representing diverse cultures.",
                    "Learn about smart investment strategies and financial planning.",
                    "Immerse yourself in compelling theatrical productions.",
                    "Delve into the world of science fiction and popular culture.",
                    "Challenge yourself with intense fitness workouts and training.",
                    "Explore sustainable practices for a greener future.",
                    "Compete in thrilling gaming tournaments and showcase your skills.",
                    "Participate in a charity run to support a worthy cause.",
                    " Dive into virtual reality and experience immersive digital worlds.",
                    "Enjoy live music performances from talented artists and bands.",
                    "Enhance your interview skills and boost your chances of landing your dream job.",
                    "Admire innovative design works and creative art installations.",
                    "Discover strategies for holistic wellness and personal well-being.",
                    "Engage with renowned authors through insightful talks and readings.",
                    "Experience the therapeutic benefits of art and creative expression.",
                    "Learn from successful entrepreneurs and gain valuable business insights."
            };




            String[] eventLocation = {"Ground 1", "Ground 2","Hall 3","Hall 2", "Hall 1","Ground 3"};
            String[] eventStatus={"completed", "active", "pending"};
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                String query1 = "INSERT INTO Events (id, e_name, e_data, e_time, e_location, e_description, organizer, reg_deadline, event_status, max_capacity, cost_id) values ";
                for (int i = 1; i <= 1000; i++) {
                    String eventName = "Event " + i;
                    int randomNumber1 = generateRandomNumber(0, 5);
                    int randomNumber = generateRandomNumber(1, 10);

                    int statrandom=generateRandomNumber(0,2);
                    int maxCapacity = generateRandomNumber(100,600);
                    String randomTime = generateRandomTime();
                    String query = String.format(" (%d, '%s', '%s', '%s', '%s', '%s', '%s', '%s', %d, %d),",
                            i, eventData[i%randomNumber], randomTime, eventLocation[randomNumber1], eventdetail[i%randomNumber], foodCompanyNames[i%49%randomNumber], regDeadline[i%49%randomNumber], eventStatus[statrandom], maxCapacity, i);

                    writer.write(query);
                    writer.newLine();
                }

                System.out.println("Queries generated and stored successfully.");
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
    public static int generateRandomNumber(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
