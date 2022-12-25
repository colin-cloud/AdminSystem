import java.util.*;

public class CountPrimes { 
    public static void main(String[] args) { 
        System.out.println("Hello world!"); 
    }
    
    public int countPrime(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }
    
    public boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public int countPrimes(int n) {
        int[] primes = new int[n];
        Array.fill(primes, 1);
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i] == 1) {
                ans++;
                if ((long)i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        prrimes[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
    
    public int countPrimes(int n) {
        int[] isPrimes = new int[n];
        List<Integer> primes = new ArrayList();
        Arrays.fill(isPrimes, 1);
        for (int i = 2; i < n; i++) {
            if (isPrimes[i] == 1) {
                primes.add(i);
            }
            for (int j = 0; 
            j < primes.size() && i * primes.get(j) < n; j++) {
                    isPrimes[i * primes.get(j)] = 0;
                    if (i % primes.get(j) == 0) {
                         break;
                    }
                }
        }
        return primes.size();
    }
}