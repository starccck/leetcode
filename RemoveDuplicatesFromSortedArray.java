public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        Solution solution = new Solution();
        long start = System.nanoTime();
        int len = solution.removeDuplicates(nums);
        System.out.println(System.nanoTime() - start);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
        int[] nums1 = {1, 1, 2};
        start = System.nanoTime();
        len = solution.removeDuplicates(nums1);
        System.out.println(System.nanoTime() - start);
        for (int i = 0; i < len; i++) {
            System.out.println(nums1[i]);
        }
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int len = 0, length = nums.length, i = 1;
        while (i < length) {
            if (nums[len] != nums[i]) {
                nums[++len] = nums[i];
            }
            i++;
        }
        return len+1;
    }

    public int removeDuplicates1(int[] nums) {
        int length = nums.length;
        if (length == 0)
            return 0;

        int len = 0, i = 1;
        while (i < length) {
            if (nums[len] != nums[i]) {
                nums[++len] = nums[i];
            }
            i++;
        }
        return len+1;
    }
}
