import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class coinChangeBackTrack {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = coinChange(new int[]{1, 2, 5}, 11);

        System.out.println(res);

    }
    public static int coinChange(int[] coins, int amount) {
        int min = Integer.MAX_VALUE; int sum = 0;
        ArrayList<List<Integer>>list = new ArrayList<>();
        ArrayList <Integer> temp = new ArrayList<>();

        helper(coins, amount, sum, min, list, temp);
        if(list.size() == 0){
            return -1;
        }

        min = findMin(list, min);
        System.out.println(min);
        return min;
    }

    private static int  helper(int[] coins, int amount, int sum, int min, ArrayList<List<Integer>>list, ArrayList <Integer> temp
    ){
        if(sum == amount){
            list.add(temp);
//            min = Math.min(min, temp.size());
            System.out.println(temp.size());
            return min;
        }
        if(sum > amount){
            return min;
        }
        for (int i = 0; i < coins.length; ++i){
            sum += coins[i];
            temp.add(coins[i]);

            helper(coins, amount, sum, min, list, temp);
            min = Math.min(min, temp.size());
            sum -= coins[i];
            temp.remove(temp.size() - 1);

        }
        return min;
    }

    private static int findMin( ArrayList<List<Integer>>list, int min){
        for (List<Integer> l: list){
            if(l.size() <= min){
                min = l.size();
            }
        }
        return min;
    }
}