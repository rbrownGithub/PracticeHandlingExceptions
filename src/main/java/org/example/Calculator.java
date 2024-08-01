package org.example;

/**
 * Provides mathematical calculations with parameter validation.
 */
public class Calculator {
    /**
     * Calculates the factorial of a non-negative integer.
     * @param num The number to calculate factorial for
     * @return The factorial of the input number
     * @throws IllegalArgumentException if num is negative
     */
    public int factorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Factorial is only defined for non-negative integers.");
        }

        int factorial = 1;
        for (int i = 2; i <= num; i++) {
            factorial *= i;
        }
        return factorial;
    }

    /**
     * Calculates the binomial coefficient (n choose k).
     * @param setSize The size of the set (n)
     * @param subsetSize The size of the subset (k)
     * @return The binomial coefficient
     * @throws IllegalArgumentException if parameters are invalid
     */
    public int binomialCoefficient(int setSize, int subsetSize) {
        // Validate input parameters
        if (setSize < 0 || subsetSize < 0) {
            throw new IllegalArgumentException("Both set size and subset size must be non-negative.");
        }
        if (subsetSize > setSize) {
            throw new IllegalArgumentException("Subset size cannot be greater than set size.");
        }

        // Calculate binomial coefficient using factorials
        return factorial(setSize) / (factorial(subsetSize) * factorial(setSize - subsetSize));
    }
}