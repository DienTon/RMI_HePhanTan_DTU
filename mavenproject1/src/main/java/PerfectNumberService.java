import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface PerfectNumberService extends Remote {
    List<String> findPerfectNumbers(List<Integer> numbers) throws RemoteException;
}
