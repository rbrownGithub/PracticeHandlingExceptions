package org.example;

/**
 * Main class to test Person and Calculator classes.
 */
public class Main {
    public static void main(String[] args) {
        // Test Person class
        testPersonClass();

        // Test Calculator class
        testCalculatorClass();
    }

    /**
     * Tests the Person class with various inputs.
     */
    private static void testPersonClass() {
        System.out.println("Testing Person class:");
        try {
            Person person1 = new Person("John Doe", 30);
            System.out.println("Person created successfully: " + person1.getName() + ", " + person1.getAge());

            @SuppressWarnings("unused")
            Person person2 = new Person("This name is way too long and exceeds forty characters", 25);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught (Person): " + e.getMessage());
        }

        try {
            @SuppressWarnings("unused")
            Person person3 = new Person("Jane Doe", 150);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught (Person): " + e.getMessage());
        }
        System.out.println();
    }

    /**
     * Tests the Calculator class with various inputs.
     */
    private static void testCalculatorClass() {
        System.out.println("Testing Calculator class:");
        Calculator calc = new Calculator();

        try {
            // Test factorial with valid and invalid inputs
            System.out.println("Factorial of 5: " + calc.factorial(5));
            System.out.println("Factorial of -1: " + calc.factorial(-1));
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught (Calculator): " + e.getMessage());
        }

        try {
            // Test binomial coefficient with valid and invalid inputs
            System.out.println("Binomial Coefficient (5,2): " + calc.binomialCoefficient(5, 2));
            System.out.println("Binomial Coefficient (5,6): " + calc.binomialCoefficient(5, 6));
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught (Calculator): " + e.getMessage());
        }
    }
}