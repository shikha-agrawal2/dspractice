package designing;
/*A class can be made as Singleton by two simple steps:
Make constructor private
Provide a static method which returns the ‘only’ instance*/

public class Singleton {
    private static Singleton uniqueInstance;

    //private constructor
    private Singleton() {
    }

    // providing global access point to uniqueInstance
    public static Singleton getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
}
