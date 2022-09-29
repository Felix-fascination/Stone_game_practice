package StoneGame;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class StoneGame {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("input.txt"));
        int stoneNumber = scanner.nextInt();
        System.out.println(stoneNumber);
    }
}
