import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        List<List<Integer>> r = generate(5);

        for (List<Integer> l : r){
            System.out.println(l);
        }
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        if(numRows == 1)
            return result;

        for (int i = 0; i < numRows - 1; ++i){
            List<Integer> pre = new ArrayList<>(result.get(i));
            pre.add(0,0);
            pre.add(0);
            List<Integer> currentRow = new ArrayList<>();
            for (int j = 0; j < pre.size() - 1; ++j){
                int sum = pre.get(j).intValue() + pre.get(j+1).intValue();
                currentRow.add(sum);
            }

            for (int k: currentRow){
                System.out.println(k);
            }

            result.add(currentRow);
        }
        return result;
    }

}



