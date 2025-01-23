package lab1.recipe01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void isPrimeReturnsFalseForNumberLessThan2(){
        Calculator calculator = new Calculator();
        assertFalse(calculator.isPrime(1));
    }

    @Test
    void isPrimeReturnsTrueForNumber2(){
        Calculator calculator = new Calculator();
        assertTrue(calculator.isPrime(2));
    }

    @Test
    void isPrimeReturnsFalseForEvenNumbersGreaterThan2(){
        Calculator calculator = new Calculator();
        assertFalse(calculator.isPrime(4));
    }

    @Test
    void isPrimeReturnsTrueForPrimeNumber(){
        Calculator calculator = new Calculator();
        assertTrue(calculator.isPrime(5));
    }

    @Test
    void isPrimeReturnsFalseForNonPrimeNumber(){
        Calculator calculator = new Calculator();
        assertFalse(calculator.isPrime(9));
    }

    @Test
    void isPrimeReturnsTrueForLargePrimeNumber(){
        Calculator calculator = new Calculator();
        assertTrue(calculator.isPrime(14229641));
    }

    @Test
    void isPrimeReturnsFalseForLargeNonPrimeNumber() {
        Calculator calculator = new Calculator();
        assertFalse(calculator.isPrime(8000));
    }
}