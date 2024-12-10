import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class PerfectNumberServiceImpl extends UnicastRemoteObject implements PerfectNumberService {

    public PerfectNumberServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public List<String> findPerfectNumbers(List<Integer> numbers) throws RemoteException {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            if (isPerfectNumber(number)) {
                result.add("So hoan thien " + number + " , vi tri " + (i + 1));
            }
        }
        return result;
    }

    private boolean isPerfectNumber(int number) {
        if (number <= 1) return false;
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }
}
