import java.util.Scanner;

public class EulerMethod {

    // Differential equations
    public static double derivative(int choice, double x, double y) {

        switch (choice) {
            case 1:
                return x + y;

            case 2:
                return x - y;

            case 3:
                return x * y;

            case 4:
                return y;

            case 5:
                return x * x + y;

            default:
                return 0;
        }
    }

    // Double input with quit option
    public static double getDoubleInput(Scanner input, String prompt) {

        while (true) {

            System.out.print(prompt);
            String userInput = input.nextLine();

            if (userInput.equalsIgnoreCase("quit")) {
                System.out.println("Program terminated.");
                System.exit(0);
            }

            try {
                return Double.parseDouble(userInput);
            }
            catch (NumberFormatException e) {
                System.out.println("Please enter a valid number or type 'quit'.");
            }
        }
    }

    // Integer input with quit option
    public static int getIntInput(Scanner input, String prompt) {

        while (true) {

            System.out.print(prompt);
            String userInput = input.nextLine();

            if (userInput.equalsIgnoreCase("quit")) {
                System.out.println("Program terminated.");
                System.exit(0);
            }

            try {
                return Integer.parseInt(userInput);
            }
            catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer or type 'quit'.");
            }
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println("     Euler's Method Calculator");
        System.out.println("==================================");
        System.out.println("Type 'quit' at any prompt to exit.\n");

        System.out.println("Choose a differential equation:");
        System.out.println("1. dy/dx = x + y");
        System.out.println("2. dy/dx = x - y");
        System.out.println("3. dy/dx = x * y");
        System.out.println("4. dy/dx = y");
        System.out.println("5. dy/dx = x^2 + y");

        int equation;

        while (true) {

            equation = getIntInput(input, "\nChoice: ");

            if (equation >= 1 && equation <= 5) {
                break;
            }

            System.out.println("Please choose a number from 1 to 5.");
        }

        double x = getDoubleInput(input, "\nInitial x value: ");
        double y = getDoubleInput(input, "Initial y value: ");

        double dx = getDoubleInput(input, "Step size (Δx): ");
        int steps = getIntInput(input, "Number of steps: ");

        System.out.println("\nPoints:");
        System.out.printf("(%.4f, %.4f)%n", x, y);

        for (int i = 0; i < steps; i++) {

            double slope = derivative(equation, x, y);

            y = y + slope * dx;
            x = x + dx;

            System.out.printf("(%.4f, %.4f)%n", x, y);
        }

        System.out.println("\nFinal Point:");
        System.out.printf("(%.4f, %.4f)%n", x, y);

        input.close();
    }
}