class Main {
    private static int div(int n) throws IllegalArgumentException {
        if (n == 0) throw new IllegalArgumentException();

        int greatest_divisor = 1;
        for (int i = 2; i <= n/2; i++) {
            if (n % i == 0) greatest_divisor = i;
        }
        return greatest_divisor;
    }

    public static void main(String[] args) {
        int n;
        for (int i = 0; i < args.length; i++) {
            try {
                n = Integer.parseInt(args[i]);
                System.out.println(n + ": " + div(n));
            }
            catch (NumberFormatException e1) { System.out.println(args[i] + " nie jest liczbą całkowitą"); }
            catch (IllegalArgumentException e2) { System.out.println("0: N\\A"); }
        }
    }
}