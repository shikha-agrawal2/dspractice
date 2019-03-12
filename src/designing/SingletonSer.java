package designing;
/*readResolve is used for replacing the object read from the stream.
        The only use I've ever seen for this is enforcing singletons; when an object is read, replace it with the singleton instance.
        This ensures that nobody can create another instance by serializing and deserializing the singleton.*/
import java.io.Serializable;

class SingletonSer implements Serializable {
    int i;
    private static SingletonSer obj = null;

    private SingletonSer() {
        System.out.println("Executing constructor");
        i = 1;
    }

    public static SingletonSer getInstance() {
        if (obj == null) {
            obj = new SingletonSer();
        }
        System.out.println("An instance is returned");
        return obj;
    }

   /*private void writeObject(ObjectOutputStream oos) {
   try {
       oos.writeInt(i);
   } catch (Exception e) {
       e.printStackTrace();
   }
   }

   private void readObject(ObjectInputStream ois) {
   try {
       i = ois.readInt();
   } catch (Exception e) {
       e.printStackTrace();
   }
   }*/

    public Object readResolve() {
        System.out.println("Executing readResolve");
        return this; // FIXME  call this instead of calling getInstance method
    }

    @Override
    public String toString() {
        return "SingletonSer [i=" + i + "]";
    }
}