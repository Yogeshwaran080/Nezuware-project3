import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Temperature Converter!");

        while (true) {
            try {
                // Prompt the user to enter the temperature value
                System.out.print("Enter the temperature value: ");
                double temperature = scanner.nextDouble();

                // Prompt the user for the source scale
                System.out.println("Select the source scale:");
                System.out.println("1. Celsius");
                System.out.println("2. Fahrenheit");
                System.out.println("3. Kelvin");
                System.out.print("Enter your choice (1-3): ");
                int sourceScale = scanner.nextInt();

                // Prompt the user for the target scale
                System.out.println("Select the target scale:");
                System.out.println("1. Celsius");
                System.out.println("2. Fahrenheit");
                System.out.println("3. Kelvin");
                System.out.print("Enter your choice (1-3): ");
                int targetScale = scanner.nextInt();

                // Perform the conversion
                double convertedTemperature = convertTemperature(temperature, sourceScale, targetScale);

                // Display the result
                System.out.printf("Converted Temperature: %.2f%n", convertedTemperature);

                // Ask if the user wants to perform another conversion
                System.out.print("Do you want to perform another conversion? (yes/no): ");
                scanner.nextLine(); // Clear buffer
                String continueChoice = scanner.nextLine().trim().toLowerCase();
                if (!continueChoice.equals("yes")) {
                    System.out.println("Thank you for using the Temperature Converter. Goodbye!");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine(); // Clear the invalid input
            }
            System.out.println(); // Add a blank line for readability
        }

        scanner.close();
    }

    /**
     * Converts the temperature between the specified scales.
     *
     * @param temperature  the temperature to convert
     * @param sourceScale  the source temperature scale (1: Celsius, 2: Fahrenheit, 3: Kelvin)
     * @param targetScale  the target temperature scale (1: Celsius, 2: Fahrenheit, 3: Kelvin)
     * @return the converted temperature
     */
    private static double convertTemperature(double temperature, int sourceScale, int targetScale) {
        if (sourceScale == targetScale) {
            return temperature; // No conversion needed
        }

        double tempInCelsius;

        // Convert source temperature to Celsius
        switch (sourceScale) {
            case 1: // Celsius
                tempInCelsius = temperature;
                break;
            case 2: // Fahrenheit
                tempInCelsius = (temperature - 32) * 5 / 9;
                break;
            case 3: // Kelvin
                tempInCelsius = temperature - 273.15;
                break;
            default:
                throw new IllegalArgumentException("Invalid source scale.");
        }

        // Convert Celsius to target temperature scale
        switch (targetScale) {
            case 1: // Celsius
                return tempInCelsius;
            case 2: // Fahrenheit
                return (tempInCelsius * 9 / 5) + 32;
            case 3: // Kelvin
                return tempInCelsius + 273.15;
            default:
                throw new IllegalArgumentException("Invalid target scale.");
        }
    }
}
