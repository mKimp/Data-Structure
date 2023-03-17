import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class coinchange {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = coinChange(new int[]{1,2,5}, 11, map);
        if(res == Integer.MAX_VALUE)
            System.out.println(-1);
        System.out.println(res);

    }

    public static int coinChange(int[] coins, int amount, HashMap<Integer, Integer> map) {
        /*
        int count = 0; int sum = 0; Stack<Integer> stack = new Stack<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        helper(coins, amount, count, sum, stack, 0); */

        if(amount == 0)
            return 0;
        if(map.containsKey(amount))
            return map.get(amount);

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; ++i){
            if(coins[i] <= amount){
                int val = coinChange(coins, amount - coins[i], map);
                if (val < min)
                    min = val;
            }
        }

        min = (min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min + 1);
        map.put(amount, min);
        return min;


    }

    public static void  helper(int[]coins, int amount, int count, int sum, Stack<Integer>stack, int startIndex){
        if(sum == amount){
            print(stack);
            return;
        }
        if(sum > amount){
            System.out.println(sum);
            return;
        }

        for (int i = startIndex; i < coins.length; ++i){
            stack.push(coins[i]);
            helper(coins, amount, count, sum + coins[i], stack, startIndex);
            stack.pop();
        }
    }

    private static void print(Stack<Integer> stack) {
        for (int i : stack)
            System.out.println(i);
    }
}
