import java.util.ArrayList;

public class numsRollToTraget {
    public static void main(String[] args) {
        System.out.println(numRollsToTarget(2,6, 7 ));
        //numRollsToTarget(2,6, 7 );
    }

    public static int numRollsToTarget(int d, int f, int target) {
        if(d == 1 && target <= f){
            return 1;
        }

        ArrayList <Integer> sum = new ArrayList<>();
        int count = 0; int sumSoFar = 0;
        return helper(d, f, target, sum, count, sumSoFar);
    }

    public static int helper(int d, int f, int target, ArrayList<Integer> sum, int count, int sumSoFar){
        System.out.println("COUNT " + count + " DECISIONS " + d);
        if (d == 0){
            if(sumSoFar == target) {
                ++count;
            }
        }
        else{
            for (int i = 1; i <= f; ++i){
                if(sumSoFar + i + Math.min(1,f)*(d - 1) <= target && sumSoFar + i  +  Math.max(0, f) * (d - 1) >= target){
                    sum.add(i);
                    count = helper(d - 1, f, target, sum, count, sumSoFar + i);
                    sum.remove(sum.size() - 1);
                }
            }
        }

        return count;

    }

    public static int calculateSum(ArrayList<Integer> sum){
        int temp = 0;
        for (Integer i : sum){
            temp += i;
        }
        return temp;
    }
}


