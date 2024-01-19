package DSA;
import java.util.Scanner;

class VirtualPet {
    private final String name;
    private int hunger;
    private int happiness;
    private int energy;

    public VirtualPet(String name) {
        this.name = name;
        this.hunger = 50;
        this.happiness = 50;
        this.energy = 50;
    }

    public void feed() {
        System.out.println("You feed " + name);
        hunger -= 20;
        happiness += 10;
        energy += 10;
    }

    public void play() {
        System.out.println("You play with " + name);
        hunger += 10;
        happiness += 20;
        energy -= 10;
    }

    public void sleep() {
        System.out.println("You put " + name + " to sleep");
        hunger += 10;
        happiness -= 10;
        energy += 20;
    }

    public void showStats() {
        System.out.println("----- " + name + "'s Stats -----");
        System.out.println("Hunger: " + hunger);
        System.out.println("Happiness: " + happiness);
        System.out.println("Energy: " + energy);
        System.out.println("-------------------------");
    }
}

class VirtualPetGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your pet's name: ");
        String petName = scanner.nextLine();

        VirtualPet pet = new VirtualPet(petName);

        boolean exit = false;

        while (!exit) {
            System.out.println("-------------------------");
            System.out.println("1. Feed");
            System.out.println("2. Play");
            System.out.println("3. Sleep");
            System.out.println("4. Show Stats");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character after reading the choice

            switch (choice) {
                case 1 -> pet.feed();
                case 2 -> pet.play();
                case 3 -> pet.sleep();
                case 4 -> pet.showStats();
                case 5 -> exit = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Exiting the game. Goodbye!");
    }
}
