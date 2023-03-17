public class merge2sortedarray {
    public static void main(String[] args) {
        int [] nums1 = new int []{1,2,3,0,0,0};
        int m = 3; int []nums2 = new int[]{2,5,6}; int n = 3;
        merge(nums1, m, nums2, n);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;
        /*
        int index = m;
        for (int i = 0; i < n; ++i){
            nums1[index] = nums2[i];
            ++index;
        }

        Arrays.sort(nums1);*/

        int [] r = new int [m+n];
        int i = 0; int j = 0; int k = 0;

        while (i < m && j < n) {
            if(nums1[i] <= nums2[j]){
                r[k] = nums1[i];
                ++i;
                ++k;
            }
            else{
                r[k] = nums2[j];
                ++j;
                ++k;
            }
        }

        while (j < n){
            r[k] = nums2[j];
            ++j;
        }
        while (i < m){
            r[k] = nums1[i];
            ++i;
        }

        for (int index : r)
            System.out.println(index);

    }
}
