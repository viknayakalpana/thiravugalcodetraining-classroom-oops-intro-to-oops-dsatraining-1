// Demonstration of OOP + SOLID Principles
// Concepts: Encapsulation, Abstraction, Inheritance, Polymorphism + SOLID

// --------------------
// QUESTION 1: SMART HOME SYSTEM
// --------------------

// ABSTRACTION
abstract class Device {
    private String deviceName;   // Encapsulation
    private boolean powerStatus;

    public Device(String deviceName) {
        this.deviceName = deviceName;
        this.powerStatus = false;
    }

    // Getters and Setters (Encapsulation)
    public String getDeviceName() {
        return deviceName;
    }

    public boolean isPowerOn() {
        return powerStatus;
    }

    public void turnOn() {
        powerStatus = true;
    }

    public void turnOff() {
        powerStatus = false;
    }

    // Abstract method (Polymorphism)
    public abstract void displayStatus();
}

// INHERITANCE
class Light extends Device {

    public Light(String name) {
        super(name);
    }

    // POLYMORPHISM
    @Override
    public void displayStatus() {
        System.out.println(getDeviceName() + " Light is " +
                (isPowerOn() ? "ON" : "OFF"));
    }
}

class Thermostat extends Device {
    private int temperature;

    public Thermostat(String name, int temp) {
        super(name);
        this.temperature = temp;
    }

    // POLYMORPHISM
    @Override
    public void displayStatus() {
        System.out.println(getDeviceName() + " Thermostat is " +
                (isPowerOn() ? "ON" : "OFF") +
                " | Temp: " + temperature + "°C");
    }
}


// --------------------
// QUESTION 2: PAYMENT SYSTEM (SOLID)
// --------------------

// INTERFACE (DIP)
interface PaymentMethod {
    void processPayment(double amount);
}

// IMPLEMENTATIONS (OCP)
class CreditCardPayment implements PaymentMethod {
    public void processPayment(double amount) {
        System.out.println("Payment of ₹" + amount + " done using Credit Card");
    }
}

class PayPalPayment implements PaymentMethod {
    public void processPayment(double amount) {
        System.out.println("Payment of ₹" + amount + " done using PayPal");
    }
}

class UPIPayment implements PaymentMethod {
    public void processPayment(double amount) {
        System.out.println("Payment of ₹" + amount + " done using UPI");
    }
}

// DEPENDS ON INTERFACE (DIP)
class PaymentProcessor {
    public void makePayment(PaymentMethod method, double amount) {
        method.processPayment(amount);
    }
}


// --------------------
// QUESTION 3: NOTIFICATION SYSTEM (SOLID)
// --------------------

// ISP: Small interfaces
interface EmailSender {
    void sendEmail(String message);
}

interface SMSSender {
    void sendSMS(String message);
}

interface PushNotificationSender {
    void sendPushNotification(String message);
}

// SRP: One responsibility per class
class EmailNotification implements EmailSender {
    public void sendEmail(String message) {
        System.out.println("Email: " + message);
    }
}

class SMSNotification implements SMSSender {
    public void sendSMS(String message) {
        System.out.println("SMS: " + message);
    }
}

class MobileAppNotification implements PushNotificationSender {
    public void sendPushNotification(String message) {
        System.out.println("Push Notification: " + message);
    }
}


// --------------------
// MAIN CLASS
// --------------------

public class OOPSSimpleDemo {

    public static void main(String[] args) {

        // -------- QUESTION 1 --------
        System.out.println("---- Smart Home Devices ----");

        Device light = new Light("Hall");
        Device thermostat = new Thermostat("Bedroom", 24);

        light.turnOn();
        thermostat.turnOn();

        light.displayStatus();
        thermostat.displayStatus();

        light.turnOff();
        light.displayStatus();


        // -------- QUESTION 2 --------
        System.out.println("\n---- Payment Processing ----");

        PaymentProcessor processor = new PaymentProcessor();

        PaymentMethod card = new CreditCardPayment();
        PaymentMethod upi = new UPIPayment();

        processor.makePayment(card, 2000);
        processor.makePayment(upi, 750);


        // -------- QUESTION 3 --------
        System.out.println("\n---- Notification System ----");

        EmailSender email = new EmailNotification();
        email.sendEmail("Welcome User!");

        SMSSender sms = new SMSNotification();
        sms.sendSMS("Your OTP is 5678");

        PushNotificationSender push = new MobileAppNotification();
        push.sendPushNotification("New message received");
    }
}