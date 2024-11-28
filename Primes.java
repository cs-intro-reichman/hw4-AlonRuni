public class Primes {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("wrong values");
            return;
        }
        /*
         * setting the terms for program:
         * two arrays: 
         * first for int numbers from 0 to N
         * second setting all the boolean values to true apart 0 and 1
         */
        int N = Integer.parseInt(args[0]);
        int primeNumbersAmount = 0;
        
        boolean [] isPrime = new boolean[N + 1];
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        /*
         * starting the algo:
         * standing on a number, checking if all following numbers are devided
         * by it. if so, changing the matching boolean value to false.
         * later on, printing all numbers which matching boolean value is true.
         */
        for (int i = 2; i < N + 1; i++) {
            if (isPrime[i]) {
                for (int j = i + 1; j < N + 1; j++) {
                    if (j % i == 0) {
                        isPrime[j] = false;
                    }
                }
            }
        }

        // printing all values, storing amount of primes to compute presentage
        System.out.println("Prime numbers up to " + N + ":");
        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i] == true) {
                System.out.println(i);
                primeNumbersAmount++;
            }
        }
        System.out.println("There are " + primeNumbersAmount + " primes between 2 and " + N + " (" + (int) ((primeNumbersAmount * 100.0) / N) + "% are primes)");

    }
}