import java.util.ArrayList;
import java.util.List;
import java.util.*;

class SolutionSum {
    public static void main(String[] args) {
        SolutionSum s = new SolutionSum();

        // Test case 1
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;
        System.out.println(s.combinationSum(candidates, target)); // expected output: [[2, 2, 3], [7]]

        // Test case 2
        candidates = new int[] { 2, 3, 5 };
        target = 8;
        System.out.println(s.combinationSum(candidates, target)); // expected output: []

        // Test case 3
        candidates = new int[] {};
        target = 8;
        System.out.println(s.combinationSum(candidates, target)); // expected output: []

        // Test case 4
        candidates = new int[] { 5, 10, 15 };
        target = 20;
        System.out.println(s.combinationSum(candidates, target)); // expected output: [[5,5,5,5], [5,5,10], [5,15], [10,10]]

        // Test case 5
        candidates = new int[] { 2, 4, 6, 8 };
        target = 10;
        System.out.println(s.combinationSum(candidates, target)); // expected output: [[2,2,2,2,2], [2,2,2,4], [2,2,6],
        // [2,4,4], [2,8], [4,6]]

        // Test case 6
        candidates = new int[] { 2, 3, 5 };
        target = 0;
        System.out.println(s.combinationSum(candidates, target)); // expected output: [[]]
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // TODO: Write your code here
        int sum = 0;
        List<Integer> currentCombination = new ArrayList<>();

        for (int i = 0; i < candidates.length; ++i){
            currentCombination.add(candidates[i]);
            sum += candidates[i];
            combinationSumRecursion(candidates, i, target, res, sum, currentCombination);
            sum -= candidates[i];
            currentCombination.remove(Integer.valueOf(candidates[i]));
        }
        return res;
    }

    public static void combinationSumRecursion(int[] candidates, int start, int target, List<List<Integer>> res, int sum, List<Integer> currentCombination ){
        //termination case
        if(sum >= target){
            if(sum == target){
                List<Integer> copy = new ArrayList<>(currentCombination);
                res.add(copy);
            }
            return;
        }

        //go through every candidate with a chosen candidate in the sum
        for (int i = start; i < candidates.length; ++i){
            sum += candidates[i];
            currentCombination.add(candidates[i]);
            combinationSumRecursion(candidates, i, target, res, sum, currentCombination);
            sum -= candidates[i];
            currentCombination.remove(Integer.valueOf(candidates[i]));
        }
    }




}
