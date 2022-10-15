package SympleSquare;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class SimpleSquare {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        long number = sc.nextLong();

        // if the number isn't simple or is more than 9 calculate digits sum till it is so
        if ( !isSimple(number) && number > 9) number = digitsSumLoop(number);
        // if number isn't simple and less than 10 return 0
        if ( !isSimple(number) ) number = 0;

        PrintWriter pw = new PrintWriter(new FileOutputStream("output.txt"));
        pw.println(number);
        pw.close();
    }
        private static boolean isSimple(long number){
            BigInteger bigNumber = BigInteger.valueOf(number);
            boolean probablyPrime = false;
            if (bigNumber.equals(BigInteger.ONE)) return probablyPrime;
            probablyPrime = bigNumber.isProbablePrime((int)Math.log(number));
            return probablyPrime;
        }

        // Calculate digits sum till this sum is simple or is less that 10
        private static long digitsSumLoop (long number){
            long sum = 0;
            while ( !isSimple(number) && number > 9)
            {
                for (long i = number; i != 0; i /= 10) {
                    sum += (i % 10);
                }
                number = sum;
                sum = 0;
            }
            return number;
        }
}
