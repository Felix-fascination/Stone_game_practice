import java.util.ArrayList;
import java.util.List;

public class JustSmth {
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>(3);
        arr.add(new ArrayList<>(3));
        arr.add(new ArrayList<>(3));
        arr.add(new ArrayList<>(3));
        for(List<Integer> numb:arr){
            for (int i = 0; i < 3; i++){
                numb.add((int)(Math.random()*100));
            }
        }
        for(List<Integer> numb:arr){
            for (int i = 0; i < 3; i++){
                System.out.print(numb.get(i) + " ");
            }
            System.out.println();
        }
        System.out.println(diagonalDifference(arr));
    }

    private static int diagonalDifference(List<List<Integer>> arr) {
        int leftDiag = 0;
        int rightDiag = 0;
        int size = arr.get(0).size();
        for (int i = 0; i < size; i++){
            leftDiag += arr.get(i).get(i);
            rightDiag += arr.get(size - 1 - i).get(i);
        }
        return Math.abs(leftDiag - rightDiag);

    }
}
