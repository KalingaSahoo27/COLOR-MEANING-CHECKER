import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ColorMeaningChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> colorMeanings = new HashMap<>();

        // Predefined color meanings
        colorMeanings.put("Red", "Symbolizes passion, energy, and love");
        colorMeanings.put("Blue", "Symbolizes calm, stability, and trust");
        colorMeanings.put("Green", "Symbolizes growth, harmony, and freshness");
        colorMeanings.put("Yellow", "Symbolizes happiness, optimism, and creativity");
        colorMeanings.put("Black", "Symbolizes power, elegance, and mystery");
        colorMeanings.put("White", "Symbolizes purity, innocence, and simplicity");

        System.out.println("🎨 Welcome to the Color Meaning Checker!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Check color meaning");
            System.out.println("2. Add a new color meaning");
            System.out.println("3. View all available colors");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter a color name: ");
                    String inputColor = scanner.nextLine().trim();

                    if (inputColor.isEmpty()) {
                        System.out.println("❗Input cannot be blank. Try again.");
                    } else if (colorMeanings.containsKey(inputColor)) {
                        System.out.println("✅ Meaning of " + inputColor + ": " + colorMeanings.get(inputColor));
                    } else {
                        System.out.println("❌ Color not found. Try again.");
                    }
                    break;

                case "2":
                    System.out.print("Enter a new color name: ");
                    String newColor = scanner.nextLine().trim();

                    if (newColor.isEmpty()) {
                        System.out.println("❗Color name cannot be blank.");
                        break;
                    }

                    if (colorMeanings.containsKey(newColor)) {
                        System.out.println("⚠️ This color already exists.");
                    } else {
                        System.out.print("Enter the meaning for " + newColor + ": ");
                        String meaning = scanner.nextLine().trim();
                        if (meaning.isEmpty()) {
                            System.out.println("❗Meaning cannot be blank.");
                        } else {
                            colorMeanings.put(newColor, meaning);
                            System.out.println("✅ Color added successfully.");
                        }
                    }
                    break;

                case "3":
                    System.out.println("📋 Available colors:");
                    for (String color : colorMeanings.keySet()) {
                        System.out.println("- " + color);
                    }
                    break;

                case "4":
                    System.out.println("👋 Exiting the application. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("❗Invalid choice. Please select a valid option (1-4).");
            }
        }
    }
}
