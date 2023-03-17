public class maxSubArray {
    public static void main(String[] args) {
        int [] test = new int[]{1,2,-1,2,-3,2,-5};
        int result = maxSymarray(test);

        System.out.println(result);
    }

    public static int maxSymarray(int[]arr){
        if(arr.length == 0)
            return 0;

        else if (arr.length == 1)
            return arr[0];

        int max_sum = arr[0];  int local = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            local = Math.max(local+arr[i], arr[i]);
            max_sum = Math.max(max_sum, local);
        }

        return max_sum;
    }
}
