import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PalindromNumbers {
    private static boolean isPalindrome(long numberInput, int numberSystem){
        char [] numbers = Long.toString(numberInput,numberSystem).toCharArray();
        int finish = numbers.length - 1;
        for (int i = 0; i <= numbers.length/2; i++){
            if (numbers[i] != numbers[finish]) return false;
            finish--;
        }
        return true;
    }

    private static void printResults (ArrayList<Integer> numberSystems) throws FileNotFoundException {
        FileOutputStream file = new FileOutputStream("output.txt");
        PrintWriter out = new PrintWriter(file);
        if (numberSystems.isEmpty()) {
            System.out.println("none");
            out.println("none");
        }
        else if (numberSystems.size() == 1) {
            System.out.println("unique");
            System.out.println(numberSystems.get(0));
            out.println("unique");
            out.println(numberSystems.get(0));
        }
        else {
            System.out.println("multiple");
            out.println("multiple");
            for(int system:numberSystems){
                System.out.print(system + " ");
                out.print(system + " ");
            }
        }
        System.out.println();
        out.flush();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        //input - one number
        //output - unique, multiple, in which displays numbers, none

        Scanner scanner = new Scanner(new FileReader("input.txt"));
        long palindromNumber = scanner.nextLong();
        ArrayList<Integer> numberSystems = new ArrayList<>(35);
        for(int numberSystem = 2; numberSystem <= 36; numberSystem++){
            if (isPalindrome(palindromNumber, numberSystem)) numberSystems.add(numberSystem);
        }
        printResults(numberSystems);

        long time = System.currentTimeMillis() - startTime;
        System.out.println(time);
    }
}
