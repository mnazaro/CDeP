import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Compute extends Remote {
    int sum(List<Integer> numbers) throws RemoteException;
    List<Integer> primeNumbers(int start, int end) throws RemoteException;
    String toUpperCase(String text) throws RemoteException;
    long factorial(int number) throws RemoteException;
}
