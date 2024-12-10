import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PerfectNumberClient {
    public static void main(String[] args) {
        try {
            PerfectNumberService service = (PerfectNumberService) Naming.lookup("//localhost/PerfectNumberService");

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Nhap day so (cach nhau bang dau ;), hoac 'stop' de dung:");
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("stop")) {
                    break;
                }

                String[] parts = input.split(";");
                List<Integer> numbers = new ArrayList<>();
                for (String part : parts) {
                    try {
                        numbers.add(Integer.parseInt(part.trim()));
                    } catch (NumberFormatException e) {
                        System.out.println("Du lieu khong hop le: " + part);
                    }
                }

                List<String> result = service.findPerfectNumbers(numbers);
                if (result.isEmpty()) {
                    System.out.println("Khong co so hoan thien trong day.");
                } else {
                    for (String res : result) {
                        System.out.println(res);
                    }
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Client exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
