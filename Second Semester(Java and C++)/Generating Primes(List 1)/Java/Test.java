public class Test {
    public static void main(String[] args) {
        if (args.length == 0) return;

        int n;
        try { //sprawdzenie czy została podana poprawna wielkość tablicy
            n = Integer.parseInt(args[0]);
            if (n < 2) throw new IllegalArgumentException();
        }
        catch ( NumberFormatException e ) { System.out.println(args[0] + " nie jest liczbą całkowitą(w zakresie inta)"); return; } 
        catch ( IllegalArgumentException e ) { System.out.println("Nieprawidłowy zakres"); return; } 

        PrimeNumbers primes = new PrimeNumbers(n);
        for (int i = 1; i < args.length; i++) {
            try {
                n = Integer.parseInt(args[i]);
                System.out.println(args[i] + " - " + primes.number(n));
            }
            catch ( NumberFormatException e ) { System.out.println(args[i] + " - nieprawidłowa dana"); }
            catch ( IndexOutOfBoundsException e ) { System.out.println(args[i] + " - liczba spoza zakresu"); } 
        }
    }
}
