public class indexInserted {
    public static void main(String[] args) {
        int [] nums = new int[]{1,3,5};
        int target = 1;

        System.out.println(searchInsert(nums, target));

    }

    public static int searchInsert(int[] nums, int target) {
        int l = 0; int h = nums.length - 1;
        while (l <= h){
            int mid = l + (h - l) / 2;
            if(nums[mid] < target){
                if(mid == nums.length){
                    return mid;
                }
                else
                    l = mid + 1;

            }
            else if(nums[mid] == target)
                return mid;

            else{
                if(nums[mid] > target && nums[mid - 1] <= target || mid == 0){
                    return mid;
                }
                else
                    h = mid - 1;
            }
        }
        return -1;
    }
}
