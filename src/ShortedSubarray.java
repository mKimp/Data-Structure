public class ShortedSubarray {
    public static void main(String[] args) {
        int result =  findUnsortedSubarray(new int[]{1,2,3,5,4});

        System.out.println(result);
    }

    public static int findUnsortedSubarray(int[] arr) {
        int result = 0;
        if (arr.length == 0)
            return 0;
        if (arr.length == 1){
            return 0;
        }

        int l = 0; int h = arr.length - 1;
        while (l < arr.length - 1){
            if(arr[l] > arr[l+1])
                break;
            ++l;
        }

        if(l == arr.length - 1)
            return 0;

        while (h > 0){
            if(arr[h] < arr[h-1])
                break;
            --h;
        }

        int min = findMin(arr, l, h);
        int max = findMax(arr, l, h);

        while (l > 0 && arr[l-1] > min)
            --l;
        while (h < arr.length - 1 && arr[h+1] < max)
            ++h;

        result = h - l + 1;
        if(result >= 0)
            return result;
        return 0;
    }

    public static int findMin(int [] arr, int l, int h){
        int min = Integer.MAX_VALUE;
        for (int i = l; i <= h; ++i){
            if(arr[i]  < min)
                min = arr[i];

        }
        return min;
    }

    public static int findMax(int [] arr, int l, int h){
        int max = Integer.MIN_VALUE;
        for (int i = l; i <= h; ++i){
            if(arr[i] > max)
                max = arr[i];

        }
        return max;
    }
}
