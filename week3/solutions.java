// Simple OOP Demo in Java
// Concepts: Abstraction, Encapsulation, Inheritance, Polymorphism

// --------------------
// ABSTRACTION
// --------------------
abstract class Vehicle {
    private String brand;   // Encapsulation

    public Vehicle(String brand) {
        this.brand = brand;
    }

    // Getter
    public String getBrand() {
        return brand;
    }

    // Setter
    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Abstract method
    public abstract void start();

    public void stop() {
        System.out.println(brand + " is stopping.");
    }
}

// --------------------
// INHERITANCE
// --------------------
class Car extends Vehicle {

    public Car(String brand) {
        super(brand);
    }

    // POLYMORPHISM (Method Overriding)
    @Override
    public void start() {
        System.out.println(getBrand() + " car starts with a key.");
    }
}

class Bike extends Vehicle {

    public Bike(String brand) {
        super(brand);
    }

    // POLYMORPHISM (Method Overriding)
    @Override
    public void start() {
        System.out.println(getBrand() + " bike starts with a button.");
    }
}

// --------------------
// MAIN CLASS
// --------------------
public class solutions {

    public static void main(String[] args) {
        
        // Polymorphism (Parent reference, Child object)
        Vehicle v1 = new Car("Toyota");
        Vehicle v2 = new Bike("Yamaha");

        v1.start();
        v2.start();

        v1.stop();
        v2.stop();

        System.out.println("---- Updating brand ----");

        v1.setBrand("Honda");
        v1.start();
    }
}