import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class GardienColors {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader file = new FileReader("input.txt");
        Scanner sc = new Scanner(file);
        int treeAmount = sc.nextInt();
        long result = 3;
        result = (long)(result * Math.pow(2, treeAmount-1));
        PrintWriter pw = new PrintWriter(new FileOutputStream("output.txt"));
        pw.println(result);
        pw.flush();
        pw.close();
    }
}
