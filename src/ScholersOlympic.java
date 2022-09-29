import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class ScholersOlympic {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        int k = sc.nextInt();
        int m = sc.nextInt();
        int n = sc.nextInt();;
        int d = sc.nextInt();
        int itemCount = 0;
        //Trying to find NOK
        for (int item = 1; item <= (k*m*n*d); item++) {
            if ((item % k == 0 && item % n == 0 && item % m == 0) && (item /k + item /n + item /m == item - d) ) {
                    itemCount = item;
                    break;
            }
        }
        itemCount = itemCount != 0 ? itemCount : -1;
        PrintWriter out = new PrintWriter(new FileOutputStream("OUTPUT.TXT"));
        out.println(itemCount);
        out.flush();
        out.close();
    }
}

