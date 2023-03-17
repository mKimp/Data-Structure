import java.util.ArrayList;
import java.util.List;

public class findAllSubset {
    private static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        subsets(new int[]{1,2,3});

        for (List<Integer> l : result){
            System.out.println(l);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 1){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(nums[0]);
            result.add(temp);
            return result;
        }
        ArrayList <Integer> buffer  = new ArrayList<>();
        helper(nums, buffer, 0, buffer.size());
        return result;
    }

    public static void helper(int [] nums, ArrayList<Integer> buffer, int startIndex, int bufferIndex){
        result.add(new ArrayList<>(buffer));
        if (bufferIndex == buffer.size()){
            return;
        }
        //find candidates
        for (int i = startIndex; i < nums.length; i++){
            buffer.add(nums[i]);
            helper(nums, buffer, startIndex + 1, bufferIndex + 1);
            buffer.remove(buffer.size() - 1);
        }
    }

    public static void addBuffer(int [] buffer, int index){

            int i = 0;
            ArrayList<Integer> temp = new ArrayList<>();
            if(index == 0) {
                result.add(new ArrayList<>(){});
                return;
            }
            if(index == buffer.length){
                return;
            }
            while (i <= index){
                temp.add(buffer[i]);
                ++i;
            }
            result.add(temp);

    }
}
