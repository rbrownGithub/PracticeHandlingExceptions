package org.example;
/**
 * Represents a Person with a name and age.
 * Includes validation for name and age parameters.
 */
public class Person {
    private String name;
    private int age;

    /**
     * Constructor for Person class.
     * @param name The person's name (not null, not empty, max 40 characters)
     * @param age The person's age (between 0 and 120)
     * @throws IllegalArgumentException if name or age is invalid
     */
    public Person(String name, int age) {
        // Validate name
        if (name == null || name.isEmpty() || name.length() > 40) {
            throw new IllegalArgumentException("Name must not be null, empty, or over 40 characters long.");
        }

        // Validate age
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age must be between 0 and 120.");
        }

        this.name = name;
        this.age = age;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}