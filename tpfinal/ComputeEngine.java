import java.util.ArrayList;
import java.util.List;

public class ComputeEngine implements Compute {

    @Override
    public int sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public List<Integer> primeNumbers(int start, int end) {
        List<Integer> primes = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    private boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    @Override
    public String toUpperCase(String text) {
        return text.toUpperCase();
    }

    @Override
    public long factorial(int number) {
        long result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
