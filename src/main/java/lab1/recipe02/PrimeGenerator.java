package lab1.recipe02;

public class PrimeGenerator extends Thread{


    @Override
    public void run() {
        long number = 1L;
        while(true){
            if(isPrime(number)){
                System.out.printf("Number %d is Prime\n", number);
            }

            if (isInterrupted()){
                System.out.println("The Prime Generator has been interrupted");
                return;
            }

            number++;
        }
    }

    /**
     * Check if a number is prime via checking up the square root of the number.
     * This is sufficient for prime checking because if a number (n) is not prime,
     * it can be factored into two numbers, a and b, such that n = a * b.
     * If both factors were greater than the square root of n, their product would be greater than n (contradiction).
     * @param number The number to check for primality
     * @return true if the number is prime, false otherwise
     */
    private boolean isPrime(long number) {
        // Handle the case where number is less than 2
        if (number <= 1) {
            return false;
        }

        // Handle the case where number is 2
        if(number == 2) {
            return true;
        }

        // Any number greater than 2 that is even is not prime
        if(number % 2 == 0) {
            return false;
        }

        // If a number is not prime, it will have a factor less than or equal to its square root
        for (long i = 3; i <= Math.sqrt(number); i+=2) {
            if ((number % i) == 0) {
                return false;
            }
        }
        return true;
    }
}
