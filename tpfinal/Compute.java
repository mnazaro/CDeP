import java.util.List;

public interface Compute {
    int sum(List<Integer> numbers);
    List<Integer> primeNumbers(int start, int end);
    String toUpperCase(String text);
    long factorial(int number);
}
