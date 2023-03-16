import java.util.ArrayList;

public class PrimeNumbers {
    //Atrybuty
    private ArrayList<Integer> primes = new ArrayList<Integer>(); //tablica liczb pierwszych

    //Konstruktory
    public PrimeNumbers(int n) {
        ArrayList<Boolean> primePositions = sieveOfEratosthenes(n);
        for (int i = 2; i <= n; i++) {
            if (primePositions.get(i) == true) primes.add(i);
        }
    }

    //Metody
    private ArrayList<Boolean> sieveOfEratosthenes(int n) { //funkcja zwracająca tablicę z pozycjami liczb pierwszych
        ArrayList<Boolean> primePositions = new ArrayList<Boolean>();
        for (int i = 0; i <= n; i++) primePositions.add(true); //zapełnienie wektora true

        for (long i = 2; i * i <= n; i++) {
            if (primePositions.get((int)i) == true) {
                for (long j = i * i; j <= n; j = j + i) primePositions.set((int)j, false); //false dla liczb nie pierwszych
            }
        }
        return primePositions;
    }

    public int number(int m) throws IndexOutOfBoundsException { //funkcja zwracająca m-tą liczbę pierwszą
        if (m >= primes.size() || m < 0) throw new ArrayIndexOutOfBoundsException();
        return primes.get(m);
    }
}