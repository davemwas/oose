/*

Logger class: The Logger class has a private static field instance, which holds the single instance of the class. The constructor is private to prevent other classes from creating instances directly.
getInstance() method: This method is used to obtain the single instance of Logger. It checks if an instance already exists; if not, it creates one (lazy initialization).
log() method: A simple method to simulate logging functionality.
SingletonPatternDemo class: Demonstrates the Singleton pattern by creating two Logger objects and showing that they are the same instance.

*/

public class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton(); 
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}


public class SingletonDemo {
    public static void main(String[] args) {

        Singleton logger1 = Singleton.getInstance();
        logger1.log("This is the first log message.");

        Singleton logger2 = Singleton.getInstance();
        logger2.log("This is the second log message.");

        System.out.println("Are both instances the same? " + (logger1 == logger2));
    }
}
