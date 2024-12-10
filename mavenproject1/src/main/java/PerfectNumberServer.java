import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class PerfectNumberServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            PerfectNumberServiceImpl obj = new PerfectNumberServiceImpl();
            Naming.rebind("PerfectNumberService", obj);
            System.out.println("PerfectNumberServer is running...");
        } catch (Exception e) {
            System.out.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
