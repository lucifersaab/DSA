package Fakers;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Menu_faker {
    static String[] menuItems = {
            "Biryani",
            "Karahi",
            "Haleem",
            "Nihari",
            "Kebabs",
            "Tandoori Chicken",
            "Seekh Kabab",
            "Chicken Tikka",
            "Chicken Handi",
            "Chapli Kabab",
            "Pulao",
            "Naan",
            "Paratha",
            "Samosa",
            "Pakora",
            "Lassi",
            "Falooda",
            "Gulab Jamun",
            "Jalebi",
            "Kheer",
            "Gajar Halwa",
            "Zarda",
            "Kulfi",
            "Rasmalai",
            "Phirni",
            "Pizza",
            "Burger",
            "Sushi",
            "Tacos",
            "Pad Thai",
            "Sushi",
            "Steak",
            "Pasta",
            "Sushi",
            "Baklava",
            "Croissant",
            "Paella",
            "Hamburger",
            "Dim Sum",
            "Sushi",
            "Fish and Chips",
            "Miso Soup",
            "Biryani",
            "Peking Duck",
            "Tiramisu",
            "Burrito",
            "Sushi",
            "Chicken Shawarma",
            "Sushi"
    };

    static String[] descriptions = {
            "Aromatic rice dish with meat and spices",
            "Spicy and savory meat curry",
            "Slow-cooked lentil and meat stew",
            "Rich and flavorful slow-cooked meat dish",
            "Grilled or skewered meat delicacies",
            "Grilled chicken marinated in spices",
            "Minced meat kebabs",
            "Grilled marinated chicken pieces",
            "Creamy and spicy chicken curry",
            "Spiced ground meat patty",
            "Fragrant rice dish cooked with meat",
            "Traditional flatbread",
            "Layered and flaky unleavened bread",
            "Deep-fried savory pastry filled with potatoes or meat",
            "Deep-fried fritters made with vegetables or meat",
            "Traditional yogurt-based drink",
            "Chilled dessert with vermicelli, syrup, and ice cream",
            "Sweet fried dough balls in syrup",
            "Deep-fried spiral-shaped sweet",
            "Rice pudding with milk, sugar, and nuts",
            "Carrot dessert with milk, sugar, and nuts",
            "Sweet rice dish with dry fruits and nuts",
            "Frozen dairy dessert",
            "Soft cheese dumplings in sweetened milk",
            "Creamy rice pudding with ground rice and nuts",
            "Classic Italian dish with various toppings",
            "Grilled or fried patty in a bun with toppings",
            "Japanese dish of vinegared rice with fish or vegetables",
            "Mexican dish with a tortilla filled with various ingredients",
            "Thai stir-fried rice noodles with meat or shrimp",
            "Japanese dish of vinegared rice with fish or vegetables",
            "Grilled or fried steak",
            "Italian dish with pasta and sauce",
            "Japanese dish of vinegared rice with fish or vegetables",
            "Sweet pastry with nuts and honey",
            "Buttery and flaky French pastry",
            "Spanish rice dish with saffron and various ingredients",
            "Sandwich with a patty, bun, and toppings",
            "Cantonese cuisine of bite-sized food",
            "Japanese dish of vinegared rice with fish or vegetables",
            "Deep-fried battered fish with chips",
            "Japanese soup with soybean paste and ingredients",
            "Aromatic rice dish with meat and spices",
            "Chinese dish of roasted duck",
            "Italian dessert with layers of coffee-soaked biscuits and mascarpone cream",
            "Mexican dish with a tortilla filled with various ingredients",
            "Lebanese dish with grilled, thinly sliced meat in a wrap",
            "Japanese dish of vinegared rice with fish or vegetables"
    };

    static int[] averagePrices = {
            300,
            400,
            250,
            350,
            200,
            350,
            300,
            350,
            400,
            300,
            200,
            50,
            60,
            30,
            40,
            80,
            100,
            70,
            60,
            50,
            80,
            90,
            60,
            70,
            50,
            600,
            300,
            800,
            500,
            400,
            800,
            700,
            400,
            900,
            200,
            300,
            400,
            500,
            150,
            800,
            300,
            700,
            200,
            400,
            500,
            600,
            300,
            400,
            500,
            600
    };



        public static void main(String[] args) {
            String filePath = "menu.txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                for (int i = 1; i < 50; i++) {
                    String query = String.format("INSERT INTO Menu (id, item_name, price, description) VALUES (%d, '%s', %d, '%s');", i, menuItems[i%48], averagePrices[i%48],descriptions[i%48]);
                    writer.write(query);
                    writer.newLine();
                }

                System.out.println("Queries generated and stored successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


}
