package designing;

import com.Node1;

public class SingletonTest {
    public static void main(String[] args) {
        Singleton uniqueInstance = Singleton.getUniqueInstance();
        System.out.println("Returned " + uniqueInstance);
        Singleton uniqueInstance1 = Singleton.getUniqueInstance();
        System.out.println("Returned " + uniqueInstance1);

        //You can use access modifiers in a constructor's declaration to control which other classes can call the constructor.
        //If you don't declare the constructor explicitly as public it is visible only in the same package where it was declared (package access).
        //Node1 n = new Node1();
    }
}
