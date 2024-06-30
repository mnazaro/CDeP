import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Executor {
    public static void main(String[] args) {
        try {
            Compute engine = new ComputeEngine();
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("Compute", engine);
            System.out.println("ComputeEngine bound in registry");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
