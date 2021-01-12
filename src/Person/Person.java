// delcare in whih package this class is
// packages are used to order all classes and prevent naming conflicts
package Person;

// importing classes that are not accessible by default
// find the class package in the documentation
import java.lang.Math;
import java.util.Scanner;
import java.util.InputMismatchException;

// class definition
// has to be the same as the file name without .java
// public means that the class can be accessed from outside the package it is in
// classes begin with a capitalized letter and use CamelCase e.g. SomeFancyClassNameThatIsReadableBecauseOfCamelCase
// classes are like things
public class Person {

    // class property
    // class properties are usually defined at the top of the class
    // class properties define the properties of a class like properties of a thing
    // variable declaration
    // this is NOT a initialization, the variable "age" has no value and is not initialized
    // protected means it not accessible from outside the class but for the class itself and all sublcasses that extend this class
    protected int age;

    // variable declaration and initialization, the variable "eyeColor" has the value "brown"
    // priavte means it is only accessible in this class
    // String is not a primitive data type as for example int, double or boolean
    // String is a Class and so "eyeColor" is an instance of a String and so "eyeColor" is an object
    private String eyeColor = "brown";

    // variable declaration and initialization
    // public means it is accessible from outside the class
    /**
     * Javadoc comment telling that this variable named "height" tells the height of the person in meter for understanding reasons.
     */
    public double height = 1.8;

    // static means this variable is declared and initialized even when no instance of this class was created
    // final means the value of this variable cannot be changed
    // a final static variable is called "constant"
    // constants are named using all capital letters and underscores to seperate words
    public static final double METER_TO_FEET_MULTIPLIER = 3.28084;

    // main method
    // gets called automatically when "running this class"
    // must be defined in the "main class" (starting class) of the project to "launch the application"
    public static void main(String[] args) {
        // method call
        // System is a class with a static accessible subclass "out" which has a public method called "println" that takes a String as argument
        // System is accessible by default and does not need to be included (imported)
        System.out.println("Hello World!");
        // do some fancy stuff
        Person person = new Person();
        double height = person.height;
        Scanner scanner;
        while (true) {
            scanner = new Scanner(System.in);
            System.out.print("Enter your height in meters: ");
            try {
                height = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("\nEnter a valid number!\n");
            }
        }
        scanner.close();
        person.setHeightMeters(height);
        System.out.println("height in feet: " + person.getHeightInFeet());
    }

    // class method
    // class methods are usually defined below the class properties
    // public means this method can be accessed from outside the class
    // String means this method returns a String
    // getEyeColor is the method name
    // method names are also defined in camel case but starting with a lower case letter
    // methods are like verbs, they do something and their name should describe an action
    // empty brackets mean that the method does not take any arguments
    public String getEyeColor() {
        // the only thing this method does is returning the eye color of the person
        // by doing this the private class property "eyeColor" can be accessed from outside the class through this method
        // a method having a return type (in this case String) must have a return statement returning a String object
        // return passes the value on the right side of the "return" out of the method
        return eyeColor;
        // after the return statement the method is finished and no more code inside the method is executed
    }

    // void means that this method does not return any value
    // the method arguments are declared within the brackets
    // "double height" means the method expects one argument of the type double and this argument has the name "height" inside the method
    // "double height" is like a variable declaration and the value to initialize the variable is given to the method within the brackets when calling it
    public void setHeightMeters(double height) {
        // because the method argument has the same name as the class property we use this
        // this references to this class so the application now knows which of the "height" is the height of the class and the height coming from the method
        // with this method we can change the height of a person during runtime
        this.height = height;
    }

    // do fancy stuff
    public double getHeightInFeet() {
        int min = 42;
        int max = 10 * 1337;
        int random = (int) (Math.random() * (max - min) + min);
        long start = System.currentTimeMillis();
        System.out.print("calculating height");
        try {
            while (true) {
                System.out.print(".");
                Thread.sleep(42);
                if (System.currentTimeMillis() - start > random) {
                    break;
                }
                Thread.sleep(750);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("\n");
        return height * METER_TO_FEET_MULTIPLIER;
    }
}
