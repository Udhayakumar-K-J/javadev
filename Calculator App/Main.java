import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Prompt user for input
            System.out.print("Enter the first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter the second number: ");
            double num2 = scanner.nextDouble();

            System.out.print("Enter an operator (+, -, *, /): ");
            char operator = scanner.next().charAt(0);

            double result;

            // Perform operation based on the operator
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    System.out.println("Result: " + result);
                    break;

                case '-':
                    result = num1 - num2;
                    System.out.println("Result: " + result);
                    break;

                case '*':
                    result = num1 * num2;
                    System.out.println("Result: " + result);
                    break;

                case '/':
                    if (num2 == 0) {
                        throw new ArithmeticException("Division by zero is not allowed.");
                    }
                    result = num1 / num2;
                    System.out.println("Result: " + result);
                    break;

                default:
                    System.out.println("Invalid operator. Please enter one of +, -, *, /.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Calculator app closed.");
        }
    }
}
