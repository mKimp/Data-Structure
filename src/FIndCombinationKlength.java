import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FIndCombinationKlength {
    static ArrayList<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        combine(4,2);

        for (List<Integer> integers : result) {
            System.out.println(integers);
        }
    }
    public static List<List<Integer>> combine(int n, int k) {

        if(n == 1){
            ArrayList <Integer> l = new ArrayList<>();
            l.add(n);
            result.add(l);
            return result;
        }
        int [] buffer = new int[k];
        helper(n, 1, 0, buffer);
        return result;
    }

    public static void helper(int n, int startIndex, int bufferIndex, int [] buffer){
        //termination
        if (bufferIndex == buffer.length){
            addToList(buffer);
            return;
        }
        if(startIndex > n)
            return;

        //chose the candidates
        for (int i = startIndex; i <= n; ++i){
            buffer[bufferIndex] = i;
            helper(n, i + 1, bufferIndex + 1, buffer);
        }
    }

    public static void addToList(int [] buffer){
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : buffer)
            l.add(i);
        result.add(l);
    }
}
